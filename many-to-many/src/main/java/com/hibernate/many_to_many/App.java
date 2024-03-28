package com.hibernate.many_to_many;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Connection started" );
        Configuration cg = new Configuration();
        cg.configure("com/hibernate/many_to_many/hibernate.cfg.xml");
        
        SessionFactory fact = cg.buildSessionFactory();
        
        Professor p1 = new Professor();
        p1.setProfessorId(123);
        p1.setProfName("Akash");
        p1.setEmail("akash123@gmail.com");
        
        Professor p2 = new Professor();
        p1.setProfessorId(125);
        p1.setProfName("Jason");
        p1.setEmail("jason11@gmail.com");
        
        Subject sub1 = new Subject();
        sub1.setSubjectCode(222);
        sub1.setSubjectName("Maths");
        
        Subject sub2 = new Subject();
        sub2.setSubjectCode(333);
        sub2.setSubjectName("Java");
        
        Subject sub3 = new Subject();
        sub3.setSubjectCode(444);
        sub3.setSubjectName("Data structures");
        
        List<Professor> profList = new ArrayList<Professor>();
        profList.add(p1);
        profList.add(p2);
        
        List<Subject> subList = new ArrayList<Subject>();
        subList.add(sub1);
        subList.add(sub2);
        subList.add(sub3);
        
        p1.setSubjects(subList);
        sub1.setProf(profList);
        
        Session s = fact.openSession();
        
        Transaction tx = s.beginTransaction();
        
        s.persist(p1);
        s.persist(p2);
        s.persist(sub1);
        s.persist(sub2);
        s.persist(sub3);
        
        tx.commit();
        
        Professor p = s.get(Professor.class, 125);
        Subject subject = s.get(Subject.class, 222);
        
        System.out.println("Professor : " + p.getProfName());
        for(Subject sub : p.getSubjects())
        {
        	System.out.println("Subject code : " + sub.getSubjectCode() + " ; Subject name : " + sub.getSubjectName());
        }
        
        System.out.println("Subject name : " + subject.getSubjectName());
        System.out.print("Professors assigned to the subject :");
        for(Professor proff : subject.getProf()) {
        	System.out.print(proff.getProfName()+ ", ");
        }
        
        s.close();
        fact.close(); 
        
        System.out.println(fact);
    }
}
