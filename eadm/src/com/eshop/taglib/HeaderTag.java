package com.eshop.taglib;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.components.Component;
import org.apache.struts2.views.jsp.ui.AbstractUITag;

import com.opensymphony.xwork2.util.ValueStack;

public class HeaderTag extends AbstractUITag {

    @Override
    public Component getBean(ValueStack arg0, HttpServletRequest arg1,
            HttpServletResponse arg2) {
        
        return new Header(arg0,arg1,arg2);
    }

}