package com.sun.ui.layout;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.widget.LinearLayout;

public class SoftKeyboardHandledLinearLayout extends LinearLayout {
    private static final String TAG = SoftKeyboardHandledLinearLayout.class.getSimpleName();

    private static int sScreenHeightWithoutVK = 0;

    private OnSoftKeyboardVisibilityChangeListener mListener;
    private int mViewInitialHeight;

    public SoftKeyboardHandledLinearLayout(Context context) {
        super(context);
    }

    public SoftKeyboardHandledLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SoftKeyboardHandledLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initializeScreenHeight() {
        if (sScreenHeightWithoutVK == 0) {
            int[] location = new int[2];
            this.getLocationOnScreen(location);
            sScreenHeightWithoutVK = this.getHeight() + location[1];
            logMsg("initializeScreenHeight location: " + location[1] + " sScreenHeightWithoutVK: " + sScreenHeightWithoutVK);
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        logMsg("onSizeChanged w: " + w + " h: " + h + " oldw: " + oldw + " oldh: " + oldh + " mListener: " + mListener);
        if (oldh == 0) {
            mViewInitialHeight = h;
            initializeScreenHeight();
            return;
        }
        if (mListener == null) {
            return;
        }
        final int diffHeight = mViewInitialHeight - h;// keyboard height
        logMsg("onSizeChanged mViewInitialHeight: " + mViewInitialHeight + " diffHeight: " + diffHeight
                + " sScreenHeightWithoutVK: " + sScreenHeightWithoutVK);

        if (diffHeight >= 100) {//100: 经验值
            mListener.onKeyboardVisible(sScreenHeightWithoutVK, diffHeight);
        } else {
            mListener.onKeyboardInvisible();
        }
    }

    public void setOnSoftKeyboardVisibilityChangeListener(OnSoftKeyboardVisibilityChangeListener listener) {
        this.mListener = listener;
    }

    public interface OnSoftKeyboardVisibilityChangeListener{
        void onKeyboardVisible(final int screenHeight, final int keyboardHeight);

        void onKeyboardInvisible();
    }

    private void logMsg(String msg) {
        Log.d(TAG, msg);
    }
}
