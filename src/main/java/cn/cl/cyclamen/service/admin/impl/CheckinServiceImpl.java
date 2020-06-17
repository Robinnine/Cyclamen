package cn.cl.cyclamen.service.admin.impl;

import cn.cl.cyclamen.dao.admin.CheckinDao;
import cn.cl.cyclamen.entity.admin.Checkin;
import cn.cl.cyclamen.service.admin.CheckinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:CheckinServiceImpl
 * package:cn.cll.cyclamen.service.admin.impl
 * Description:
 *
 * @date:2020/4/15 16:10
 * @author:cll@163.com
 */
@Service
public class CheckinServiceImpl implements CheckinService {

    @Autowired
    private CheckinDao checkinDao;

    @Override
    public int add(Checkin checkin) {
        // TODO Auto-generated method stub
        return checkinDao.add(checkin);
    }

    @Override
    public int edit(Checkin checkin) {
        // TODO Auto-generated method stub
        return checkinDao.edit(checkin);
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        return checkinDao.delete(id);
    }

    @Override
    public List<Checkin> findList(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return checkinDao.findList(queryMap);
    }

    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return checkinDao.getTotal(queryMap);
    }

    @Override
    public Checkin find(Long id) {
        // TODO Auto-generated method stub
        return checkinDao.find(id);
    }

    @Override
    public List<Map> getStatsByMonth() {
        // TODO Auto-generated method stub
        return checkinDao.getStatsByMonth();
    }

    @Override
    public List<Map> getStatsByDay() {
        // TODO Auto-generated method stub
        return checkinDao.getStatsByDay();
    }







}
