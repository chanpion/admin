package com.chanpion.admin.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author April Chen
 * @date 2020/8/4 14:09
 */
public class LogUtil {
    private static final Logger LOG = LoggerFactory.getLogger(LogUtil.class);

    static {
        System.setProperty("log4j2.isThreadContextMapInheritable", "true");
    }

    public static void info(String msg) {
        LOG.info(msg);
    }

    public static void info(String format, Object... msg) {
        LOG.info(format, msg);
    }

    public static void error(String msg) {
        LOG.error(msg);
    }

    public static void error(String msg, Throwable e) {
        LOG.error(msg, e);
    }
}
