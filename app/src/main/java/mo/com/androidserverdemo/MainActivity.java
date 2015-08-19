package mo.com.androidserverdemo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import mo.com.androidserverdemo.server.ServerDemo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //开启服务
    public void startServer(View view){
        Intent service = new Intent(this, ServerDemo.class);
        startService(service);

    }

    //结束服务
    public void stopServer(View view){
        Intent service = new Intent(this, ServerDemo.class);
        stopService(service);

    }
}
