/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import dao.IStudentDao;
import entity.Student;
import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author ezgih
 */
@Named
@SessionScoped
public class StudentController implements Serializable {

    @EJB //EJB notasyonu.
    private IStudentDao studentDao; //ejb lere direk erişim yok , interface üzerinden erişim var. o yüzden IStudentDao dan bir tane değişken oluşturduk.

    private Student student;

    private List<Student> studentList;

    public StudentController() {
    }

    public String insertStudent() {
        studentDao.addStudent(this.student);
        this.student = new Student();
        return "index";
    }

    public String deleteStudent(Student student) {
        studentDao.removeStudent(student);
        return "index";
    }

    public List<Student> getStudentList() {
        this.studentList = studentDao.getAll();
        return this.studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public Student getStudent() {
        if (this.student == null) {
            this.student = new Student();
        }
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

}
