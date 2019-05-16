### 1.测试导航-Html测试练习
- [http://localhost:9091/html/Login.html](http://localhost:9091/html/Login.html)
- [http://localhost:9091/html/admin.html](http://localhost:9091/html/admin.html)
- [http://localhost:9091/html/pubsub.html](http://localhost:9091/html/pubsub.html)-观察者模式
- [http://localhost:9091/html/linq.html](http://localhost:9091/html/linq.html)-linq
- [http://localhost:9091/html/pjax/pjax.html](http://localhost:9091/html/pjax/pjax.html)-pjax实现页面无刷新渲染
- [http://localhost:9091/html/tree/vue-tree.html](http://localhost:9091/html/tree/vue-tree.html)-vue如何用递归组件写树形控件
- [http://localhost:9091/html/tree/js-tree.html](http://localhost:9091/html/tree/js-tree.html)-js 递归输出树型

### 2.测试导航-Admin
- [http://localhost:9091/admin/admin.html](http://localhost:9091/admin/admin.html)
- [http://localhost:9091/admin/home.html](http://localhost:9091/admin/home.html)

### 2.Layui前端布局参考
-  manage-使用springboot+mybatis+layui+shiro+thymeleaf开发的后台权限管理系统（使用springboot+mybatis+layui+shiro+thymeleaf）
    - [https://gitee.com/wyait/manage](https://gitee.com/wyait/manage)
    - manage-2019-05-09-1530-[独立运行版-后台权限管理系统].rar-下载百度云=>软件开发-JAVA=>J-H-后台管理系统

### 2.Layui-参考：
－ [layui-简单的登录注册界面](https://www.cnblogs.com/davis16/p/8697808.html)
- [layuiAdmin 后台管理模板](https://www.layui.com/admin/)
    - [单页版](https://www.layui.com/admin/pro/)
    - [iframe版](https://www.layui.com/admin/std/dist/views/)
- [admin开发调试-页面](https://www.layui.com/demo/admin.html)
- []()
### 2.1.Layui-问题处理参考
- [layer弹层遮罩挡住窗体解决](https://blog.csdn.net/q646926099/article/details/78797091)
- [重置表单的三种方法](https://blog.csdn.net/qq_27596179/article/details/80883201)
    ```
    表单重置：记住 要用document.getElementById("myform").reset(); 不要用$("#myform").reset();
    ```
- [layer弹出层官网](http://layer.layui.com)-推荐参考byArvin
- layer弹出层是否带关闭
    ```
    ==》有关闭按钮
    layer.alert("添加成功！",function(){
        layer.closeAll();
        //加载load方法
        location.reload();//自定义
    });
    ==》无关闭按钮
    layer.alert("添加成功！",{  closeBtn: 0 },function(){
        layer.closeAll();
        //加载load方法
        location.reload();//自定义
    });
    ```
-   [vue中运用v-html渲染标签]-闭合问题
    ```
    1.错误：缺少</span>
    temp.push("<span class=\"treegrid-indent\">");
    --------------
    2.正确：
    temp.push("<span class=\"treegrid-indent\"></span>");
    ```


### 2.2.JQuery-问题处理参考
- [jQuery TreeGrid](https://www.cnblogs.com/sunyingyuan/p/3686213.html)
- [js递归算法实现无限级树形菜单](http://www.51xuediannao.com/javascript/digui_shu.html)
    ```
    //排序
    var dataAll=tmpList.orderAsc(a=>[a.sortNo,a.id])
    //生成树结构
    function sonsTree(arr,id){
        var temp = [],lev=0;
        var forFn = function(arr, id,lev){
            for (var i = 0; i < arr.length; i++) {
                var item = arr[i];
                if (item.parentId==id) {
                    item.lev=lev;
                    temp.push(item);
                    forFn(arr,item.id,lev+1);
                }
            }
        };
        forFn(arr, id,lev);
        return temp;
    }
    ```
- [如何在JavaScript中写枚举(翻译)](https://www.jianshu.com/p/76fc5ffa9279)
- [JavaScript对象枚举遍历](https://blog.csdn.net/qq_42062727/article/details/80480860)
    ```
    /**
     * 资源类型枚举
     */
    var PermissionTypeEnum = {
        CATALOG: {name: "small", value: 1},
        MENU: {name: "medium", value: 2},
        FEATURE: {name: "large", value: 3},
    };
    ------------------
    //来自permList4VUE.js
    toTypeName:function (permissionType) {
            //枚举遍历
            for(var prop in PermissionTypeEnum){
                var item=PermissionTypeEnum[prop];
                if(item.value==permissionType){
                    return item.name;
                }
            }
            return "";
        }
    ```
- [jQuery自动给表单赋值](https://blog.csdn.net/liu22985342/article/details/27534501)
    ```
    var options = { jsonValue: dd, isDebug: false };
    $("#UserForm_Modify").initForm(options);
    ```
- []()

### 3.Thymeleaf-参考：
- [Thymeleaf入门与基本概述](https://www.cnblogs.com/jiangbei/p/8462294.html)
- []()


### 4.axios-参考：
- [axios中文文档](https://www.jianshu.com/p/7a9fbcbb1114)
- [vue axios 请求带token设置](https://www.cnblogs.com/lfqcode/p/8690402.html)
- [使用axios.all处理并发请求](https://my.oschina.net/jamesview/blog/1860548)
- [axios拦截设置和错误处理](https://blog.csdn.net/sjn0503/article/details/74729300)
- [vue+axios 前端实现登录拦截（路由拦截、http拦截）-包含遮罩层设置](https://blog.csdn.net/wojiaomaxiaoqi/article/details/78558600)

### 5.单页面应用
- [单页面应用的页面跳转及如何通过url跳转至指定页面](https://blog.csdn.net/w405722907/article/details/82255249)
- [Pjax是什么以及为什么推荐大家用](https://my.oschina.net/sub/blog/123447)
- [jQuery+pjax简单示例汇总](https://www.cnblogs.com/telwanggs/p/7136694.html)
- [pjax使用小结](https://www.jianshu.com/p/557cad38e7dd)
- [https://github.com/defunkt/jquery-pjax](https://github.com/defunkt/jquery-pjax)
- [pjax失效情况](https://www.jianshu.com/p/557cad38e7dd)
```
除了上述情况之外，还有下列几种情况：
ajax 请求失败，或者 timeout 后请求被中止
当前页面的 X-PJAX-Version 和请求的新页面版本不一致
请求得到完整的页面（包含 html 标签）却没设置 fragment 参数

-----
点击这里查看pushState的浏览器支持情况。
https://caniuse.com/#search=pushstate
```

### 6.pjax示例
- [spring-boot项目freemarker模板使用jquery.pjax实现页面无刷新渲染](https://www.codercto.com/a/22195.html)
- 通过referrer与cookie实现自动跳转
    - [javascript操作referer方法探讨](http://www.jquerycn.cn/a_11559)
    - [jquery之cookie操作](https://www.cnblogs.com/s313139232/p/7839037.html)
- [解决pjax加载页面不执行js插件的问题](https://www.cnblogs.com/fanwenhao/p/9643549.html)-特别重要--重点参考byArvin
    ```
    在使用jquery.pjax的时候发现加载页面时不会执行其中的layui以及jquery的初始化方法，包括一些插件的初始化方法。
    查看源码后发现该jquery.pjax替换容器内容时，是将服务器端返回的html转换为了jquery dom节点然后再执行的替换，但是这样操作会导致一系列的加载事件不会被触发，导致例如jquery和layui的初始化方法不会被执行。
    于是决定将添加dom节点修改为直接添加html片段。
    修改代码
    1.将jquery.pjax.js中311行的 context.html(container.contents)修改为 context.html(data)。
    这样在pjax加载新页面的时候便会直接将服务器端返回html片段添加进容器。
    但是这样仅处理了新增页面，而执行回退操作时pjax会从缓存中读取上一个页面的内容，同样pjax在回退上一个页面的时候依然是以dom节点的方式存储和添加的，所以我们还需要继续修改。
    2. 将365行的
      cachePush(pjax.state.id, [options.container, cloneContents(context)])
        修改为
      cachePush(pjax.state.id, [options.container, context.html()])
    到此修改完成，此时使用pjax加载新页面的时候，layui jquery等插件的初始化方法即可正确执行。
    ```
- []()
- []()