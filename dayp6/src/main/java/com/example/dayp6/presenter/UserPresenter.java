package com.example.dayp6.presenter;

import com.example.dayp6.UserCallBack;
import com.example.dayp6.base.BasePresenter;
import com.example.dayp6.bean.User;
import com.example.dayp6.model.UserModel;
import com.example.dayp6.view.UserView;

import java.util.List;

public class UserPresenter extends BasePresenter<UserView> {

    private UserModel userModel;

    @Override
    protected void initModel() {
        userModel = new UserModel();
        addModel(userModel);
    }
    public void select(String classname){
        userModel.select(classname,new UserCallBack() {
            @Override
            public void onSucess(List<User> users) {
                mView.setData(users);
            }

            @Override
            public void onFain(String str) {
                mView.showToast(str);
            }
        });
    }
}
