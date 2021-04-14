package com.blog.genrr.blog.blogWork.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author Genrr
 * @since 2021-04-08
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Papers implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String name;

    private String inside;

    private String auth;

    public Papers(String name,String inside,String auth){
        this.setName(name);
        this.setInside(inside);
        this.setAuth(auth);
    }

}
