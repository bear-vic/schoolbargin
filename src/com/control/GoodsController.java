/**
 * @description 
 * @date 2016-8-19
 * @author hxg	
 */
package com.control;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import utils.MyConstants;

import com.entity.User;
import com.entity.ex.BundleQuery;
import com.entity.ex.ExGoods;
import com.entity.ex.ItemQuery;
import com.entity.ex.SMessage;
import com.service.IGoodsService;

@Controller
@RequestMapping("/goods")
public class GoodsController {
	@Resource
	IGoodsService goodsService;
	
	@RequestMapping(value = "/publish", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String publish(HttpSession session, ExGoods goods,
			HttpServletRequest req) throws Exception {
		goodsService.addGoods(
				(User) session.getAttribute(MyConstants.SESSION_MSG), goods);
		req.setAttribute(MyConstants.REQUEST_MSG, new SMessage("发布成功"));
		return "hand_result";
	}

	@RequestMapping("/lookmine")
	public String lookMine(HttpSession session, HttpServletRequest req)
			throws Exception {
		User user = (User) session.getAttribute(MyConstants.SESSION_MSG);
		req.setAttribute(MyConstants.REQUEST_OBJ,
				goodsService.selectByUserId(user));
		return "user_goods";
	}

	@RequestMapping(value = "/modify", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String modify(HttpSession session, ExGoods goods,
			HttpServletRequest req) throws Exception {
		goodsService.update(
				(User) session.getAttribute(MyConstants.SESSION_MSG), goods);
		req.setAttribute(MyConstants.REQUEST_MSG, new SMessage("修改成功"));
		return "hand_result";
	}

	@RequestMapping(value = "/delgoods", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String delGoods(HttpSession session, Integer gId,
			HttpServletRequest req) throws Exception {
		goodsService.deleteById(gId);
		req.setAttribute(MyConstants.REQUEST_MSG, new SMessage("删除成功"));
		return "hand_result";
	}

	@RequestMapping(value = "/lookall", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String lookAll(HttpServletRequest req) throws Exception {
		List<BundleQuery> bs = goodsService.selectAll();
		if (bs != null) {
			req.setAttribute(MyConstants.REQUEST_OBJ, bs);
		}
		return "main";
	}

	@RequestMapping(value = "/search", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String search(HttpServletRequest req,
			@RequestParam(required = true, defaultValue = "1") Integer pc,
			@RequestParam(required = true, defaultValue = "4") Integer ps)
			throws Exception {
		goodsService.selectByPageBean(req, pc, ps);
		return "main";
	}

	@RequestMapping(value = "/searchlike", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String searchLike(HttpServletRequest req, ItemQuery iq)
			throws Exception {
		// iq.setPs(pageCount);
		goodsService.queryPageBean(req, iq);
		return "main";
	}

	@RequestMapping(value = "/lookdetail", method = { RequestMethod.POST,
			RequestMethod.GET })
	public String lookDetail(HttpServletRequest req, int gId) throws Exception {
		// iq.setPs(pageCount);
		return "goods_info";
	}
}
