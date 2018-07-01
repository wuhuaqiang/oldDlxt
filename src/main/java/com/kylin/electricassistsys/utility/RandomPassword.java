package com.kylin.electricassistsys.utility;

import java.security.SecureRandom;

/**
 * Created by Threecolors on 2018/2/26.
 */
public class RandomPassword
{
    //获取验证过的随机密码
    public static String getRandomPassword(int len) {
        String result = null;
        while(true){
            result = makeRandomPassword(len);
            int count = 0;
            if(result.matches(".*[a-z]{1,}.*"))
            {
                count++;
            }

            if(result.matches(".*[A-Z]{1,}.*"))
            {
                count++;
            }
            if (result.matches(".*\\d{1,}.*") && result.matches(".*[~!@#$%^&*\\.?]{1,}.*")) {
                count++;
            }

            if (result.matches(".*[~!@#$%^&*\\.?]{1,}.*")) {
                count++;
            }

            if(count>2)
            {
                return result;
            }
        }
    }

    //随机密码生成
    private static String makeRandomPassword(int len){
        char charr[] = "abcdefghijklm1234567890~!@#$%^&*.?nopqrstuvwxyzABCDEFGHIJKLM1234567890~!@#$%^&*.?NOPQRSTUVWXYZ1234567890~!@#$%^&*.?".toCharArray();
        StringBuilder sb = new StringBuilder();
        SecureRandom r = new SecureRandom();
        for (int x = 0; x < len; ++x) {
            sb.append(charr[r.nextInt(charr.length)]);
        }
        return sb.toString();
    }
}
