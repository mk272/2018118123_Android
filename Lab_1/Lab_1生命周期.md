1、在AndroidManifest.xml配置文件中，可以看出Hello1是应用的入口Activity。![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\msohtmlclip1\01\clip_image001.png)

 

2、启动应用，生命周期如图所示

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\msohtmlclip1\01\clip_image002.png)

活动创建，在onCreate（）方法中完成各种初始化操作、加载布局，在onStart（）方法中对资源进行加载，活动由不可见变为可见。onResume（）表活动准备好和用户进行交互，并且处于运行状态。

界面截图

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\msohtmlclip1\01\clip_image004.jpg)

3、点击TOHELLO1按钮，生命周期如图所示

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\msohtmlclip1\01\clip_image006.jpg)

onPause（）方法表系统准备启动这一个活动，执行onResume（）方法表活动正在运行，onPostResume（）方法确保屏幕对用户可见。

界面截图

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\msohtmlclip1\01\clip_image007.jpg)

3、点击TOHELLO2按钮，生命周期如图所示

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\msohtmlclip1\01\clip_image009.jpg)

onPause()杀掉上一个进程、释放资源。执行onCreate()创建此活动，onStart（）方法将此活动由不可见变为可见。执行onResum（）执行此活动。onStop()方法将Hello1活动变为不可见。

界面截图

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\msohtmlclip1\01\clip_image011.jpg)

3、点击TOHELLO3按钮，生命周期如图所示

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\msohtmlclip1\01\clip_image013.jpg)

onPause()杀掉上一个进程、释放资源。执行onCreate()创建此活动，onStart（）方法将此活动由不可见变为可见。执行onResum（）执行此活动。onStop()方法将Hello2活动变为不可见。

 

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\msohtmlclip1\01\clip_image015.jpg)

4、关闭应用，生命周期如图所示

![img](file:///C:\Users\ADMINI~1\AppData\Local\Temp\msohtmlclip1\01\clip_image016.png)

执行onDestroy()方法销毁活动。