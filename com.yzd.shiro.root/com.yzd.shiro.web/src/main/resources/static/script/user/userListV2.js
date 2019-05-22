/**
 * 角色管理--代码整理版
 */
$(function () {
    $("#addUserBtn").click(function () {
        ViewUtil.toShowAddEditUser("开通用户");
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
var JobStatusEnum = {
    YES: {name: "在职", value: 0},
    NO: {name: "离职", value: 1},
};
//
var ViewUtil = {
    toView: function (arr) {
        var temp = [];
        for (var i = 0; i < arr.length; i++) {
            var item = arr[i];
            item.jobName = ViewUtil.toJobName(item.jobStatus);
            temp.push(item);
        }
        return temp;
    },
    toJobName: function (jobStatus) {
        //枚举遍历
        for (var prop in JobStatusEnum) {
            var item = JobStatusEnum[prop];
            if (item.value == jobStatus) {
                return item.name;
            }
        }
        return "";
    },
    toAlertSuccess: function (title) {
        //弹出层:无关闭按钮
        layer.alert(title, {closeBtn: 0}, function () {
            layer.closeAll();
            //加载load方法
            //window.location.reload();
            RequestUtil.initDataListFun();
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
    toTreeData4AddUser: function (itemList) {
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
    toTreeData4UpdateUser: function (itemList, roleId) {
        var treeData = [];
        for (var i = 0, il = itemList.length; i < il; i++) {
            var item = itemList[i];
            item.name = item.roleName;
            item.open = true;
            item.checked = roleId == item.id;
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
    },
    getRoleId: function () {
        var treeObj = $.fn.zTree.getZTreeObj("ztree4RoleList");
        var nodes = treeObj.getCheckedNodes(true);
        var nodeIds = [];
        for (var i = 0; i < nodes.length; i++) {
            nodeIds.push(nodes[i].id);
        }
        //var permIds= nodeIds.join(",");
        return nodeIds;
    },
    toFormView: function (item) {
        //表单初始赋值
        var options = {jsonValue: item, isDebug: false};
        $("#userForm").initForm(options);
    },
    toDelUserView:function (id,name) {
        console.log("===删除id："+id);
        if(null!=id){
            layer.confirm('您确定要删除['+name+']角色吗？', {
                btn: ['确认','返回'] //按钮
            }, function(){
                RequestUtil.delUserFun(id);
            }, function(){
                layer.closeAll();
            });
        }
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
                //转为显示数据
                var viewData = ViewUtil.toView(result.data);
                vm.reports = viewData;
                console.log(viewData);
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
    initUserForm4Update: function (id) {
        axios.all([RequestUtil.getListRoleFun4Update(), RequestUtil.getUserFun4Update(id)])
            .then(axios.spread(function (response4ListRole, response4User) {
                var result4ListRole = response4ListRole.data;
                var result4User = response4User.data;
                console.log(result4ListRole);
                console.log(result4User);
                if (result4ListRole.code != 200) {
                    alert("getListRoleFun4Update请求失败：" + result4ListRole.data);
                    return;
                }
                if (result4User.code != 200) {
                    alert("getUserFun4Update请求失败：" + result4User.data);
                    return;
                }
                var item4User = result4User.data;
                ViewUtil.toFormView(item4User);
                var treeData = ViewUtil.toTreeData4UpdateUser(result4ListRole.data, item4User.roleId);
                ViewUtil.initZTree(treeData);
                console.log('两个请求都完成了')
            }));
    },
    getListRoleFun4Update: function () {
        return instance.get("/api/role/getListRole");
    },
    getUserFun4Update: function (id) {
        return instance.get("/api/user/getUser?id=" + id);
    },
    userSubmitFun: function () {
        var params = $("#userForm").serializeJson();
        params.roleIds = ViewUtil.getRoleId();
        instance.post('/api/user/addEditUser', params).then(function (response) {
            var result = response.data;
            if (result.code == 200) {
                ViewUtil.toAlertSuccess("操作成功！");
                return;
            }
            layer.alert(result.data);
        });
    },
    delUserFun:function (id) {
        instance.post('/api/user/delUser?id='+id)
            .then(function (response) {
                var result=response.data;
                if(result.code==200){
                    ViewUtil.toAlertSuccess("删除成功！");
                    return;
                }
                layer.closeAll();
                alert(result.data);
            });
    }
};
//VUE 放在代码的最后面
Vue.component("component4job", {
    template: "#jobTpl",
    props: ["data"]
})
var vm = new Vue({
    el: "#tbody4RoleList",
    data: {reports: []},
    created: function () {
        RequestUtil.initDataListFun();
    },
    methods: {
        updateVUE: function (val) {
            alert(val);
            ViewUtil.toShowAddEditUser("编辑用户");
            RequestUtil.initUserForm4Update(val);
        },
        delVUE: function (id, name) {
            ViewUtil.toDelUserView(id, name);
        }
    }
});