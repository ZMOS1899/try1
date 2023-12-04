package com.itheima.controller;

import com.itheima.pojo.Dept;
import com.itheima.pojo.Result;
import com.itheima.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequestMapping("/depts")
public class DeptController {

//    private static Logger log = LoggerFactory.getLogger(DeptController.class)
    @Autowired
    private DeptService deptService;

//    @RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result list() {
        log.info("view all dept's data");

        List<Dept> deptList = deptService.list();

        return Result.success(deptList);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("dept has been deleted: {} ", id);

        deptService.delete(id);
        return Result.success();
    }
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        log.info("add new dept: {}", dept);

        deptService.add(dept);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result show(@PathVariable Integer id) {
        log.info("show dept: {}", id);

        Dept dept = deptService.show(id);
        return Result.success(dept);
    }

    @PutMapping
    public Result update(@RequestBody Dept dept) {
        log.info("------------------update dept: {}", dept);

        deptService.update(dept);

        return Result.success();
    }

}
