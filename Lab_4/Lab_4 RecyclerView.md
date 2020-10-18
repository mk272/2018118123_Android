### 实验要求

创建RecyclerView项目，实现数据滚动的效果；点击RecyclerView项目中图片下方文字实现文字可编辑效果。

------

### 实验目的

掌握RecyclerView控件基本原理。

------

### 实验内容

 

1、 项目界面

创建RecyclerView项目，运行程序，项目界面可滚动。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/1_1.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/1_2.png)

2、 项目界面增加水果

在MainActivity类的initFruits（）方法中增加水果柠檬、桃子。

运行界面如下

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/2_1.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/2_2.png)

3、 项目增加点击事件

以第24项的柠檬为例子

（1）    点击柠檬图片

界面显示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/3_1.png)

（2）点击图片下方文字

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/3_2.png)

界面弹出可编辑的文本框，框内内容为原先图片的文本内容，我们可以进行对它修改。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/3_3.png)

点击“确定”按钮，界面会显示修改成功，并且柠檬图片下方文字已更新

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/3_4.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_4/Lab_4pictures/3_5.png)

------

### 实验总结

1、RecyclerView构件性能优于ListView构件，它不仅可以实现数据纵向滚动的效果，还可以实现横向滚动、瀑布流布局的效果。

2、RecyclerView项目需要构建适配器。

3、RecyclerView没有提供类似于setOnItemClickListener()这样的注册监听器方法，需要我们自己给子项具体的View去注册点击事件。RecyclerView所有的点击事件都由具体的View去注册。