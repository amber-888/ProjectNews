package com.example.webtest.openweb;

import javax.persistence.*;

@Entity
@Table(name = "regulation")
public class rules {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @Column(name = "name")
    private String name;     // 姓名
    @Column(name = "student_num")
    private String studentNum;     // 学号
    @Column(name = "sex")
    private String sex;         // 性别
    @Column(name = "timeslice")
    private String timeslice;    // 时间
    @Column(name = "web_name")
    private String webName;     // 网站
    @Column(name = "number")
    private Integer number;   // 条数

    // 使用默认构造方法

    public Integer getId() {
        return id;
    }

    // get和set姓名
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // get和set学号
    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    // get和set性别
    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

     //get和set时间
    public String getTimeslice() {
        return timeslice;
    }

    public void setTimeslice(String timeslice) {
        this.timeslice = timeslice;
    }

    // get和set网页信息
    public String getWebName() {
        return webName;
    }

    public void setWebName(String webName) {
        this.webName = webName;
    }
    // get和set条数信息
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }
}
