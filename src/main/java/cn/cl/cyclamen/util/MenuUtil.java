package cn.cl.cyclamen.util;

import cn.cl.cyclamen.entity.admin.Menu;

import java.util.ArrayList;
import java.util.List;

/** 菜单操作的公用方法
 * ClassName:MenuUtil
 * package:cn.cll.cyclamen.util
 * Description:
 *
 * @date:2020/4/14 21:12
 * @author:cll@163.com
 */
public class MenuUtil {
    /**
     * 从给定的菜单中返回所有顶级菜单
     * @param menuList
     * @return
     */
    public static List<Menu> getAllTopMenu(List<Menu> menuList){
        List<Menu> ret = new ArrayList<Menu>();
        for(Menu menu:menuList){
            if(menu.getParentId() == 0){
                ret.add(menu);
            }
        }
        return ret;
    }

    /**
     * 获取所有的二级菜单
     * @param menuList
     * @return
     */
    public static List<Menu> getAllSecondMenu(List<Menu> menuList){
        List<Menu> ret = new ArrayList<Menu>();
        List<Menu> allTopMenu = getAllTopMenu(menuList);
        for(Menu menu:menuList){
            for(Menu topMenu:allTopMenu){
                if(menu.getParentId() == topMenu.getId()){
                    ret.add(menu);
                    break;
                }
            }
        }
        return ret;
    }

    /**
     * 获取某个二级菜单下的按钮
     * @param menuList
     * @param
     * @return
     */
    public static List<Menu> getAllThirdMenu(List<Menu> menuList,Long secondMenuId){
        List<Menu> ret = new ArrayList<Menu>();
        for(Menu menu:menuList){
            if(menu.getParentId() == secondMenuId){
                ret.add(menu);
            }
        }
        return ret;
    }
}
