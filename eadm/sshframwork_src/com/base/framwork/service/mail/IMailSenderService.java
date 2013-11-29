package com.base.framwork.service.mail;

import java.util.Map;

import com.base.framwork.service.IBaseService;

public interface IMailSenderService extends IBaseService{
	

	/**
	 * 发送模板邮件 
	 * 
	 */
	public void sendWithTemplate(String[] toMailAddr, Map model);

	/**
	 * 发送普通文本邮件
	 *
	 */
	public void sendText(String[] toMailAddr);

	/**
	 * 发送普通Html邮件
	 *
	 */
	public void sendHtml(String[] toMailAddr);
	
	/**
	 * 发送普通带一张图片的Html邮件
	 *
	 */
	public void sendHtmlWithImage(String[] toMailAddr, String imagePath);

	/**
	 * 发送普通带附件的Html邮件
	 *
	 */
	public void sendHtmlWithAttachment(String[] toMailAddr, String filePath);

	/**
	 * 发送HTML模板邮件
	 *
	 */
    public void sendHtmlWithTemplate(final String mailTo,final Map model);
	/**
	 * 发送HTML模板邮件
	 * 带附件
	 *
	 */
    public void sendHtmlWithTemplate(final String[] mailTo,final Map model,final String [] files);

	/**
	 * 检查邮箱是否真实存在
	 * @param email
	 * @return
	 * 		true if exists
	 */
	public boolean checkEmail(String email);
    
    /**
     * 不按照默认主题可调用此方法设置主题
     * @param mailSubject
     */
	public void setSubject(String mailSubject);

	/**
	 * 不按照默认模板可调用此方法设置主题
	 * @param templateName
	 */
	public void setTemplateName(String templateName);

	/**
	 * 不按照默认内容可调用此方法设置主题
	 * @param content
	 */
	public void setContent(String content);

}
