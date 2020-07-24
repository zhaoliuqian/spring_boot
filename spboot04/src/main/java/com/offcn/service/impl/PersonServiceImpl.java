package com.offcn.service.impl;

import com.offcn.dao.PersonDao;
import com.offcn.pojo.Person;
import com.offcn.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

  @Autowired
  private PersonDao pd;

    @Override
    public void add(Person person) {
       pd.save(person);
    }

    @Override
    public void delete(Integer id) {
        pd.deleteById(id);
    }

    @Override
    public void update(Person person) {
        pd.save(person);
    }

    @Override
    public Person get(Integer id) {
        return pd.findById(id).get();
    }

    @Override
    public List<Person> getAll() {
        return pd.findAll();
    }
}
