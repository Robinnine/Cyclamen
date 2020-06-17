package cn.cl.cyclamen.entity.admin;

import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * ClassName:Evaluate
 * package:cn.cll.cyclamen.entity.admin
 * Description:
 *
 * @date:2020/4/14 22:12
 * @author:cll@163.com
 */
@Component
public class Evaluate {
    private int id; // 评论ID
    private int userId;  //评论者的用户ID
    private String evaluation; // 评价内容
    private Date createTime;  // 评价时间

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
