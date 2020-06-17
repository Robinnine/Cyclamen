package cn.cl.cyclamen.controller.home;

import cn.cl.cyclamen.entity.User;
import cn.cl.cyclamen.service.RoomTypeService;
import cn.cl.cyclamen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/** 前台首页控制器
 * ClassName:HomeController
 * package:cn.cll.cyclamen.controller.home
 * Description:
 *
 * @date:2020/4/14 20:44
 * @author:cll@163.com
 */
@RequestMapping("/home")
@Controller
public class HomeController {

    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private UserService userService;


    /**
     * 用户首页
     */
    @RequestMapping(value="/index",method= RequestMethod.GET)
    public ModelAndView room(ModelAndView model, @RequestParam(name="name",defaultValue="") String name
    ){
        Map<String,Object> queryMap = new HashMap<String, Object>();
        queryMap.put("name", name);
        queryMap.put("offset", 0);
        queryMap.put("pageSize", 999);
        model.addObject("roomTypeList", roomTypeService.findList(queryMap));
        model.setViewName("home/index/index");
        model.addObject("kw", name);
        return model;
    }
    /**
     * 房间列表页
     * @param model
     * @param name
     * @return
     */
    @RequestMapping(value="/room",method= RequestMethod.GET)
    public ModelAndView list(ModelAndView model,@RequestParam(name="name",defaultValue="") String name
                             ){
        Map<String,Object> queryMap = new HashMap<String, Object>();
        queryMap.put("name", name);
        queryMap.put("offset", 0);
        queryMap.put("pageSize", 999);
        model.addObject("roomTypeList", roomTypeService.findList(queryMap));
        model.setViewName("home/index/room");
        model.addObject("kw", name);
        return model;
    }



    /**
     * 登录页面
     * @param model
     * @return
     */
    @RequestMapping(value="/login",method= RequestMethod.GET)
    public ModelAndView login(ModelAndView model
    ){
        model.setViewName("home/index/login");
        return model;
    }

    /**
     * 注册页面
     * @param model
     * @return
     */
    @RequestMapping(value="/reg",method= RequestMethod.GET)
    public ModelAndView reg(ModelAndView model
    ){
        model.setViewName("home/index/reg");
        return model;
    }




    /**
     * 登录信息提交
     * @param user
     * @return
     */
    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,String> loginAct(User user, String vcode, HttpServletRequest request){
        Map<String,String> retMap = new HashMap<String, String>();
        if(user == null){
            retMap.put("type", "error");
            retMap.put("msg", "请填写正确的用户信息！");
            return retMap;
        }
        if(StringUtils.isEmpty(user.getName())){
            retMap.put("type", "error");
            retMap.put("msg", "用户名不能为空！");
            return retMap;
        }
        if(StringUtils.isEmpty(user.getPassword())){
            retMap.put("type", "error");
            retMap.put("msg", "密码不能为空！");
            return retMap;
        }
        if(StringUtils.isEmpty(vcode)){
            retMap.put("type", "error");
            retMap.put("msg", "验证码不能为空！");
            return retMap;
        }
        Object attribute = request.getSession().getAttribute("userLoginCpacha");
        if(attribute == null){
            retMap.put("type", "error");
            retMap.put("msg", "验证码过期，请刷新！");
            return retMap;
        }
        if(!vcode.equalsIgnoreCase(attribute.toString())){
            retMap.put("type", "error");
            retMap.put("msg", "验证码错误！");
            return retMap;
        }
        User findByName = userService.findByName(user.getName());
        if(findByName == null){
            retMap.put("type", "error");
            retMap.put("msg", "用户名不存在！");
            return retMap;
        }
        if(!user.getPassword().equals(findByName.getPassword())){
            retMap.put("type", "error");
            retMap.put("msg", "密码错误！");
            return retMap;
        }
        if(findByName.getStatus() == -1){
            retMap.put("type", "error");
            retMap.put("msg", "该用户已被禁用，请联系管理员！");
            return retMap;
        }
        request.getSession().setAttribute("user", findByName);
        request.getSession().setAttribute("userLoginCpacha", null);
        retMap.put("type", "success");
        retMap.put("msg", "登录成功！");
        return retMap;
    }

    /**
     * 注册信息提交
     * @param user
     * @return
     */
    @RequestMapping(value="/reg",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,String> regAct(User user){
        Map<String,String> retMap = new HashMap<String, String>();
        if(user == null){
            retMap.put("type", "error");
            retMap.put("msg", "请填写正确的用户信息！");
            return retMap;
        }
        if(StringUtils.isEmpty(user.getName())){
            retMap.put("type", "error");
            retMap.put("msg", "用户名不能为空！");
            return retMap;
        }
        if(StringUtils.isEmpty(user.getPassword())){
            retMap.put("type", "error");
            retMap.put("msg", "密码不能为空！");
            return retMap;
        }
        if(StringUtils.isEmpty(user.getMobile())){
            retMap.put("type", "error");
            retMap.put("msg", "手机号不能为空！");
            return retMap;
        }
        if(isExist(user.getName())){
            retMap.put("type", "error");
            retMap.put("msg", "该用户名已经存在！");
            return retMap;
        }
        if(userService.add(user) <= 0){
            retMap.put("type", "error");
            retMap.put("msg", "注册失败，请联系管理员！");
            return retMap;
        }
        retMap.put("type", "success");
        retMap.put("msg", "注册成功！");
        return retMap;
    }

    /**
     * 退出登录
     * @param request
     * @return
     */
    @RequestMapping(value="/logout",method= RequestMethod.GET)
    public String logout(HttpServletRequest request){
        request.getSession().setAttribute("user", null);
        return "redirect:login";
    }

    private boolean isExist(String name){
        User user = userService.findByName(name);
        if(user == null)return false;
        return true;
    }
}

