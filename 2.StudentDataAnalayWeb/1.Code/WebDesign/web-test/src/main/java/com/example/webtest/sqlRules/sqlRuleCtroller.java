package com.example.webtest.sqlRules;

import com.example.webtest.openweb.rules;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import java.util.List;

//在网页中规则的获取、保存、删除和显示
@Controller
public class sqlRuleCtroller {
    @Resource
    RuleServicelmpl ruleService;

        @RequestMapping("/")
        public String index() {
            return "redirect:/list";
        }

        @RequestMapping("/list")
        public String list(Model model) {
            List<rules> rule=ruleService.getRulesList();
            model.addAttribute("rule", rule);
            return "allweb/history/history";
        }

        @RequestMapping("/add")
        public String add(rules rule) {
            ruleService.save(rule);
            return "redirect:/list";
        }

        @RequestMapping("/delete")
        public String delete(int id) {
            ruleService.delete(id);
            return "redirect:/list";
        }
}
