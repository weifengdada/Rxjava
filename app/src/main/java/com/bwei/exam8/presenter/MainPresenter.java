package com.bwei.exam8.presenter;

import com.bwei.exam8.MainActivity;
import com.bwei.exam8.bean.DataDataBean;
import com.bwei.exam8.model.MainModel;
import com.bwei.exam8.model.ModelCallBack;
import com.bwei.exam8.view.MainView;

/**
 * Created by acer on 2017/12/6.
 */

public class MainPresenter {
    MainView view;
    MainModel mainModel;
    public MainPresenter(MainView view) {
        this.view=view;
        this.mainModel=new MainModel();
    }
    public void get(){

        mainModel.getData(new ModelCallBack() {
            @Override
            public void success(DataDataBean bean) {
              if(view!=null){
                  view.success(bean);
              }
            }

            @Override
            public void failure(Exception e) {


            }
        });




    }



}
