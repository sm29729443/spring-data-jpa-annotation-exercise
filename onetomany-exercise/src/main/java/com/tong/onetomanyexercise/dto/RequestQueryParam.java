package com.tong.onetomanyexercise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RequestQueryParam {
    private Integer pageSize;
    private String p2;
    private String p3;
    private String p4;
    private String p5;
}
