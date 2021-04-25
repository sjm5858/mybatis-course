package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.MyStudent;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
import com.bjpowernode.vo.ViewStudent;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {

    @Test
    public void testSelectStudents() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = dao.selectStudentById(1002);

        System.out.println("student=" + student);

    }

    @Test
    public void testSelectMultiParam() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiParam("李四", 20);
        for (Student student : students) {
            System.out.println("学生=" + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectViewStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        ViewStudent viewStudent = dao.selectStudentReturnViewStudent(1005);
        System.out.println("学生=" + viewStudent);
        sqlSession.close();
    }

    @Test
    public void testSelectCountStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        int count = dao.countStudent();
        System.out.println("学生的数量=" + count);
        sqlSession.close();
    }

    @Test
    public void testSelectMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<Object, Object> map = dao.selectMapById(1001);
        System.out.println("map==" + map);

        sqlSession.close();
    }

    //=========================================================
    @Test
    public void testSelectAllStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectAllStudents();
        for (Student student : students) {
            System.out.println("学生=" + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectAllStudent2() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> students = dao.selectMyStudent();
        for (MyStudent student : students) {
            System.out.println("学生=" + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectDiffColProperty() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<MyStudent> students = dao.selectDiffColProperty();
        for (MyStudent student : students) {
            System.out.println("##学生=" + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectLikeOne() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "%李%";
        List<Student> students = dao.selectLikeOne(name);
        for (Student student : students) {
            System.out.println("##学生=" + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectLikeTwo() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        String name = "李";
        List<Student> students = dao.selectLikeTwo(name);
        for (Student student : students) {
            System.out.println("##学生=" + student);
        }
        sqlSession.close();
    }
}
