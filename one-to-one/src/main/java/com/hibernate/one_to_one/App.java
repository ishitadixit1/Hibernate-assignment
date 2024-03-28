package com.hibernate.one_to_one;

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
        cg.configure("/com/hibernate/one_to_one/hibernate.cfg.xml");
        
        SessionFactory fact = cg.buildSessionFactory();
        
        Cohort c1 = new Cohort();
        
        c1.setCohortId(123);
        c1.setCohortName("Batch2k24");
        
        Project p1 = new Project();
        
        p1.setProjectId(212);
        p1.setProjectName("Stock management");
        p1.setCohort(c1);
        
        
        Session s = fact.openSession();
        
        Transaction tx = s.beginTransaction();
        
        s.persist(c1);
        s.persist(p1);
        
        tx.commit();
        
        Project p = s.get(Project.class, 212);
        System.out.println("Project name : " + p.getProjectName());
        System.out.println("Cohort name : " + p.getCohort().getCohortName());
        
        s.close();
        
        fact.close();
        
    }
}
