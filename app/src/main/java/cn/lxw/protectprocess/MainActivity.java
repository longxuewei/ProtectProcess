package cn.lxw.protectprocess;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent intent = getIntent();
        if (intent != null) {
            String packagename = intent.getStringExtra("PACKAGENAME");
            if (!TextUtils.isEmpty(packagename)) {
                InstallReceiver.PACKAGENAME = packagename;
            }
        }
    }
}
