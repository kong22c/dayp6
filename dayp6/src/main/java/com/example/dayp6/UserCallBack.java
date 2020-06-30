package com.example.dayp6;

import com.example.dayp6.bean.User;

import java.util.List;

public interface UserCallBack {
    void onSucess(List<User>users);
    void onFain(String str);
}
