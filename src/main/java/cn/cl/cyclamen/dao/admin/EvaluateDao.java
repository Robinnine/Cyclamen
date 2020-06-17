package cn.cl.cyclamen.dao.admin;

import cn.cl.cyclamen.entity.admin.Evaluate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ClassName:EvaluateDao
 * package:cn.cll.cyclamen.dao.admin
 * Description:
 *
 * @date:2020/4/14 23:42
 * @author:cll@163.com
 */
@Repository
public interface EvaluateDao {
    public int delete(Long id);
    public List<Evaluate> findList(Map<String, Object> queryMap);
    public List<Evaluate> findAll();
    public Integer getTotal(Map<String, Object> queryMap);
}
