package com.sun.ui.paint;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Custom view that use path to draw sth
 */
public class PathView extends View {

    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        final Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);

        final Path path = new Path();

        /** Line */
//        useLineTo(path);
//        useMoveTo(path);
//        useClose(path);

        /** Bezier curve */
//        useQuadTo(path);
//        useCubicTo(path);

        /** Arc */
//        useArcTo(path);

        /** Relative method */
//        useRLineTo(path);

        /** Add method */
//        useAddArc(path);
        useAddOval(path);

        canvas.drawPath(path, paint);

        // Used for Path.Direction
//        paint.setStyle(Paint.Style.FILL);
        paint.setTextSize(100);
        canvas.drawTextOnPath("123456789", path, 0, 0, paint);
    }

    private void useAddOval(Path path) {
        path.moveTo(300, 300);
        RectF oval = new RectF(300, 300, 800, 1000);
//        path.addOval(oval, Path.Direction.CW);
        path.addOval(oval, Path.Direction.CCW);
    }

    private void useAddArc(Path path) {
        path.moveTo(300, 300);
        path.lineTo(500, 500);
        RectF oval = new RectF(300, 300, 800, 1000);
        path.addArc(oval, 0, 90);
    }

    private void useRLineTo(Path path) {
        path.moveTo(300, 300);
        path.rLineTo(500, 500);// (500, 500) is relative to (300, 300) not (0, 0)
    }

    private void useArcTo(Path path) {
        path.moveTo(300, 300);

        RectF oval = new RectF(300, 300, 800, 800);
//        path.arcTo(oval, 0, 90);
        path.arcTo(oval, 0, 90, true);
    }

    private void useCubicTo(Path path) {
        path.moveTo(300, 300);
        path.cubicTo(500, 500, 800, 0, 1000, 300);
    }

    private void useQuadTo(Path path) {
        path.moveTo(300, 300);
        path.quadTo(500, 500, 800, 300);
    }

    private void useClose(Path path) {
        useMoveTo(path);
        path.close();
    }

    private void useLineTo(Path path) {
        path.lineTo(300, 300);
    }

    private void useMoveTo(Path path) {
        path.moveTo(300, 300);
        path.lineTo(800, 300);
        path.lineTo(1000, 600);
        path.lineTo(500, 600);
    }


}
