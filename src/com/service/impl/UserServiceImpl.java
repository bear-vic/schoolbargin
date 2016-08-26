package com.service.impl;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import utils.MyConstants;

import com.dao.UserMapper;
import com.entity.User;
import com.exception.ExceptionCommon;
import com.service.IUserService;
@Transactional
@Service
public class UserServiceImpl implements IUserService {
	@Resource
	UserMapper userMapper;

	@Override
	public User findUserById(int id) throws Exception {
		return userMapper.selectByPrimaryKey(id);
	}

	@Override
	public int addUser(User user) throws Exception {
		return userMapper.insertSelective(user);
	}

	@Override
	public boolean validate(HttpSession session, User user) throws Exception {
		User realastic = userMapper.selectByUserName(user.getuName());
		if (realastic != null) {
			if (realastic.getuPassword().equals(
					user.getuPassword().trim())) {
				session.setAttribute(MyConstants.SESSION_MSG, realastic);
				return true;
			}
		}
		return false;
	}

	@Override
	public void updateUser(HttpSession session, User user) throws Exception {
		User realastic = (User) session.getAttribute(MyConstants.SESSION_MSG);
		if (realastic != null) {
			int id=realastic.getuId();
			user.setuId(id);
			userMapper.updateByPrimaryKeySelective(user);
			session.setAttribute(MyConstants.SESSION_MSG, findUserById(id));
		} else {
			throw new ExceptionCommon("用户已过期！请重新登录");
		}
	};
}
