package com.test.dao.daoImp;

import com.test.dao.Idao.IUserDao;
import com.test.domain.UserBean;
import com.test.utils.commonUtils.DBHelper;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDaoImp implements IUserDao{

    @Override
    public UserBean findUser(UserBean userBean) {
        DBHelper doHelper = new DBHelper();
        String sql = "select name,sex,age,phone,address,createtime from user where name = ?";
        ResultSet resultSet = null;
        UserBean user = new UserBean();
        PreparedStatement preparedStatement = null;
        try {
            preparedStatement = doHelper.getConn().prepareStatement(sql);
            preparedStatement.setString(1,user.getName());
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()){
                user.setName(resultSet.getString("name"));
                user.setAge(resultSet.getInt("age"));
                user.setSex(resultSet.getString("sex"));
                user.setAddress(resultSet.getString("address"));
                user.setPhone(resultSet.getString("phone"));
                user.setCreatetime(resultSet.getString("createtime'"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            try {
                resultSet.close();
                preparedStatement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }

    @Override
    public void addUser(UserBean userBean) {

    }

    @Override
    public boolean changeUserFlag(UserBean userBean) {
        return false;
    }

    @Override
    public void updateUser(UserBean userBean) {

    }
}
