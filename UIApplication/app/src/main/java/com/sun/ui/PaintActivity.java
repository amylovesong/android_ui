package com.sun.ui;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ViewGroup;

import com.sun.ui.paint.CanvasView;
import com.sun.ui.paint.PathEffectView;
import com.sun.ui.paint.PathView;
import com.sun.ui.paint.ShaderView;

public class PaintActivity extends AppCompatActivity {
    private ViewGroup mPathViewContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_paint);
        mPathViewContainer = (ViewGroup) findViewById(R.id.activity_paint_path_view_container);

//        addPathView();
//        addPathEffectView();
//        addShaderView();
        addCanvasView();
    }

    private void addPathView() {
        PathView pathView = new PathView(getApplicationContext());
        pathView.setLayoutParams(getLayoutParams());

        mPathViewContainer.addView(pathView);
    }

    private void addPathEffectView() {
        PathEffectView pathEffectView = new PathEffectView(getApplicationContext());
        pathEffectView.setLayoutParams(getLayoutParams());

        mPathViewContainer.addView(pathEffectView);
    }

    private void addShaderView() {
        ShaderView shaderView = new ShaderView(getApplicationContext());
        shaderView.setLayoutParams(getLayoutParams());

        mPathViewContainer.addView(shaderView);
    }

    private void addCanvasView() {
        CanvasView canvasView = new CanvasView(getApplicationContext());
        canvasView.setLayoutParams(getLayoutParams());

        mPathViewContainer.addView(canvasView);
    }

    @NonNull
    private ViewGroup.LayoutParams getLayoutParams() {
        return new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT);
    }
}
