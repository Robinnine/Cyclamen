package cn.cl.cyclamen.dao;

import cn.cl.cyclamen.entity.BookOrder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * ClassName:BookOrderDao
 * package:cn.cll.cyclamen.dao
 * Description:
 *
 * @date:2020/4/14 23:36
 * @author:cll@163.com
 */
@Repository
public interface BookOrderDao {
    public int add(BookOrder bookOrder);
    public int cancel(BookOrder bookOrder);
    public int edit(BookOrder bookOrder);
    public int delete(Long id);
    public List<BookOrder> findList(Map<String, Object> queryMap);
    public List<BookOrder> orderList(Map<String, Object> queryMap);
    public Integer getTotal(Map<String, Object> queryMap);
    public BookOrder find(Long id);
}
