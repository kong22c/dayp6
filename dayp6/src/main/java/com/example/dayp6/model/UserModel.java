package com.example.dayp6.model;

import com.example.dayp6.UserCallBack;
import com.example.dayp6.base.BaseApp;
import com.example.dayp6.base.BaseModel;
import com.example.dayp6.bean.User;
import com.example.dayp6.db.UserDao;

import java.util.List;

public class UserModel  extends BaseModel{
    public void select(String classname,UserCallBack callBack){
        try {
            UserDao userDao = BaseApp.getInstance().getDaoSession().getUserDao();
            List<User> users = userDao.queryBuilder().where(UserDao.Properties.Classname.eq(classname)).list();
            callBack.onSucess(users);
        } catch (Exception e) {
            e.printStackTrace();
            callBack.onFain("数据库为空");
        }
    }
}
