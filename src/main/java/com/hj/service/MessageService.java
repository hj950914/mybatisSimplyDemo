package com.hj.service;

import com.hj.entity.Message;

import java.util.List;

/**
 * Author: hj
 * Date: 2019-04-24 19:07
 * Description: <描述>
 */
public interface MessageService {

    //将message表数据读取到页面展示
    public List<Message> show();
}
