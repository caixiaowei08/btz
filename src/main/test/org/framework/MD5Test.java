package org.framework;

import org.baron.framework.utils.PasswordUtil;
import org.junit.*;

import java.security.NoSuchAlgorithmException;

/**
 * Created by User on 2017/5/12.
 */
public class MD5Test {
    @org.junit.Test
    public void test(){
        System.out.println(PasswordUtil.getMD5Encryp("112233"));
    }
}
