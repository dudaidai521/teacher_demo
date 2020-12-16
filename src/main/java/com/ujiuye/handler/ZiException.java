package com.ujiuye.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ZiException extends RuntimeException{

    private Integer code;
    private String msg;
}
