/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Student;
import java.util.List;
import javax.ejb.Remote;

/**
 *
 * @author ezgih
 */
@Remote
public interface IStudentDao {

    void addStudent(Student student);

    void removeStudent(Student student);

    List<Student> getAll();
}
