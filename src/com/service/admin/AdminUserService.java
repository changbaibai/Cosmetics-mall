package com.service.admin;

import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.po.Buser;

public interface AdminUserService {
	public String userInfo(Model model);
	public String deleteuserManager(Integer id, Model model);
	public String adduser(Buser buser,Model model, HttpSession session);
}
