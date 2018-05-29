package com.example.administrator.jingdong.view.GouWuChe_View;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ExpandableListView;

public class Goucard  extends ExpandableListView {


    public Goucard(Context context) {
        super(context);
    }

    public Goucard(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public Goucard(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int i = View.MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, View.MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, i);
    }
}
