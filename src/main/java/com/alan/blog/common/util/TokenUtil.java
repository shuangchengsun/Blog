package com.alan.blog.common.util;

import java.util.UUID;

public class TokenUtil {

    public static String getToken(){
        String RUID = UUID.randomUUID().toString().replace("-", "");
        return RUID;
    }

    public static void main(String[] args) {
        System.out.print(TokenUtil.getToken());
    }
}
