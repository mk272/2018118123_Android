### 实验要求

设计一个简单的UI界面。

------

### 实验目的

掌握UI界面设计的基本理念，熟知各种控件的使用及各种布局，学习布局合理化。

------

### 实验内容

1、布局

此程序采用百分比布局，将屏幕划分成六等份，每一份都包含了一个按钮，每一个按钮的宽占据了布局的40%，高占据了屏幕的25%。

在activity_main.xml配置文件中，设置六个Button按钮属性android:layout_gravity值为left|top、right|top、left|center、right|center、left|bottom、right|bottom。即这六个按钮位于布局的左上、右上、左中、右中、左下、右下。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_5/Lab_5%20pictures/0.png)

2、界面

（1）、主界面是由六个等分按钮组成的布局，每个按钮都有独自的背景图。

在res目录下新建drawable-xhdpi目录，将按钮背景图置于此文件夹下。在activity_main.xml配置文件中，设置六个Button按钮属性android:background="@drawable/"（斜杠后为图片名），即可为按钮设置背景图。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_5/Lab_5%20pictures/1.png)

（2）、点击每个按钮，会跳转到各自内容说明的界面。用TextView编辑文本内容，底部放置一个“返回”按钮可返回主界面。

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_5/Lab_5%20pictures/2.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_5/Lab_5%20pictures/3.png)



![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_5/Lab_5%20pictures/4.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_5/Lab_5%20pictures/5.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_5/Lab_5%20pictures/6.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_5/Lab_5%20pictures/7.png)

3、主要代码

MainActivity.class的settupButtons()方法

```
private void settupButtons() {
    Button b;
    b = (Button) findViewById(R.id.button1);
    b.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Tomato.class);
            startActivity(intent);
        }
    });
    b = (Button) findViewById(R.id.button2);
    b.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Watermelon.class);
            startActivity(intent);
        }
    });
    b = (Button) findViewById(R.id.button3);
    b.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Sugarcane.class);
            startActivity(intent);
        }
    });
    b = (Button) findViewById(R.id.button4);
    b.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Potato.class);
            startActivity(intent);
        }
    });
    b = (Button) findViewById(R.id.button5);
    b.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Ginger.class);
            startActivity(intent);
        }
    });
    b = (Button) findViewById(R.id.button6);
    b.setOnClickListener(new View.OnClickListener() {
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Fish.class);
            startActivity(intent);
        }
    });
}
```

为主界面的6个按钮设置点击事件，点击按钮就会跳转到各自内容说明的界面。

------

### 实验总结

1、LinearLayout布局支持使用layout_weight属性实现按比例指定控件的大小。FrameLayout、RelativeLayout布局不支持。

2、百分比布局：在这种布局中，可以不再使用wrap_content、math_parent等方式来指定控件的大小，而是允许直接指定控件在布局中所占的百分比，这样的话就可以轻松实现平分布局 甚至是任意比例分割布局的效果。