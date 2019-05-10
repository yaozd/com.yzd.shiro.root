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
//添加或修改资源
function submit4PermFun() {
    alert("submit4PermFun");
    console.log($("#form4Perm").serializeJson());
    instance.post('/api/auth/addEditPerm',$("#form4Perm").serializeJson())
        .then(function (response) {
            console.log(response);
            alert("ok");
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