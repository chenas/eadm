package com.eshop.commonsys.action;


import java.io.ByteArrayInputStream;

import org.springframework.stereotype.Component;

import com.base.framwork.action.BaseAction;
import com.base.framwork.util.SecurityCodeUtil;
import com.base.framwork.util.SecurityCodeUtil.SecurityCodeLevel;
import com.base.framwork.util.SecurityImage;

/**
 * 提供图片验证码
 */
@Component
public class SecurityCodeImageAction extends BaseAction{
    
    //图片流
    private ByteArrayInputStream imageStream;

    public ByteArrayInputStream getImageStream() {
        return imageStream;
    }

    public void setImageStream(ByteArrayInputStream imageStream) {
        this.imageStream = imageStream;
    }

    
    public String execute() throws Exception {
        //如果开启Hard模式，可以不区分大小写
        String securityCode = SecurityCodeUtil.getSecurityCode(4,SecurityCodeLevel.Hard, false).toLowerCase();
        
        //获取默认难度和长度的验证码,区分大小写
//        String securityCode = SecurityCode.getSecurityCode();
        imageStream = SecurityImage.getImageAsInputStream(securityCode);
        //放入session中
        doPutSessionObject("SESSION_SECURITY_CODE", securityCode);
        return SUCCESS;
    }

}