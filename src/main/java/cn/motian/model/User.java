package cn.motian.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class User extends BaseData {
    private String unionId;
    private String name;
    private String pass; // pass应该加密后存储 校验时解密校验
    private String identity; //身份
    private String teL; //电话
    private String addr; //地址
    private String email; //邮件

    public User() {
    }

    public User(String name, String pass, String identity,
                String teL, String addr, String email) {
        this.name = name;
        this.pass = pass;
        this.identity = identity;
        this.teL = teL;
        this.addr = addr;
        this.email = email;
    }

}

