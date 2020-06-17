package cn.cl.cyclamen.controller.home;

import cn.cl.cyclamen.entity.BookOrder;
import cn.cl.cyclamen.entity.RoomType;
import cn.cl.cyclamen.entity.User;
import cn.cl.cyclamen.service.BookOrderService;
import cn.cl.cyclamen.service.RoomTypeService;
import cn.cl.cyclamen.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/** 前台用户控制器
 * ClassName:HomeUserController
 * package:cn.cll.cyclamen.controller.home
 * Description:
 *
 * @date:2020/4/14 20:46
 * @author:cll@163.com
 */
@RequestMapping("/home/user")
@Controller
public class HomeUserController {

    @Autowired
    private RoomTypeService roomTypeService;
    @Autowired
    private UserService userService;
    @Autowired
    private BookOrderService bookOrderService;

    /**
     * 前台用户中心首页
     *
     * @param
     * @param
     * @return
     */
    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ModelAndView list(ModelAndView model, HttpServletRequest request
    ) {
        User user = (User) request.getSession().getAttribute("user");
        Map<String, Object> queryMap = new HashMap<String, Object>();
        queryMap.put("userId", user.getId());
        queryMap.put("offset", 0);
        queryMap.put("pageSize", 999);
        model.addObject("bookOrderList", bookOrderService.orderList(queryMap));
        model.addObject("roomTypeList", roomTypeService.findAll());
        model.setViewName("home/user/index");
        return model;
    }

    /**
     * 预定房间页面
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/book_order", method = RequestMethod.GET)
    public ModelAndView bookOrder(ModelAndView model, Long roomTypeId
    ) {
        model.addObject("roomType", roomTypeService.find(roomTypeId));
        model.setViewName("home/user/book_order");
        return model;
    }


    /**
     * 预定信息提交
     *
     * @param
     * @return
     */
    @RequestMapping(value = "/book_order", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> bookOrderAct(BookOrder bookOrder, HttpServletRequest request) {
        Map<String, String> ret = new HashMap<String, String>();
        if (bookOrder == null) {
            ret.put("type", "error");
            ret.put("msg", "请填写正确的预定订单信息!");
            return ret;
        }
        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            ret.put("type", "error");
            ret.put("msg", "用户不能为空!");
            return ret;
        }
        bookOrder.setUserId(user.getId());
        if (bookOrder.getRoomTypeId() == null) {
            ret.put("type", "error");
            ret.put("msg", "房型不能为空!");
            return ret;
        }
        if (StringUtils.isEmpty(bookOrder.getRealName())) {
            ret.put("type", "error");
            ret.put("msg", "预定订单联系人姓名不能为空!");
            return ret;
        }

        if (StringUtils.isEmpty(bookOrder.getMobile())) {
            ret.put("type", "error");
            ret.put("msg", "预定订单联系人手机号不能为空!");
            return ret;
        }
        if (StringUtils.isEmpty(bookOrder.getIdCard())) {
            ret.put("type", "error");
            ret.put("msg", "联系人身份证号不能为空!");
            return ret;
        }
        if (StringUtils.isEmpty(bookOrder.getArriveDate())) {
            ret.put("type", "error");
            ret.put("msg", "到达时间不能为空!");
            return ret;
        }
        if (StringUtils.isEmpty(bookOrder.getLeaveDate())) {
            ret.put("type", "error");
            ret.put("msg", "离店时间不能为空!");
            return ret;
        }
        bookOrder.setCreateTime(new Date());
        bookOrder.setStatus(0);
        if (bookOrderService.add(bookOrder) <= 0) {
            ret.put("type", "error");
            ret.put("msg", "添加失败，请联系管理员!");
            return ret;
        }
        RoomType roomType = roomTypeService.find(bookOrder.getRoomTypeId());
        //预定成功后去修改该房型的预定数
        if (roomType != null) {
            roomType.setBookNum(roomType.getBookNum() + 1);
            roomType.setAvilableNum(roomType.getAvilableNum() - 1);
            roomTypeService.updateNum(roomType);
            //如果可用的房间数为0，则设置该房型状态已满
            if (roomType.getAvilableNum() == 0) {
                roomType.setStatus(0);
                roomTypeService.edit(roomType);
            }
        }
        ret.put("type", "success");
        ret.put("msg", "预定成功!");
        return ret;
    }

