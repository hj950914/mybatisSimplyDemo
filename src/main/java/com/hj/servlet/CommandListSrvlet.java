package com.hj.servlet;

import com.hj.entity.Command;
import com.hj.service.CommandService;
import com.hj.service.impl.CommandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author: hj
 * Date: 2019-04-26 16:03
 * Description: 使用command表查询数据进行页面跳转
 */
public class CommandListSrvlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置接收的编码
        req.setCharacterEncoding("utf-8");
        CommandService commandService = new CommandServiceImpl();
        //接收页面的值
        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Command command = new Command();
        command.setName(name);
        command.setDescription(description);
        //设置查询缓存
        req.setAttribute("name", name);
        req.setAttribute("description", description);
        List<Command> commandList = commandService.queryCommandList(command);
        //向页面传值
        req.setAttribute("commandList", commandList);
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
