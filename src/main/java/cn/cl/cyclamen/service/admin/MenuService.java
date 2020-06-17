package cn.cl.cyclamen.service.admin;

import cn.cl.cyclamen.entity.admin.Menu;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:MenuService
 * package:cn.cll.cyclamen.service.admin
 * Description:
 *
 * @date:2020/4/14 22:43
 * @author:cll@163.com
 */
@Service
public interface MenuService {
    public int add(Menu menu);
    public List<Menu> findList(Map<String, Object> queryMap);
    public List<Menu> findTopList();
    public int getTotal(Map<String, Object> queryMap);
    public int edit(Menu menu);
    public int delete(Long id);
    public List<Menu> findChildernList(Long parentId);
    public List<Menu> findListByIds(String ids);
}
