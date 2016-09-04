/**
 * @description 关于用户的服务类
 * @date 2016-8-20
 * @author hxg	
 */

package com.service;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Service;

import com.entity.User;

@Service
public interface IUserService {

	User findUserById(int id) throws Exception;

	/**
	 * @return void
	 * @param
	 */
	int addUser(User user) throws Exception;

	/**
	 * @return boolean
	 * @param
	 */
	boolean validate(HttpSession session, User user) throws Exception;

	/**
	 * @return void
	 * @param
	 */
	void updateUser(HttpSession session, User user) throws Exception;


	/**
	 * @description
	 * @steps 				
	 * @return Object
	 * @param 
	 */
	User findUser(User user) throws Exception;
}
