package cn.cl.cyclamen.service.admin.impl;

import cn.cl.cyclamen.dao.admin.RoomDao;
import cn.cl.cyclamen.entity.admin.Room;
import cn.cl.cyclamen.service.admin.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:RoomServiceImpl
 * package:cn.cll.cyclamen.service.admin.impl
 * Description:
 *
 * @date:2020/4/15 16:09
 * @author:cll@163.com
 */
@Service
public class RoomServiceImpl implements RoomService {

    @Autowired
    private RoomDao roomDao;

    @Override
    public int add(Room room) {
        // TODO Auto-generated method stub
        return roomDao.add(room);
    }

    @Override
    public int edit(Room room) {
        // TODO Auto-generated method stub
        return roomDao.edit(room);
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        return roomDao.delete(id);
    }

    @Override
    public List<Room> findList(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return roomDao.findList(queryMap);
    }

    @Override
    public List<Room> findAll() {
        // TODO Auto-generated method stub
        return roomDao.findAll();
    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return roomDao.getTotal(queryMap);
    }

    @Override
    public Room find(Long id) {
        // TODO Auto-generated method stub
        return roomDao.find(id);
    }

    @Override
    public Room findBySn(String sn) {
        // TODO Auto-generated method stub
        return roomDao.findBySn(sn);
    }

}
