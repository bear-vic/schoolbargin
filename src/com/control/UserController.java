/**
 * @description 
 * @date 2016-8-17
 * @author hxg	
 */
package com.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import utils.MyConstants;

import com.entity.User;
import com.entity.ex.SMessage;
import com.service.IUserService;
import com.service.impl.UserManager;

@Controller
@RequestMapping("/user")
public class UserController {
	@Resource
	IUserService userService;
	@Resource
	GoodsController goodsController;
	UserManager userManager = UserManager.getInstance();

	@RequestMapping(value = "/login")
	public String login(User user, HttpSession session, HttpServletRequest req)
			throws Exception {
		session.getServletContext().setAttribute(
				MyConstants.APPLICATION_USERMAP, userManager);
		if (userService.validate(session, user)) {
			userManager.addUser(user, session);
			session.setMaxInactiveInterval(60*10);
			goodsController.search(req, 1, 4);
			return "main";
		}
		req.setAttribute(MyConstants.REQUEST_MSG, new SMessage("login fail"));
		return "login";
	}

	@RequestMapping("/logout")
	public String logout(HttpSession session) throws Exception {
		session.invalidate();
		return "redirect:/pages/main.jsp";
	}

	@RequestMapping("/regist")
	public String regist(User user, HttpServletRequest req) throws Exception {
		userService.addUser(user);
		req.setAttribute(MyConstants.REQUEST_MSG, new SMessage("注册成功"));
		return "hand_result";
	}

	@RequestMapping("/update")
	public String update(HttpSession session, User user, HttpServletRequest req)
			throws Exception {
		userService.updateUser(session, user);
		req.setAttribute(MyConstants.REQUEST_MSG, new SMessage("修改成功"));
		return "hand_result";
	}

	@RequestMapping("/lookother")
	public String lookOther(HttpSession session) throws Exception {
		// userService.updateUser(session, user);
		return "user_info_others";
	}
}
