package com.sun.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.sun.ui.layout.SoftKeyboardHandledLinearLayout;

public class SignInActivity extends AppCompatActivity implements SoftKeyboardHandledLinearLayout.OnSoftKeyboardVisibilityChangeListener {

    private static final String TAG = SignInActivity.class.getSimpleName();

    private View mForgetPwdView;
    private View mRegisterView;
    private SoftKeyboardHandledLinearLayout mEditTextParentLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.provider_activity_sign_in);

        initView();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    private void initView() {
        mForgetPwdView = findViewById(R.id.provider_activity_sign_in_tv_forget_pwd);
        mRegisterView = findViewById(R.id.provider_activity_sign_in_tv_register);
        mEditTextParentLayout = (SoftKeyboardHandledLinearLayout) mForgetPwdView.getParent();

        mEditTextParentLayout.setOnSoftKeyboardVisibilityChangeListener(this);
    }

    private void hideSoftKeyboard() {
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(mEditTextParentLayout.getWindowToken(), 0);
    }

    @Override
    public void onKeyboardVisible(final int screenHeight, final int keyboardHeight) {
        logMsg("onKeyboardVisible screenHeight: " + screenHeight + " keyboardHeight: " + keyboardHeight);
        final View view = mForgetPwdView;

        final int[] location = new int[2];
        view.getLocationOnScreen(location);
        final int bottom = location[1] + view.getHeight() + getResources().getDimensionPixelSize(R.dimen.dimen_17dp);
        final int y = keyboardHeight - (screenHeight - bottom);
        logMsg("onKeyboardVisible bottom: " + bottom + " scrollY: " + y);
        mEditTextParentLayout.scrollBy(0, y);

        mRegisterView.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onKeyboardInvisible() {
        logMsg("onKeyboardInvisible");
        mEditTextParentLayout.setScrollY(0);

        mRegisterView.setVisibility(View.VISIBLE);
    }

    private void logMsg(String msg) {
        Log.d(TAG, msg);
    }
}
