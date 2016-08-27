/**
 * @description 
 * @date 2016-8-27
 * @author hxg	
 */
package com.service.impl.listener;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

import utils.MyConstants;

import com.entity.User;
import com.service.impl.UserManager;

public class SessionWorker implements HttpSessionListener {

	@Override
	public void sessionCreated(HttpSessionEvent se) {
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent se) {
		User user=(User) se.getSession().getAttribute(MyConstants.SESSION_MSG);
		if (user!=null) {
			UserManager.getInstance().deleteUser(user);
		}
	}

}
