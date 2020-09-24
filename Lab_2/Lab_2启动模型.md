1、standard 

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/1_1.png)

Standard是活动默认的启动模式，在不进行显示指定的情况下，所有活动都会自动使用这种启动模式。活动Hello1的启动模式为standard。

修改Hello1活动的onCreate（）方法和settupButtons（）方法（）

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/1_2.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/1_3.png)

重新运行程序，连续两次点击TOHELLO1按钮

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/1_4.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/1_5.png)

从打印信息可以看出，每点击一次按钮就会创建出一个新的Hello1实例。此时返回栈中也会存在3个Hello1的实例，因此此时需要连按3次back键才能退出程序。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/1_6.png)

2、singleTop

singleTop启动模式，在启动模式时如果发现返回栈的栈顶已经是该活动，则认为可以直接使用它，不会在创建新的活动。不过当活动并未处于栈顶位置时，再启动此活动，还是会创建新的实例的。

AndroidManifest.xml中Hello1的启动模式，如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/2_1.png)

（1）当Hello1活动一直处于栈顶时

运行程序，日志截图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/2_2.png)

不管点击多少次TOHELLO1按钮，都不会有新的Hello1实例产生，因为Hello1已经处于返回栈的栈顶。

（2）当Hello1活动不是一直处于栈顶时的情况

Hello1中onCreate（）的代码如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/2_3.png)

Hello1中settupButtons（）方法TOHELLO2按钮点击事件的代码如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/2_4.png)

Hello2中onCreate（）方法代码如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/2_5.png)

Hello2中settupButtons（）方法TOHELLO1按钮点击事件的代码如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/2_6.png)

运行程序，在Hello1活动单击TOHELLO2按钮启动Hello2活动，在Hello界面点击TOHELLO1按钮又会重新进入到Hello1.

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/2_7.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_2/Lab2_pictures/2_8.png)

可以看到系统创建了两个不同的Hello1实例，由于在Hello2活动中再次启动Hello1时，栈顶活动已经变成了Hello2，因此会创建一个新的Hello1实例。