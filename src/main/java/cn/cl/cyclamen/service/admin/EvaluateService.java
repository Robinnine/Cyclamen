package cn.cl.cyclamen.service.admin;

import cn.cl.cyclamen.entity.admin.Evaluate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:EvaluateService
 * package:cn.cll.cyclamen.service.admin
 * Description:
 *
 * @date:2020/4/14 22:48
 * @author:cll@163.com
 */
@Service
public interface EvaluateService {
    public int delete(Long id);
    public List<Evaluate> findList(Map<String, Object> queryMap);
    public List<Evaluate> findAll();
    public Integer getTotal(Map<String, Object> queryMap);
}
