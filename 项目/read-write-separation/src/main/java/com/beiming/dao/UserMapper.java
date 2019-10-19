package com.beiming.dao;


import org.apache.ibatis.annotations.Mapper;
import com.beiming.entity.User;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{

}
