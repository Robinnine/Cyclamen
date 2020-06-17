package cn.cl.cyclamen.entity.admin;

import org.springframework.stereotype.Component;

/**
 * ClassName:Role
 * package:cn.cll.cyclamen.entity.admin
 * Description:
 *
 * @date:2020/4/14 22:06
 * @author:cll@163.com
 */
@Component
public class Role {
    private Long id; //角色ID
    private String name; //角色名称
    private String remark;//角色备注

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
