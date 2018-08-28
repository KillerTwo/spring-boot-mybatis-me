package org.lwt.mybatisspringboota.controller;

import java.util.HashMap;
import java.util.Map;

import org.lwt.mybatisspringboota.entity.Departments;
import org.lwt.mybatisspringboota.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/select")
public class SelectController {
  @Autowired
  DepartmentService departmentService;
  
  @GetMapping("/id")
  public Map<String, Object> searchDept(@RequestParam("deptno") String deptNo){
    System.out.println("请求的部门id为："+deptNo);
    Map<String, Object> map = new HashMap<>();
    Departments dept = departmentService.getDeptById(deptNo);
    System.out.println("查询到的数据："+dept.getDeptName());
    map.put("msg", "success");
    map.put("results", dept);
    return map;
  }
  
  @RequestMapping(value="/insert", method=RequestMethod.POST)
  public Map<String, Object> addData(@RequestBody Departments dept){
    System.out.println("添加的数据："+dept.getDeptNo());
    System.out.println("添加的数据："+dept.getDeptName());
    Map<String, Object> map = new HashMap<>();
    int effected = departmentService.addDept(dept);
    if(effected > 0) {
      map.put("msg", "success");
      map.put("effected", effected);
    }else {
      map.put("msg", "error");
      map.put("err", "插入数据失败。");
    }
    return map;
  }
}
