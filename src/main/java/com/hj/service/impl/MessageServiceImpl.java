package com.hj.service.impl;

import com.hj.dao.MessageDao;
import com.hj.entity.Message;
import com.hj.service.MessageService;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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

    @Override
    public List<Message> showQuery(Message message) {
        MessageDao messageDao = new MessageDao();
        List<Message> messageListWhere = messageDao.queryMessageList2(message);
        return messageListWhere;
    }

    @Override
    public void deleteOne(String id) {
        if (id != null && !"".equals(id)) {
            MessageDao messageDao = new MessageDao();
            messageDao.deleteOne(Integer.valueOf(id));
        }
    }

    @Override
    public void deleteBatch(String[] ids) {
        MessageDao messageDao = new MessageDao();
        List<Integer> listId = new ArrayList<>();
        for (int i = 0; i < ids.length; i++) {
            listId.add(Integer.valueOf(ids[0]));
        }
        messageDao.deleteBatch(listId);
    }

}
