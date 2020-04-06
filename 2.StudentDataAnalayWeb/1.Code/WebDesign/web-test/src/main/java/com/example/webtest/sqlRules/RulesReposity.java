package com.example.webtest.sqlRules;

import com.example.webtest.openweb.rules;
import org.springframework.data.jpa.repository.JpaRepository;

// 继承数据库操作接口以及方法的重载
public interface RulesReposity extends JpaRepository<rules, Integer> {

    rules findById(int id);
    void deleteById(Integer id);
}
