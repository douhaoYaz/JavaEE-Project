package pers.douhaoyaz.userlogin.controller;

import pers.douhaoyaz.userlogin.entity.vo.MessageModel;
import pers.douhaoyaz.userlogin.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServlet extends HttpServlet {

    // 实例化UserService对象
    private UserService userService = new UserService();

    /**
     * @description
     *      1. 接收客户端的请求（接收参数：姓名、密码）
     *      2. 调用service层方法，返回消息模型对象
     *      3. 判断消息模型的状态码，根据其值决定跳转到哪个页面
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. 接收客户端的请求（接收参数：姓名、密码）
        // 设置客户端的编码格式，防止出现乱啊
        req.setCharacterEncoding("UTF-8");
        // 接收register.jsp提交的用户登录数据
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");
        String upwd_confirm = req.getParameter("upwd_confirm");

        // 2. 调用service层方法，返回消息模型对象
        MessageModel messageModel = userService.userRegister(uname, upwd, upwd_confirm);

        // 3. 判断消息模型的状态码，根据其值决定跳转到哪个页面
        if(messageModel.getCode() == 1){
//            // 注册成功则跳转到登录页面login.jsp
//            resp.sendRedirect("login.jsp");
            // 设置注册成功信息到request域对象并转发到register.jsp让用户点击链接跳转
            req.setAttribute("regSuccess", "注册成功！输入账号名和密码登录叭");
            req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
        else{
            // 注册失败则留在本页register.jsp，并显示失败原因
            req.setAttribute("messageModel", messageModel.getMsg());
            req.getRequestDispatcher("register.jsp").forward(req, resp);
        }

    }
}
