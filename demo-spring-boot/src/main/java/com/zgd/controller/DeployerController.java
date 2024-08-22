package com.zgd.controller;

import com.zgd.core.JsonResult;
import com.zgd.core.exception.ProductBizException;
import com.zgd.core.exception.ProductErrorCodeEnum;
import com.zgd.domain.request.DeployReq;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

/**
 * 部署一个saas服务
 *
 * @author zgd
 */
@RestController
@RequestMapping("/api/v1/deploy")
@Validated
@Slf4j
public class DeployerController {
    /**
     * 类中参数验证，要添加@Valid注解
     * 如果这个类中还有其他object对象需要递归验证，那么每一层都需要添加@Valid注解
     */
    @PostMapping("/startDeploy")
    public JsonResult<Boolean> startDeploy(@Valid @RequestBody DeployReq deployReq,
                                           @NotEmpty(message = "userId不能为空") @RequestParam("userId") String userId) {
        return JsonResult.buildSuccess(Boolean.TRUE);
    }


    @GetMapping("/testException")
    public JsonResult<String> testException() {
        throw new ProductBizException(ProductErrorCodeEnum.DEVICE_GET_TOKEN_ERROR);
    }
}
