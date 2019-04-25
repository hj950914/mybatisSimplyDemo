package com.hj.util;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.Reader;

/**
 * Author: hj
 * Date: 2019-04-25 13:29
 * Description: 访问数据库类
 */
public class DBAccess {

    public static SqlSession getSqlSession() throws IOException {
        //读取配置文件
        Reader reader = Resources.getResourceAsReader("Configuration.xml");
        //构建一个SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        //通过SqlSessionFactory打开一个数据库会话
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession;
    }

    @Test
    public void test1() throws IOException {
        SqlSession sqlSession = DBAccess.getSqlSession();
        if (sqlSession != null) {
            System.out.println("mybatis连接数据库成功");
            sqlSession.close();
        }
    }
}
