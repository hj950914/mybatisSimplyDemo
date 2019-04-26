package com.hj.service;

import com.hj.entity.Command;

import java.util.List;

/**
 * Author: hj
 * Date: 2019-04-26 15:53
 * Description: Command表相关操作
 */
public interface CommandService {

    //根据条件查询表
    public List<Command> queryCommandList(Command command);

    //单条删除
    public void deleteOne(String id);
}
