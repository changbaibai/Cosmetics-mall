package com.service.admin;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;

import com.dao.AdminUserDao;
import com.dao.CartDao;
import com.dao.UserCenterDao;
import com.dao.UserDao;
import com.po.Buser;
@Service("adminUserService")
@Transactional
public class AdminUserServiceImpl implements AdminUserService{
	@Autowired
	private AdminUserDao adminUserDao;
	@Autowired
	private CartDao cartDao;
	@Autowired
	private UserDao userDao;
	@Autowired
	private UserCenterDao userCenterDao;
	@Override
	public String userInfo(Model model) {
		model.addAttribute("userList", adminUserDao.userInfo());
		return "admin/userManager";
	}
	@Override
	public String deleteuserManager(Integer id, Model model) {
		//用户有关联
		if(cartDao.selectCart(id).size() > 0 ||
				userCenterDao.myFocus(id).size() > 0||
				userCenterDao.myOrder(id).size() > 0) {
			model.addAttribute("msg", "用户有关联，不能删除！");
			return "forward:/adminUser/userInfo";
		}
		if(adminUserDao.deleteuserManager(id) > 0) 
			model.addAttribute("msg", "成功删除用户！");
		return "forward:/adminUser/userInfo";
	}
	@Override
	public String adduser(Buser buser,Model model, HttpSession session) {
		//用户有关联
		int n =userDao.register(buser);
		if(n > 0) {
			return "forward:/adminUser/userInfo";
		}else {
			model.addAttribute("msg", "添加失败！");
			return "forward:/adminUser/userInfo";
		} 

	}

}
