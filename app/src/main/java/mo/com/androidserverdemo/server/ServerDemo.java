package mo.com.androidserverdemo.server;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * 服务实际上就是一个长期运行在后台，没有界面的activity
 *
 * 服务的生命周期是：
 *
 * onCreate()——>onStartCommand()——>onStart()——>onDestroy()
 *
 * onCreate(创建服务)--onStartCommand(onStart)--onDestory(销毁服务)
 *服务里面的onStart已经过时了，请使用onStartCommand接收指令
 *
 *多次启动服务只会执行一次onCreate方法，但是会多次执行onStartCommand
 *
 * 服务一经停止，多次停止服务，将不会起作用
 *
 *
 * Created by Administrator on 2015/8/18.
 */
public class ServerDemo extends Service {

    private static final String TAG = "ServerDemo";
    boolean flag;   //标记
    //创建服务
    @Override
    public void onCreate() {
        super.onCreate();
        Log.i(TAG, "服务被创建了。。。。。。");
        Log.i(TAG, "onCreate。。。。。。");

        new Thread(new Runnable() {
            @Override
            public void run() {
                flag = true;
                while(flag){
                    Log.i(TAG,"正在等待新的设备的插入。。。。");
                    SystemClock.sleep(1000);
                }
            }
        }
        ).start();
    }
    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        Log.i(TAG, "onStart。。。。。。。");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "服务被取消了。。。。。。。");
        Log.i(TAG, "onDestroy。。。。。。。");

        flag = false;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i(TAG, "onStartCommand。。。。。。。");

        return super.onStartCommand(intent, flags, startId);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
