package com.bwei.exam8.view;

import com.bwei.exam8.bean.DataDataBean;

/**
 * Created by acer on 2017/12/6.
 */

public interface MainView {
    public void success(DataDataBean bean);
    public void failure(Exception e);
}
