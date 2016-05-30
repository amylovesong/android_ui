package com.sun.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.sun.ui.paint.PathView;

public class PaintActivity extends AppCompatActivity {
    private ViewGroup mPathViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        mPathViewContainer = (ViewGroup) findViewById(R.id.activity_paint_path_view_container);

        addPathView();
    }

    private void addPathView() {
        PathView pathView = new PathView(getApplicationContext());
        ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT);
        pathView.setLayoutParams(lp);

        mPathViewContainer.addView(pathView);
    }
}
