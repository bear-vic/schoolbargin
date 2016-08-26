/**
 * @description 
 * @date 2016-8-26
 * @author hxg	
 */
package com.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import utils.DateUtils;
import utils.MyConstants;

import com.dao.CommentsMapper;
import com.dao.UserMapper;
import com.entity.Comments;
import com.entity.User;
import com.entity.ex.BundleQuery;
import com.entity.ex.ExComments;
import com.entity.ex.PageBean;
import com.service.ICommentsService;

/**
 *
 */
@Transactional
@Service
public class CommentsServiceImpl implements ICommentsService {
	@Resource
	CommentsMapper commentsMapper;
	@Resource
	UserMapper userMapper;

	@Override
	public void addComments(HttpSession session, Comments comments)
			throws Exception {
		User user = (User) session.getAttribute("user");
		comments.setcDate(new Date());
		comments.setcUser(user.getuId());
		commentsMapper.insertSelective(comments);
	}

	@Override
	public void queryAllByGoodsId(int goodsId, HttpSession session)
			throws Exception {
		@SuppressWarnings("unchecked")
		PageBean<BundleQuery> pb = (PageBean<BundleQuery>) session
				.getAttribute("pb");
		List<BundleQuery> bList = pb.gettList();
		BundleQuery bundle = null;
		for (BundleQuery bq : bList) {
			if (bq.getGoods().getgId() == goodsId) {
				bundle = bq;
			}
		}
		List<Comments> cList = commentsMapper.selectByGoodsId(goodsId);
		List<ExComments> exList = new ArrayList<ExComments>();
		for (Comments c : cList) {
			ExComments exc = new ExComments();
			BeanUtils.copyProperties(exc, c);
			exc.setExDate(DateUtils.getFormatDate(c.getcDate()));
			exc.setExUname(userMapper.selectByPrimaryKey(c.getcUser())
					.getuName());
			exList.add(exc);
		}
		bundle.setCommentsList(exList);
		session.setAttribute(MyConstants.SESSION_COMMENTS, bundle);
	}

}
