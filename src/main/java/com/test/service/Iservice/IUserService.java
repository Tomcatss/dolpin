package com.test.service.Iservice;

import com.test.domain.UserBean;
import com.test.pojo.UserPojo;

public interface IUserService {
    public UserPojo findUser(UserBean userBean);
}
