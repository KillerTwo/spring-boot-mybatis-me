package org.lwt.mybatisspringboota.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.lwt.mybatisspringboota.entity.Departments;

@Mapper
public interface DepartmentsMapper {
    int deleteByPrimaryKey(String deptNo);

    int insert(Departments record);

    Departments selectByPrimaryKey(String deptNo);

    List<Departments> selectAll();

    int updateByPrimaryKey(Departments record);
}