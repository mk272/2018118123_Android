### 实验四

Intent应用

------

#### 实验要求

创建项目使用显式Intent、隐式Intent、系统内置隐式Intent

------

#### 实验目的

掌握Intent的原理及其应用

------

#### 实验内容

1、使用显式Intent

创建一个活动FirstActivity，在布局文件中定义一个按钮BUTTON1。再新建一个活动SecondActivity，再布局文件中定义一个按钮BUTTON2。每个活动都需要再AndroidManifest.xml进行注册，但这个步骤系统已自动完成。

修改FirstActivity中按钮的点击事件

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/1_1.png)

重新运行程序，在FirstActivity的界面点击BUTTON1按钮，结果如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/1_2.png)

2、使用隐式Intent

（1）、通过在activity标签下配置intent-filter的内容，可以指定当前活动能够响应的action和category，修改AndroidManifest.xml，如图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/2_1.png)

修改FirstActivity中BUTTON1按钮的点击事件

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/2_2.png)

（2）、每个Intent中只能指定一个action，但却能指定多个category。

修改FirstActivity中BUTTON1按钮的点击事件

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/2_3.png)

在intent-filter中再添加一个category的声明

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/2_4.png)

此时程序正常运行，在FirstActivity的界面点击BUTTON1按钮，结果如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/1_2.png)

3、系统内置隐式Intent

修改FirstActivity中按钮的点击事件

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/3_1.png)

指定了Intent的action是Intent.ACTION_VIEW，这是一个Android系统内置的动作，其常量值为android.intent.action.VIEW。然后通过Uri.parse()方法，将一个网址字符串解析成一个Uri对象，再调用Intent的setDate()方法将这个Uri对象传递过去。

重新运行程序，在FirstActivity界面点击BUTTON1按钮就可以看到打开了系统浏览器

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/3_2.png)

除了http协议外，还可以指定很多其他协议。

下面的代码展示了如何在我们的程序中调用系统拨号界面

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/3_3.png)

指定了Intent的action时Intent.ACTION_DIAL，这是一个系统 内置的动作。然后在data部分指定了协议时tel，号码是10086。重新运行程序，在FirstActivity的界面点击按钮，结果如图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/3_4.png)

------

#### 实验总结

1、Intent是Android程序中各组件之间进行交互的一种重要方式，它不仅可以指明那个当前组件想要执行的动作，还可以再不同组件之间进行传递数据。Intent一般可被用于启动活动、启动服务以及发送广播等场景。

2、Intent可以分为两种：显示Intent和隐式Intent。Intent有多个构造函数的重载，其中一个是Intent(Context packageContext, Class<?> cls)。这个构造函数接收两个参数，第一个参数Context要求提供一个启动活动的上下文，第二个参数Class则是指定想要启动的活动目标，通过这个构造函数就可以构建出Intent的“意图”。

3、Activity类中提供了一个startActivity()方法，这个方法是专门用于启动活动的，它接收一个Intent参数，将构建好的Intent传入startActivity()方法中就可以启动目标活动了。

------

