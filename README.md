# Lifeful

基于Lifeful接口的异步回调框架

## 用法

* Android Studio
	
	```
	compile 'com.smile:lifeful:1.0.0'
	```
	
对于MVP框架来说，可以在Model或Presenter层进行异步回调的判断。

## 用法

###### 1. 在需要判断的Activity/Fragment中实现Lifeful接口和isAlive()方法，你也可以在BaseActivity/BaseFragment中实现Lifeful接口和isAlive()方法，所有的Activity/Fragment继承即可。
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

###### 2. 将Lifeful传递给Presenter层，在Presenter层做判断。
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
当然了，如果你不需要判断，可以直接使用OnLoadListener
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