package com.dao;

import java.util.List;

import com.entity.Comments;

public interface CommentsMapper {
	int deleteByPrimaryKey(Integer cId);

	int insert(Comments record);

	int insertSelective(Comments record);

	Comments selectByPrimaryKey(Integer cId);

	int updateByPrimaryKeySelective(Comments record);

	int updateByPrimaryKeyWithBLOBs(Comments record);

	int updateByPrimaryKey(Comments record);

	/**
	 * @description
	 * @steps
	 * @return List<Comments>
	 * @param
	 */
	List<Comments> selectByGoodsId(int goodsId);
}