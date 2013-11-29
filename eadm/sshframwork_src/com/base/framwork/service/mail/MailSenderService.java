package com.base.framwork.service.mail;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.apache.commons.net.smtp.SMTPClient;
import org.apache.commons.net.smtp.SMTPReply;
import org.apache.velocity.app.VelocityEngine;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.ui.velocity.VelocityEngineUtils;
import org.xbill.DNS.Lookup;
import org.xbill.DNS.Record;
import org.xbill.DNS.Type;

import com.base.framwork.service.BaseService;
import com.base.framwork.util.ConfigUtil;

public class MailSenderService extends BaseService implements IMailSenderService{
	private JavaMailSender mailSender;//spring配置中定义
	private VelocityEngine velocityEngine;//spring配置中定义
	private SimpleMailMessage simpleMailMessage;//spring配置中定义
	private String from;	//可通过mail.properties设置值
	private String subject;  //可通过mail.properties设置值,中文乱码,在applicationContext-mail.xml配置
	private String content;  //可通过mail.properties设置值
	private String templateName; //模板名称,默认模板为 mail-register.vm
	// 是否需要身份验证   
	private boolean validate = true; 
	
	public JavaMailSender getMailSender() {
		return mailSender;
	}
	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}
	public VelocityEngine getVelocityEngine() {
		return velocityEngine;
	}
	public void setVelocityEngine(VelocityEngine velocityEngine) {
		this.velocityEngine = velocityEngine;
	}
	/**
	 * 
	 * 发送模板邮件
	 */
	public void sendWithTemplate(String[] toMailAddr, Map model){
		mailSender = this.getMailSender();
		simpleMailMessage.setTo(toMailAddr); //接收人  
		simpleMailMessage.setFrom(simpleMailMessage.getFrom()); //发送人,从配置文件中取得
		simpleMailMessage.setSubject(subject);
        String result = null;
        try {
        	//编码方式用GBK，UTF-8出现乱码
        	result = VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, templateName, "GBK",model);
		} catch (Exception e) {}
		simpleMailMessage.setText(result);
        mailSender.send(simpleMailMessage);
	}
	/**
	 * 发送普通文本邮件
	 * @param toMailAddr
	 * 			接收邮件人的地址
	 */
	public void sendText(String[] toMailAddr){
		mailSender = this.getMailSender();
		simpleMailMessage.setTo(toMailAddr); //接收人  
		simpleMailMessage.setFrom(simpleMailMessage.getFrom()); //发送人,从配置文件中取得
		simpleMailMessage.setSubject(subject);
		simpleMailMessage.setText(content);
	    mailSender.send(simpleMailMessage);
	}
	/**
	 * 发送普通Html邮件
	 *
	 */
	public void sendHtml(String[] toMailAddr){
		mailSender = this.getMailSender();
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		MimeMessageHelper messageHelper = null;
		try {
			messageHelper = new MimeMessageHelper(mimeMessage);
			messageHelper.setTo(toMailAddr);
			messageHelper.setFrom(simpleMailMessage.getFrom());
			messageHelper.setSubject(subject);
			messageHelper.setText(content,true);      
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	    mailSender.send(mimeMessage);
	}
	

	/**
	 * 发送HTML模板邮件
	 *
	 */
    public void sendHtmlWithTemplate(final String mailTo, final Map model){
        MimeMessagePreparator preparator = new MimeMessagePreparator() {
            //注意MimeMessagePreparator接口只有这一个回调函数
          public void prepare(MimeMessage mimeMessage) throws Exception
          {
             MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true,"GBK");
             //这是一个生成Mime邮件简单工具，如果不使用GBK这个，中文会出现乱码
             //如果您使用的都是英文，那么可以使用MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
             message.setTo(mailTo);//设置接收方的email地址
             message.setSubject(subject);//设置邮件主题
             message.setFrom(simpleMailMessage.getFrom());//设置发送方地址
              String text = VelocityEngineUtils.mergeTemplateIntoString(
                velocityEngine, getTemplateName(),"GBK", model);
              //从模板中加载要发送的内容，vmfile就是模板文件的名字
              //注意模板中有中文要加GBK，model中存放的是要替换模板中字段的值
             message.setText(text, true);
          }
        };
          mailSender.send(preparator);//发送邮件
    }
	/**
	 * 发送HTML模板邮件
	 * 带附件
	 *
	 */
	@Override
    public void sendHtmlWithTemplate(final String[] mailTo,final Map model,final String [] files)
    {  
       MimeMessagePreparator preparator = new MimeMessagePreparator() {
           //注意MimeMessagePreparator接口只有这一个回调函数
         public void prepare(MimeMessage mimeMessage) throws Exception
         {
            MimeMessageHelper message = new MimeMessageHelper(mimeMessage,true,"GBK");
            //这是一个生成Mime邮件简单工具，如果不使用GBK这个，中文会出现乱码
            //如果您使用的都是英文，那么可以使用MimeMessageHelper message = new MimeMessageHelper(mimeMessage);
            message.setTo(mailTo);//设置接收方的email地址
            message.setSubject(subject);//设置邮件主题
            message.setFrom(simpleMailMessage.getFrom());//设置发送方地址
             String text = VelocityEngineUtils.mergeTemplateIntoString(
               velocityEngine, getTemplateName(),"GBK", model);
             //从模板中加载要发送的内容，vmfile就是模板文件的名字
             //注意模板中有中文要加GBK，model中存放的是要替换模板中字段的值
            message.setText(text, true);
            //将发送的内容赋值给MimeMessageHelper,后面的true表示内容解析成html
            //如果您不想解析文本内容，可以使用false或者不添加这项
            FileSystemResource file;
            for(String s:files)//添加附件
            {
               file = new FileSystemResource(new File(s));//读取附件
               message.addAttachment(s, file);//向email中添加附件
            }
          }
      };
       mailSender.send(preparator);//发送邮件
    }
   
	
	/**
	 * 发送普通带一张图片的Html邮件
	 *
	 */
	public void sendHtmlWithImage(String[] toMailAddr, String imagePath){
		mailSender = this.getMailSender();
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"GBK");
			messageHelper.setTo(toMailAddr);
			messageHelper.setFrom(simpleMailMessage.getFrom());
			messageHelper.setSubject(subject);
			messageHelper.setText(content,true);
