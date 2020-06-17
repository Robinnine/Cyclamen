package cn.cl.cyclamen.entity;

import org.springframework.stereotype.Component;

import java.util.Date;

/** 预订房间生成订单实体类
 * ClassName:BookOrder
 * package:cn.cll.cyclamen.entity
 * Description:
 *
 * @date:2020/4/14 21:57
 * @author:cll@163.com
 */
@Component
public class BookOrder {
    private Long id;//预定订单id
    private Long userId;//客户id
    private Long roomTypeId;//房型id
    private String realName;//预定者姓名
    private String idCard;//身份证号码
    private String mobile;//手机号
    private int status;//状态：0：预定中，1：已入住,2:已结算离店 3：预定订单取消
    private int payWay;//支付方式 0 ；支付宝，1；微信，2；现金
    private int orderWay;// 预订方式 0；网上预订，1；在店预订
    private String arriveDate;//入住日期
    private String leaveDate;//离店日期
    private Date createTime;//预定日期
    private String remark;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }



    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomId) {
        this.roomTypeId = roomId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getArriveDate() {
        return arriveDate;
    }

    public void setArriveDate(String arriveDate) {
        this.arriveDate = arriveDate;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getPayWay() {
        return payWay;
    }

    public void setPayWay(int payWay) {
        this.payWay = payWay;
    }

    public int getOrderWay() {
        return orderWay;
    }

    public void setOrderWay(int orderWay) {
        this.orderWay = orderWay;
    }
}
