/**
 * @description 
 * @date 2016-8-26
 * @author hxg	
 */
package com.control;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.entity.Comments;
import com.service.ICommentsService;

@Controller
@RequestMapping("/comments")
public class CommentsController {
	@Resource
	ICommentsService commentsService;
	
	@RequestMapping("/watch")
	public String watch(int goodsId, HttpSession session) throws Exception {
		commentsService.queryAllByGoodsId(goodsId, session);
		return "goods_info";
	}

	@RequestMapping("/leaveMsg")
	public String leaveMsg(HttpSession session, Comments comments)
			throws Exception {
		commentsService.addComments(session, comments);
		int goodsId=comments.getcGoods();
		watch(goodsId, session);
		return "goods_info";
	}
}
