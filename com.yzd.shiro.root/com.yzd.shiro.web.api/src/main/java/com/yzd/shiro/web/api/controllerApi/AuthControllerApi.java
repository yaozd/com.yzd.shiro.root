package com.yzd.shiro.web.api.controllerApi;

import com.yzd.shiro.web.api.model.request.auth.AddEditPermForm;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/auth")
public class AuthControllerApi {
    @ApiOperation(value = "addEditPerm-添加或编辑资源")
    @PostMapping("addEditPerm")
    public String addEditPerm(@RequestBody AddEditPermForm form) {
        //
        return "auth:addEditPerm-true";
    }
}
