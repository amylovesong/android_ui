package com.sun.ui.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sunxiaoling on 16/6/10.
 */
public class PathEffectView extends View {
    private Paint mPaint;
    private Path mPath;
    private Context mContext;
    private int phase = 0;

    public PathEffectView(Context context) {
        super(context);
        init(context);
    }

    public PathEffectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public PathEffectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        this.mContext = context;
        initPaint();
        initPath();
    }

    private void initPaint() {
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(5);
        mPaint.setColor(Color.DKGRAY);
    }

    private void initPath() {
        mPath = new Path();
        mPath.moveTo(10, 50);

        for (int i = 0; i< 30 ; i++) {
            mPath.lineTo(i * 35, (float) (Math.random() * 100));
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Custom code here
        canvas.translate(0, 250);

        mPaint.setPathEffect(null);
        canvas.drawPath(mPath, mPaint);

        canvas.translate(0, 500);

//        mPaint.setPathEffect(new CornerPathEffect(50));
//        mPaint.setPathEffect(new DiscretePathEffect(3.0f, 5.0f));
//        mPaint.setPathEffect(new DashPathEffect(new float[]{20, 10}, phase));

//        final Path path = new Path();
//        path.addCircle(0, 0, 3, Path.Direction.CCW);
//        final PathEffect pathEffect = new PathDashPathEffect(path, 12, phase, PathDashPathEffect.Style.ROTATE);
//        mPaint.setPathEffect(pathEffect);

//        final ComposePathEffect composePathEffect = new ComposePathEffect(new CornerPathEffect(50),
//                new DashPathEffect(new float[]{20, 10}, 1));
//        mPaint.setPathEffect(composePathEffect);

//        final SumPathEffect sumPathEffect = new SumPathEffect(new CornerPathEffect(50),
//                new DashPathEffect(new float[]{20, 10}, 1));
//        mPaint.setPathEffect(sumPathEffect);

        canvas.drawPath(mPath, mPaint);

//        phase++;
//        invalidate();
    }
}
