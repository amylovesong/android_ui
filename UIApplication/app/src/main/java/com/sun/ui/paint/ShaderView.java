package com.sun.ui.paint;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.sun.ui.R;

/**
 * Created by sunxiaoling on 16/6/10.
 */
public class ShaderView extends View {
    private Paint mPaint;

    public ShaderView(Context context) {
        super(context);
        init();
    }

    public ShaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public ShaderView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        mPaint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        /** BitmapShader */
//        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
//        mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
//        mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.CLAMP));
//        mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.MIRROR, Shader.TileMode.MIRROR));
//        mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.MIRROR));
//        mPaint.setShader(new BitmapShader(bitmap, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
//        canvas.drawRect(0, 0, 1200, 1760, mPaint);
//        canvas.drawCircle(400, 400, 400, mPaint);

        /** LinearGradient */
//        final Shader shader = new LinearGradient(0, 0, 400, 400, Color.YELLOW, Color.RED, Shader.TileMode.REPEAT);
//        final Shader shader = new LinearGradient(0, 0, 400, 400,
//                new int[]{Color.RED, Color.YELLOW, Color.GREEN, Color.CYAN, Color.BLUE},
//                null,
////                new float[]{0, 0.1f, 0.5f, 0.7f, 0.8f},
//                Shader.TileMode.MIRROR);
//        mPaint.setShader(shader);
//        canvas.drawRect(0, 0, 800, 800, mPaint);

        /** SweepGradient */
//        mPaint.setShader(new SweepGradient(400, 400, Color.RED, Color.YELLOW));
//        canvas.drawCircle(400, 400, 400, mPaint);

        /** RadialGradient */
//        final Shader shader = new RadialGradient(400, 400, 200, Color.RED, Color.YELLOW, Shader.TileMode.REPEAT);
//        mPaint.setShader(shader);
//        canvas.drawCircle(400, 400, 400, mPaint);

        /** ComposeShader */
//        final Shader shader1 = new RadialGradient(200, 200, 200, Color.RED, Color.GREEN, Shader.TileMode.CLAMP);
//        final Shader shader2 = new SweepGradient(200, 200, new int[]{Color.GREEN, Color.WHITE}, null);
//        final ComposeShader composeShader = new ComposeShader(shader1, shader2, PorterDuff.Mode.DARKEN);
//        mPaint.setShader(composeShader);
//        canvas.drawRect(0, 0, 400, 400, mPaint);

        /** Matrix */
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.image);
        final BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        Matrix matrix = new Matrix();
//        matrix.setTranslate(50, 50);
//        matrix.setRotate(20);
        matrix.preTranslate(200, 200);
        matrix.postRotate(20);
        matrix.postScale(0.8f, 0.8f);
        bitmapShader.setLocalMatrix(matrix);

        mPaint.setShader(bitmapShader);
        canvas.drawRect(0, 0, 1200, 1760, mPaint);
    }
}
