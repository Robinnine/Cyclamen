package cn.cl.cyclamen.entity.admin;

import org.springframework.stereotype.Component;

/**
 * ClassName:Floor
 * package:cn.cll.cyclamen.entity.admin
 * Description:
 *
 * @date:2020/4/14 22:05
 * @author:cll@163.com
 */
@Component
public class Floor {
    private Long id;//楼层id
    private String name;//楼层名称
    private String remark;//楼层备注

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