//			Content="<html><head></head><body><img src=\"cid:image\"/></body></html>";
			//图片必须这样子：<img src='cid:image'/>
			FileSystemResource img = new FileSystemResource(new File(imagePath));
			messageHelper.addInline("image",img);
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    mailSender.send(mimeMessage);
	}
	/**
	 * 发送普通带附件的Html邮件
	 * @param toMailAddr
	 * @param filePath
	 */
	public void sendHtmlWithAttachment(String[] toMailAddr, String filePath){
		mailSender = this.getMailSender();
		MimeMessage mimeMessage = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage,true,"GBK");
			messageHelper.setTo(toMailAddr);
			messageHelper.setFrom(simpleMailMessage.getFrom());
			messageHelper.setSubject(subject);
			messageHelper.setText(content,true);
			FileSystemResource file = new FileSystemResource(new File(filePath));
//			log.info("file.getFilename==="+file.getFilename());
			messageHelper.addAttachment(file.getFilename(),file);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	    mailSender.send(mimeMessage);
	}
	
	/**
	 * 检查邮箱是否真实存在
	 * @param email
	 * @return
	 * 		true if exists
	 */
	public boolean checkEmail(String email) {
		if (!email.matches("[\\w\\.\\-]+@([\\w\\-]+\\.)+[\\w\\-]+")) {
			return false;
		}
		String logStr = "";
		String host = "";
		String hostName = email.split("@")[1];// 去掉@后面的
		log.info("hostName:" + hostName);
		Record[] result = null;
		SMTPClient client = new SMTPClient();
		try {
			// 查找MX记录
			Lookup lookup = new Lookup(hostName, Type.MX);
			lookup.run();
			if (lookup.getResult() != Lookup.SUCCESSFUL) {
				log.info("找不到MX记录");
				return false;
			} else {
				result = lookup.getAnswers();
				for (int i = 0; i < result.length; i++) {
					log.info(result[i].getAdditionalName().toString());
					log.info(result[i]);
				}
			}
			// 连接到邮箱服务器
			for (int i = 0; i < result.length; i++) {
				host = result[i].getAdditionalName().toString();
				client.connect(host);
				if (!SMTPReply.isPositiveCompletion(client.getReplyCode())) {
					client.disconnect();
					continue;
				} else {
					logStr += "邮箱mx记录" + hostName + "存在";
					logStr += "成功连接到" + host;
					return true;
					//break;
				}
			}
			log.info(client.getReplyString());
			client.login(ConfigUtil.getConfig("mail.properties", "mail.check.host"));
			log.info(client.getReplyString());
			client.setSender(ConfigUtil.getConfig("mail.properties", "mail.check.sender"));// 发件人
			logStr += "=" + client.getReplyString();
			client.addRecipient(email);
			logStr += ">RCPT TO: <" + email + ">\n";
			logStr += "=" + client.getReplyString();
			if (250 == client.getReplyCode()) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				client.disconnect();
			} catch (IOException e) {
			} // 打印日志
			log.info(logStr);
		}
		return false;
	}
	
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getTemplateName() {
		return templateName;
	}
	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public boolean isValidate() {
		return validate;
	}
	public void setValidate(boolean validate) {
		this.validate = validate;
	}
	public SimpleMailMessage getSimpleMailMessage() {
		return simpleMailMessage;
	}
	public void setSimpleMailMessage(SimpleMailMessage simpleMailMessage) {
		this.simpleMailMessage = simpleMailMessage;
	}
}

