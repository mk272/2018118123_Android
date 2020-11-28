### 实验十一

------

#### 实验要求

实现子服务的绑定，子服务代码运行在异步任务。

------

### 实验目的

掌握基本原理及其应用

------

#### 实验内容

1、布局

在activity_main.xml文件中定义BIND SERVICE按钮和UNBIND SERVICE按钮，界面如图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_11/Lab_11pictures/11_1.png)

2、代码

修改MyService类的代码

新建一个内部类DwonloadBinder，继承自类Binder，修改MyService代码如下

```
public class MyService extends Service {
... ...
private DownloadBinder mBinder = new DownloadBinder();

class DownloadBinder extends Binder{

    public void startDownload(){
        Log.d("MyService","startDownload executed");
    }

    public int getProgress(){
        Log.d("MyService","getProgress executed");
        return 0;
    }
}

@Override
public IBinder onBind(Intent intent) {
       return mBinder;
... ...
}
```

修改MainActivity类代码如下

```
public class MainActivity extends AppCompatActivity implements View.OnClickListener{
... ...
private MyService.DownloadBinder downloadBinder;

private ServiceConnection connection = new ServiceConnection() {

	//活动与服务成功绑定时调用
    @Override
    public void onServiceConnected(ComponentName componentName, 
    IBinder service) {
        downloadBinder = (MyService.DownloadBinder) service;
        downloadBinder.startDownload();
        downloadBinder.getProgress();
    }
    
    //活动与服务的连接断开时调用
    @Override
    public void onServiceDisconnected(ComponentName componentName) {
	
	}
};
    
@Override
protected void onCreate(Bundle savedInstanceState) {
		... ...
        Button bindService = (Button)findViewById(R.id.bind_service);
        Button unbindService = (Button)findViewById(R.id.unbind_service);
        bindService.setOnClickListener(this);
        unbindService.setOnClickListener(this);
    }

@Override
public void onClick(View v) {
        switch (v.getId()){
			... ...
            case R.id.bind_service:
                Intent bindIntent = new Intent(this,MyService.class);
                bindService(bindIntent , connection ,BIND_AUTO_CREATE);
                break;
            case R.id.unbind_service:
                unbindService(connection);
                break;
            default:
                break;
        }
    }
}
```

服务进行绑定：这个功能是在Bind Service按钮的点击事件里完成的。构建出一个Intent对象，然后调用bindService()方法将MainActivity和MyService进行绑定。

解除绑定：Unbind Service按钮里实现的功能，调用unbindService()方法解除连接。

3、响应事件

点击BIND SERVICE按钮，logcat打印日志如下

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_11/Lab_11pictures/11_2.png)

点击UNBIND SERVICE按钮，logcat打印日志如下

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_11/Lab_11pictures/11_3.png)

------

#### 实验总结

1、组件（如activity）和服务进行绑定后，可以发送请求、接收响应、执行进程间通信（IPC）。不会无限期在后台运行。

要提供服务绑定，必须实现onBind()回调方法，该方法返回的IBinder对象定义了客户端用来与服务进行交互的编程接口。

客户端可以通过调用bindService()绑定到服务。调用时，必须提供ServiceConnection的实现，后者会监控与服务的连接，当Android系统创建客户端与服务之间的连接时，会对ServiceConnection回调onServiceConnected()，向客户端传递用来与服务通信的IBinder。当实现绑定服务的时候，最重要的环节是定义onBind()回调方法返回的接口。

2、在Connect的时候，在将Binder本地对象传给Activity组件的时候，是通过**消息处理机制来间接传递**的，（1）、因为当前线程需要尽快返回到线程池中，去做其他的Binder进程间通信请求，从而提高程序的并发处理Binder通信请求能力。（2）、在Activity组件在接受Binder本地对象的时候，可能会执行一些界面操作相关的代码，因此需要通过消息处理机制将这个操作放在主线程中执行。

------

