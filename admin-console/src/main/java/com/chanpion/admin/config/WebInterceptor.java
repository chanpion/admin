package com.chanpion.admin.config;

import com.chanpion.admin.system.entity.Menu;
import com.chanpion.admin.system.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * @author April Chen
 * @date 2020/7/29 19:37
 */
public class WebInterceptor extends HandlerInterceptorAdapter {
    private static final Logger logger = LoggerFactory.getLogger(WebInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        logger.info("pre handler");

        return super.preHandle(request, response, handler);
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            User user = new User();
            user.setUsername("April Chen");
            user.setImage("dist/img/user2-160x160.jpg");
            modelAndView.addObject("user", user);

            Menu menuTree = new Menu("菜单");
            Menu systemMenu = new Menu("系统管理");
            List<Menu> children = new ArrayList<>();
            children.add(new Menu("菜单管理","/menu"));
            children.add(new Menu("用户管理"));
            children.add(new Menu("权限管理"));
            systemMenu.setChildren(children);

            List<Menu> menus = new ArrayList<>();
            menus.add(systemMenu);
            menuTree.setChildren(menus);

            modelAndView.addObject("menus", menus);
            modelAndView.addObject("menuTree", menuTree);
        }

        super.postHandle(request, response, handler, modelAndView);
    }
}
