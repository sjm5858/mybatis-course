package com.bjpowernode;

import com.bjpowernode.dao.StudentDao;
import com.bjpowernode.domain.Student;
import com.bjpowernode.utils.MyBatisUtils;
import com.bjpowernode.vo.QueryParam;
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
    public void testSelectMultiObject() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        QueryParam param = new QueryParam();
        param.setParamAge(20);
        param.setParamName("沈俊名");

        List<Student> students = dao.selectMultiObject(param);
        for (Student student : students) {
            System.out.println("学生=" + student);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiStudent() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Student student = new Student();
        student.setName("沈俊名");
        student.setAge(20);

        List<Student> students = dao.selectMultiStudent(student);
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiPosition() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiPosition("沈俊名",20);
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiMap() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<String,Object> data = new HashMap<>();
        data.put("myname","沈俊名");
        data.put("age",20);

        List<Student> students = dao.selectMultiMap(data);
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiUse$() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$("'' or 1=1");
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiUse$Order() {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectUse$Order("age");
        for (Student stu : students) {
            System.out.println("学生=" + stu);
        }
        sqlSession.close();
    }
}
