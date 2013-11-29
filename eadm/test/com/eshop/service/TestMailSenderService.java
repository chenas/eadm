package com.eshop.service;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.base.framwork.service.mail.IMailSenderService;

public class TestMailSenderService {
	
	IMailSenderService mailSenderService;
	
	@Before
	public void init(){
		ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		mailSenderService = (IMailSenderService) ctx.getBean("mailSenderService");
	}
	
	@Test
	public void testSendWithTemplate(){
		String[] mails = {"917146226@qq.com", "1486061782@qq.com"};
		
		//注册完马上发送邮件
		mailSenderService.setSubject("注册成功");
		mailSenderService.setTemplateName("mail-register.vm");//设置的邮件模板
		Map model=new HashMap();
		model.put("username", "reciever");
		//String url=request.getRequestURL().toString();
		String url= "www.test.com"; //url.substring(0, url.lastIndexOf("/"));
		model.put("url", url);
		model.put("email", "shopusst@163.com");
		mailSenderService.sendWithTemplate(mails, model);
		System.out.println("邮件发送成功！");
	}
	
	@Test
	public void testSendText(){
		String[] mails = {"chenas1017@163.com"};
		mailSenderService.sendText(mails);
		System.out.println("邮件发送成功！");
	}
	
	@Test
	public void testSendHtmlWithTemplate(){
		String mails = "917146226@qq.com";
		//注册完马上发送邮件
		mailSenderService.setSubject("注册成功");
		mailSenderService.setTemplateName("mail-register.vm");//设置的邮件模板
		Map model=new HashMap();
		model.put("username", "reciever");
		//String url=request.getRequestURL().toString();
		String url= "www.test.com"; //url.substring(0, url.lastIndexOf("/"));
		model.put("url", url);
		model.put("toMailAddr", "917146226@qq.com");
		mailSenderService.sendHtmlWithTemplate(mails, model);
		System.out.println("邮件发送成功！");
	}
	
	@Test
	public void testSendHtmlWithImage(){
		String[] mails = {"917146226@qq.com"};
		mailSenderService.sendHtmlWithImage(mails, "D:\\test\\1659.png");
		System.out.println("邮件发送成功！");
		
	}
	
	@Test
	public void testCheckMail(){
		//163,qq,gmail测试通过
		boolean flag = mailSenderService.checkEmail("12@gmail.com");
		System.out.println(flag);
	}
	
}
