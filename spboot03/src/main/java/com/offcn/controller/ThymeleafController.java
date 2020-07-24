package com.offcn.controller;

import com.offcn.pojo.Person;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @GetMapping("/first")
    public String indexPage(Model model) {
        model.addAttribute("message",  "Hello, Thymeleaf!");
        Person p = new Person(1,"范老师","男",18);
        model.addAttribute("person",p);

        Person p1 = new Person(1, "范老师", "男", 18);
        Person p2 = new Person(2, "张老师", "男", 19);
        Person p3 = new Person(3, "周老师", "女", 20);
        Person p4 = new Person(4, "仓老师", "女", 36);
        List<Person> pList = new ArrayList<>();
        pList.add(p1);
        pList.add(p2);
        pList.add(p3);
        pList.add(p4);
        model.addAttribute("pList", pList);

        model.addAttribute("fruit", "apple");

        return "index";
    }

}
