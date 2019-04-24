package com.hj.dao;

import com.hj.entity.Message;
import com.hj.util.JdbcUtil;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Author: hj
 * Date: 2019-04-24 18:33
 * Description: <描述>
 */
public class MessageDao {

    private PreparedStatement ps;
    private ResultSet rs;


    //查询message表
    public List<Message> query() {
        String sql = "select * from message";
        Connection connection = JdbcUtil.getConnection();
        List<Message> messageList = new ArrayList<>();//存放message内容
        try {
            ps = connection.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Message message = new Message();
                message.setId(rs.getInt("id"));
                message.setCommand(rs.getString("command"));
                message.setDescription(rs.getString("description"));
                message.setContent(rs.getString("content"));
                messageList.add(message);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return messageList;
    }

    @Test
    public void test1(){
        List<Message> messageList = new MessageDao().query();
        System.out.println(messageList);
    }
}
