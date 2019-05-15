package com.yzd.shiro.web.api.controllerApi;

import com.yzd.shiro.db.entity.enumExt.TbPermissionEnum;
import com.yzd.shiro.db.entity.enumExt.TbPublicEnum;
import com.yzd.shiro.db.entity.table.TbPermission;
import com.yzd.shiro.db.entity.where.PageWhere;
import com.yzd.shiro.service.inf.IPermissionServiceInf;
import com.yzd.shiro.web.api.common.exceptionExt.CustomException;
import com.yzd.shiro.web.api.model.request.auth.AddEditPermForm;
import com.yzd.shiro.web.api.model.response.auth.GetListPermVM;
import com.yzd.shiro.web.api.model.response.auth.GetPermVM;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthControllerApi {
    @Autowired
    IPermissionServiceInf iPermissionServiceInf;

    @ApiOperation(value = "addEditPerm-添加或编辑资源")
    @PostMapping("addEditPerm")
    public String addEditPerm(@RequestBody AddEditPermForm form) {
        //
        TbPermission item = AddEditPermForm.toEntity(form);
        if(item.getId()==0){
            iPermissionServiceInf.insertSelective(item);
            return "auth:add-ok";
        }
        iPermissionServiceInf.updateByPrimaryKeySelective(item);
        return "auth:edit-ok";
    }

    @ApiOperation(value = "getListPerm-获得资源列表")
    @GetMapping("getListPerm")
    public List<GetListPermVM> getListPerm() {
        TbPermission where = new TbPermission();
        where.setEnableStatus(TbPermissionEnum.enableStatus.YES.CODE);
        where.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        List<TbPermission> itemList4TbPermission = iPermissionServiceInf.selectList(where, null, PageWhere.newPage(0, 500));
        List<GetListPermVM> itemList4GetListPermVM = new ArrayList<>();
        itemList4TbPermission.forEach(item -> itemList4GetListPermVM.add(GetListPermVM.toVM(item)));
        return itemList4GetListPermVM;
    }

    @ApiOperation(value = "getPerm-获得资源列")
    @GetMapping("getPerm")
    public GetPermVM getPerm(Long id) {
        TbPermission item4TbPermission = iPermissionServiceInf.selectByPrimaryKey(id);
        if (item4TbPermission == null) {
            throw new CustomException("没有找到id=[" + id + "]的资源");
        }
        return GetPermVM.toVM(item4TbPermission);
    }

    @ApiOperation(value = "delPerm-删除资源")
    @PostMapping("delPerm")
    public String delPerm(Long id) {
        TbPermission item4TbPermission = iPermissionServiceInf.selectByPrimaryKey(id);
        if (item4TbPermission == null) {
            throw new CustomException("没有找到id=[" + id + "]的资源");
        }
        TbPermission item4Where = new TbPermission();
        item4Where.setParentId(item4TbPermission.getId());
        item4Where.setGmtIsDel(TbPublicEnum.gmtIsDel.NO.CODE);
        Long count = iPermissionServiceInf.selectCount(item4Where, null);
        if (count > 0) {
            throw new CustomException("当前节点下有子节点，无法删除");
        }
        TbPermission item4Update = new TbPermission();
        item4Update.setId(item4TbPermission.getId());
        item4Update.setGmtIsDel(TbPublicEnum.gmtIsDel.YES.CODE);
        iPermissionServiceInf.updateByPrimaryKeySelective(item4Update);
        return "删除成功";
    }
}
