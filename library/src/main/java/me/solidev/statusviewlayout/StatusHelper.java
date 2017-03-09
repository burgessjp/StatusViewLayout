package me.solidev.statusviewlayout;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by _SOLID
 * Date:2017/3/9
 * Time:9:38
 * Desc:Very convenient to let  activity and fragment have the state
 */

public class StatusHelper {
    public static StatusViewLayout setContentView(Activity activity, int layoutResID) {
        StatusViewLayout layout = new StatusViewLayout(activity);
        layout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        View contentView = LayoutInflater.from(activity).inflate(layoutResID, layout, false);
        layout.addView(contentView);
        layout.showContent();
        activity.setContentView(layout);
        return layout;
    }

    public static StatusViewLayout setContentView(Activity activity, View contentView) {
        StatusViewLayout layout = new StatusViewLayout(activity);
        layout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(contentView);
        layout.showContent();
        activity.setContentView(layout);
        return layout;
    }

    public static StatusViewLayout onCreateView(Fragment fragment, int layoutResID) {
        StatusViewLayout layout = new StatusViewLayout(fragment.getContext());
        layout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        View rootView = LayoutInflater.from(fragment.getContext()).inflate(layoutResID, layout, false);
        layout.addView(rootView);
        layout.showContent();
        return layout;
    }

    public static StatusViewLayout onCreateView(Fragment fragment, View rootView) {
        StatusViewLayout layout = new StatusViewLayout(fragment.getContext());
        layout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT));
        layout.addView(rootView);
        layout.showContent();
        return layout;
    }

}
