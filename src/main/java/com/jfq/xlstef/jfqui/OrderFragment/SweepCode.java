package com.jfq.xlstef.jfqui.OrderFragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import com.jfq.xlstef.jfqui.OrderFragment.Adapter.CategoryAdapter;
import com.jfq.xlstef.jfqui.R;

public class SweepCode  extends BaseFragment {

    //初始化特有数据
    public  SweepCode()
    {
        pageLayout= R.layout.sweep_code_layout3;
        path="http://store.tuihs.com/store/orders/paid?page=0&size=10";
         CategoryAdapter.mOrdername=CategoryAdapter.OrderName.SweepCode;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        return super.onCreateView(inflater, container, savedInstanceState);
    }


}
