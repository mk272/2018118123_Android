### 实验九

异步任务的隐含子线程程序框架。

------

#### 实验要求

使用AsyncTask创建一个异步处理的项目，使用其方法完成对任务的定制

------

#### 实验目的

掌握基本使用原理及其应用

------

#### 实验内容

1、布局界面

在activity_main.xml文件配置gravity为center，让控件上的组件都居中。

```
android:gravity="center"
```

添加相应按钮，文字，进度条，界面如图所示

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_9/Lab_9pictures/9_1.png)

2、主要代码

在MainActivity里新建一个内部类MyTask，MyTask是AsyncTask的派生类。

编写MyTask类的方法

```
// 方法1：onPreExecute（）
// 作用：执行 线程任务前的操作
@Override
protected void onPreExecute() {
    text.setText("加载中");
    // 执行前显示提示
}

// 方法2：doInBackground（）
// 作用：接收输入参数、执行任务中的耗时操作、返回 线程任务执行的结果
// 此处通过计算从而模拟“加载进度”的情况
@Override
protected String doInBackground(String... params) {

    try {
        int count = 0;
        int length = 1;
        while (count<99) {

            count += length;
            // 可调用publishProgress（）显示进度, 之后将执行onProgressUpdate（）
            publishProgress(count);
            // 模拟耗时任务
            Thread.sleep(50);
        }
    }catch (InterruptedException e) {
        e.printStackTrace();
    }
    return null;
}

// 方法3：onProgressUpdate（）
// 作用：在主线程 显示线程任务执行的进度
@Override
protected void onProgressUpdate(Integer... progresses) {

    progressBar.setProgress(progresses[0]);
    text.setText("loading..." + progresses[0] + "%");

}

// 方法4：onPostExecute（）
// 作用：接收线程任务执行结果、将执行结果显示到UI组件
@Override
protected void onPostExecute(String result) {
    // 执行完毕后，则更新UI
    text.setText("加载完毕");
}

// 方法5：onCancelled()
// 作用：将异步任务设置为：取消状态
@Override
protected void onCancelled() {
    text.setText("已取消");
    progressBar.setProgress(0);

}
```

3、响应事件

（1）、点击“点我加载”按钮，进度条会开始加载，加载完成会显示“加载完毕”

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_9/Lab_9pictures/9_2.png)

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_9/Lab_9pictures/9_3.png)

（2）、点击“CANCEL”按钮，界面会显示“已取消”

![Image](https://github.com/mk272/2018118123_Android/raw/master/Lab_9/Lab_9pictures/9_4.png)

------

#### 实验总结

1、AsyncTask的定义：

`public abstract class AsyncTask<Params, Progress, Result>` 

三种泛型类型分别代表“启动任务执行的输入参数”、“后台任务执行的进度”、“后台计算结果的类型”。在特定场合下，并不是所有类型都被使用，如果没有被使用，可以用java.lang.Void类型代替。

2、一个异步任务的执行一般包括以下几个步骤：

（1）、**execute(Params... params)**，执行一个异步任务，需要我们在代码中调用此方法，触发异步任务的执行。

（2）、**onPreExecute()**，在execute(Params... params)被调用后立即执行，一般用来在执行后台任务前对UI做一些标记。

（3）、**doInBackground(Params... params)**，在onPreExecute()完成后立即执行，用于执行较为费时的操作，此方法将接收输入参数和返回计算结果。在执行过程中可以调用publishProgress(Progress... values)来更新进度信息。

（4）、**onProgressUpdate(Progress... values)**，在调用publishProgress(Progress... values)时，此方法被执行，直接将进度信息更新到UI组件上。

（5）、**onPostExecute(Result result)**，当后台操作结束时，此方法将会被调用，计算结果将做为参数传递到此方法中，直接将结果显示到UI组件上。

3、在使用的时候，有几点需要格外注意：

（1）、异步任务的实例必须在UI线程中创建。

（2）、execute(Params... params)方法必须在UI线程中调用。

（3）、不要手动调用onPreExecute()，doInBackground(Params... params)，onProgressUpdate(Progress... values)，onPostExecute(Result result)这几个方法。

（4）、不能在doInBackground(Params... params)中更改UI组件的信息。

（5）、一个任务实例只能执行一次，如果执行第二次将会抛出异常。



------

