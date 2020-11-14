## 实验二

### 实验要求

在实际的项目中我们应该根据特定的需求为每个活动指定恰当的启动模式。运行程序，观察不同活动在不同启动模式下运行的状态

### 实验目的

掌握四种启动模式的概念，深入了解四种启动模式的异同。

### 实验内容

1、standard 

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/1_1.png)

Standard是活动默认的启动模式，在不进行显示指定的情况下，所有活动都会自动使用这种启动模式。活动Hello1的启动模式为standard。

修改Hello1活动的onCreate（）方法和settupButtons（）方法（）

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/1_2.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/1_3.png)

重新运行程序，连续两次点击TOHELLO1按钮

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/1_4.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/1_5.png)

从打印信息可以看出，每点击一次按钮就会创建出一个新的Hello1实例。此时返回栈中也会存在3个Hello1的实例，因此此时需要连按3次back键才能退出程序。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/1_6.png)

2、singleTop

singleTop启动模式，在启动模式时如果发现返回栈的栈顶已经是该活动，则认为可以直接使用它，不会在创建新的活动。不过当活动并未处于栈顶位置时，再启动此活动，还是会创建新的实例的。

AndroidManifest.xml中Hello1的启动模式，如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/2_1.png)

（1）当Hello1活动一直处于栈顶时

运行程序，日志截图

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/2_2.png)

不管点击多少次TOHELLO1按钮，都不会有新的Hello1实例产生，因为Hello1已经处于返回栈的栈顶。

（2）当Hello1活动不是一直处于栈顶时的情况

修改Hello1中onCreate（）的代码如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/2_3.png)

修改Hello1中settupButtons（）方法TOHELLO2按钮点击事件的代码如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/2_4.png)

修改Hello2中onCreate（）方法代码如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/2_5.png)

修改Hello2中settupButtons（）方法TOHELLO1按钮点击事件的代码如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/2_6.png)

运行程序，在Hello1活动单击TOHELLO2按钮启动Hello2活动，在Hello界面点击TOHELLO1按钮又会重新进入到Hello1.

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/2_7.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/2_8.png)

可以看到系统创建了两个不同的Hello1实例，由于在Hello2活动中再次启动Hello1时，栈顶活动已经变成了Hello2，因此会创建一个新的Hello1实例。

3、singleTask

当活动的 启动模式指定为singleTask，每次启动该活动时系统首先会在返回栈中检查是否存在该活动的实例，如果发现已经存在则直接使用该实例，并把在这个活动之上的所有活动统统出栈，如果没有发现就会创建一个新的活动实例。

AndroidManifest.xml中Hello3的启动模式

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/3_1.png)

现运行程序，在Hello1界面点击TOHELLO3按钮进入到Hello3，然后在Hello3点击按钮TOHELLO1到Hello1，再按TOHELLO3到Hello3.

查看日志中的打印信息，如图

在主界面点击TOHELLO3按钮的日志，创建了一个新的Hello3实例。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/3_2.png)

在Hello3点击按钮TOHELLO1的日志，创建了一个新的Hello1实例

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/3_3.png)

进入Hello1点击按钮TOHELLO3的日志，没有创建新的实例

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/3_4.png)

程序启动时，点击TOHELLO3按钮进入Hello3活动，在Hello3活动点击TOHELLO1按钮进入Hello1活动。在Hello1活动中启动Hello3活动时，发现返回栈中已经存在一个Hello3的实例，并且是在Hello1的下面。2-onDestroy表Hello1从返回栈中出栈，此时Hello3成为了栈顶的活动。

4、singleInstance

AndroidManifest.xml中Hello2的启动模式，如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/4_1.png)

在Hello1的onCreate()方法中添加语句

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/4_2.png)

在Hello2的onCreate()方法中添加语句

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/4_3.png)

在Hello3的onCreate()方法中添加语句

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/4_4.png)

运行程序，日志截图如下

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_3/Lab3_pictures/4_5.png)

Hello2的Task id 不同于 Hello1和Hello3，这说明Hello2确实是存放在一个单独的返回栈里的，而且这个栈中只有Hello2这一个活动。

### 实验总结

1、standard是活动默认的启动模式，在不进行显式指定的情况下，所有的活动都会自动使用这种启动模式。对于standard模式的活动，系统不会在乎这个活动是否已经在返回栈中存在，每次启动的时候都会创建一个该活动的实例。

2、在有些情况下，standard模式不太合理，活动明明已经在栈顶了，为什么再次启动的时候还需要再次创建一个新的活动实例呢？这个时候可以用singleTop模式，当活动的模式指定为singleTop了，在启动活动的时候如果发现返回栈的栈顶已经是该活动，则认为可以直接使用它，不会再创建新的活动实例。

3、当活动的模式指定为singleTask后，每次启动活动时先会在返回栈中检查是否存该互动的实例，如果有，则使用，并把在这个活动之上的所有互动统统出栈，如果没有则创建一个新的活动实例。

4、指定为singleInstance模式的活动会启用一个新的返回栈来管理活动。singleInstance模式下会有一个单独的返回栈来管理这个活动，不管是哪一个程序来访问这个活动，都使用的是同一个返回栈。