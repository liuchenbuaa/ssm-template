package com.zhuo.framework.mapper;

import com.zhuo.framework.BaseTest;
import com.zhuo.framework.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by liuchen on 18/2/24.
 */
public class UserMapperTest extends BaseTest{

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    @Test
    public void Test(){
        SqlSession session = sqlSessionFactory.openSession();
        AllMapper userMapper = session.getMapper(AllMapper.class);
        User user = userMapper.getUser(1);
        System.out.println(user);
        session.close();
    }
}
