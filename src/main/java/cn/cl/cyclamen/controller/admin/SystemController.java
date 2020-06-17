package cn.cl.cyclamen.controller.admin;

import cn.cl.cyclamen.entity.admin.Authority;
import cn.cl.cyclamen.entity.admin.Menu;
import cn.cl.cyclamen.entity.admin.Role;
import cn.cl.cyclamen.entity.admin.Staff;
import cn.cl.cyclamen.service.admin.*;
import cn.cl.cyclamen.util.CpachaUtil;
import cn.cl.cyclamen.util.MenuUtil;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 系统操作类控制器
 * ClassName:SystemController
 * package:cn.cll.cyclamen.controller.admin
 * Description:
 *
 * @date:2020/4/14 23:55
 * @author:cll@163.com
 */
@Controller
@RequestMapping("/system")
public class SystemController {

    @Autowired
    private StaffService staffService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private AuthorityService authorityService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private LogService logService;

    /**
     * 系统登录后的主页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView index(ModelAndView model, HttpServletRequest request) {
        List<Menu> userMenus = (List<Menu>) request.getSession().getAttribute("userMenus");
        model.addObject("topMenuList", MenuUtil.getAllTopMenu(userMenus));
        model.addObject("secondMenuList", MenuUtil.getAllSecondMenu(userMenus));
        model.setViewName("system/index");
        return model;//WEB-INF/views/+system/index+.jsp = WEB-INF/views/system/index.jsp
    }

    /**
     * 系统登录后的欢迎页
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public ModelAndView welcome(ModelAndView model) {
        model.setViewName("system/welcome");
        return model;
    }

    /**
     * 登陆页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public ModelAndView login(ModelAndView model) {
        model.setViewName("system/login");
        return model;
    }
    /**
     * 登录表单提交处理控制器
     * @param staff
     * @param cpacha
     * @return
     */
    @RequestMapping(value="/login",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, String> loginAct(Staff staff, String cpacha, HttpServletRequest request){
        Map<String, String> ret = new HashMap<String, String>();
        if(staff == null){
            ret.put("type", "error");
            ret.put("msg", "请填写用户信息！");
            return ret;
        }
        if(StringUtils.isEmpty(cpacha)){
            ret.put("type", "error");
            ret.put("msg", "请填写验证码！");
            return ret;
        }
        if(StringUtils.isEmpty(staff.getUsername())){
            ret.put("type", "error");
            ret.put("msg", "请填写用户名！");
            return ret;
        }
        if(StringUtils.isEmpty(staff.getPassword())){
            ret.put("type", "error");
            ret.put("msg", "请填写密码！");
            return ret;
        }
        Object loginCpacha = request.getSession().getAttribute("loginCpacha");
        if(loginCpacha == null){
            ret.put("type", "error");
            ret.put("msg", "会话超时，请刷新页面！");
            return ret;
        }
        if(!cpacha.toUpperCase().equals(loginCpacha.toString().toUpperCase())){
            ret.put("type", "error");
            ret.put("msg", "验证码错误！");
            logService.add("用户名为"+staff.getUsername()+"的用户登录时输入验证码错误!");
            return ret;
        }
        Staff findByStaffname = staffService.findByStaffname(staff.getUsername());
        if(findByStaffname == null){
            ret.put("type", "error");
            ret.put("msg", "该用户名不存在！");
            logService.add("登录时，用户名为"+staff.getUsername()+"的用户不存在!");
            return ret;
        }
        if(!staff.getPassword().equals(findByStaffname.getPassword())){
            ret.put("type", "error");
            ret.put("msg", "密码错误！");
            logService.add("用户名为"+staff.getUsername()+"的用户登录时输入密码错误!");
            return ret;
        }
        //说明用户名密码及验证码都正确
        //此时需要查询用户的角色权限
        Role role = roleService.find(findByStaffname.getRoleId());
        List<Authority> authorityList = authorityService.findListByRoleId(role.getId());//根据角色获取权限列表
        String menuIds = "";
        for(Authority authority:authorityList){
            menuIds += authority.getMenuId() + ",";
        }
        if(!StringUtils.isEmpty(menuIds)){
            menuIds = menuIds.substring(0,menuIds.length()-1);
        }
        List<Menu> userMenus = menuService.findListByIds(menuIds);
        //把角色信息、菜单信息放到session中
        request.getSession().setAttribute("admin", findByStaffname);
        request.getSession().setAttribute("role", role);
        request.getSession().setAttribute("userMenus", userMenus);
        ret.put("type", "success");
        ret.put("msg", "登录成功！");
        logService.add("用户名为{"+staff.getUsername()+"}，角色为{"+role.getName()+"}的用户登录成功!");
        return ret;
    }

    /**
     * 后台退出注销功能
     * @param request
     * @return
     */
    @RequestMapping(value="/logout",method= RequestMethod.GET)
    public String logout(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.setAttribute("admin", null);
        session.setAttribute("role", null);
        request.getSession().setAttribute("userMenus", null);
        return "redirect:login";
    }
    /**
     * 备份数据库
     * @param request
     */
    @RequestMapping(value="/dbBackUp",method= RequestMethod.GET)
    public void dbBackUp(String root,String pwd,String dbName,String backPath,String backName) throws IOException {
        String pathSql = backPath+backName;
        File fileSql = new File(pathSql);
        //创建备份sql文件
        if (!fileSql.exists()){
            fileSql.createNewFile();
        }
        //mysqldump -hlocalhost -uroot -p123456 db > /home/back.sql
        StringBuffer sb = new StringBuffer();
        sb.append("D:\\MySQL\\mysql-8.0.17-winx64\\bin\\mysqldump");
        sb.append(" -h127.0.0.1");
        sb.append(" -u"+root);
        sb.append(" -p"+pwd);
        sb.append(" "+dbName+" >");
        sb.append(pathSql);
        System.out.println("cmd命令为："+sb.toString());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("开始备份："+dbName);
        Process process = runtime.exec("cmd /c"+sb.toString());
        System.out.println("备份成功!");

    }






    /**
     * 修改密码页面
     * @param model
     * @return
     */
    @RequestMapping(value="/edit_password",method= RequestMethod.GET)
    public ModelAndView editPassword(ModelAndView model){
        model.setViewName("system/edit_password");
        return model;
    }

    @RequestMapping(value="/edit_password",method= RequestMethod.POST)
    @ResponseBody
    public Map<String, String> editPasswordAct(String newpassword, String oldpassword, HttpServletRequest request){
        Map<String, String> ret = new HashMap<String, String>();
        if(StringUtils.isEmpty(newpassword)){
            ret.put("type", "error");
            ret.put("msg", "请填写新密码！");
            return ret;
        }
        Staff staff = (Staff)request.getSession().getAttribute("admin");
        if(!staff.getPassword().equals(oldpassword)){
            ret.put("type", "error");
            ret.put("msg", "原密码错误！");
            return ret;
        }
        staff.setPassword(newpassword);
        if(staffService.editPassword(staff) <= 0){
            ret.put("type", "error");
            ret.put("msg", "密码修改失败，请联系管理员！");
            return ret;
        }
        ret.put("type", "success");
        ret.put("msg", "密码修改成功！");
        logService.add("用户名为{"+staff.getUsername()+"}，的用户成功修改密码!");
        return ret;
    }

    /**
     * 本系统所有的验证码均采用此方法
     * @param vcodeLen
     * @param width
     * @param height
     * @param cpachaType:用来区别验证码的类型，传入字符串
     * @param request
     * @param response
     */
    @RequestMapping(value="/get_cpacha",method= RequestMethod.GET)
    public void generateCpacha(
            @RequestParam(name="vl",required=false,defaultValue="4") Integer vcodeLen,
            @RequestParam(name="w",required=false,defaultValue="100") Integer width,
            @RequestParam(name="h",required=false,defaultValue="30") Integer height,
            @RequestParam(name="type",required=true,defaultValue="loginCpacha") String cpachaType,
            HttpServletRequest request,
            HttpServletResponse response){
        CpachaUtil cpachaUtil = new CpachaUtil(vcodeLen, width, height);
        String generatorVCode = cpachaUtil.generatorVCode();
        request.getSession().setAttribute(cpachaType, generatorVCode);
        BufferedImage generatorRotateVCodeImage = cpachaUtil.generatorRotateVCodeImage(generatorVCode, true);
        try {
            ImageIO.write(generatorRotateVCodeImage, "gif", response.getOutputStream());
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
