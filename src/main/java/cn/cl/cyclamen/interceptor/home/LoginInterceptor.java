package cn.cl.cyclamen.interceptor.home;

import net.sf.json.JSONObject;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/** 前端登录拦截器
 * ClassName:LoginInterceptor
 * package:cn.cll.cyclamen.interceptor.home
 * Description:
 *
 * @date:2020/4/14 21:51
 * @author:cll@163.com
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest arg0,
                                HttpServletResponse arg1, Object arg2, Exception arg3)
            throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1,
                           Object arg2, ModelAndView arg3) throws Exception {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object arg2) throws Exception {
        // TODO Auto-generated method stub
        String requestURI = request.getRequestURI();
        Object admin = request.getSession().getAttribute("user");
        if(admin == null){
            //表示未登录或者登录失效
            System.out.println("链接"+requestURI+"进入拦截器！");
            String header = request.getHeader("X-Requested-With");
            //判断是否是ajax请求
            if("XMLHttpRequest".equals(header)){
                //表示是ajax请求
                Map<String, String> ret = new HashMap<String, String>();
                ret.put("type", "error");
                ret.put("msg", "登录会话超时或还未登录，请重新登录!");
                response.getWriter().write(JSONObject.fromObject(ret).toString());
                return false;
            }
            //表示是普通链接跳转，直接重定向到登录页面
            response.sendRedirect(request.getServletContext().getContextPath() + "/home/login");
            return false;
        }

        return true;
    }

}