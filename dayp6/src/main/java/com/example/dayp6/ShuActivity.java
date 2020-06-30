package com.example.dayp6;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.dayp6.adapter.UserAdapter;
import com.example.dayp6.base.BaseActivity;
import com.example.dayp6.base.BaseApp;
import com.example.dayp6.base.BaseModel;
import com.example.dayp6.bean.User;
import com.example.dayp6.db.UserDao;
import com.example.dayp6.presenter.UserPresenter;
import com.example.dayp6.view.UserView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ShuActivity extends BaseActivity<UserPresenter> implements UserView {


    @BindView(R.id.rv)
    RecyclerView rv;
    private UserAdapter adapter;
    private ArrayList<User> users;
    private String name;


    @Override
    protected void initLister() {

    }

    @Override
    protected void initData() {
        mPresenter.select(name);

    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        //Log.i("444", "initView: "+classname);
        rv.setLayoutManager(new LinearLayoutManager(this));
       rv.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        users = new ArrayList<>();
        adapter = new UserAdapter(this, users);
        rv.setAdapter(adapter);
    }

    @Override
    protected void initPresenter() {
       mPresenter = new UserPresenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_shu;
    }

    @Override
    public void setData(List<User> list) {
        users.addAll(list);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void showToast(String str) {
        Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
    }


}
