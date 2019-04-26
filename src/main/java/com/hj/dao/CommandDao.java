package com.hj.dao;

import com.hj.entity.Command;
import com.hj.entity.CommandContent;
import com.hj.util.DBAccess;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * Author: hj
 * Date: 2019-04-26 14:37
 * Description: <描述>
 */
public class CommandDao {

    //根据条件查询command表和command_content(使用Mybatis)
    public List<Command> queryCommandList(Command command) {
        SqlSession sqlSession = null;
        List<Command> commandList = null;
        try {
            sqlSession = DBAccess.getSqlSession();
            commandList = sqlSession.selectList("Command.queryCommandList", command);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return commandList;
    }

    //单条删除
    public void deleteOne(int id) {
        SqlSession sqlSession = null;
        try {
            sqlSession = DBAccess.getSqlSession();
            sqlSession.delete("Command.deleteOne", id);
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
    public void testQuery() {
        Command command = new Command();
        command.setName("查看");
        command.setDescription("精彩");
        List<Command> commandList = new CommandDao().queryCommandList(command);
        for (int i = 0; i < commandList.size(); i++) {
            List<CommandContent> contentList = commandList.get(i).getContentList();
            System.out.println(contentList);
        }
        //System.out.println(commandList);
    }

    @Test
    public void testDelete(){
        new CommandDao().deleteOne(13);
    }

}
