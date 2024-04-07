package org.hillel;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Додавання студентів
        StudentDAO studentDAO = new StudentDAO();
        Student student1 = new Student("John", "john@example.com");
        Student student2 = new Student("Alice", "alice@example.com");
        Student student3 = new Student("Peter", "peter@example.com");
        Student student4 = new Student("Max", "max@example.com");
        Student student5 = new Student("Olena", "olena@example.com");

        studentDAO.addStudent(student1);
        studentDAO.addStudent(student2);
        studentDAO.addStudent(student3);
        studentDAO.addStudent(student4);
        studentDAO.addStudent(student5);

        // Отримання всіх студентів
        List<Student> allStudents = studentDAO.getAllStudents();
        for (Student student : allStudents) {
            System.out.println(student);
        }

        // Отримання студента за ID та його оновлення
        Student retrievedStudent = studentDAO.getStudentById(1);
        System.out.println("Retrieved Student: " + retrievedStudent);
        retrievedStudent.setName("Updated Name");
        studentDAO.updateStudent(retrievedStudent);

        // Видалення студента
        studentDAO.deleteStudent(student2);
    }

}