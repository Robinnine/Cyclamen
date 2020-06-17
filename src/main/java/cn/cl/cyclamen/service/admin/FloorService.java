package cn.cl.cyclamen.service.admin;

import cn.cl.cyclamen.entity.admin.Floor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:FloorService
 * package:cn.cll.cyclamen.service.admin
 * Description:
 *
 * @date:2020/4/14 22:46
 * @author:cll@163.com
 */
@Service
public interface FloorService {
    public int add(Floor floor);
    public int edit(Floor floor);
    public int delete(Long id);
    public List<Floor> findList(Map<String, Object> queryMap);
    public List<Floor> findAll();
    public Integer getTotal(Map<String, Object> queryMap);
}
