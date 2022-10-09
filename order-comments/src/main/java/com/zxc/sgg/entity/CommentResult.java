package com.zxc.sgg.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class CommentResult<T> implements Serializable {

    private Integer code;
    private String message;
    private T data;

    public CommentResult(Integer code, String message) {
        this(code,message,null);
    }
}
