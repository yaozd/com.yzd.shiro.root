/**
 * 角色管理--代码整理版
 */
$(function () {
    $("#roleListLi").click(function () {
        ViewUtil.toShowRoleListLi();
    });
    $("#setRoleLi").click(function () {
        ViewUtil.toShowSetRoleLi();
        RequestUtil.initRoleForm4Add();
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
    },
    toTreeData4AddRole:function (itemList) {
        var treeData = [];
        for(var i=0,il=itemList.length;i<il;i++){
            var item=itemList[i];
            item.pId=item.parentId;
            item.open=true;
            treeData.push(item);
        }
        return treeData;
    },
    toTreeData4UpdateRole:function (itemList,permIds) {
        var treeData = [];
        for(var i=0,il=itemList.length;i<il;i++){
            var item=itemList[i];
            item.pId=item.parentId;
            item.open=true;
            var checked=permIds.contains(item.id);
            item.checked=checked;
            treeData.push(item);
        }
        return treeData;
    },
    initZTree:function (treeData) {
        var setting = {
            check: {
                enable: true,
                chkboxType:{ "Y":"p", "N":"s"}
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };
        $.fn.zTree.init($("#ztree4PermList"), setting, treeData);
    },
    getPermIds:function () {
        var treeObj = $.fn.zTree.getZTreeObj("ztree4PermList");
        var nodes = treeObj.getCheckedNodes(true);
        var nodeIds =[];
        for (var i = 0; i < nodes.length; i++) {
            nodeIds.push(nodes[i].id);
        }
        //var permIds= nodeIds.join(",");
        return nodeIds;
    },
    toFormView:function (item) {
        //表单初始赋值
        var options = { jsonValue: item, isDebug: false };
        $("#form4Role").initForm(options);
    }
};
var RequestUtil={
    //添加或更新角色
    submit4RoleFun:function () {
        alert(1);
        var params=$("#form4Role").serializeJson();
        params.permIds=ViewUtil.getPermIds();
        instance.post('/api/role/addEditRole',params).then(function (response) {
                var result=response.data;
                if(result.code==200){
                    ViewUtil.toAlertSuccess();
                    return;
                }
                layer.alert(result.data);
            });
    },
    //初始化角色表单--开通角色
    initRoleForm4Add:function () {
        instance.get("/api/auth/getListPerm")
            .then(function (response) {
                var result=response.data;
                if(result.code==200){
                    console.log(result);
                    var treeData=ViewUtil.toTreeData4AddRole(result.data);
                    ViewUtil.initZTree(treeData);
                }
            });
    },
    //初始化角色表单--更新角色
    initRoleForm4Update:function () {
        axios.all([RequestUtil.getListPermFun4Update(), RequestUtil.getRoleFun4Update(21)])
            .then(axios.spread(function (response4ListPerm, response4Role) {
                var result4ListPerm=response4ListPerm.data;
                var result4Role=response4Role.data;
                console.log(result4ListPerm);
                console.log(result4Role);
                if(result4ListPerm.code!=200){
                    alert("getListPermFun4Update请求失败："+result4ListPerm.data);
                    return;
                }
                if(result4Role.code!=200){
                    alert("getRoleFun4Update请求失败："+result4Role.data);
                    return;
                }
                var item4Role=result4Role.data;
                ViewUtil.toFormView(item4Role);
                var treeData=ViewUtil.toTreeData4UpdateRole(result4ListPerm.data,item4Role.permIds);
                ViewUtil.initZTree(treeData);
                console.log('两个请求都完成了')
            }));
    },
    getListPermFun4Update:function () {
       return instance.get("/api/auth/getListPerm");
    },
    getRoleFun4Update:function (id) {
        return instance.get("/api/role/getRole?id="+id);
    }

};
