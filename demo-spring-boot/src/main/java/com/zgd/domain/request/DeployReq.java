package com.zgd.domain.request;

import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

/**
 * @author zgd
 */
@Data
public class DeployReq {
    @Valid
    private VirPlatReq virPlatReq;

    @Valid
    private List<VirMachineReq> virMachineReqList;

    @NotEmpty
    private String callBackUrl;

}
