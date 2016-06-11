package com.sun.ui.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sunxiaoling on 16/6/11.
 */
public class CanvasView extends View {
    private Paint mPaint;
    private Rect rect1;
    private Rect rect2;
    private Path mPath;
    private Region region1;
    private Region region2;
    private int count = 0;

    public CanvasView(Context context) {
        super(context);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public CanvasView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
        mPaint.setColor(Color.BLACK);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(4);

        rect1 = new Rect(0, 0, 500, 500);
        rect2 = new Rect(250, 250, 750, 750);

        mPath = new Path();
        mPath.moveTo(300, 300);
        mPath.lineTo(450, 138);
        mPath.lineTo(900, 600);
        mPath.lineTo(480, 660);
        mPath.close();

        region1 = new Region(200, 200, 600, 600);
        region2 = new Region(400, 400, 800, 800);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setLayerType(LAYER_TYPE_SOFTWARE, null);

        canvas.drawColor(Color.GREEN);

        /** Clip Rect*/
////        canvas.clipRect(0, 0, 500, 500);
//        canvas.drawRect(rect1, mPaint);
//        canvas.drawRect(rect2, mPaint);
//
////        final boolean flag = rect1.intersect(rect2);
//        rect1.union(rect2);
//
//        canvas.clipRect(rect1);
//        canvas.drawColor(Color.parseColor("#90FFFFFF"));

        /** Clip Path*/
//        canvas.drawPath(mPath, mPaint);
//        canvas.clipPath(mPath);
//        canvas.drawColor(Color.parseColor("#90FFFFFF"));

        /** Clip Region */
        canvas.save();
        canvas.clipRegion(region1);
//        canvas.clipRegion(region2, Region.Op.DIFFERENCE);
//        canvas.clipRegion(region2, Region.Op.INTERSECT);
//        canvas.clipRegion(region2, Region.Op.REPLACE);
//        canvas.clipRegion(region2, Region.Op.REVERSE_DIFFERENCE);
//        canvas.clipRegion(region2, Region.Op.UNION);
        canvas.clipRegion(region2, Region.Op.XOR);
        canvas.drawColor(Color.parseColor("#90FFFFFF"));
        canvas.restore();
        canvas.drawRect(region1.getBounds(), mPaint);
        canvas.drawRect(region2.getBounds(), mPaint);
    }
}
