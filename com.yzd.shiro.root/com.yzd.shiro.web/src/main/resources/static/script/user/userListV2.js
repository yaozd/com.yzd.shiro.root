/**
 * 角色管理--代码整理版
 */
$(function () {
    $("#addUserBtn").click(function () {
        ViewUtil.toShowAddEditUser("开通角色");
        RequestUtil.initUserForm4Add();
    });
});
//搜索框
layui.use(['form', 'laydate', 'table'], function () {
    var form = layui.form
        , layer = layui.layer
        , laydate = layui.laydate
        , table = layui.table;
    //日期
    laydate.render({
        elem: '#insertTimeStart'
    });
    laydate.render({
        elem: '#insertTimeEnd'
    });
    //TODO 数据校验
    //监听搜索框
    form.on('submit(searchSubmit)', function (data) {
        //重新加载table
        alert(2);
        RequestUtil.searchSubmitFun();
        return false;
    });
    form.on('submit(userSubmit)', function (data) {
        //重新加载table
        alert(3);
        RequestUtil.userSubmitFun();
        return false;
    });
});
//
var ViewUtil = {
    toAlertSuccess: function (title) {
        //弹出层:无关闭按钮
        layer.alert(title, {closeBtn: 0}, function () {
            layer.closeAll();
            //加载load方法
            //window.location.reload();
            //ViewUtil.toShowRoleListLi();
        });
    },
    toShowAddEditUser: function (title) {
        layer.open({
            type: 1,
            title: title,
            fixed: true,
            resize: true,
            shadeClose: true,
            area: ['600px', '700px'],
            content: $('#setUser'),  //页面自定义的div，样式自定义
            success: function (layero) {
                //layer弹层遮罩挡住窗体解决
                var mask = $(".layui-layer-shade");
                mask.appendTo(layero.parent());
            },
            end: function () {
                //window.location.reload();
            }
        });
    },
    toTreeData4AddUser:function (itemList) {
        console.log(itemList);
        var treeData = [];
        for (var i = 0, il = itemList.length; i < il; i++) {
            var item = itemList[i];
            item.name = item.roleName;
            item.open = true;
            treeData.push(item);
        }
        return treeData;
    },
    initZTree: function (treeData) {
        var setting = {
            check: {
                enable: true,
                chkStyle: "radio", radioType: "level",
                chkboxType: {"Y": "p", "N": "s"}
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };
        $.fn.zTree.init($("#ztree4RoleList"), setting, treeData);
    }
};
//
var RequestUtil = {
    searchSubmitFun: function () {
        var params = $("#userSearch").serializeJson();
        console.log(params);
        instance.post('/api/user/getListUser', params).then(function (response) {
            console.log("response=" + response);
            console.log(response);
            var result = response.data;
            if (result.code == 200) {
                vm.reports = result.data;
                console.log(result.data);
                return;
            }
            layer.alert(result.data);
        });
    },
    initDataListFun: function () {
        RequestUtil.searchSubmitFun();
    },
    //初始化角色表单--开通角色
    initUserForm4Add: function () {
        instance.get("/api/role/getListRole")
            .then(function (response) {
                var result = response.data;
                if (result.code == 200) {
                    console.log(result);
                    var treeData = ViewUtil.toTreeData4AddUser(result.data);
                    ViewUtil.initZTree(treeData);
                }
            });
    },
    userSubmitFun:function () {
        var params = $("#userForm").serializeJson();
        //params.permIds = ViewUtil.getRoleIds();
        instance.post('/api/user/addEditUser', params).then(function (response) {
            var result = response.data;
            if (result.code == 200) {
                ViewUtil.toAlertSuccess("操作成功！");
                return;
            }
            layer.alert(result.data);
        });
    }
};
//VUE 放在代码的最后面
var vm = new Vue({
    el: "#tbody4RoleList",
    data: {reports: []},
    created: function () {
        RequestUtil.initDataListFun();
    },
    methods: {
        updateRoleVUE: function (val) {
            alert(val);
            ViewUtil.toShowUpdateRoleLi();
            RequestUtil.initRoleForm4Update(val);
        },
        delVUE: function (id, name) {
            ViewUtil.toDelRoleView(id, name);
        }
    }
});