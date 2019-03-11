# MediaPlayer的简单实现
## 播放生命周期
[MediaPlayer生命周期](https://developer.android.com/images/mediaplayer_state_diagram.gif)

## 常见问题
1. VideoView播放短暂黑屏
**产生原因**：
视频文件加载入内存所需时间
**解决方法**：
(1)VideoView添加MediaPlayer.OnPreparedListener监听事件，并在onPrepared(MediaPlayer mp)回调方法中播放视频，此时视频已经完成了加载
(2)VideoView执行start()方法后，延迟几百毫秒后开始播放

2. VideoView播放时，切换跳转至其他界面后返回播放黑屏
**产生原因**：
VideoView被回收，且未作VideoView的状态保存
**解决方法**：
在VideoView所在的Activity或Fragment的生命周期中处理VideoView视频播放和暂停。