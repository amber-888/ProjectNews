package com.example.webtest.openweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


// 网页相关操作
@Controller
public class openstartweb {
    // 加载开始页面
    @RequestMapping("/start")
    public String  getWeb() {
        return "allweb/startweb/indext";
    }

    // 加载信息页面
    @RequestMapping(value = "/infor")
    public String  getInfor(Model model) {
        rules regulation = new rules();
        regulation.setName("随机");
        regulation.setStudentNum("随机");
        regulation.setSex("随机");
        regulation.setNumber(100);
        model.addAttribute("regulation",regulation);
        return "allweb/information/information";
    }

    // 加载结果页面
    @RequestMapping("/result")
    public String  getResult() {
        return "allweb/result/result";
    }
}

//    // 获取表单信息,并保存到数据库
//    @RequestMapping(value = "/list",method = RequestMethod.POST)
//    @ResponseBody
//    public String getInformation(@ModelAttribute(value = "regulation") rules regulation){
//        String n = regulation.getName();
//        String num = regulation.getStudentNum();
//        String se = regulation.getSex();
//        String times = regulation.getTimeslice();
//        String webn = regulation.getWebName();
//        int numb = regulation.getNumber();
//        System.out.print(n+num+times+webn+numb+se);
//        return n+num+times+webn+numb+se;
//    }

// 加载历史记录页面
//    @RequestMapping("/history")
//    public String  getHistory() {
//        return "allweb/history/history";
//    }
