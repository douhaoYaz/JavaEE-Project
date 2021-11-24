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
            req.getSession().setAttribute("user", messageModel.getObject());
            resp.sendRedirect("success.jsp");
        }
        else{
            // 将消息模型对象设置到request作用域中，请求转发跳转到failure.jsp
            req.setAttribute("messageModel", messageModel);     //设置整个messageModel是因为既需要它的提示信息也需要它的回显对象
            req.getRequestDispatcher("failure.jsp").forward(req, resp);
        }


//        // 判断账号或密码是否为空，然后输出错误提示
//        if(uname == null || "".equals(uname.trim())){
//            // 设置request域对象来传递数据，这里不用session域对象是因为实现传递提示数据的功能，request的范围已经够用了
//            req.setAttribute("msg", "记得填账号哦");
//            // 请求转发，将请求转发到failure.jsp，因为没填账号所以要用户在failure.jsp的界面重新填一次登录信息
//            req.getRequestDispatcher("failure.jsp").forward(req, resp);
//            return;
//        }
//        if(upwd == null || "".equals(upwd.trim())){
//            // 设置request域对象来传递数据，这里不用session域对象是因为实现传递提示数据的功能，request的范围已经够用了
//            req.setAttribute("msg", "记得填密码哦");
//            // 请求转发，将请求转发到failure.jsp，因为没填密码所以要用户在failure.jsp的界面重新填一次登录信息
//            req.getRequestDispatcher("failure.jsp").forward(req, resp);
//            return;
//        }


//        // 登录成功的情况，目前先暂定账号和密码都为DearJane
//        if("DearJane".equals(uname) && "DearJane".equals(upwd)){
//            // 将登录信息设置到session域对象中，类似于某东某宝右上角的登录信息
//            req.getSession().setAttribute("uname", uname);
//            // 重定向，跳转到success.jsp登录成功页面
//            resp.sendRedirect("success.jsp");
//        }
    }
}
