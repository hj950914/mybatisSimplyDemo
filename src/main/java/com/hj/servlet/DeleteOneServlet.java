package com.hj.servlet;

import com.hj.entity.Message;
import com.hj.service.MessageService;
import com.hj.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: hj
 * Date: 2019-04-25 16:14
 * Description: 单条删除servlet
 */
public class DeleteOneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        //接收页面的值
        String id = req.getParameter("id");
        MessageService messageService = new MessageServiceImpl();
        messageService.deleteOne(id);
        //向页面跳转
        req.getRequestDispatcher("/List.action").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
