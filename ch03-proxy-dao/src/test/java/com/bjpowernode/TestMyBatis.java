package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class TestMyBatis {

    @Test
    public void testSelectStudents(){
        /**
         * 使用mybatis的动态代理机制， 使用SqlSession.getMapper(dao接口)
         * getMapper能获取dao接口对应的实现类对象
         */
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        //com.sun.proxy.$Proxy2 :JDK的动态代理
        System.out.println("dao=" + dao.getClass().getName());

        //调用dao的方法， 执行数据库的操作
        List<Student> students = dao.selectStudents();
        for (Student student : students) {
            System.out.println("学生=" + student);
        }
    }

    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setId(5858);
        student.setName("sjm");
        student.setEmail("sjm666");
        student.setAge(24);

        int nums = dao.insertStudent(student);
        sqlSession.commit();

        System.out.println("添加的数量：" + nums);

    }
}
