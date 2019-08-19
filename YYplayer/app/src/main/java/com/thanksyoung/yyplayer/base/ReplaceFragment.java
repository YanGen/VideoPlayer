package com.thanksyoung.yyplayer.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ReplaceFragment extends Fragment {
    private BasePager basePager;

    public ReplaceFragment(BasePager basePager) {
        this.basePager = basePager;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (basePager != null){
            // 各个页面的识图
            return basePager.rootview;
        }

        return null;
    }
}
