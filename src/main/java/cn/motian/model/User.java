package cn.motian.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String unionId;
    private String name;
    private String pass; // pass应该加密后存储 校验时解密校验
    private String identity; //身份

    public User() {
    }

    public User(String name, String pass, String identity) {
        this.name = name;
        this.pass = pass;
        this.identity = identity;
    }
}

