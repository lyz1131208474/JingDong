package com.example.administrator.jingdong.Fragment.WoDe;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.jingdong.Fragment.WoDe.DengLu.DengLu;
import com.example.administrator.jingdong.Fragment.WoDe.TX_touxiang.Tx_Activity;
import com.example.administrator.jingdong.R;

public class WoDeFragment extends Fragment {
    private View view;
    private ImageView DL_Img;
    /**
     * 用户登录
     */
    private TextView DL_Text;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View contentView = inflater.inflate(R.layout.fr_wode, container, false);

        initView(contentView);
        return contentView;

    }

    private void initView(View contentView) {
        DL_Img = (ImageView) contentView.findViewById(R.id.DL_img);
        DL_Text = (TextView) contentView.findViewById(R.id.DL_text);
        DL_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent DL_intent = new Intent(getActivity(), DengLu.class);
                startActivity(DL_intent);
            }
        });

        DL_Img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tx_intent = new Intent(getActivity(), Tx_Activity.class);
                startActivity(tx_intent);
            }
        });
    }
}
