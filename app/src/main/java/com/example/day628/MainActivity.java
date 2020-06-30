package com.example.day628;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.day628.build.Computer;
import com.example.day628.build.HuaweiBuilder;
import com.example.day628.build.MacBuilder;
import com.example.day628.factory.Apple;
import com.example.day628.factory.Banana;
import com.example.day628.factory.SuperFactoryImpl;
import com.example.day628.obser.KingHonor;
import com.example.day628.obser.LittleStudent;
import com.example.day628.obser.Teacher;
import com.example.day628.single.SingleTon;
import com.example.day628.single.SingleTon1;
import com.example.day628.single.SingleTon2;
import com.example.day628.single.SingleTon3;
import com.example.day628.template.ArmyComputer;
import com.example.day628.template.Coder;
import com.example.day628.template.XiaobaiComputer;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button mBtn;
    private KingHonor kingHonor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
        single();
        obser();
        factory();
        build();
        template();
    }

    private void template() {
        new XiaobaiComputer().start();
        new Coder().start();
        new ArmyComputer().start();
    }

    private void build() {
        Computer huawei = new HuaweiBuilder()
                .buildCpu("intel 9.0 芯片")
                .buildDisplay("xxx 显示器")
                .buildOs()
                .build();


        Computer mac = new MacBuilder()
                .buildOs()
                .buildCpu("intel 7.0 芯片")
                .buildDisplay("retina 显示器")
                .build();

        Log.d("111", "huawei: "+huawei.toString());
        Log.d("1111", "mac: "+mac.toString());
    }

    private void factory() {
        /*Product apple = new AppleFactory().createProduct();
        Product banana = new BananaFactory().createProduct();
        apple.print();
        banana.print();
*/
        SuperFactoryImpl superFactory = new SuperFactoryImpl();
        Apple apple1 = superFactory.createProduct(Apple.class);
        Banana banana1 = superFactory.createProduct(Banana.class);
        apple1.print();
        banana1.print();

    }

    private void obser() {
        kingHonor = new KingHonor();
        LittleStudent littleStudent = new LittleStudent();
        Teacher teacher = new Teacher();

        //添加观察者
       kingHonor.addObserver(littleStudent);
        kingHonor.addObserver(teacher);
    }
    private void single() {
        SingleTon instance1 = SingleTon.getInstance();
        SingleTon instance2 = SingleTon.getInstance();
        Log.i("1111", "single: " + instance1 + "==========" + instance2);
        SingleTon1 instance = SingleTon1.getInstance();
        SingleTon1 instance3 = SingleTon1.getInstance();
        Log.i("1111", "single: " + instance + "==========" + instance3);
        SingleTon2 instance4 = SingleTon2.getInstance();
        SingleTon2 instance5 = SingleTon2.getInstance();
        Log.i("1111", "single: " + instance4 + "==========" + instance5);
        SingleTon3 instance6 = SingleTon3.getInstance();
        SingleTon3 instance7 = SingleTon3.getInstance();
        Log.i("1111", "single: " + instance6 + "==========" + instance7);
    }

    private void initViews() {
        mBtn = findViewById(R.id.btn);
        mBtn.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
       kingHonor.gameUpdate("农药更新了,快来喝!");
    }
}
