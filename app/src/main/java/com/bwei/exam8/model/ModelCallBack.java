package com.bwei.exam8.model;

import com.bwei.exam8.bean.DataDataBean;

/**
 * Created by acer on 2017/12/6.
 */

public interface ModelCallBack {
    public void success(DataDataBean bean);
    public void failure(Exception e);
}
