/**
 * @description 
 * @date 2016-8-26
 * @author hxg	
 */
package com.service;

import javax.servlet.http.HttpSession;

import com.entity.Comments;

public interface ICommentsService {

	/**
	 * @param comments 
	 * @param session 
	 * @description
	 * @steps
	 * @return void
	 * @param
	 */
	void addComments(HttpSession session, Comments comments) throws Exception;

	/**
	 * @param session
	 * @description
	 * @steps
	 * @return void
	 * @param
	 */
	void queryAllByGoodsId(int goodsId, HttpSession session) throws Exception;

}
