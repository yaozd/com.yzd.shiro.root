/**
 * 权限管理
 */
layui.use(['form', 'layedit', 'laydate'], function(){
    var form = layui.form,layedit = layui.layedit,laydate = layui.laydate;
    //监控提交
    form.on("submit(submit4Perm)",function () {
        submit4PermFun();
        return false;
    });
});
$(function () {
    initListPermFun();
});
var tmpList=[];
function initListPermFun() {
    instance.get("/api/auth/getListPerm")
        .then(function (response) {
            var result=response.data;
            if(result.code==200){
                console.log(result);
                tmpList=result.data;
                var itemList4All=result.data.orderAsc(function (a){
                    return [a.sortNo,a.id];
                });
                var treeData=sonsTree(itemList4All,0);
                console.log(treeData);
            }
        });
}
/**
 * 利用子孙树生成一个树形
 * @param arr
 * @param id
 * @returns {Array}
 */
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
//添加或修改资源
function submit4PermFun() {
    //alert("submit4PermFun");
    console.log($("#form4Perm").serializeJson());
    instance.post('/api/auth/addEditPerm',$("#form4Perm").serializeJson())
        .then(function (response) {
            var result=response.data;
            if(result.code==200){
                //弹出层:无关闭按钮
                layer.alert("添加成功！",{  closeBtn: 0 },function(){
                    layer.closeAll();
                    //加载load方法
                });
                return;
            }
            alert(result.data);
        });
}

//开通权限-新增
function addPermFun(parentId){
    //表单重置：记住 要用document.getElementById("myform").reset(); 不要用$("#myform").reset();
    document.getElementById("form4Perm").reset();
    if(null!=parentId){
        $("#id").val(0);
        $("#parentId").val(parentId);
        layer.open({
            type:1,
            title: "添加权限",
            fixed:true,
            resize :true,
            shadeClose: true,
            area: ['600px', '700px'],
            content:$('#updatePerm'),  //页面自定义的div，样式自定义
            success:function(layero){
                //layer弹层遮罩挡住窗体解决
                var mask = $(".layui-layer-shade");
                mask.appendTo(layero.parent());
            },
            end:function(){
                //window.location.reload();
            }
        });
    }
}