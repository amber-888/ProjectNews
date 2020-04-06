package com.example.webtest.resultSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class echarsContorller {
    @RequestMapping(value = "/EcharsShow")
    @ResponseBody
    public List<resultEchar> findById(Model model) {
        List<resultEchar> list = new ArrayList<resultEchar>();
        list.add(new resultEchar("帽子","50"));
        list.add(new resultEchar("鞋子","60"));
        list.add(new resultEchar("毛衣","90"));
        list.add(new resultEchar("羽绒服","234"));
        list.add(new resultEchar("羊毛衫","56"));
        System.err.println(list.toString());
        return list;
    }

    @GetMapping(value = "/Echars.do")
    public String echarts4(Model model){
        System.err.println("========开始");
        return "allweb/result/result";
    }
}
