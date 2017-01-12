package me.solidev.statusview;

import android.support.annotation.LayoutRes;

import me.solidev.library.R;

/**
 * Created by _SOLID
 * Date:2017/1/12
 * Time:16:07
 * Desc:全局配置
 */

public class StatusViewConfig {
    static StatusViewConfig config = new StatusViewConfig();
    @LayoutRes
    int loadingResId = R.layout.status_view_layout_loading;
    @LayoutRes
    int errorResId = R.layout.status_view_layout_error;
    @LayoutRes
    int emptyResId = R.layout.status_view_layout_empty;
    @LayoutRes
    int noNetWorkResId = R.layout.status_view_layout_error_no_network;

    public static StatusViewConfig loadingResId(@LayoutRes int loadingResId) {
        config.loadingResId = loadingResId;
        return config;
    }

    public static StatusViewConfig errorResId(@LayoutRes int errorResId) {
        config.errorResId = errorResId;
        return config;
    }

    public static StatusViewConfig emptyResId(@LayoutRes int emptyResId) {
        config.emptyResId = emptyResId;
        return config;
    }
}
