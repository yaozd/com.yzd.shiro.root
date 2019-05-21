/**
 * 角色管理--代码整理版
 */
$(function () {
    $("#addUserBtn").click(function () {
        //ViewUtil.toShowRoleListLi();
        alert(1);
    });
});
//搜索框
layui.use(['form','laydate'], function(){
    var form = layui.form ,layer = layui.layer
        ,laydate = layui.laydate;
    //日期
    laydate.render({
        elem: '#insertTimeStart'
    });
    laydate.render({
        elem: '#insertTimeEnd'
    });
    //TODO 数据校验
    //监听搜索框
    form.on('submit(searchSubmit)', function(data){
        //重新加载table
        alert(2);
        RequestUtil.searchSubmitFun();
        return false;
    });
});
//
var ViewUtil={
    toAlertSuccess: function (title) {
        //弹出层:无关闭按钮
        layer.alert(title, {closeBtn: 0}, function () {
            layer.closeAll();
            //加载load方法
            //window.location.reload();
            //ViewUtil.toShowRoleListLi();
        });
    },
};
//
var RequestUtil = {
    searchSubmitFun:function () {
        var params = $("#userSearch").serializeJson();
        console.log(params);
        instance.post('/api/user/getListUser', params).then(function (response) {
            var result = response.data;
            if (result.code == 200) {
                ViewUtil.toAlertSuccess("操作成功！");
                return;
            }
            layer.alert(result.data);
        });
    }
};