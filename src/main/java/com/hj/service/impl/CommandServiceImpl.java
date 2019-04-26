package com.hj.service.impl;

import com.hj.dao.CommandDao;
import com.hj.entity.Command;
import com.hj.service.CommandService;

import java.util.List;

/**
 * Author: hj
 * Date: 2019-04-26 16:01
 * Description: <描述>
 */
public class CommandServiceImpl implements CommandService {
    @Override
    public List<Command> queryCommandList(Command command) {
        List<Command> commandList = null;
        CommandDao commandDao = new CommandDao();
        commandList = commandDao.queryCommandList(command);
        return commandList;
    }

    @Override
    public void deleteOne(String id) {
        CommandDao commandDao = new CommandDao();
        commandDao.deleteOne(Integer.valueOf(id));
    }
}


