package com.zgd.domain.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author zgd
 */
@Data
public class VirMachineReq {

    @NotEmpty
    private String templateId;
    @Min(1)
    private Integer hostId;
}
