package com.alan.demo.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @Description springboot实现拦截器   session登录机制
 * <p>
 * 注意:  此配置文件仅用于 自测 分布式session问题
 * <p>
 * 会影响到其它接口的路径   自行按照需要放开路径
 * @Author gaodehan
 * @Version V1.0.0
 * @Since 1.0
 * @Date 2020/2/8
 */


//@Slf4j
//@Configuration
//public class SeeionConfig implements WebMvcConfigurer {
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new SecurityInterceptor())
//                .excludePathPatterns("/redis-user/login")
//                .excludePathPatterns("/redis-user/logout")
//                .excludePathPatterns("/mybatis-users")
//
//                //拦截所有路径
//                .addPathPatterns("/**");
//    }
//
//    @Configuration
//    public class SecurityInterceptor implements HandlerInterceptor {
//
//        @Override
//        public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//            HttpSession session = request.getSession();
//            //验证当前session是否存在,存在返回true, true的代表能正常处理逻辑
//            if (session.getAttribute(session.getId()) != null) {
//                log.info("session拦截器,session={},验证通过", session.getId());
//                return true;
//            }
//
//            //session不存在,返回false,并提示请重新登录
//            response.setCharacterEncoding("UTF-8");
//            response.setContentType("application/json; charset=utf-8");
//            response.getWriter().write("请登录!!!");
//            log.info("session拦截器,session={},验证失败", session.getId());
//            return false;
//        }
//    }
//}
