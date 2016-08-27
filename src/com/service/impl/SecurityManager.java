/**
 * @description 通过aop实现权限认证的一个帮助类
 * @date 2016-8-19
 * @author hxg	
 */
package com.service.impl;

import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Service;

import com.entity.User;
import com.exception.ExceptionCommon;

import utils.MyConstants;

@Service
@Aspect
public class SecurityManager {

	@Before("execution(* com.control.*.*(..))")
	public void check(JoinPoint point) throws Exception {
		Object session = point.getArgs()[0];
		if (session != null && session instanceof HttpSession) {
			User user = (User) ((HttpSession) session)
					.getAttribute(MyConstants.SESSION_MSG);
			if (user == null) {
				throw new ExceptionCommon("你还没登录");
			}
		}
	}
	
	/*@After("execution(* com.control.UserController.log*(..))")
	public void count(JoinPoint point) throws Exception {
		
		System.out.println("------------after check---------------------------");
	}
	*/
	
	// 对密码加密
	/*
	 * @Around("execution(* com.control.UserController.*(..))") public void
	 * SHAPassword(ProceedingJoinPoint point){
	 * 
	 * }
	 */
}
