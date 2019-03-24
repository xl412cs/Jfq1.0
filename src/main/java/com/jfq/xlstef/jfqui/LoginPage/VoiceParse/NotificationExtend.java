package com.jfq.xlstef.jfqui.LoginPage.VoiceParse;

import java.lang.ref.WeakReference;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * 负责显示通知栏
 * @author Administrator
 *
 */
public class NotificationExtend {
    private WeakReference<Context> mContextReference;
    private final String TAG = "Show";
    private int mHeadId;
    private String mTitle = "";
    private String mContent = "";

    public void setActivity(Context context) {
        if (null != mContextReference) mContextReference.clear();
        mContextReference = new WeakReference<Context>(context);
    }

    public void setParam(int RHeadId, String title, String content) {
        mHeadId = RHeadId;
        mTitle = title;
        mContent = content;
    }

    public Context getContext() {
        if (null == mContextReference) return null;
        return mContextReference.get();
    }

    @SuppressWarnings("deprecation")
    public void showNotification() {
        if (null == mContextReference || null == mContextReference.get()) return;
        NotificationManager notificationManager = (
                NotificationManager)mContextReference.get().getSystemService(
                android.content.Context.NOTIFICATION_SERVICE);

        Notification notification = new Notification();

        int icon = mHeadId;
        CharSequence tickerText = mContent;
        long when = System.currentTimeMillis();
        notification.flags = Notification.FLAG_ONGOING_EVENT;
        notification.flags |= Notification.FLAG_AUTO_CANCEL;
        notification.flags |= Notification.FLAG_SHOW_LIGHTS;
        //系统状态栏会出现闪一下提示--正在后台运行
        notification = new Notification(icon, tickerText, when);

        // 放置系统状态栏  在"正在运行"栏目中
        Intent notificationIntent = new Intent(mContextReference.get(), mContextReference.get().getClass());
        notificationIntent.setAction(Intent.ACTION_MAIN);
        notificationIntent.addCategory(Intent.CATEGORY_LAUNCHER);
        PendingIntent contentIntent = PendingIntent.getActivity(
                mContextReference.get(), 0, notificationIntent,PendingIntent.FLAG_UPDATE_CURRENT);

        //放置在屏幕整个下滑，出现栏目中
        //notification.setLatestEventInfo(mContextReference.get(), mTitle, mContent, contentIntent);
        //刷新
        notificationManager.notify(TAG, 529, notification);
    }

    public void cancelNotification(){
        if (null == mContextReference || null == mContextReference.get()) return;
        NotificationManager notificationManager = (
                NotificationManager) mContextReference.get().getSystemService(
                android.content.Context.NOTIFICATION_SERVICE);
        notificationManager.cancel(TAG, 529);
    }
}
