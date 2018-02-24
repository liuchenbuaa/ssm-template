package com.zhuo.framework.mapper;

import com.zhuo.framework.model.User;
import org.apache.ibatis.annotations.Select;

/**
 * Created by liuchen on 18/2/24.
 */
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getUser(int id);
}
