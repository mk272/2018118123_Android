### 实验十 

------

#### 实验要求

创建服务，启动和停止服务，让服务代码运行在显示子线程。

------

#### 实验目的

掌握基本原理及其应用

------

#### 实验内容

1、创建服务

新建类MyService，类MyService是Service的派生类，它重写Service类的方法。

```
//服务创建时调用
public void onCreate(){
    super.onCreate();
    Log.d("MyService","onCreate executed");
}

//服务启动时调用
public int onStartCommand(Intent intent,int flags,int startId){
    Log.d("MyService","onStartCommand executed");
    return super.onStartCommand(intent,flags,startId);
}

//服务销毁时调用
public void onDestroy(){
    super.onDestroy();
    Log.d("MyService","onDestory executed");
}
```

2、启动和停止服务

（1）、布局

在activity_main.xml文件中定义"Start Service"按钮和“Stop Service”按钮，程序初始界面如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_10/Lab_10pictures/10_1.png)

（2）、主要代码

在MainActivity中注册按钮的点击事件，代码如下

```
@Override
public void onClick(View v) {
    switch (v.getId()){
        case R.id.start_service:
            Intent startIntent = new Intent(this,MyService.class);
            startService(startIntent);
            break;
        case R.id.stop_service:
            Intent stopIntent = new Intent(this,MyService.class);
            stopService(stopIntent);
            break;
        default:
            break;
    }
}
```

为验证服务已经启动或停止，在MyService类中方法加入打印日志

```
public void onCreate(){
    super.onCreate();
    Log.d("MyService","onCreate executed");
}

public int onStartCommand(Intent intent,int flags,int startId){
    Log.d("MyService","onStartCommand executed");
    return super.onStartCommand(intent,flags,startId);
}

public void onDestroy(){
    super.onDestroy();
    Log.d("MyService","onDestory executed");
}
```

（3）、响应事件

点击Start Service按钮，logcat中打印日志如下

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_10/Lab_10pictures/10_2.png)

此时服务成功启动，可以在Settings->Developer options->Running services中找到该服务。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_10/Lab_10pictures/10_3.png)

点击Stop Service按钮或者在Running Services中点击该服务并stop，logcat打印日志如下

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_10/Lab_10pictures/10_4.png)

3、服务代码运行在显示子线程

（1）、在activity_main.xml文件中定义一个“START INTENTSERVICE”按钮，界面如图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_10/Lab_10pictures/10_5.png)

（2）、主要代码

新建类MyIntentService来继承自类IntentService，重写其方法。

```
public MyIntentService() {
        super("MyIntentService");
    }

@Override
protected void onHandleIntent(@Nullable Intent intent) {
        //打印当前进程的ID
        Log.d("MyIntentService","Thread id is"+Thread.currentThread().getId());
    }

public void onDestroy(){
        super.onDestroy();
        Log.d("MyIntentService","onDestroy executed");
    }
```

在MainActivity中注册按钮的点击事件

```
@Override
public void onClick(View v) {
    switch (v.getId()){
        ...
        case R.id.start_intent_service:
            Log.d("MainActivity","Thread id  
            is"+Thread.currentThread().getId());
            Intent intentService = new Intent(this,MyIntentService.class);
            startService(intentService);
            break;
        default:
            break;
    }
}
```

（3）、响应事件

点击START INTENTSERVICE按钮，logcat打印日志如下

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_10/Lab_10pictures/10_6.png)

------

#### 实验总结

1、Service类

**onCreate()**：该方法在服务创建时调用

**onStartCommand()**：该方法在每次服务启动时调用

**onDestroy()**：该方法在服务销毁的时候调用

2、startService()方法用于启动服务，stopService()方法用于停止服务

3、在服务每个具体的方法里开启一个子线程，然后在这里取处理那些耗时的逻辑，这样可以避免出现Application Not Respoding的情况。