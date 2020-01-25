package com.luv2code.hibernate.demo.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class QueryStudentDemo {
    public static void main(String[] args) {

        //create session factory
        SessionFactory factory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Student.class)
                .buildSessionFactory();
        //create session
        Session session = factory.getCurrentSession();

        try {
            //start transaction
            session.beginTransaction();

            //query students
            List<Student> theStudents = session.createQuery("from Student").getResultList();

            //display the students
            displayTheStudents(theStudents);

            //query students: lastName = "Dow"
            theStudents = session.createQuery("from Student s where s.lastName='Dow'").getResultList();

            //display the students
            System.out.println("\n\nStudent who have last name of Dow.");
            displayTheStudents(theStudents);

            // commit transaction
            session.getTransaction().commit();

            System.out.println("Done!");
        } finally {
            factory.close();
        }
    }

    private static void displayTheStudents(List<Student> theStudents) {
        for (Student tempStudent : theStudents) {
            System.out.println(tempStudent);
        }
    }
}
