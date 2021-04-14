package com.blog.genrr.blog.blogWork.entity;

import java.time.LocalDateTime;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

/**
 * <p>
 * 
 * </p>
 *
 * @author Genrr
 * @since 2021-04-05
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class User implements Serializable {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @NotBlank
    private String name;

    @NotBlank
    private String pwd;

    private Integer status;

    @TableField(fill = FieldFill.INSERT)
    @NotEmpty
    private LocalDateTime createdDate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    @NotEmpty
    private LocalDateTime lastUpdateDate;


}
