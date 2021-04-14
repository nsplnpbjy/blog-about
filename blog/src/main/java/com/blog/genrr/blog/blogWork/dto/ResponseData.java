package com.blog.genrr.blog.blogWork.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @author nsplnpbjy
 */
@Data
@AllArgsConstructor
public class ResponseData implements Serializable {

    private int code;
    private String msg;
    private Object data;

    public static ResponseData good(Object data){
        return new ResponseData(200,"ok",data);
    }

    public static ResponseData bad(Object data){
        return new ResponseData(400,"error",data);
    }

}
