
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
    var item=$("#form4Role").serializeJson();
    item.permIds=ViewUtil.getPermIds();
    instance.post('/api/role/addEditPerm',item)
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
        return permIds;
    }
};