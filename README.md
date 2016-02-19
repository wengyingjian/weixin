# 微信公众平台后台

## 模块说明

### turing-* 模块
包含 图灵机器人 公用类\服务 模块
#### turing-common:公用类
机器人回复类型分为: 文字\链接\新闻\菜谱\以及一些错误编码
#### turing-service:服务
包含聊天\记录两个服务

### weixin-* 模块
包含 微信 接口\公用类\服务 模块
#### weixin-api
两个接口,使用相同的url:Get用于接收微信token验证\Post用于接收公众号消息  

**扩展:**

对于各种类型的消息,可以自由选择\替换消息的处理器.  
只要消息的处理器实现了`com.wengyingjian.weixin.common.service.generic.WeixinResponseService`接口,
并且在`com.wengyingjian.weixin.ApiApp`类中声明即可.
自动调用`matches`方法,如果匹配上,则调用`handleMessage`方法进行消息处理.
具体的消息类型参见微信文档:
[http://mp.weixin.qq.com/wiki/home/index.html](http://mp.weixin.qq.com/wiki/home/index.html)
#### weixin-common
#### weixin-service
主要是`com.wengyingjian.weixin.common.service.generic.WeixinResponseService`实现类
目前完成了两种消息的处理方案:
订阅消息:`com.wengyingjian.weixin.service.impl.WeixinSubscribeResponseServiceImpl`
文本消息:`com.wengyingjian.weixin.service.impl.WeixinTextResponseServiceImpl`

**文本消息扩展:**  

文本消息提供消息关键字过滤扩展功能.
在`com.wengyingjian.weixin.filter`包下,只需实现了`com.wengyingjian.weixin.filter.generic.WeixinInterceptor`接口,
并且注册为bean,即可由默认的文本消息处理器自动过滤.
首先调用`filter`方法查看是否满足过滤条件,如果满足,则调用`intercept`方法将消息进行拦截,在此处进行回复.

**默认的回复规则:**

如果关键字匹配没有命中,则使用默认的回复方式: 调用图灵机器人的聊天功能

