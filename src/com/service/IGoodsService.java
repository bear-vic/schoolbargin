/**
 * @description 关于商品的服务类接口
 * @date 2016-8-20
 * @author hxg	
 */
package com.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.entity.User;
import com.entity.ex.BundleQuery;
import com.entity.ex.ExGoods;
import com.entity.ex.ItemQuery;
import com.entity.ex.PageBean;

public interface IGoodsService {

	/**
	 * @description 给用户添加货物
	 * @return void
	 * @param user
	 * @param goods
	 */
	void addGoods(User user, ExGoods goods) throws Exception;

	/**
	 * @description 查找用户所有物品
	 * @return void
	 * @param
	 */
	List<ExGoods> selectByUserId(User user) throws Exception;

	/**
	 * @description 更新用户商品信息
	 * @return void
	 * @param
	 */
	void update(User user, ExGoods goods) throws Exception;

	/**
	 * @description 用户指定商品id并删除
	 * @return void
	 * @param
	 */
	void deleteById(Integer gId) throws Exception;

	/**
	 * @description 查询所有符合条件的商品
	 * @return void
	 * @param
	 */
	List<BundleQuery> selectAll() throws Exception;

	/**
	 * @description 分页查询所有商品
	 * @return void
	 * @param
	 */
	PageBean<BundleQuery> selectByPageBean(HttpServletRequest req, Integer pc,
			Integer ps) throws Exception;

	/**
	 * @deprecated
	 * @description 过时 查询满足条件的商品并分页
	 * @return void
	 * @param
	 */
	void queryBeanByGoodsName(HttpServletRequest req, ItemQuery iq)
			throws Exception;

	/**
	 * @deprecated
	 * @description 过时 查询满足条件的商品并分页
	 * @return void
	 * @param
	 */
	void queryBeanByUserName(HttpServletRequest req, ItemQuery iq)
			throws Exception;

	/**
	 * @description 查询满足指定条件的商品并分页
	 * @return void
	 * @param iq
	 *            查询条件
	 */
	PageBean<BundleQuery> queryPageBean(HttpServletRequest req, ItemQuery iq) throws Exception;

	/**
	 * @description 查询满足指定条件的商品并分页
	 * @return void
	 * @param iq
	 *            查询条件
	 * 
	 */
	int queryPageBeanCount(HttpServletRequest req, ItemQuery iq)
			throws Exception;

}
