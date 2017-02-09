package org.william.util;


import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by huawai on 2016/12/21.
 * Description:
 */
public class NetworkUtil {

    /**
     * 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址;
     *
     * @param request
     * @return
     * @throws IOException
     */
    public final static String getIpAddress(HttpServletRequest request) {
        // 获取请求主机IP地址,如果通过代理进来，则透过防火墙获取真实IP地址

        String ip = request.getHeader("X-Forwarded-For");
        String headerType = null;
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
                headerType = "Proxy-Client-IP";
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
                headerType = "WL-Proxy-Client-IP";
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
                headerType = "HTTP_CLIENT_IP";
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
                headerType = "HTTP_X_FORWARDED_FOR";
            }
            if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
                headerType = "getRemoteAddr";
            }
            LoggerUtil.info(NetworkUtil.class, String.format("getIpAddress(HttpServletRequest) - %s - String ip:%s", headerType, ip));
        } else if (ip.length() > 15) {
            String[] ips = ip.split(",");
            for (int index = 0; index < ips.length; index++) {
                String strIp = (String) ips[index];
                if (!("unknown".equalsIgnoreCase(strIp))) {
                    ip = strIp;
                    LoggerUtil.info(NetworkUtil.class, String.format("getIpAddress(HttpServletRequest) - String ip:%s", ip));
                    break;
                }
            }
        }
        return ip;
    }
}
