package com.hj.servlet;

import com.hj.service.CommandService;
import com.hj.service.impl.CommandServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: hj
 * Date: 2019-04-26 17:09
 * Description: command表实现单条删除
 */
public class CommandDeleteOneServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //接收页面的值
        String id = req.getParameter("id");
        //调用后台数据库
        CommandService commandService = new CommandServiceImpl();
        commandService.deleteOne(id);
        //返回列表页面
        req.getRequestDispatcher("/CommandListSrvlet.action").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
