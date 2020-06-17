package cn.cl.cyclamen.entity.admin;

import org.springframework.stereotype.Component;

/**
 * ClassName:Room
 * package:cn.cll.cyclamen.entity.admin
 * Description:
 *
 * @date:2020/4/14 22:07
 * @author:cll@163.com
 */
@Component
public class Room {
    private Long id;//房间id
    private String photo;//房间图片
    private String sn;//房间编号
    private Long roomTypeId;//房型id
    private Long floorId;//所属楼层id
    private int status;//房型状态，0：可入住,1:已入住,2:打扫中
    private String remark;//房型备注


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }


    public Long getRoomTypeId() {
        return roomTypeId;
    }

    public void setRoomTypeId(Long roomTypeId) {
        this.roomTypeId = roomTypeId;
    }

    public Long getFloorId() {
        return floorId;
    }

    public void setFloorId(Long floorId) {
        this.floorId = floorId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
