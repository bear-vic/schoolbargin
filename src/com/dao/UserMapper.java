package com.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import com.entity.UC;
import com.entity.User;

public interface UserMapper {
	int deleteByPrimaryKey(Integer uId);

	int insert(User record);

	int insertSelective(User record);

	User selectByPrimaryKey(@Param("uId") Integer uId);

	int updateByPrimaryKeySelective(User record);

	int updateByPrimaryKey(User record);

	/**
	 * @return User
	 * @param
	 */
	User selectByUserName(String getuName);

	/**
	 * @return List
	 * @param
	 */
	List<Integer> queryByUserName(@Param("uname") String uname);

	UC selectById(int id);

}