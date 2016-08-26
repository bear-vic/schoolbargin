/**
 * @description 包含用户和商品的查询
 * @date 2016-8-21
 * @author hxg	
 */
package com.entity.ex;

import java.util.List;

import com.entity.User;

public class BundleQuery {
	private ExGoods goods;
	private User user;
	private List<ExComments> commentsList;

	public List<ExComments> getCommentsList() {
		return commentsList;
	}

	public void setCommentsList(List<ExComments> commentsList) {
		this.commentsList = commentsList;
	}

	public ExGoods getGoods() {
		return goods;
	}

	public void setGoods(ExGoods goods) {
		this.goods = (ExGoods) goods;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
