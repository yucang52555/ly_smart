package com.smart.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.smart.sso.client.SessionPermission;
import com.smart.sso.client.SessionUser;
import com.smart.sso.client.SessionUtils;

import javax.servlet.http.HttpServletRequest;

/**
 * @author kingkang
 */
@Controller
@RequestMapping("/index")
public class IndexController {

	@RequestMapping(method = RequestMethod.GET)
	public String execute(HttpServletRequest request, Model model) {
		SessionUser sessionUser = SessionUtils.getSessionUser(request);
		model.addAttribute("userName", sessionUser.getAccount());
		
		SessionPermission sessionPermission = SessionUtils.getSessionPermission(request);
		if (sessionPermission != null){
			model.addAttribute("userMenus", sessionPermission.getMenuList());
			model.addAttribute("userPermissions", sessionPermission.getPermissionSet());
		}
		return "/index";
	}
}