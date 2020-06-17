package cn.cl.cyclamen.service.admin.impl;

import cn.cl.cyclamen.dao.admin.LogDao;
import cn.cl.cyclamen.entity.admin.Log;
import cn.cl.cyclamen.service.admin.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ClassName:LogServicesImpl
 * package:cn.cll.cyclamen.service.admin.impl
 * Description:
 *
 * @date:2020/4/19 18:59
 * @author:cll@163.com
 */
@Service
public class LogServicesImpl implements LogService {
    @Autowired
    private LogDao logDao;

    @Override
    public int add(Log log) {
        // TODO Auto-generated method stub
        return logDao.add(log);
    }

    @Override
    public List<Log> findList(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return logDao.findList(queryMap);
    }

    @Override
    public int getTotal(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return logDao.getTotal(queryMap);
    }

    @Override
    public int delete(String ids) {
        // TODO Auto-generated method stub
        return logDao.delete(ids);
    }

    @Override
    public int add(String content) {
        // TODO Auto-generated method stub
        Log log = new Log();
        log.setContent(content);
        log.setCreateTime(new Date());
        return logDao.add(log);
    }



}
