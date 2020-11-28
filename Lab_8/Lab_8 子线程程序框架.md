

### 实验八

------

#### 实验要求

创建子线程的程序框架，消息处理机制和多线程之间的数据交换。

------

#### 实验目的

掌握基本原理与使用

------

#### 实验内容

1、布局

在activity_main.xml布局文件中，定义一个button组件和TextView组件显示“Hello World”

```
<Button
    android:id="@+id/change_text"
    android:layout_width="match_parent"
    android:layout_height="wrap_content"
    android:text="Change Text"
    />

<TextView
    android:id="@+id/text"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    android:layout_centerInParent="true"
    android:text="Hello World!"
    android:textSize="20sp"
    />
```

界面如下所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_8/Lab_8pictures/8_1.png)

2、主要代码

MainActivity中的代码，如下所示

```
public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    public static final int UPDATE_TEXT=1;
    //UPDATE_TEXT整型常量表示更新TextView的动作
    
    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text=(TextView)findViewById(R.id.text);
        Button changeText = (Button)findViewById(R.id.change_text);
        changeText.setOnClickListener(this);

    }

    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch(msg.what){
                case UPDATE_TEXT:
                    text.setText("Nice to meet you");
                    break;
                default:
                    break;
            }
        }
    };

    public void onClick(View v){
        switch(v.getId()){
            case R.id.change_text:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Message message = new Message();
                        message.what = UPDATE_TEXT;
                        handler.sendMessage(message);
                    }
                }).start();
                break;
            default:
                break;
        }
    }

}
```

创建一个Message对象，将它的what字段的值指定为UPDATE_TEXT，然后调用Handler的sendMessage（）方法将这条Message发送出去。Handler接收到这条message，继而在handleMessgae（）方法中对它进行更新UI操作处理。handleMessage（）方法是在主线程中进行的，即UI更新操作是在主线程进行的，不会出现错误。

3、响应事件

点击CHANGE TEXT按钮，文本变为"Nice to meet you"

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_8/Lab_8pictures/8_2.png)

------

#### 实验总结

Android的UI是线程不安全的，如果想要更新程序里的UI元素，则必须在主线程中进行，即Android是不允许在子线程中进行UI操作的，但有时候我们必须在子线程去执行一些耗时任务。Android提供了一套异步消息处理机制，完美解决了在子线程中进行UI操作的问题。