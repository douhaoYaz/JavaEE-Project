package pers.douhaoyaz.userlogin.service;

import pers.douhaoyaz.userlogin.entity.User;
import pers.douhaoyaz.userlogin.entity.vo.MessageModel;

/**
 * 业务逻辑
 */
public class UserService {

    /**
     * @description
     *      用户登录：
     *      1. 参数的非空判断
     *      2. 调用dao层的查询方法，通过用户名查询用户对象
     *      3. 判断用户对象是否为空
     *      4. 比较数据库查询到的密码和前台传递过来的密码
     *      5. 登录成功，设置消息模型对象的成功状态、提示信息、用户对象，并return
     * @param uname
     * @param upwd
     * @return
     */
    public MessageModel userLogin(String uname, String upwd) {
        MessageModel messageModel = new MessageModel();

        // 回显数据
        User u = new User();
        u.setUserName(uname);
        u.setUserPwd(upwd);
        messageModel.setObject(u);

        // 1. 参数的非空判断
        if(uname == null || "".equals(uname.trim())){
            // 将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("记得填账号哦");
            return messageModel;
        }
        if(upwd == null || "".equals(upwd.trim())){
            // 将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("记得填密码哦");
            return messageModel;
        }

        // TODO 连接数据库查询，即2. 调用dao层的查询方法，通过用户名查询用户对象
        // TODO 3. 判断用户对象是否为空
        // TODO 4. 比较数据库查询到的密码和前台传递过来的密码

        return messageModel;
    }
}
