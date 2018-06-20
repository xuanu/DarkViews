# DarkViews
default pressed view

> 带默认按下效果的控件
> [添加依赖方法](https://jitpack.io/#xuanu/DarkViews/v1.0)
> 拥有控件
```
DarkButton extends Button
DarkImage extends ImageView
DarkRadio extends RadioButton
DarkText extends TextView
```
> 使用方法同继承控件，仅仅默认加了按下效果 。

# 增加百分比字体大小控件
```
PercentText
> 必须要设置的属性：app:textSize="xx",如果不设置会取默认20.(在初始化时通过getTextSize()没有拿到正确的大小，所以才这样做。)
> 支持属性：baseScreenHeight,默认的屏幕高度。根据屏幕高度的百分比来调。

PercentAutoText
> 仅支持单行。
> 必须要设置的属性：app:textSize="xx",如果不设置会取默认20.(在初始化时通过getTextSize()没有拿到正确的大小，所以才这样做。)
> 支持属性：baseScreenHeight,默认的屏幕高度。根据屏幕高度的百分比来调。
> 支持属性：autoTactics,取值有width和height.(当前屏幕的宽高不足时，会自己进行缩放。)

```

# [RadioFramelayout](https://github.com/amphiaraus/Android-RatioLayout);
>　集成
