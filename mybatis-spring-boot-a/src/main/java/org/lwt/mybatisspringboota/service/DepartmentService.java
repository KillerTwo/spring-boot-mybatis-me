package org.lwt.mybatisspringboota.service;

import org.lwt.mybatisspringboota.entity.Departments;

public interface DepartmentService {
  Departments getDeptById(String deptNo);
  
  int addDept(Departments dept);
}
