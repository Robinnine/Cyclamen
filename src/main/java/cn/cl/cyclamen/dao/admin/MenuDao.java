package cn.cl.cyclamen.dao.admin;

import cn.cl.cyclamen.entity.admin.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ClassName:MenuDao
 * package:cn.cll.cyclamen.dao.admin
 * Description:
 *
 * @date:2020/4/14 23:39
 * @author:cll@163.com
 */
@Repository
public interface MenuDao {
    public int add(Menu menu);
    public List<Menu> findList(Map<String, Object> queryMap);
    public List<Menu> findTopList();
    public int getTotal(Map<String, Object> queryMap);
    public int edit(Menu menu);
    public int delete(Long id);
    public List<Menu> findChildernList(Long parentId);
    public List<Menu> findListByIds(String ids);
    
}