    /**
     * 取消订单的提交
     */
    @RequestMapping(value = "/cancel-info",method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> cancel(BookOrder bookOrder, HttpServletRequest request) {
        Map<String, String> ret = new HashMap<String, String>();
        User user = (User) request.getSession().getAttribute("user");
        bookOrder.setUserId(user.getId());
        System.out.println(bookOrder.getUserId());
        System.out.println(bookOrder.getId());
        if(bookOrder.getUserId() == null){
            ret.put("type", "error");
            ret.put("msg", "订单取消失败!");
            return ret;
        }
        BookOrder existBookOrder = bookOrderService.find(bookOrder.getId());
        if(existBookOrder == null){
            ret.put("type", "error");
            ret.put("msg", "请选择正确的数据进行编辑!");
            return ret;
        }
        if(bookOrderService.cancel(bookOrder) <= 0){
            ret.put("type", "error");
            ret.put("msg", "取消失败，请联系民宿管理人员!");
            return ret;
        }
        //判断订单状态是否发生了变化
        if(bookOrder.getStatus()== 3) {
            //订单状态发生了变化
            //首先恢复原来房型的预定数及可用数
            RoomType oldRoomType = roomTypeService.find(existBookOrder.getRoomTypeId());
            oldRoomType.setAvilableNum(oldRoomType.getAvilableNum() + 1);
            oldRoomType.setBookNum(oldRoomType.getBookNum() - 1);
            roomTypeService.updateNum(oldRoomType);
            if (oldRoomType.getStatus() == 0) {
                //旧的房间原来是满房，现在不满房的话，恢复状态
                if (oldRoomType.getAvilableNum() > 0) {
                    //设置成状态可用
                    oldRoomType.setStatus(1);
                    roomTypeService.edit(oldRoomType);
                }
            }
        }

            ret.put("type", "success");
            ret.put("msg", "修改成功!");
            return ret;

        }





    /**
     * 修改个人信息提交
     * @param user
     * @return
     */
    @RequestMapping(value="/update_info",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,String> updateInfoAct(User user, HttpServletRequest request){
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
        User loginedUser = (User)request.getSession().getAttribute("user");
        if(isExist(user.getName(),loginedUser.getId())){
            retMap.put("type", "error");
            retMap.put("msg", "该用户名已经存在！");
            return retMap;
        }
        loginedUser.setIdCard(user.getIdCard());
        loginedUser.setMobile(user.getMobile());
        loginedUser.setName(user.getName());
        loginedUser.setRealName(user.getRealName());
        if(userService.edit(loginedUser) <= 0){
            retMap.put("type", "error");
            retMap.put("msg", "修改失败，请联系管理员！");
            return retMap;
        }
        request.getSession().setAttribute("user", loginedUser);
        retMap.put("type", "success");
        retMap.put("msg", "修改成功！");
        return retMap;
    }

    /**
     * 修改密码提交
     * @param
     * @return
     */
    @RequestMapping(value="/update_pwd",method= RequestMethod.POST)
    @ResponseBody
    public Map<String,String> updatePwdAct(String oldPassword, String newPassword, HttpServletRequest request){
        Map<String,String> retMap = new HashMap<String, String>();
        if(StringUtils.isEmpty(oldPassword)){
            retMap.put("type", "error");
            retMap.put("msg", "请填写原来的密码！");
            return retMap;
        }
        if(StringUtils.isEmpty(newPassword)){
            retMap.put("type", "error");
            retMap.put("msg", "请填写新密码！");
            return retMap;
        }
        User loginedUser = (User)request.getSession().getAttribute("user");
        if(!oldPassword.equals(loginedUser.getPassword())){
            retMap.put("type", "error");
            retMap.put("msg", "原密码错误！");
            return retMap;
        }
        loginedUser.setPassword(newPassword);
        if(userService.edit(loginedUser) <= 0){
            retMap.put("type", "error");
            retMap.put("msg", "修改失败，请联系管理员！");
            return retMap;
        }
        retMap.put("type", "success");
        retMap.put("msg", "修改密码成功！");
        return retMap;
    }



    /**
     * 判断用户是否存在
     * @param name
     * @param id
     * @return
     */
    private boolean isExist(String name,Long id){
        User user = userService.findByName(name);
        if(user == null) {
            return false;
        }
        if(user != null && user.getId().longValue() == id) {
            return false;
        }
        return true;
    }
}
