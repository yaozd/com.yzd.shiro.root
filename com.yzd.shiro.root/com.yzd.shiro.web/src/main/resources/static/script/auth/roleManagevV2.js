/**
 * 角色管理--代码整理版
 */
$(function () {
    $("#roleListLi").click(function () {
        ViewUtil.toShowRoleListLi();
    });
    $("#setRoleLi").click(function () {
        ViewUtil.toShowSetRoleLi();
    });
});
layui.use(['form'], function(){
    var form = layui.form;
    //监控提交
    form.on("submit(submit4Role)",function () {
        RequestUtil.submit4RoleFun();
        return false;
    });
});
var ViewUtil={
    toShowUpdateRoleLi:function () {
        $("#roleListLi").removeClass("layui-this");
        $("#setRoleLi").removeClass("layui-this");
        $("#roleListDiv").removeClass("layui-show");
        $("#setRoleDiv").removeClass("layui-show");

        $("#updateRoleLi").addClass("layui-this");
        $("#updateRoleDiv").addClass("layui-show");
        $("#updateRoleLi").css("display","inline-block");
        $("#updateRoleDiv").css("display","inline-block");
        //
        $("#setRoleDiv").html("");
        $("#updateRoleDiv").html($("#addEditFormTpl").html());
    },
    toShowRoleListLi:function () {
        $("#setRoleLi").removeClass("layui-this");
        $("#setRoleDiv").removeClass("layui-show");

        $("#updateRoleLi").css("display","none");
        $("#updateRoleDiv").css("display","none");
        $("#roleListLi").addClass("layui-this");
        $("#roleListDiv").addClass("layui-show");
    },
    toShowSetRoleLi:function () {
        $("#roleListLi").removeClass("layui-this");
        $("#roleListDiv").removeClass("layui-show");
        //
        $("#updateRoleLi").css("display","none");
        $("#updateRoleDiv").css("display","none");
        $("#setRoleLi").addClass("layui-this");
        $("#setRoleDiv").addClass("layui-show");
        //
        $("#updateRoleDiv").html("");
        $("#setRoleDiv").html($("#addEditFormTpl").html());
    },
    toAlertSuccess:function () {
        //弹出层:无关闭按钮
        layer.alert("操作成功！",{  closeBtn: 0 },function(){
            layer.closeAll();
            //加载load方法
            //window.location.reload();
        });
    }
};
var RequestUtil={
    submit4RoleFun:function () {
        alert(1);
        var param=$("#form4Role").serializeJson();
        instance.post('/api/role/addEditRole',param).then(function (response) {
                var result=response.data;
                if(result.code==200){
                    ViewUtil.toAlertSuccess();
                    return;
                }
                layer.alert(result.data);
            });
    }
};
