package com.example.dayp6;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.dayp6.base.BaseApp;
import com.example.dayp6.bean.User;
import com.example.dayp6.db.DaoSession;
import com.example.dayp6.db.UserDao;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tl)
    Toolbar tl;
    @BindView(R.id.ed_name)
    EditText edName;
    @BindView(R.id.ed_pass)
    EditText edPass;
    @BindView(R.id.btn_login)
    Button btnLogin;
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initview();
    }

    private void initview() {
        userDao = BaseApp.getInstance().getDaoSession().getUserDao();
        List<User> users = userDao.loadAll();
        if (users.isEmpty()){
            for (int i = 0; i <10 ; i++) {
                userDao.insertOrReplace(new User(null,"张三"+i,"123456","男","1909a","22")) ;
                userDao.insertOrReplace(new User(null,"王五"+i,"123456","男","1909b","22")) ;
            }
        }

    }

    @OnClick(R.id.btn_login)
    public void onViewClicked() {
        String name = edName.getText().toString();
        String pass = edPass.getText().toString();
        if (!TextUtils.isEmpty(name)&&!TextUtils.isEmpty(pass)){
            List<User> list = userDao.queryBuilder().where(UserDao.Properties.Name.eq(name), UserDao.Properties.Pass.eq(pass)).list();
            if (list.size()>0&&!list.isEmpty()){
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, ShuActivity.class);
                UserDao userDao = BaseApp.getInstance().getDaoSession().getUserDao();
                List<User> userList = userDao.queryBuilder().where(UserDao.Properties.Name.eq(name)).list();
                User user = userList.get(0);
               String classname = user.getClassname();
                intent.putExtra("name",classname);
                startActivity(intent);
            }else {
                Toast.makeText(this, "账号密码不存在", Toast.LENGTH_SHORT).show();
            }

        }else {
            Toast.makeText(this, "用户名与密码不能为空", Toast.LENGTH_SHORT).show();
        }

    }
}
