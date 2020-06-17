package cn.cl.cyclamen.entity.admin;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName:Log
 * package:cn.cll.cyclamen.entity.admin
 * Description:
 *
 * @date:2020/4/14 22:04
 * @author:cll@163.com
 */
@Component
public class Log {
    private Long id;
    private String content;//日志内容
    private Date createTime;//创建时间

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
