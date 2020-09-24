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