package com.zgd.domain.request;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

/**
 * @author zgd
 */
@Data
public class VirPlatReq {
    @NotEmpty
    private String virPlatIp;
    @Min(1)
    private Integer virPlatPort;
}
