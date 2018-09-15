package com.test.service.serviceImp;

import com.test.dao.Idao.IUserDao;
import com.test.dao.daoImp.UserDaoImp;
import com.test.domain.UserBean;
import com.test.pojo.UserPojo;
import com.test.service.Iservice.IUserService;

public class UserServiceImp implements IUserService {

    @Override
    public UserPojo findUser(UserBean userBean) {
        IUserDao userDao = new UserDaoImp();
        UserBean userBean1 = userDao.findUser(userBean);
        UserPojo userPojo = new UserPojo();
        userPojo.setName(userBean1.getName());
        userPojo.setAge(userBean1.getAge());
        userPojo.setSex(userBean1.getSex());
        return userPojo;
    }
}
