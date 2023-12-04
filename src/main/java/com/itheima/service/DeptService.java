package com.itheima.service;

import com.itheima.pojo.Dept;
import org.springframework.stereotype.Service;

import java.util.List;


public interface DeptService {
    /**
     * view all dept's data
     * @return
     */
    List<Dept> list();

    void delete(Integer id);

    void add(Dept dept);

    Dept show(Integer id);



    void update(Dept dept);
}
