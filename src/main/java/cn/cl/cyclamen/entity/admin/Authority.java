package cn.cl.cyclamen.entity.admin;

import org.springframework.stereotype.Component;

/**
 * ClassName:Authority
 * package:cn.cll.cyclamen.entity.admin
 * Description:
 *
 * @date:2020/4/14 22:11
 * @author:cll@163.com
 */
@Component
public class Authority {
    private Long id;
    private Long roleId;//角色id
    private Long menuId;//菜单id

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }
}
