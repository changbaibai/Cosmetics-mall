package com.controller.admin;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.po.Buser;
import com.service.admin.AdminUserService;

@Controller
@RequestMapping("/adminUser")
public class AdminUserController extends BaseController{
	@Autowired
	private AdminUserService adminUserService;
	@RequestMapping("/userInfo")
	public String userInfo(Model model) {
		return adminUserService.userInfo(model);
	}
	@RequestMapping("/deleteuserManager")
	public String deleteuserManager(Integer id, Model model) {
		return adminUserService.deleteuserManager(id, model);
	}
	@RequestMapping("/toadduser")
	public String toregister(Buser buser) {
		return "admin/adduser";
	}
	@RequestMapping("/adduser")
	public String register(@ModelAttribute Buser buser,Model model, HttpSession session) {
		return adminUserService.adduser(buser, model, session);
	}
}
