package com.chanpion.admin.system.utils;

import com.chanpion.admin.system.entity.User;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

/**
 * @author April Chen
 * @date 2019/9/6 16:20
 */
public class ShiroUtil {
    private static final SecureRandomNumberGenerator secureRandom = new SecureRandomNumberGenerator();
    public static final String ALGORITHM_NAME = "md5";
    public static final int HASH_ITERATIONS = 2;

    /**
     * 加密密码
     *
     * @param password 原始密码
     * @return 加密后密码
     */
    public String encryptPassword(String password) {
        return encryptPassword(password, randomSalt());
    }

    /**
     * 加密密码
     *
     * @param password 原始密码
     * @param salt     加密盐
     * @return 加密后密码
     */
    public static String encryptPassword(String password, String salt) {
        if (StringUtils.isBlank(salt)) {
            salt = randomSalt();
        }
        return new SimpleHash(ALGORITHM_NAME, password, ByteSource.Util.bytes(salt), HASH_ITERATIONS).toHex();
    }

    public static String randomSalt() {
        return secureRandom.nextBytes().toHex();
    }

    /**
     * 是否登录状态
     */
    public static boolean isLogin() {
        return SecurityUtils.getSubject().getPrincipal() != null;
    }

    public static User getCurrentUser(){
        return (User) SecurityUtils.getSubject().getSession().getAttribute("user");
    }
}
