package com.example.dayp6.view;

import com.example.dayp6.base.BaseView;
import com.example.dayp6.bean.User;

import java.util.List;

public interface UserView extends BaseView {
    void setData(List<User>list);
}
