package com.hj.service.impl;

import com.hj.dao.MessageDao;
import com.hj.entity.Message;
import com.hj.service.MessageService;

import java.util.List;

/**
 * Author: hj
 * Date: 2019-04-24 19:09
 * Description: <描述>
 */
public class MessageServiceImpl implements MessageService {

    @Override
    public List<Message> show() {
        MessageDao messageDao = new MessageDao();
        List<Message> messageList = messageDao.query();
        return messageList;
    }
}
