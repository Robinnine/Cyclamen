package cn.cl.cyclamen.entity.admin;

import org.springframework.stereotype.Component;

/** 员工实体类
 * ClassName:Staff
 * package:cn.cll.cyclamen.entity.admin
 * Description:
 *
 * @date:2020/4/14 21:33
 * @author:cll@163.com
 */
@Component
public class Staff {
    private Long id;//员工id，设置自增
    private String username;//员工名，登录名
    private String password;//登录密码
    private Long roleId;//所属角色id
    private String photo;//头像照片地址
    private int sex;//性别0,代表未知，1代表男，2代表女
    private Integer age;//年龄
    private String phoneNum;//联系方式

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }


}
