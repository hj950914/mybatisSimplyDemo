package com.hj.servlet;

import com.hj.service.MessageService;
import com.hj.service.impl.MessageServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Author: hj
 * Date: 2019-04-25 16:59
 * Description: 批量删除servlet
 */
public class DeleteBatchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        req.setCharacterEncoding("UTF-8");
        //接收页面的值
        String[] parameterValues = req.getParameterValues("ids");
        MessageService messageService = new MessageServiceImpl();
        messageService.deleteBatch(parameterValues);
        //向页面跳转
        req.getRequestDispatcher("/List.action").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
