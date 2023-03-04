package com.ruoyi.common.utils.user;

import com.ruoyi.common.utils.CacheUtils;
import com.ruoyi.common.utils.CookieUtils;
import org.apache.shiro.session.Session;

import javax.servlet.http.HttpServletRequest;

public class CurrentUser {

    /**
     * 获取 shiro-activeSessionCache 缓存中的个人信息
     *
     * @param httpServletRequest
     * @return
     */
    public static Session getWhoAmI(HttpServletRequest httpServletRequest){
        String cacheName = "shiro-activeSessionCache";
        String cacheKey = CookieUtils.getCookie(httpServletRequest,"JSESSIONID");
        return (Session) CacheUtils.get(cacheName, cacheKey);
    }

}
