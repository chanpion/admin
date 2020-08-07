package com.chanpion.admin.controller;

import com.chanpion.admin.common.utils.LogUtil;
import com.chanpion.admin.system.utils.CaptchaUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author April Chen
 * @date 2020/7/27 17:24
 */
@Controller
public class LoginController {

    @GetMapping("login")
    public String login() {
        return "login";
    }

    @PostMapping("login")
    public String doLogin(Model model, String username, String password,
                          @RequestParam(required = false, defaultValue = "false") Boolean rememberMe) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password, rememberMe);
        Subject subject = SecurityUtils.getSubject();
        String msg = null;
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                LogUtil.info("user {} login success.", username);
                return "/";
            } else {
                return "error";
            }
        } catch (IncorrectCredentialsException e) {
            msg = "密码有误，请重新输入!";
        } catch (ExcessiveAttemptsException e) {
            msg = "登录失败次数过多!";
        } catch (LockedAccountException e) {
            msg = "帐号已被锁定! ";
        } catch (DisabledAccountException e) {
            msg = "帐号已被禁用! ";
        } catch (ExpiredCredentialsException e) {
            msg = "帐号已过期! ";
        } catch (UnknownAccountException e) {
            msg = "帐号不存在!";
        } catch (UnauthorizedException e) {
            msg = "您没有得到相应的授权！" + e.getMessage();
        } catch (Exception e) {
            LogUtil.error("{}", e);
        } finally {
            model.addAttribute("message", msg);
            LogUtil.info(msg);
        }
        return "/error";
    }

    /**
     * 退出
     */
    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout() {
        SecurityUtils.getSubject().logout();
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @GetMapping("/forgot-password")
    public String forgotPassword() {
        return "forgot-password";
    }

    /**
     * 验证码
     */
    @RequestMapping("/captcha")
    @ResponseBody
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws IOException {
        CaptchaUtil.captcha(request, response);
    }

}
