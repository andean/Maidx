# Maidx 微信分享 Version 1.0.0 

测试同一应用不同包名微信分享功能

Maidx 正式版  [下载](https://github.com/andean/Maidx/apk/Maidx_release_1.0.0.apk)

Maidx Dev 开发版 [下载](https://github.com/andean/Maidx/apk/Maidx_debug_1.0.0.apk)

Maidx 与 Maidx Dev 区别 包名不一样

## 功能

- [x] 测试同一应用不同包名微信分享功能
- [ ] 测试微信文本分享功能
- [ ] 测试微信图片分享功能
- [ ] 测试微信音乐分享功能
- [ ] 测试微信视频分享功能
- [ ] 测试微信网页分享功能

## 技术

### 1. Android框架组件 ViewBinding详解及使用

#### 简介

> 谷歌在Android Studio 3.6 Canary 11版本中正式推出视图绑定View Binding
> 
> 首先需要使用AS 3.6 Canary 11之上的版本，这里我使用AS 3.6.1升级gradle plugin版本到3.6.1
> 
> ViewBinding是一项功能，使您可以更轻松地编写与视图交互的代码。在模块中启用视图绑定后，它将为该模块中存在的每个XML布局文件生成一个绑定类。绑定类的实例包含对在相应布局中具有ID的所有视图的直接引用。在大多数情况下，视图绑定替换findViewById()。

#### 环境要求

> Android Studio版本3.6及以上
>
> Gradle 插件版本3.6.0及以上

#### 使用步骤

- 视图绑定功能可按模块启用。要在某个模块中启用视图绑定，请将 viewBinding 元素添加到其 build.gradle 文件中，如下例所示：
```
android {
    ...

    viewBinding{
        enabled = true
    }
}
```

- 如果您希望在生成绑定类时忽略某个布局文件，请将 tools:viewBindingIgnore="true" 属性添加到相应布局文件的根视图中：
```
    <LinearLayout
            ...
            tools:viewBindingIgnore="true" >
        ...
    </LinearLayout>
```

> 为某个模块启用视图绑定功能后，系统会为该模块中包含的每个 XML 布局文件各生成一个绑定类。每个绑定类均包含对根视图以及具有 ID 的所有视图的引用。系统会通过以下方式生成绑定类的名称：将 XML 文件的名称转换为驼峰式大小写，并在末尾添加“Binding”一词。

- 假设我们有一个xml布局文件，命名为activity_main.xml:
```
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
     tools:context=".MainActivity" >

    <TextView
        android:id="@+id/tv_text"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content" />

    <Button
        android:id="@+id/btn"
        android:layout_width="match_parent"
        android:layout_height="wrap_content" />
            
    <ImageView
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"/>

</LinearLayout>

```

> 生成的绑定类将名为 ActivityMainBinding。此类具有两个字段：一个是名为 tvText 的 TextView，另一个是名为 btn 的 Button。该布局中的 ImageView 没有 ID，因此绑定类中不存在对它的引用。

> 每个绑定类还包含一个 getRoot() 方法，用于为相应布局文件的根视图提供直接引用。在此示例中，ActivityMainBinding 类中的 getRoot() 方法会返回 LinearLayout 根视图。

- 要获取生成的绑定类的实例，您可以调用其静态 inflate() 方法。通常情况下，还可以调用 setContentView()，从而将该绑定类的根视图作为参数进行传递，以使它成为屏幕上的活动视图。在此示例中，您可以在 Activity 中调用 ActivityMainBinding.inflate()：
```
public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding mBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mBinding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(mBinding.getRoot());

        mBinding.tvText.setText("是不是这样使用呢？");
        mBinding.btn.setText("我是一个按钮");

    }
}

```

与使用 findViewById 相比，视图绑定具有一些很显著的优点：

- **Null 安全**：由于视图绑定会创建对视图的直接引用，因此不存在因视图 ID 无效而引发 Null 指针异常的风险。此外，如果视图仅出现在布局的某些配置中，则绑定类中包含其引用的字段会使用 @Nullable 标记。
- **类型安全**：每个绑定类中的字段均具有与它们在 XML 文件中引用的视图相匹配的类型。这意味着不存在发生类转换异常的风险。

参考链接：https://juejin.im/post/5e670b66f265da574a1ec2f1


### 2. lottie使用

https://github.com/airbnb/lottie-android

```
dependencies {
  implementation 'com.airbnb.android:lottie:$lottieVersion'
}
```


```
    <com.airbnb.lottie.LottieAnimationView
        android:id="@+id/iv_splash_lottie"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center"
        android:layout_marginBottom="40dp"
        app:lottie_autoPlay="true"
        app:lottie_loop="false"
        app:lottie_rawRes="@raw/welcome" />
```


```
    // 设置动画监听
    mBinding.ivSplashLottie.addAnimatorListener(new AnimatorListenerAdapter() {

        @Override
        public void onAnimationEnd(Animator animation) {
            startActivity(new Intent(LottieActivity.this, MainActivity.class));
            finish();
        }
    });
```






