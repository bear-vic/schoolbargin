/**
 * @description 
 * @date 2016-8-23
 * @author hxg	
 */
package com.service.impl;

import java.util.HashMap;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.entity.User;

public class UserManager {
	private HashMap<User, HttpSession> userMap;
	private int userNum;

	private UserManager() {
		userMap = new HashMap<User, HttpSession>();
	}

	static class Nest {
		private static UserManager instance = new UserManager();
	}

	public static UserManager getInstance() {
		return Nest.instance;
	}

	public void addUser(User user, HttpSession session) {
		if (find(user) == null) {
			userMap.put(user, session);
		}
		userNum = count();
	}

	private User find(User user) {
		Set<User> uSet = userMap.keySet();
		if (!uSet.isEmpty()) {
			for (User u : uSet) {
				if (u.getuName().equals(user.getuName())) {
					return u;
				}
			}
		}
		return null;
	}

	public void deleteUser(User user) {
		userMap.remove(find(user));
		userNum = count();
	}

	public void change(User user) {
		// userMap.get(user)
	}

	public int getUserNum() {
		return userNum;
	}

	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}

	public HashMap<User, HttpSession> getUserMap() {
		return userMap;
	}

	public void setUserMap(HashMap<User, HttpSession> userMap) {
		this.userMap = userMap;
	}

	public int count() {
		return userMap.size();
	}

}
