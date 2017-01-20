package cn.lxw.protectprocess;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * 源代码: Lxw
 * 伊妹儿: China2021@126.com
 * 时间轴: 2017 年 01 月 20 日 10 : 41
 */

public class InstallReceiver extends BroadcastReceiver {
    public static String PACKAGENAME = "cn.lxw.updateproject";

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        Toast.makeText(context, "收到消息", Toast.LENGTH_SHORT).show();
        if (action.equals(Intent.ACTION_PACKAGE_ADDED)) {
            String dataString = intent.getDataString();
            Toast.makeText(context, "安装: " + dataString, Toast.LENGTH_SHORT).show();
            if (dataString.contains(PACKAGENAME)) {
                Intent launchIntent = context.getPackageManager().getLaunchIntentForPackage(PACKAGENAME);
                if (launchIntent != null)
                    Toast.makeText(context, "包名正确,并且intent不为空", Toast.LENGTH_LONG).show();
                context.startActivity(launchIntent);
            }
        }
    }
}
