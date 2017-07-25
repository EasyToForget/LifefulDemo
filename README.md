# Lifeful

基于 Lifeful 接口的异步回调框架，点击 [blog][1] 查看更多。

## 用法

* Android Studio
	
	```
	compile 'com.smile:lifeful:1.0.0'
	```
	
对于MVP框架来说，可以在 Model 或 Presenter 层进行异步回调的判断。

## 用法

###### 1. 在需要判断的 Activity/Fragment 中实现 Lifeful 接口和 isAlive() 方法，你也可以在 BaseActivity/BaseFragment 中实现 Lifeful 接口和 isAlive() 方法，所有的 Activity/Fragment 继承即可。
```java
    @Override
    public boolean isAlive() {
        if (activity == null)
            return false;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return !(activity.isDestroyed() || activity.isFinishing());
        }
        return !activity.isFinishing();
    }
```

###### 2. 将 Lifeful 传递给 Presenter 层，在 Presenter 层做判断。
```java
    loadModel.load(new OnLoadLifefulListener<>(new OnLoadListener<String>() {
            @Override
            public void onSuccess(String success) {
                
            }

            @Override
            public void onError(String error) {
                
            }
        }, lifeful));
       
```
当然了，如果你不需要判断，可以直接使用 OnLoadListener
```java
    loadModel.load(new OnLoadListener<String>() {
             @Override
             public void onSuccess(String success) {
                    
             }
    
             @Override
             public void onError(String error) {
                    
             }
         });
       
```

[1]: https://easytoforget.github.io/2017/07/25/handle-callback-while-activity-or-fragment-finished/