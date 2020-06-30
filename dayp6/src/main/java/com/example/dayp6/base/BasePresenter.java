package com.example.dayp6.base;

import java.util.ArrayList;

public abstract class BasePresenter<V extends BaseView> {
    public V mView;
    public ArrayList<BaseModel>models=new ArrayList<BaseModel>();
    public BasePresenter(){
        initModel();
    }
    public void bindView(V view){
        mView=view;
    }

    protected abstract void initModel();
    public void addModel(BaseModel baseModel){
        models.add(baseModel);
    }

}
