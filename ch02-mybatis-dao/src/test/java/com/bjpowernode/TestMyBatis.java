package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.dao.impl.StudentDaoImpl;
import com.bjpowernode.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudents(){

        //com.bjpowernode.dao.StudentDao
        StudentDao dao = new StudentDaoImpl();
        /**
         * List<Student> studentList = dao.selectStudents(); 调用
         * 1.dao对象，类型是StudentDao，全限定名称是：com.bjpowernode.dao.StudentDao
         * 全限定名称 和 namespace 是一样的。
         *
         * 2.方法名称，selectStudents ，这个方法名称就是 mapper 文件中的 id值 selectStudents
         *
         * 3.通过dao方法中方法的返回值也可以确定MyBatis要调用的SqlSession方法
         *   如果返回值是List ，调用的是SqlSession.selectList()方法。
         *   如果返回值是 int，或是非List的，看mapper文件中的标签是<insert>,<update> 就会调用
         *   SqlSession的insert， update等方法
         *
         * mybatis的动态代理：mybatis根据dao的方法调用，获取执行sql语句的信息。
         *   mybatis根据你的dao接口，创建出一个dao接口的实现类，并创建这个类的对象。
         *   完成SqlSession调用方法，访问数据库
         *
         */
        List<Student> studentList = dao.selectStudents();
        for (Student student : studentList) {
            System.out.println(student);
        }
    }

    @Test
    public void testInsertStudent(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(2005);
        student.setName("白云山");
        student.setEmail("ss@qq.com");
        int nums = dao.insertStudent(student);
        System.out.println("添加对象的数量：" + nums);
    }
}
