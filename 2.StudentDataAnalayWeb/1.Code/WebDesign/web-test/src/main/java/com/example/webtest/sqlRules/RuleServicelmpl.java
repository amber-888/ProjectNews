package com.example.webtest.sqlRules;

import com.example.webtest.openweb.rules;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

//定义规则的保存、查找、删除、获取方法
@Service
public class RuleServicelmpl{
        @Autowired
        private RulesReposity rulesRepository;

        public List<rules> getRulesList() {
            return rulesRepository.findAll();
        }

        public rules findRulesById(int id) {
            return rulesRepository.findById(id);
        }

        public void save(rules rule) {
            rulesRepository.save(rule);
        }

        public void delete(int id) {
            rulesRepository.delete(findRulesById(id));
        }
}
