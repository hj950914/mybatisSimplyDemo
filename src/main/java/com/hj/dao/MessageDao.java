package com.hj.dao;

import com.hj.entity.Message;
import com.hj.util.DBAccess;
import com.hj.util.JdbcUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.hj.util.DBAccess.getSqlSession;

/**
 * Author: hj
 * Date: 2019-04-24 18:33
 * Description: <描述>
 */
public class MessageDao {

    private PreparedStatement ps;
    private ResultSet rs;


    //查询message表(使用JDBC)
    public List<Message> query() {
        //String sql = "select * from message";
        StringBuilder sql = new StringBuilder("select * from message");
        Connection connection = JdbcUtil.getConnection();
        List<Message> messageList = new ArrayList<>();//存放message内容
        try {
            ps = connection.prepareStatement(sql.toString());
            rs = ps.executeQuery();
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setCommand(rs.getString("command"));
                message.setDescription(rs.getString("description"));
                message.setContent(rs.getString("content"));
                messageList.add(message);
            }
            //关闭资源
            JdbcUtil.close(ps, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }

    //根据条件查询message表(使用JDBC)
    public List<Message> queryMessageList(Message message) {
        String command = message.getCommand();
        String description = message.getDescription();
        //存放查询到的数据
        List<Message> messageList = new ArrayList<>();
        StringBuilder sql = new StringBuilder("select * from message where 1=1 ");
        //设置缓存
        List<String> stringList = new ArrayList<>();
        if (command != null && !"".equals(command.trim())) {
            sql.append(" and command=? ");
            stringList.add(command);
        }
        if (description != null && !"".equals(description.trim())) {
            sql.append(" and description like '%' ? '%'");
            stringList.add(description);
        }
        Connection connection = JdbcUtil.getConnection();
        try {
            ps = connection.prepareStatement(sql.toString());
            for (int i = 0; i < stringList.size(); i++) {
                ps.setString(i + 1, stringList.get(i));
            }
            rs = ps.executeQuery();
            while (rs.next()) {
                Message message1 = new Message();
                message1.setId(rs.getInt("ID"));
                message1.setCommand(rs.getString("command"));
                message1.setDescription(rs.getString("description"));
                message1.setContent(rs.getString("CONTENT"));
                messageList.add(message1);
            }
            //关闭资源
            JdbcUtil.close(ps, connection);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }

    //根据条件查询message表(使用Mybatis)
    public List<Message> queryMessageList2(Message message) {
        SqlSession sqlSession = null;
        List<Message> messageList = new ArrayList<>();
        try {
            sqlSession = DBAccess.getSqlSession();
            //通过sqlSession执行sql语句
            messageList = sqlSession.selectList("Message.queryMessageList2", message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
        return messageList;
    }

    //删除单条内容(使用Mybatis)
    public void deleteOne(int id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBAccess.getSqlSession();
            //通过sqlSession执行sql语句
            sqlSession.delete("Message.deleteOne", id);
            //删除操作需要设置提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    //删除多条内容(使用Mybatis)
    public void deleteBatch(List<Integer> listId) {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBAccess.getSqlSession();
            //通过sqlSession执行sql语句
            sqlSession.delete("Message.deleteBatch", listId);
            //删除操作需要设置提交
            sqlSession.commit();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (sqlSession != null) {
                sqlSession.close();
            }
        }
    }

    @Test
    public void test1() {
        /*List<Message> messageList = new MessageDao().query();
        System.out.println(messageList);*/

        /*Message message = new Message();
        message.setCommand("查看");
        message.setDescription("精彩");
        List<Message> messageList = new MessageDao().queryMessageList2(message);
        System.out.println(messageList);*/

        Integer[] ids = {16, 17, 18};
        List<Integer> listId = new ArrayList<>(Arrays.asList(ids));
        new MessageDao().deleteBatch(listId);
    }
}
