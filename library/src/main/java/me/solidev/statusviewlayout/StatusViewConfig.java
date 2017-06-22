package me.solidev.statusviewlayout;


/**
 * Created by _SOLID
 * Date:2017/1/12
 * Time:16:07
 * Desc:全局配置
 */

public class StatusViewConfig {
    static StatusViewConfig config = new StatusViewConfig();
    int loadingResId = R.layout.status_view_layout_loading;
    int errorResId = R.layout.status_view_layout_error;
    int emptyResId = R.layout.status_view_layout_empty;
    int noNetWorkResId = R.layout.status_view_layout_error_no_network;

    int errorDrawable = -1;
    int emptyDrawable = -1;
    int noNetWorkDrawable = -1;

    public static StatusViewConfig loadingResId(int loadingResId) {
        config.loadingResId = loadingResId;
        return config;
    }

    public static StatusViewConfig errorResId(int errorResId) {
        config.errorResId = errorResId;
        return config;
    }

    public static StatusViewConfig emptyResId(int emptyResId) {
        config.emptyResId = emptyResId;
        return config;
    }

    public static StatusViewConfig errorDrawable(int errorDrawable) {
        config.errorDrawable = errorDrawable;
        return config;
    }

    public static StatusViewConfig emptyDrawable(int emptyDrawable) {
        config.emptyDrawable = emptyDrawable;
        return config;
    }

    public static StatusViewConfig noNetWorkDrawable(int noNetWorkDrawable) {
        config.noNetWorkDrawable = noNetWorkDrawable;
        return config;
    }
}
