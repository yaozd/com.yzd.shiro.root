
layui.use(['form'], function(){
    var form = layui.form;
    //监控提交
    form.on("submit(submit4Role)",function () {
        submit4RoleFun();
        return false;
    });
});
function submit4RoleFun() {
    alert(1);
    console.log($("#form4Role").serializeJson());
    var param=$("#form4Role").serializeJson();
    param.permIds=ViewUtil.getPermIds();
    instance.post('/api/role/addEditRole',param)
        .then(function (response) {
            var result=response.data;
            if(result.code==200){
                //弹出层:无关闭按钮
                layer.alert("操作成功！",{  closeBtn: 0 },function(){
                    layer.closeAll();
                    //加载load方法
                    //window.location.reload();
                });
                return;
            }
            alert(result.data);
        });
}
/**
 * 角色管理
 */
$(function () {
    initPermList();
    //
    $("#roleListLi").click(function () {
        ViewUtil.toShowRoleListLi();
    });
    $("#setRoleLi").click(function () {
        ViewUtil.toShowSetRoleLi();
    });
})
function initPermList() {
    instance.get("/api/auth/getListPerm")
        .then(function (response) {
            var result=response.data;
            if(result.code==200){
                console.log(result);
               var treeData=ViewUtil.toTreeData(result.data);
               ViewUtil.initZTree(treeData);
            }
        });
}
var ViewUtil={
    toTreeData:function (itemList) {
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
    initZTree4UpdateRole:function (treeData) {
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
        $.fn.zTree.init($("#ztree4PermList2Update"), setting, treeData);
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
        var permIds= nodeIds.join(",");
        return nodeIds;
    },
    toShowUpdateRoleLi:function () {
        $("#roleListLi").removeClass("layui-this");
        $("#setRoleLi").removeClass("layui-this");
        $("#roleListDiv").removeClass("layui-show");
        $("#setRoleDiv").removeClass("layui-show");

        $("#updateRoleLi").addClass("layui-this");
        $("#updateRoleDiv").addClass("layui-show");
        $("#updateRoleLi").css("display","inline-block");
        $("#updateRoleDiv").css("display","inline-block");
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

        $("#updateRoleLi").css("display","none");
        $("#updateRoleDiv").css("display","none");
        $("#setRoleLi").addClass("layui-this");
        $("#setRoleDiv").addClass("layui-show");
    },
    toFormView:function (item) {
        //表单初始赋值
        var options = { jsonValue: item, isDebug: false };
        $("#form4UpdateRole").initForm(options);
    }
};

var model4RoleList = {
    reports:[]
};
var vm = new Vue({
    el: "#tbody4RoleList",
    data: model4RoleList,
    created:function(){
        initDataFun4RoleList();
    },
    methods:{
        updateRoleVUE:function (val) {
            alert(11);
            ViewUtil.toShowUpdateRoleLi();
            initDataFun4UpdateRole(val);
        },
        delVUE:function (id,name) {
            delFun(id,name);
        },
        editVUE:function (id) {
            editPermFun(id);
        }
    }
});
function initDataFun4RoleList() {
    instance.get("/api/role/getListRole")
        .then(function (response) {
            var result=response.data;
            if(result.code==200){
                console.log(result.data);
                vm.reports=result.data;
            }
        });
}
function initDataFun4UpdateRole(id) {
    document.getElementById("form4UpdateRole").reset();
    if(null!=id){
        instance.get("/api/role/getRole?id="+id).then(function (response) {
            var result=response.data;
            if(result.code==200){
                var item=result.data;
                console.log(item);
                ViewUtil.toFormView(item);
                initPermList4UpdateRole(item.permIds);
                return;
            }
            alert(result.data);
            layer.alert("获取权限数据出错，请您稍后再试"+result.data);
        });
    }
}
function initPermList4UpdateRole(permIds) {
    instance.get("/api/auth/getListPerm")
        .then(function (response) {
            var result=response.data;
            if(result.code==200){
                console.log(result);
                var treeData=ViewUtil.toTreeData4UpdateRole(result.data,permIds);
                ViewUtil.initZTree4UpdateRole(treeData);
            }
        });
}