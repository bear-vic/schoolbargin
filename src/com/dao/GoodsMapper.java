package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.entity.Goods;
import com.entity.ex.ItemQuery;

public interface GoodsMapper {
	int deleteByPrimaryKey(Integer gId);

	int insert(Goods record);

	int insertSelective(Goods record);

	Goods selectByPrimaryKey(Integer gId);

	int updateByPrimaryKeySelective(Goods record);

	int updateByPrimaryKeyWithBLOBs(Goods record);

	int updateByPrimaryKey(Goods record);

	List<Goods> selectAll();

	List<Goods> selectByUserId(Integer uId);

	List<Goods> selectAllByPageBean(@Param("startPos") int startPos,
			@Param("pageSize") int pageSize) throws Exception;

	int selectCount() throws Exception;

	int queryCount(ItemQuery iq) throws Exception;

	List<Goods> queryPageBean(ItemQuery iq) throws Exception;
}