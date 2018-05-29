package com.example.administrator.jingdong.view.Fl_View;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class Fl_MyGridView extends GridView {
    public Fl_MyGridView(Context context) {
        super(context);
    }

    public Fl_MyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Fl_MyGridView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int i = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);

        super.onMeasure(widthMeasureSpec, i);
    }
}
