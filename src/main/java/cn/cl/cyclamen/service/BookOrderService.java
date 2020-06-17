package cn.cl.cyclamen.service;

import cn.cl.cyclamen.entity.BookOrder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/** 预订订单
 * ClassName:BookOrderService
 * package:cn.cll.cyclamen.service
 * Description:
 *
 * @date:2020/4/14 22:38
 * @author:cll@163.com
 */
@Service
public interface BookOrderService {
    public int add(BookOrder bookOrder);
    public int cancel(BookOrder bookOrder);
    public int edit(BookOrder bookOrder);
    public int delete(Long id);
    public List<BookOrder> findList(Map<String, Object> queryMap);
    public List<BookOrder> orderList(Map<String, Object> queryMap);
    public Integer getTotal(Map<String, Object> queryMap);
    public BookOrder find(Long id);



}
