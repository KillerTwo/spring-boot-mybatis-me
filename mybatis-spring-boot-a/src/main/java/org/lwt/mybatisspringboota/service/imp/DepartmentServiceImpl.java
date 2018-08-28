package org.lwt.mybatisspringboota.service.imp;

import org.lwt.mybatisspringboota.entity.Departments;
import org.lwt.mybatisspringboota.mapper.DepartmentsMapper;
import org.lwt.mybatisspringboota.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

  @Autowired
  DepartmentsMapper departmentsMapper;
  
  @Override
  public Departments getDeptById(String deptNo) {
    
    return departmentsMapper.selectByPrimaryKey(deptNo);
  }
  
  @Override
  public int addDept(Departments dept) {
    
    return departmentsMapper.insert(dept);
  }

}
