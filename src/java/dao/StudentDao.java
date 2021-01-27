/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entity.Student;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author ezgih
 */
@Stateless
public class StudentDao extends Dao implements IStudentDao {

    @Override
    public void addStudent(Student student) {
        String q = "insert into student (id,name,age) values (default,?,?)";
        try {
            PreparedStatement pst = getConnection().prepareStatement(q);
            pst.setString(1, student.getName());
            pst.setInt(2, student.getAge());
            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeStudent(Student student) {
        String q = "delete from student where id=?";
        try {
            PreparedStatement pst = getConnection().prepareStatement(q);
            pst.setInt(1, student.getId());
            pst.executeQuery();
            pst.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public List<Student> getAll() {
        String q = "select * from student order by name";
        List<Student> list = new ArrayList<>();
        try {
            PreparedStatement pst = getConnection().prepareStatement(q);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                Student temp = new Student(rs.getInt("id"), rs.getString("name"), rs.getInt("age"));
                list.add(temp);
            }
            pst.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return list;
    }

}
