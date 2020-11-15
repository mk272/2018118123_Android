### 实验二

 活动的生命周期及几个回调函数的使用

------

#### 实验要求

运行程序，观察每个活动的生命周期。

------

#### 实验目的

掌握活动的生命周期，深入理解活动的生命周期，学会合理管理应用资源。

------

#### 实验内容

1、在AndroidManifest.xml配置文件中，可以看出Hello1是应用的入口Activity。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab_2_pictures/1.png)



2、启动应用，生命周期如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab_2_pictures/2_1.png)

活动创建，在onCreate（）方法中完成各种初始化操作、加载布局，在onStart（）方法中对资源进行加载，活动由不可见变为可见。onResume（）表活动准备好和用户进行交互，并且处于运行状态。

界面截图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab_2_pictures/2_2.png)

3、点击TOHELLO1按钮，生命周期如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab_2_pictures/3_1.png)

onPause（）方法表系统准备启动这一个活动，执行onResume（）方法表活动正在运行，onPostResume（）方法确保屏幕对用户可见。

界面截图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab_2_pictures/3_2.png)

4、点击TOHELLO2按钮，生命周期如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab_2_pictures/4_1.png)

onPause()杀掉上一个进程、释放资源。执行onCreate()创建此活动，onStart（）方法将此活动由不可见变为可见。执行onResum（）执行此活动。onStop()方法将Hello1活动变为不可见。

界面截图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab_2_pictures/4_2.png)

5、点击TOHELLO3按钮，生命周期如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab_2_pictures/5_1.png)

onPause()杀掉上一个进程、释放资源。执行onCreate()创建此活动，onStart（）方法将此活动由不可见变为可见。执行onResum（）执行此活动。onStop()方法将Hello2活动变为不可见。

界面截图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab_2_pictures/5_2.png)

6、关闭应用，生命周期如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab_2_pictures/6.png)

执行onDestroy()方法销毁活动。

------

#### 实验总结

1、每个活动在其生命周期中最多可能会有4种状态：运行状态、暂停状态、停止状态、销毁状态。

当一个活动位于返回栈的栈顶时，这时活动就处于运行状态。当一个活动不再处于栈顶位置，但仍然可见时，这时活动就进入了暂停状态。当一个活动不再处于站到此为止，并且完全不可见时，就进入了停止状态。当一个活动从返回栈中移除后就变成了销毁状态。

2、Activity类种定义了7个回调方法，覆盖了活动生命周期的每一个环节。

- onCreate() ：这个方法会在活动第一次被创建的时候调用。
- onStart() ：这个方法在活动即将要出现的时候调用。
- onResume()： 这个方法在活动准备好和用户交互的时候调用。
- onPause() ：这个方法在系统准备去启动或者回复另一个活动的时候调用。
- onStop() ：这个方法在活动完全不可见的时候调用。
- onDestroy()：这个方法在活动被销毁的时候调用。
- onRestart()：这个方法在活动由停止状态变为运行状态之前调用，也就是活动被重新启动了。

3、活动的生命周期

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab_2_pictures/7.png)

