package me.solidev.statusviewlayout;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;


/**
 * Created by _SOLID
 * Date:2016/7/8
 * Time:10:36
 */
public class StatusViewLayout extends FrameLayout {

    private View mLoadingView;
    private View mErrorView;
    private View mEmptyView;
    private View mNoNetWorkView;

    private TextView tv_loading;
    private TextView tv_empty;
    private TextView tv_error;

    private int loadingResId;
    private int errorResId;
    private int emptyResId;
    private int noNetWorkResId;

    private OnClickListener mOnRetryListener;

    public StatusViewLayout(Context context) {
        this(context, null);
    }

    public StatusViewLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public StatusViewLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        final TypedArray a =
                context.obtainStyledAttributes(attrs, R.styleable.StatusViewLayout, defStyleAttr, 0);

        loadingResId = a.getResourceId(R.styleable.StatusViewLayout_loading_view
                , StatusViewConfig.config.loadingResId);
        errorResId = a.getResourceId(R.styleable.StatusViewLayout_error_view
                , StatusViewConfig.config.errorResId);
        emptyResId = a.getResourceId(R.styleable.StatusViewLayout_empty_view
                , StatusViewConfig.config.emptyResId);

        noNetWorkResId = a.getResourceId(R.styleable.StatusViewLayout_no_network_view
                , StatusViewConfig.config.noNetWorkResId);
        a.recycle();
        setUpView();

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        showContent();
    }

    private void setUpView() {
        LayoutParams layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        layoutParams.gravity = Gravity.CENTER;

        mLoadingView = LayoutInflater.from(getContext()).inflate(loadingResId, null);
        mErrorView = LayoutInflater.from(getContext()).inflate(errorResId, null);
        mEmptyView = LayoutInflater.from(getContext()).inflate(emptyResId, null);
        mNoNetWorkView = LayoutInflater.from(getContext()).inflate(noNetWorkResId, null);


        tv_loading = (TextView) mLoadingView.findViewById(R.id.status_view_tv_loading);
        tv_empty = (TextView) mEmptyView.findViewById(R.id.status_view_tv_empty);
        tv_error = (TextView) mErrorView.findViewById(R.id.status_view_tv_error);

        addView(mLoadingView, layoutParams);
        addView(mErrorView, layoutParams);
        addView(mEmptyView, layoutParams);
        addView(mNoNetWorkView, layoutParams);

        View mRetryView = mErrorView.findViewById(R.id.status_view_btn_reload);
        View mRetryViewNoNet = mNoNetWorkView.findViewById(R.id.status_view_btn_reload);
        if (mRetryView != null) {
            mRetryView.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnRetryListener != null) {
                        mOnRetryListener.onClick(v);
                    }
                }
            });
        }
        if (mRetryViewNoNet != null) {
            mRetryViewNoNet.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mOnRetryListener != null) {
                        mOnRetryListener.onClick(v);
                    }
                }
            });
        }


    }

    public void setOnRetryListener(OnClickListener listener) {
        mOnRetryListener = listener;
    }


    public void showLoading() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(View.GONE);
        }
        mLoadingView.setVisibility(View.VISIBLE);
    }

    public void showLoading(String loadingText) {
        if (tv_loading != null && !TextUtils.isEmpty(loadingText))
            tv_loading.setText(loadingText);
        showLoading();
    }

    public void showError() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(View.GONE);
        }
        mErrorView.setVisibility(View.VISIBLE);
    }

    public void showError(String errorText) {
        if (tv_error != null && !TextUtils.isEmpty(errorText)) {
            tv_error.setText("");
            tv_error.append(errorText);
            tv_error.append(" ");
            tv_error.append(getContext().getString(R.string.status_view_error_text_click_reload));
        }
        showError();
    }

    public void showEmpty() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(View.GONE);
        }
        mEmptyView.setVisibility(View.VISIBLE);
    }

    public void showEmpty(String emptyText) {
        if (tv_empty != null && !TextUtils.isEmpty(emptyText))
            tv_empty.setText(emptyText);
        showEmpty();
    }

    public void showNetWorkException() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(View.GONE);
        }
        mNoNetWorkView.setVisibility(View.VISIBLE);
    }

    public void showContent() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(View.GONE);
        }
        getChildAt(getChildCount() - 1).setVisibility(View.VISIBLE);
    }
}
