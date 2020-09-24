1、在AndroidManifest.xml配置文件中，可以看出Hello1是应用的入口Activity。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_1/Lab_1_pictures/1.png)



2、启动应用，生命周期如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_1/Lab_1_pictures/2_1.png)

活动创建，在onCreate（）方法中完成各种初始化操作、加载布局，在onStart（）方法中对资源进行加载，活动由不可见变为可见。onResume（）表活动准备好和用户进行交互，并且处于运行状态。

界面截图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_1/Lab_1_pictures/2_2.png)

3、点击TOHELLO1按钮，生命周期如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_1/Lab_1_pictures/3_1.png)

onPause（）方法表系统准备启动这一个活动，执行onResume（）方法表活动正在运行，onPostResume（）方法确保屏幕对用户可见。

界面截图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_1/Lab_1_pictures/3_2.png)

4、点击TOHELLO2按钮，生命周期如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_1/Lab_1_pictures/4_1.png)

onPause()杀掉上一个进程、释放资源。执行onCreate()创建此活动，onStart（）方法将此活动由不可见变为可见。执行onResum（）执行此活动。onStop()方法将Hello1活动变为不可见。

界面截图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_1/Lab_1_pictures/4_2.png)

5、点击TOHELLO3按钮，生命周期如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_1/Lab_1_pictures/5_1.png)

onPause()杀掉上一个进程、释放资源。执行onCreate()创建此活动，onStart（）方法将此活动由不可见变为可见。执行onResum（）执行此活动。onStop()方法将Hello2活动变为不可见。

界面截图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_1/Lab_1_pictures/5_2.png)

6、关闭应用，生命周期如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_1/Lab_1_pictures/6.png)

执行onDestroy()方法销毁活动。