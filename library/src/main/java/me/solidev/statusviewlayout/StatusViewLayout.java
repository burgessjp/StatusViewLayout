package me.solidev.statusviewlayout;

import android.content.Context;
import android.content.res.TypedArray;
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
    private LayoutParams mLayoutParams;
    private OnClickListener mOnRetryListener;
    private TextView tv_loading;
    private TextView tv_empty;
    private TextView tv_error;

    private int loadingResId;
    private int errorResId;
    private int emptyResId;
    private int noNetWorkResId;


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
        mLayoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mLayoutParams.gravity = Gravity.CENTER;

        mLoadingView = LayoutInflater.from(getContext()).inflate(loadingResId, null);
        mErrorView = LayoutInflater.from(getContext()).inflate(errorResId, null);
        mEmptyView = LayoutInflater.from(getContext()).inflate(emptyResId, null);
        mNoNetWorkView = LayoutInflater.from(getContext()).inflate(noNetWorkResId, null);


        tv_loading = (TextView) mLoadingView.findViewById(R.id.tv_loading);
        tv_empty = (TextView) mEmptyView.findViewById(R.id.tv_empty);
        tv_error = (TextView) mEmptyView.findViewById(R.id.tv_error);

        addView(mLoadingView, mLayoutParams);
        addView(mErrorView, mLayoutParams);
        addView(mEmptyView, mLayoutParams);
        addView(mNoNetWorkView, mLayoutParams);

        View mRetryView = mErrorView.findViewById(R.id.btn_reload);
        View mRetryViewNoNet = mNoNetWorkView.findViewById(R.id.btn_reload);
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
        if (tv_loading != null)
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
        if (tv_error != null)
            tv_error.setText(errorText);
        showError();
    }

    public void showEmpty() {
        for (int i = 0; i < getChildCount(); i++) {
            getChildAt(i).setVisibility(View.GONE);
        }
        mEmptyView.setVisibility(View.VISIBLE);
    }

    public void showEmpty(String emptyText) {
        if (tv_empty != null)
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
