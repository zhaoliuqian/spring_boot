package com.offcn.controller;

import com.offcn.pojo.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/manageruser")
public class PersonController {

    @Autowired
    private PersonService personService;

    /***
     * 获取全部用户信息
     *
     * @return
     */
    @GetMapping("/")
    public String getPersonList(Model model) {
        List<Person> list = personService.getAll();
        model.addAttribute("page", list);
        return "person/list";
    }

    @RequestMapping("/toEdit/{id}")
    public String toEdit(Model model, @PathVariable("id") Integer id) {
        Person person = personService.get(id);
        model.addAttribute("person", person);
        return "person/personEdit";
    }

    /***
     * 跳转到新增用户界面
     *
     * @return
     */
    @RequestMapping("/toAdd")
    public String toadd() {

        return "person/personAdd";
    }

    /***
     * 新增用户
     *
     * @param person
     * @return
     */
    @PostMapping("/add")
    public String createPerson(Person person) {
        personService.add(person);
        return "redirect:/manageruser/";
    }


    @RequestMapping("/edit")
    public String edit(Person person) {
        personService.update(person);
        return "redirect:/manageruser/";
    }

    /***
     * 删除指定id用户
     *
     * @param id
     * @return
     */
    @GetMapping("/delete/{id}")
    public String deletePerson(@PathVariable("id") Integer id) {
        personService.delete(id);
        return "redirect:/manageruser/";
    }

}
