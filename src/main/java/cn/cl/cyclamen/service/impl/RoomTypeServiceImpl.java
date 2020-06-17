package cn.cl.cyclamen.service.impl;

import cn.cl.cyclamen.dao.RoomTypeDao;
import cn.cl.cyclamen.entity.RoomType;
import cn.cl.cyclamen.service.RoomTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:AuthorityServiceImpl
 * package:cn.cll.cyclamen.service.impl
 * Description:
 *
 * @date:2020/4/14 22:40
 * @author:cll@163.com
 */

@Service
public class RoomTypeServiceImpl implements RoomTypeService {

    @Autowired
    private RoomTypeDao roomTypeDao;

    @Override
    public int add(RoomType roomType) {
        // TODO Auto-generated method stub
        return roomTypeDao.add(roomType);
    }

    @Override
    public int edit(RoomType roomType) {
        // TODO Auto-generated method stub
        return roomTypeDao.edit(roomType);
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        return roomTypeDao.delete(id);
    }

    @Override
    public List<RoomType> findList(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return roomTypeDao.findList(queryMap);
    }

    @Override
    public List<RoomType> findAll() {
        // TODO Auto-generated method stub
        return roomTypeDao.findAll();
    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return roomTypeDao.getTotal(queryMap);
    }

    @Override
    public RoomType find(Long id) {
        // TODO Auto-generated method stub
        return roomTypeDao.find(id);
    }

    @Override
    public int updateNum(RoomType roomType) {
        // TODO Auto-generated method stub
        return roomTypeDao.updateNum(roomType);
    }

}
