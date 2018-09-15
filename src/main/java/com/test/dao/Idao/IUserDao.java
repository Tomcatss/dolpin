package com.test.dao.Idao;

import com.test.domain.UserBean;

public interface IUserDao {
    //用户登录，查找用户信息
    public UserBean findUser(UserBean userBean);

    //用户注册
    public void addUser(UserBean userBean);

    //设置用户状态标志位
    public boolean changeUserFlag(UserBean userBean);

    //用户修改个人信息
    public void updateUser(UserBean userBean);

}
