package pers.douhaoyaz.userlogin.service;

import pers.douhaoyaz.userlogin.DAO.DAO;
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

        // 连接数据库查询，即2. 调用dao层的查询方法，通过用户名查询用户对象
        User user = DAO.login(uname);

        // 3. 判断用户对象是否为空
        if(user == null){
            // 将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("我从没见过这样的人，你不要骗我哦");
            return messageModel;
        }

        // 4. 比较数据库查询到的密码和前台传递过来的密码
        if(!upwd.equals(user.getUserPwd())){
            // 如果不相等，将状态码、提示信息、回显数据设置到消息模型对象中，返回消息模型对象
            messageModel.setCode(0);
            messageModel.setMsg("有内鬼，终止交易");
            return messageModel;
        }

        // 5.登录成功，设置消息模型对象的成功状态、提示信息、用户对象，并return
        messageModel.setCode(1);
        messageModel.setMsg("Link Start!");
        messageModel.setObject(user);

        return messageModel;
    }

    /**
     * @description
     *      1. 参数的非空判断
     *      2. 密码的确认
     *      3. 调用DAO层的注册register方法，根据注册成功或失败来设置messageModel对象并返回
     * @param uname
     * @param upwd
     * @param upwd_confirm
     * @return
     */
    public MessageModel userRegister(String uname, String upwd, String upwd_confirm) {

        MessageModel messageModel = new MessageModel();

        System.out.println("UserService:");
        System.out.println("uname: " + uname);
        System.out.println("upwd: " + upwd);
        System.out.println("upwd_confirm: " + upwd_confirm);
        System.out.println(String.format("INSERT INTO user (userName, userPwd) values('%s', '%s')", uname, upwd));

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

        // 2. 密码的确认
        if(!upwd.equals(upwd_confirm)){
            // 密码不一致
            messageModel.setCode(0);
            messageModel.setMsg("两次输入的密码不同哦");
            return messageModel;
        }

        // 3. 调用DAO层的注册register方法，根据注册成功或失败来设置messageModel对象并返回
        int flag = DAO.register(uname, upwd);
        if (flag == 1){
            messageModel.setCode(1);
            messageModel.setMsg("注册成功");
        }
        else if (flag == 2){
            // 数据库查询到已存在账号名和uname一样的数据
            messageModel.setCode(0);
            messageModel.setMsg("这个名字已经被别人起啦，你换一个叭");
        }
        else if (flag == 0){
            // 数据库操作失败
            messageModel.setCode(0);
            messageModel.setMsg("数据库操作失败");
        }

        return  messageModel;
    }
}
