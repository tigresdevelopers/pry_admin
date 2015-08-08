package com.tigers.controllers;


import javax.faces.bean.ManagedBean;

import com.tigers.util.FileUtil;
import com.tigers.util.jsf.Faces;

@ManagedBean(name="link")
public class LinkBean {
	
	
	
	public void redirect(String url) throws Exception {
		//System.out.println(Faces.getContextPath());
		System.out.println(url);
		//System.out.println(Faces.getContextPath()+"/"+FileUtil.loadBundleLink(url));
		Faces.redirect(Faces.getContextPath()+"/"+FileUtil.loadBundleLink(url));
	}
	

}
