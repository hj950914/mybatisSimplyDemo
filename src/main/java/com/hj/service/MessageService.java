package com.hj.service;

import com.hj.entity.Message;

import java.util.List;

/**
 * Author: hj
 * Date: 2019-04-24 19:07
 * Description: Message表相关操作
 */
public interface MessageService {

    //将message表数据读取到页面展示
    public List<Message> show();

    //根据条件查询数据
    public List<Message> showQuery(Message message);

    //单条删除数据
    public void deleteOne(String id);

    //批量删除
    public void deleteBatch(String[] ids);
}
