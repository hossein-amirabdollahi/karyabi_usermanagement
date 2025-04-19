package com.karyabi.usermanagement.util;

import org.springframework.stereotype.Component;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Component
public class HashUtil {

    public String hashWithMD5(String rawPassword) {
        String saltedPassword = rawPassword + "w@e8kH#0Dk4dS$";
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] digest = md.digest(saltedPassword.getBytes());

            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }

            return sb.toString();

        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not available.");
        }
    }
//    public static void main(String[] args) {
//        String rawPassword = "1245987986";
//        HashUtil hashUtil = new HashUtil();
//        System.out.println(hashUtil.hashWithMD5(rawPassword));
//    }
}
