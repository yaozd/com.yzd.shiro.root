### 1.测试导航
- [http://localhost:9090/swagger-ui.html](http://localhost:9090/swagger-ui.html)

### 权限管理
-   类型
    ```
    1.目录
    2.菜单
    3.功能（api）(功能就是按钮，目前暂时取消按钮选项-2019-05-14)
    4.按钮
    ```
 ### 2.@ControllerAdvice全局异常处理问题分析 
```
@ControllerAdvice 处理异常也有一定的 局限性。只有进入 Controller 层的错误，才会由 @ControllerAdvice 处理。
Filter中的异常是不被@ControllerAdvice拦截的，需要在Filter中直接处理
```