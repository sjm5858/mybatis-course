package com.bjpowernode.dao;


import com.bjpowernode.domain.Student;

import java.util.List;

public interface StudentDao {

    // 动态sql，使用java对象作为参数
    List<Student> selectStudentIf(Student student);

    // where的使用
    List<Student> selectStudentWhere(Student student);

    //foreach 用法1
    List<Student> selectForeachOne(List<Integer> idlist);

    //foreach 用法2
    List<Student> selectForeachTwo(List<Student> studentlist);


    //使用PageHelper分页数据
    List<Student> selectAll();

}
