package pers.douhaoyaz.userlogin.controller;

import pers.douhaoyaz.userlogin.entity.vo.MessageModel;
import pers.douhaoyaz.userlogin.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {

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
        // 接收login.jsp提交的用户登录数据
        String uname = req.getParameter("uname");
        String upwd = req.getParameter("upwd");

        // 2. 调用service层方法，返回消息模型对象
        MessageModel messageModel = userService.userLogin(uname, upwd);
        // 3. 判断消息模型的状态码，根据其值决定跳转到哪个页面
        if(messageModel.getCode() == 1){
            // 将消息模型中的用户信息设置到session作用域中，重定向跳转到奥success.jsp
            req.getSession().setAttribute("messageModel", messageModel);
            resp.sendRedirect("success.jsp");
        }
        else{
            // 将消息模型对象设置到request作用域中，请求转发跳转到failure.jsp
            req.setAttribute("messageModel", messageModel);     //设置整个messageModel是因为既需要它的提示信息也需要它的回显对象
            req.getRequestDispatcher("failure.jsp").forward(req, resp);
        }

    }
}
