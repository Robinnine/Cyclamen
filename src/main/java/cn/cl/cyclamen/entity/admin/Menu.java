package cn.cl.cyclamen.entity.admin;

import org.springframework.stereotype.Component;

/**
 * ClassName:MenuService
 * package:cn.cll.cyclamen.entity.admin
 * Description:
 *
 * @date:2020/4/14 22:08
 * @author:cll@163.com
 */
@Component
public class Menu {
    private Long id;
    private Long parentId;//父类id
    private Long _parentId;//父类id,用来匹配easyui的父类id
    private String name;//菜单名称
    private String description;//菜单描述
    private String icon;//菜单icon图表

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public Long get_parentId() {
        return _parentId;
    }

    public void set_parentId(Long _parentId) {
        this._parentId = _parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
