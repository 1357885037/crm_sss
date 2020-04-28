package com.hy.crm.util;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class Md5 {

    public static String md4Test(String u_Name,String u_Pass){
        String hashAlgorithmName="MD5"; //加密方式
        Object credentials=u_Pass;   //要加密的密码
        Object salt= ByteSource.Util.bytes(u_Name);//加的盐
        int hashIterations=1024;//加密次数

        Object result=new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
        return result.toString();

    }

//    public static void main(String[] args) {
//        String hashAlgorithmName="MD5"; //加密方式
//        Object credentials="190729";   //要加密的密码
//        Object salt= ByteSource.Util.bytes("tanghao");//加的盐
//        int hashIterations=1024;//加密次数
//
//        Object result=new SimpleHash(hashAlgorithmName,credentials,salt,hashIterations);
//        System.out.println(result.toString());
//    	}


}
