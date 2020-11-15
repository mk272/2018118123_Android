### 实验七

广播、自定义广播的使用

------

#### 实验要求

发送广播、自定义广播并接收广播，且做出反应

------

#### 实验目的

掌握广播的基本原理及其使用

------

#### 实验内容

Android内置了很多系统级别的广播，在应用程序中通过监听这些广播得到各种系统的状态信息。想要接收这些广播，就需要使用广播接收器。

广播接收器对广播进行注册，这样当有相应的广播发出时，广播接收器就能够接收到该广播，并在内部处理相应的逻辑。

1、系统广播

接收系统广播：静态注册开机启动

在BroadcastTest项目新建一个广播接收器BootCompleteReceiver，重写onReceive()方法，当模拟器开机启动完成时弹出“Boot Complete”消息提示启动完成。

该广播接收器要在AndroidMainfest.xml文件中注册，该步骤系统已自动完成。此外还要进行授权和添加相应的action。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_7/Lab_7pictures/1.1.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_7/Lab_7pictures/1_2.png)

重新运行程序，将模拟器关闭并重新启动，在启动完成之后就会接收到开机广播。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_7/Lab_7pictures/1_3.png)

2、自定义广播

（1）、发送标准广播

新建MyBroadcastReceiver广播接收器，在AndroidManifest.xml中对该广播接收器进行修改

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_7/Lab_7pictures/2_1.png)

在布局文件中定义一个SEND BROADCAST按钮，当点击按钮时，将会发送“com.example.broadcasttest2.MY_BROADCAST2”的广播。

当该广播接收器收到自定义广播时，程序就会弹出“received in MyBroadcastReceiver”的提示。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_7/Lab_7pictures/2_2.png)

（2）、发送有序广播

广播是一种可以跨进程的通信方式，在应用程序内发出的广播，在其他的应用程序也是可以接收到的。

新建BroadcastTest3项目，定义一个新的广播接收器AnotherBroadcastReceiver。重写onReceive()方法，并为该广播接收器添加com.example.broadcasttest2.MY_BROADCAST2的action，当该广播接收器收到自定义广播时，程序就会弹出“received in AnotherBroadcastReceiver”的提示。

现在运行BroadcastTest3项目将这个程序安装到模拟器上，然后重新回到BroadcastTest2项目的主界面，并点击一下SEND BROADCAST按钮，就会分别弹出两条提示信息。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_7/Lab_7pictures/2_3.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_7/Lab_7pictures/2_4.png)

以上程序里发出的广播都是标准广播，现在发送有序广播。发送有序广播只需修改一行代码，将sendBroadcast()方法改成sendOrderedBroadcast()。

这个时候的广播是有先后顺序的，而且前面的广播接收器还可以将广播截断，以组织其继续传播。设定广播的先后顺序要在注册的时候进行设定。在AndroidManifese.xml中对MyBroadcastReceiver接收器进行修改，修改<intent-filter>标签，修改为<intent-filter android:priority="100">。并在MyBroadcastReceiver中的onReceive()方法中调用abortBroadcast()。表示将这条广播截断，后面的广播接收器将无法再接收到这条广播。运行程序，只有MyBroadcastReceiver接收到广播。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_7/Lab_7pictures/2_5.png)

------

#### 实验总结

1、Android中的每个应用程序都可以对自己感兴趣的广播进行注册，这样该程序就只会接收到自己所关心的广播内容，这些广播可以是来自系统，也可以是来自于其他程序的。Android提供了一套完整的API，允许应用程序自由地发送和接收广播。

2、Android中的广播主要可以分为两种类型：标准广播和有序广播。标准广播时一种完全异步执行的广播，有序广播则是一种同步执行的广播。

3、注册广播的方式一般有两种，在代码中注册和在AndroidManifest.xml中注册，前者称为动态注册，后者称为静态注册。

------

