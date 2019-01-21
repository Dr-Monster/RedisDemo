package com.example.mapper;
import java.util.List;

import com.example.dto.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 
 * TUserMapper数据库操作接口类
 * 
 **/
public interface TUserMapper{


	/**
	 * 
	 * 查询（根据主键ID查询）
	 * 
	 **/
	TUser selectByPrimaryKey(@Param("id") Long id);

	/**
	 * 
	 * 添加
	 * 
	 **/
	int insert(TUser record);

	/**
	 * 
	 * 添加 （匹配有值的字段）
	 * 
	 **/
	int insertSelective(TUser record);

	/**
	 * 
	 * 修改 （匹配有值的字段）
	 * 
	 **/
	int updateByPrimaryKeySelective(TUser record);

	/**
	 * 
	 * 分页查询</br>eg: xx.getByPage(null, 0, 3, "id", "desc");
	 * 
	 **/
	List<TUser> getByPage(@Param("tUser") TUser tUser, @Param("start") Integer start, @Param("limit") Integer limit, @Param("orderColumn") String orderColumn, @Param("orderType") String orderType);

	/**
	 * 
	 * 根据实体属性查询
	 * 
	 **/
	List<TUser> getListByCondition(@Param("tUser") TUser tUser);

	/**
	 * 
	 * 根据实体属性查询
	 * 
	 **/
	int getCountByCondition(@Param("tUser") TUser tUser);

	/**
	 * 
	 * 查询单条数据
	 * 
	 **/
	TUser getOneByCondition(@Param("tUser") TUser tUser);


	List<TUser> selectAll();

}