/**
 * @description 
 * @date 2016-8-20
 * @author hxg	
 */
package com.service.impl;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import utils.DateUtils;
import utils.MyConstants;

import com.dao.GoodsMapper;
import com.dao.UserMapper;
import com.entity.Goods;
import com.entity.User;
import com.entity.ex.BundleQuery;
import com.entity.ex.ExGoods;
import com.entity.ex.ItemQuery;
import com.entity.ex.PageBean;
import com.service.IGoodsService;

@Transactional
@Controller
public class GoodsServiceImpl implements IGoodsService {
	@Resource
	GoodsMapper goodsMapper;
	@Resource
	UserMapper userMapper;

	@Override
	public void addGoods(User user, ExGoods goods) throws Exception {
		Goods real = new Goods();
		BeanUtils.copyProperties(real, goods);
		// 获取图片并转存
		String filePath = createPath(goods);
		real.setgPic(filePath);
		real.setgUid(user.getuId());
		real.setgDate(new Date());
		goodsMapper.insertSelective(real);
	}

	@Override
	public List<ExGoods> selectByUserId(User user) throws Exception {
		List<Goods> lgs = goodsMapper.selectByUserId(user.getuId());
		List<ExGoods> les = new ArrayList<ExGoods>();
		if (!lgs.isEmpty()) {
			for (Goods goods : lgs) {
				ExGoods exG = new ExGoods();
				BeanUtils.copyProperties(exG, goods);
				exG.setExDate(DateUtils.getFormatDate(exG.getgDate()));
				les.add(exG);
			}
		}
		return les;
	}

	@Override
	public List<BundleQuery> selectAll() throws Exception {
		List<Goods> items = goodsMapper.selectAll();
		List<BundleQuery> bundleList = null;
		bundleList = transfer(items, bundleList);
		return bundleList;
	}

	/**
	 * 把查询出来的集合goods转换为ExGoods
	 * 
	 * @param origin
	 *            原集合类
	 * @param dest
	 *            目标集合类
	 * */
	private List<BundleQuery> transfer(List<Goods> origin,
			List<BundleQuery> dest) throws IllegalAccessException,
			InvocationTargetException {
		if (!origin.isEmpty()) {
			dest = new ArrayList<BundleQuery>();
			for (Goods goods : origin) {
				BundleQuery bundleQuery = new BundleQuery();
				ExGoods exG = new ExGoods();
				BeanUtils.copyProperties(exG, goods);
				exG.setExDate(DateUtils.getFormatDate(exG.getgDate()));
				bundleQuery.setGoods(exG);
				bundleQuery.setUser(userMapper.selectByPrimaryKey(goods
						.getgUid()));
				dest.add(bundleQuery);
			}
		}
		return dest;
	}

	@Override
	public void update(User user, ExGoods goods) throws Exception {
		Goods origin = goodsMapper.selectByPrimaryKey(goods.getgId());
		goods.setgPic(origin.getgPic());// 设置原来图片路径
		String filePath = createPath(goods);// 生成新的图片路径
		goods.setgPic(filePath);// 设置新图片路径
		goodsMapper.updateByPrimaryKeySelective(goods);
	}

	/**
	 * 生成映射到本地的路径,如果存在图片，删除原来图片
	 * 
	 * @param exGoods
	 *            上传的物品
	 * @return 相对于服务器的路径
	 * */
	private String createPath(ExGoods exGoods) throws Exception {
		String filePath = exGoods.getgPic();
		MultipartFile file = exGoods.getgPicFile();
		File oldFile = new File(MyConstants.TOMCAT_PATH + filePath);// 得到原来图片
		if (file.getSize() > 0) {
			if (oldFile.exists() && !oldFile.isDirectory()) {
				oldFile.delete();
			}
			String oldName = file.getOriginalFilename();// 得到上传文件名称
			String suffix = oldName.substring(oldName.lastIndexOf("."));
			Calendar c = Calendar.getInstance();
			String subPackage = c.get(Calendar.YEAR) + "_"
					+ (c.get(Calendar.MONTH) + 1) + "/";
			String newName = UUID.randomUUID() + suffix;// 修改文件名字
			filePath = MyConstants.PIC_PATH + subPackage + newName;// 相对于服务器的地址
			File realFile = new File(MyConstants.TOMCAT_PATH + filePath);// 存到本地文件
			realFile.mkdirs();
			file.transferTo(realFile);
		}
		return filePath;
	}

	@Override
	public void deleteById(Integer gId) throws Exception {
		goodsMapper.deleteByPrimaryKey(gId);
	}

	/**
	 * @return 
	 * @steps 1. 查询所有记录 2.得到分页 3. 存到session中
	 * */
	@Override
	public PageBean<BundleQuery> selectByPageBean(HttpServletRequest req, Integer pc, Integer ps)
			throws Exception {
		// 查询总记录数
		int totalCount = goodsMapper.selectCount();
		// 初始化pagebean
		PageBean<BundleQuery> page = new PageBean<BundleQuery>(totalCount, pc,
				ps);
		// 查询所有数据
		List<BundleQuery> dest = null;
		List<Goods> origin = goodsMapper.selectAllByPageBean(
				page.getStartPos(), page.getPageSize());
		dest = transfer(origin, dest);

		page.settList(dest);
		req.getSession().setAttribute(MyConstants.REQUEST_PB, page);
		return page;
	}

	/**
	 * @return 
	 * @steps 1.初始化查询条件，然后查询所有数据 2.初始化分页pagebean 3.存放到 session中
	 * */
	@Override
	public PageBean<BundleQuery> queryPageBean(HttpServletRequest req, ItemQuery iq)
			throws Exception {
		if (iq != null) {
			String byU = iq.getByUName();
			if (StringUtils.isNotEmpty(byU)) {
				List<Integer> uIds = userMapper.queryByUserName(byU);
				if (!uIds.isEmpty() && uIds != null) {
					iq.setuIds(uIds);
				} else {
					uIds.add(null);
					iq.setuIds(uIds);
				}
			}
		}

		// 初始化iq
		iq.init();
		// 查询所有数据
		List<Goods> origin = goodsMapper.queryPageBean(iq);
		if (StringUtils.isEmpty(iq.getByGName())) {
			iq.setByGName(null);
		}
		// 查询总记录数
		int totalCount = queryPageBeanCount(req, iq);

		// 初始化pagebean
		PageBean<BundleQuery> page = new PageBean<BundleQuery>(totalCount,
				iq.getPc(), iq.getPs());
		// 转换
		List<BundleQuery> dest = null;
		dest = transfer(origin, dest);

		page.settList(dest);
		req.getSession().setAttribute(MyConstants.REQUEST_PB, page);
		return page;

	}

	@Override
	public int queryPageBeanCount(HttpServletRequest req, ItemQuery iq)
			throws Exception {
		return goodsMapper.queryCount(iq);
	}

	@Override
	public void queryBeanByGoodsName(HttpServletRequest req, ItemQuery iq)
			throws Exception {
	}

	@Override
	public void queryBeanByUserName(HttpServletRequest req, ItemQuery iq)
			throws Exception {
	}

}
