package com.hj.servlet;

import com.hj.entity.Message;
import com.hj.service.MessageService;
import com.hj.service.impl.MessageServiceImpl;
import org.junit.jupiter.api.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Author: hj
 * Date: 2019-04-24 17:03
 * Description: 列表页面初始化控制
 */
public class ListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置接收的编码
        req.setCharacterEncoding("utf-8");
        MessageService messageService = new MessageServiceImpl();
        //List<Message> messageList = messageService.show();
        //接收页面的值
        String command = req.getParameter("command");
        String description = req.getParameter("description");
        Message message = new Message();
        message.setCommand(command);
        message.setDescription(description);
        //设置查询缓存
        req.setAttribute("command", command);
        req.setAttribute("description", description);
        List<Message> messageList1 = messageService.showQuery(message);
        //向页面传值
        req.setAttribute("messageList", messageList1);
        req.getRequestDispatcher("/WEB-INF/jsp/back/list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req, resp);
    }
}
