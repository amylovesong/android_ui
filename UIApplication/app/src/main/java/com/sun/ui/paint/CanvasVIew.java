package com.sun.ui.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.sun.ui.R;

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
//        setLayerType(LAYER_TYPE_SOFTWARE, null);
//        canvas.drawColor(Color.GREEN);

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
//        canvas.save();
//        canvas.clipRegion(region1);
////        canvas.clipRegion(region2, Region.Op.DIFFERENCE);
////        canvas.clipRegion(region2, Region.Op.INTERSECT);
////        canvas.clipRegion(region2, Region.Op.REPLACE);
////        canvas.clipRegion(region2, Region.Op.REVERSE_DIFFERENCE);
////        canvas.clipRegion(region2, Region.Op.UNION);
//        canvas.clipRegion(region2, Region.Op.XOR);
//        canvas.drawColor(Color.parseColor("#90FFFFFF"));
//        canvas.restore();
//        canvas.drawRect(region1.getBounds(), mPaint);
//        canvas.drawRect(region2.getBounds(), mPaint);

        /** Region VS. Rect*/
//        final Rect rect = new Rect(0, 0, 400, 400);
//        final Region region = new Region(400, 400, 800, 800);
//
//        // Region不受Canvas的变换影响
//        canvas.scale(0.75f, 0.75f);
//
//        canvas.drawColor(Color.WHITE);
//
//        canvas.save();
//        canvas.clipRect(rect);
//        canvas.drawColor(Color.RED);
//        canvas.restore();
//
//        canvas.save();
//        canvas.clipRegion(region);
//        canvas.drawColor(Color.BLUE);
//        canvas.restore();
//
//        mPaint.setColor(Color.GREEN);
//        mPaint.setStrokeWidth(10);
//        canvas.drawRect(0, 0, canvas.getWidth(), canvas.getHeight(), mPaint);

        /** Layer */
//        canvas.drawColor(Color.WHITE);
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.RED);
//        canvas.drawRect(200, 200, 600, 600, mPaint);
//
////        canvas.save();
////        canvas.saveLayer(0, 0, 600, 600, null, Canvas.ALL_SAVE_FLAG);
//        canvas.saveLayerAlpha(0, 0, 600, 600, 100, Canvas.ALL_SAVE_FLAG);
//        canvas.rotate(30);
//
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(300, 300, 500, 500, mPaint);
//
//        canvas.restore();
//
//        mPaint.setColor(Color.GREEN);
//        canvas.drawCircle(400, 400, 80, mPaint);

        /** Layer - restoreToCount(saveCount) & getSaveCount() */
//        logMsg("onDraw getSaveCount: " + canvas.getSaveCount());
//        canvas.drawColor(Color.WHITE);
//        int saveID1 = canvas.save(Canvas.MATRIX_SAVE_FLAG);
//        logMsg("onDraw getSaveCount: " + canvas.getSaveCount());
//        canvas.rotate(30);
//
//        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setColor(Color.RED);
//        canvas.drawRect(200, 200, 600, 600, mPaint);
//
//        canvas.restoreToCount(saveID1);
//        logMsg("onDraw getSaveCount: " + canvas.getSaveCount());
//
//        int saveID2 = canvas.save(Canvas.MATRIX_SAVE_FLAG);
//        logMsg("onDraw getSaveCount: " + canvas.getSaveCount());
//        mPaint.setColor(Color.BLUE);
//        canvas.drawRect(300, 300, 500, 500, mPaint);
//
////        canvas.restoreToCount(saveID1);
//        canvas.restoreToCount(saveID2);
//
//        mPaint.setColor(Color.GREEN);
//        canvas.drawCircle(400, 400, 80, mPaint);

        /** 变换 */
        canvas.drawColor(Color.WHITE);
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);

////        canvas.scale(0.8f, 0.5f);
//        canvas.scale(0.8f, 0.5f, bitmap.getWidth() / 2, 0);//以(px, py)作为缩放的中心点
////        canvas.scale(1.0f, 1.0f, bitmap.getWidth(), 0);

//        canvas.rotate(30);
//        canvas.rotate(15, bitmap.getWidth() / 2, 0);

//        canvas.skew(0.5f, 0.0f);

        final Matrix matrix = new Matrix();
        matrix.setScale(0.8f, 0.35f);
        matrix.postTranslate(400, 400);
        canvas.setMatrix(matrix);

        canvas.drawBitmap(bitmap, 0, 0, null);
    }

    private void logMsg(String msg) {
        Log.d(CanvasView.class.getSimpleName(), msg);
    }
}
