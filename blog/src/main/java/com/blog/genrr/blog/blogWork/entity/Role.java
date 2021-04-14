package com.blog.genrr.blog.blogWork.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author Genrr
 * @since 2021-04-13
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Role implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String name;


}
