package org.example.mybatis.persistence;

import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.example.mybatis.domain.Lecture;
import org.example.mybatis.domain.Student;
import org.example.mybatis.domain.StudentLecture;
import org.example.mybatis.domain.StudentSelfcard;
import org.example.mybatis.mapper.LectureMapper;
import org.example.mybatis.mapper.StudentLectureMapper;
import org.example.mybatis.mapper.StudentMapper;
import org.example.mybatis.mapper.StudentSelfcardMapper;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class One2ManyTest {
	private SqlSession session = null;
	
	@Before
	public void setUp() throws IOException {
		String resource = "mybatis-config.xml";
		Reader reader = Resources.getResourceAsReader(resource);
		SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
		SqlSessionFactory factory = builder.build(reader);

		session = factory.openSession();
	}

	@Test
	public void one2ManyTest() {
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.selectByPrimaryKey(1l);
        System.out.printf("---------" + student.getStudentSelfcard().getIssueDate());
        for (StudentLecture studentLecture : student.getStudentLectureList()) {
            System.out.printf("##########" + studentLecture.getGrade());
        }
        System.out.printf("============================");
    }

    @Test
    public void selectStudentLectureByStudentIdTest() {
        StudentLectureMapper studentLectureMapper = session.getMapper(StudentLectureMapper.class);
        List<StudentLecture> studentLectures = studentLectureMapper.selectByStudentId(1l);
        System.out.printf("---------" + studentLectures.size());
        for (StudentLecture studentLecture : studentLectures) {
            System.out.printf("##########" + studentLecture.getGrade());
        }
        System.out.printf("============================");
    }

	@Test
	public void insertStudentTest() {
        Student student = new Student();
        student.setComment("11111");
        student.setCnnmae("小张");
        student.setNote("test");
        student.setSex(1);
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        studentMapper.insert(student);
        session.commit();
    }

    @Test
    public void insertStudentSelfcardTest() {
	    StudentMapper studentMapper = session.getMapper(StudentMapper.class);
	    Student student = studentMapper.selectByPrimaryKey(1l);

        StudentSelfcard studentSelfcard = new StudentSelfcard();
        studentSelfcard.setNote("test");
        studentSelfcard.setEndDate(new Date());
        studentSelfcard.setIssueDate(new Date());
        studentSelfcard.setStudent(student);
        studentSelfcard.setStudentNative("jjjjjjj");

        StudentSelfcardMapper studentSelfcardMapper = session.getMapper(StudentSelfcardMapper.class);
        studentSelfcardMapper.insert(studentSelfcard);
        session.commit();
    }

    @Test
    public void insertLectureTest() {
        Lecture lecture = new Lecture();
        lecture.setLectureNmae("语文");
        lecture.setNote("语文");
        LectureMapper lectureMapper = session.getMapper(LectureMapper.class);
        lectureMapper.insert(lecture);
        session.commit();
    }

    @Test
    public void insertStudentLectureTest() {
        StudentMapper studentMapper = session.getMapper(StudentMapper.class);
        Student student = studentMapper.selectByPrimaryKey(1l);

        StudentLecture studentLecture = new StudentLecture();
        studentLecture.setGrade(BigDecimal.valueOf(98));
        studentLecture.setNote("数学分数");
        studentLecture.setStudentId(student.getId().intValue());
        StudentLectureMapper studentLectureMapper = session.getMapper(StudentLectureMapper.class);
        studentLectureMapper.insert(studentLecture);
        session.commit();
    }

	@After
	public void tearDown() {
		if (session != null) {
			session.close();
		}
	}
}