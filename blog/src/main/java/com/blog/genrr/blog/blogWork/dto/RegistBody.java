package com.blog.genrr.blog.blogWork.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RegistBody {

    @NotBlank
    private String username;

    @NotBlank
    private String password;

}
