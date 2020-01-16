package huicuitest.dinghuo.com.testapplication;

import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void toWeChatScan(View view) {
//        try {
//            //利用Intent打开微信
//            Uri uri = Uri.parse("weixin://dl/scan");
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(intent);
//        } catch (Exception e) {
//            //若无法正常跳转，在此进行错误处理
//            Toast.makeText(this, "无法跳转到微信，请检查是否安装了微信", Toast.LENGTH_SHORT).show();
//        }
        try {
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("com.tencent.mm", "com.tencent.mm.ui.LauncherUI"));
            intent.putExtra("LauncherUI.From.Scaner.Shortcut", true);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction("android.intent.action.VIEW");
            this.startActivity(intent);
            showTips("扫码后请输入支付金额为：100.00 元");
        } catch (Exception e) {
        }
    }

    public void toAliPayScan(View view) {
//        try {
//            //利用Intent打开支付宝
//            //支付宝跳过开启动画打开扫码和付款码的urlscheme分别是：
//            //alipayqr://platformapi/startapp?saId=10000007
//            //alipayqr://platformapi/startapp?saId=20000056
//            Uri uri = Uri.parse("alipayqr://platformapi/startapp?saId=10000007");
//            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            startActivity(intent);
//        } catch (Exception e) {
//            //若无法正常跳转，在此进行错误处理
//            Toast.makeText(this, "打开失败，请检查是否安装了支付宝", Toast.LENGTH_SHORT).show();
//        }
        try
        {
//            Long time = System.currentTimeMillis();
//            Uri uri = Uri.parse("alipayqr://platformapi/startapp?saId=10000007&clientVersion=3.7.0.0718&t="+ time);
//            String urlpay = "https://qr.alipay.com/fkx17111fvxzuiymyp0hub7";
//            Uri uri = Uri.parse("alipayqr://platformapi/startapp?t=" + time + "&saId=10000007&sourceId=excashierQrcodePay&actionType=route&clientVersion=10.1.85&qrcode=" + urlpay);
//            Uri uri = Uri.parse("alipayqr://platformapi/startapp?saId=10000007");
            Uri uri = Uri.parse("alipayqr://platformapi/startapp");
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
//            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.setAction("android.intent.action.VIEW");
//            intent.setAction(Intent.CATEGORY_APP_BROWSER);
            this.startActivity(intent);
            Toast.makeText(this, "扫码后请输入支付金额为：100.00 元", Toast.LENGTH_LONG).show();
            showTips("扫码后请输入支付金额为：100.00 元");
        } catch (Exception e)
        {
            e.printStackTrace();
            Toast toast  = Toast.makeText(this, "打开失败，请检查是否安装了支付宝", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0 , 0);
            toast.show();
        }
    }
    public void toAliPayScan2(View view) {
        try
        {
            Long time = System.currentTimeMillis();
//            String urlpay = "https://qr.alipay.com/fkx17111fvxzuiymyp0hub7";
            String urlpay = "https://qr.alipay.com/fkx13867n8kdfqq9nxmuge9";
            Uri uri = Uri.parse("alipayqr://platformapi/startapp?saId=10000007&qrcode=" + urlpay);
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            this.startActivity(intent);
            showTips("请输入付款金额：100.00 元");
        } catch (Exception e)
        {
            Toast.makeText(this, "打开失败，请检查是否安装了支付宝", Toast.LENGTH_SHORT).show();
        }
    }
    private void showTips(String msg){
        Toast toast  = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER, 0 , 0);
        toast.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
