package com.alan.blog.util;

import com.alan.blog.Exception.TokenFormatException;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptUtil {

    public static String MD5(String str){
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuffer buf = new StringBuffer();
            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0) {
                    i += 256;
                }
                if (i < 16) {
                    buf.append("0");
                }
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();

        } catch (NoSuchAlgorithmException e) {
            return null;
        }
    }

    public static boolean checkToken(String token){
        if(token.length() != 64){
            throw new TokenFormatException("token 格式错误");
        }else{
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                if(EncryptUtil.MD5(token.substring(0,32)).equals(token.substring(32,64))){
                    return true;
                }else {
                    return false;
                }
            }catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            }

        }
        return false;
    }
}
