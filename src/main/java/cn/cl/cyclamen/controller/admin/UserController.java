package cn.cl.cyclamen.controller.admin;

import cn.cl.cyclamen.entity.User;
import cn.cl.cyclamen.page.admin.Page;
import cn.cl.cyclamen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/** 用户管理后台控制器
 * ClassName:UserController
 * package:cn.cll.cyclamen.controller.admin
 * Description:
 *
 * @date:2020/4/14 20:50
 * @author:cll@163.com
 */
@RequestMapping("/admin/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;


    /**
     * 用户管理列表页面
     * @param model
     * @return
     */
    @RequestMapping(value="/list",method= RequestMethod.GET)
    public ModelAndView list(ModelAndView model){
        model.setViewName("user/list");
        return model;
    }

    /**
     * 用户信息添加操作
     * @param user
     * @return
     */
    @RequestMapping(value="/add",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, String> add(User user){
        Map<String, String> ret = new HashMap<String, String>();
        if(user == null){
            ret.put("type", "error");
            ret.put("msg", "请填写正确的用户信息!");
            return ret;
        }
        if(StringUtils.isEmpty(user.getName())){
            ret.put("type", "error");
            ret.put("msg", "用户名称不能为空!");
            return ret;
        }
        if(StringUtils.isEmpty(user.getPassword())){
            ret.put("type", "error");
            ret.put("msg", "用户密码不能为空!");
            return ret;
        }
        if(isExist(user.getName(), 0l)){
            ret.put("type", "error");
            ret.put("msg", "该用户名已经存在!");
            return ret;
        }
        if(userService.add(user) <= 0){
            ret.put("type", "error");
            ret.put("msg", "添加失败，请联系管理员!");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "添加成功!");
        return ret;
    }

    /**
     * 用户信息编辑操作
     * @param user
     * @return
     */
    @RequestMapping(value="/edit",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, String> edit(User user){
        Map<String, String> ret = new HashMap<String, String>();
        if(user == null){
            ret.put("type", "error");
            ret.put("msg", "请填写正确的用户信息!");
            return ret;
        }
        if(StringUtils.isEmpty(user.getName())){
            ret.put("type", "error");
            ret.put("msg", "用户名称不能为空!");
            return ret;
        }
        if(StringUtils.isEmpty(user.getPassword())){
            ret.put("type", "error");
            ret.put("msg", "用户密码不能为空!");
            return ret;
        }
        if(isExist(user.getName(), user.getId())){
            ret.put("type", "error");
            ret.put("msg", "该用户名已经存在!");
            return ret;
        }
        if(userService.edit(user) <= 0){
            ret.put("type", "error");
            ret.put("msg", "添加失败，请联系管理员!");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "修改成功!");
        return ret;
    }

    /**
     * 分页查询用户信息
     * @param name
     * @param page
     * @return
     */
    @RequestMapping(value="/list",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> findList(
            @RequestParam(name="name",defaultValue="") String name,
            @RequestParam(name="realName",defaultValue="") String realName,
            @RequestParam(name="idCard",defaultValue="") String idCard,
            @RequestParam(name="mobile",defaultValue="") String mobile,
            @RequestParam(name="status",required=false) Integer status,
            Page page
    ){
        Map<String,Object> ret = new HashMap<String, Object>();
        Map<String,Object> queryMap = new HashMap<String, Object>();
        queryMap.put("name", name);
        queryMap.put("status", status);
       // queryMap.put("realName", realName);
     //   queryMap.put("idCard", idCard);
        queryMap.put("mobile", mobile);
        queryMap.put("offset", page.getOffset());
        queryMap.put("pageSize", page.getRows());
        ret.put("rows", userService.findList(queryMap));
        ret.put("total", userService.getTotal(queryMap));
        return ret;
    }

    /**
     * 用户信息删除操作
     * @param id
     * @return
     */
    @RequestMapping(value="/delete",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, String> delete(Long id){
        Map<String, String> ret = new HashMap<String, String>();
        if(id == null){
            ret.put("type", "error");
            ret.put("msg", "请选择要删除的信息!");
            return ret;
        }
        try {
            if(userService.delete(id) <= 0){
                ret.put("type", "error");
                ret.put("msg", "删除失败，请联系管理员!");
                return ret;
            }
        } catch (Exception e) {
            // TODO: handle exception
            ret.put("type", "error");
            ret.put("msg", "该用户下存在订单信息，请先删除该用户下的所有订单信息!");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "删除成功!");
        return ret;
    }

    /**
     * 判断用户名是否存在
     * @param name
     * @param id
     * @return
     */
    private boolean isExist(String name,Long id){
        User findByName = userService.findByName(name);
        if(findByName == null)return false;
        if(findByName.getId().longValue() == id.longValue())return false;
        return true;
    }
}
