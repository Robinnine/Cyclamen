package cn.cl.cyclamen.service.impl;

import cn.cl.cyclamen.dao.BookOrderDao;
import cn.cl.cyclamen.entity.BookOrder;
import cn.cl.cyclamen.service.BookOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * ClassName:BookOrderServiceImpl
 * package:cn.cll.cyclamen.service.impl
 * Description:
 *
 * @date:2020/4/14 22:40
 * @author:cll@163.com
 */
@Service
public class BookOrderServiceImpl implements BookOrderService {

    @Autowired
    private BookOrderDao bookOrderDao;

    @Override
    public int add(BookOrder bookOrder) {
        // TODO Auto-generated method stub
        return bookOrderDao.add(bookOrder);
    }

    @Override
    public int cancel(BookOrder bookOrder){
        return bookOrderDao.cancel(bookOrder);
    }

    @Override
    public int edit(BookOrder bookOrder) {
        // TODO Auto-generated method stub
        return bookOrderDao.edit(bookOrder);
    }

    @Override
    public int delete(Long id) {
        // TODO Auto-generated method stub
        return bookOrderDao.delete(id);
    }

    @Override
    public List<BookOrder> findList(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return bookOrderDao.findList(queryMap);
    }
    @Override
    public List<BookOrder> orderList(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return bookOrderDao.orderList(queryMap);
    }


    @Override
    public Integer getTotal(Map<String, Object> queryMap) {
        // TODO Auto-generated method stub
        return bookOrderDao.getTotal(queryMap);
    }

    @Override
    public BookOrder find(Long id) {
        // TODO Auto-generated method stub
        return bookOrderDao.find(id);
    }





}

