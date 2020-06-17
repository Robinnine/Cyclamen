package cn.cl.cyclamen.service.admin.impl;

import cn.cl.cyclamen.dao.admin.FloorDao;
import cn.cl.cyclamen.entity.admin.Floor;
import cn.cl.cyclamen.service.admin.FloorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:FloorServiceImpl
 * package:cn.cll.cyclamen.service.admin.impl
 * Description:
 *
 * @date:2020/4/15 16:10
 * @author:cll@163.com
 */
@Service
public class FloorServiceImpl implements FloorService {

    @Autowired
    private FloorDao floorDao;

    @Override
    public int add(Floor floor) {
        // TODO Auto-generated method stub
        return floorDao.add(floor);
    }

    @Override
    public int edit(Floor floor) {
        // TODO Auto-generated method stub
        return floorDao.edit(floor);
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        return floorDao.delete(id);
    }

    @Override
    public List<Floor> findList(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return floorDao.findList(queryMap);
    }

    @Override
    public List<Floor> findAll() {
        // TODO Auto-generated method stub
        return floorDao.findAll();
    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return floorDao.getTotal(queryMap);
    }

}
