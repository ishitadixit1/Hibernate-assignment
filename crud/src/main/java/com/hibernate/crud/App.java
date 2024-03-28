package com.hibernate.crud;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import entity.Employee;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "Hello World!" );
        Employee e1 = new Employee();
        e1.setName("Ishita");;
        e1.setEmail("ishita@gmail.com");
        
        
        Employee e2 = new Employee();
        e2.setName("Jyoti");
        e2.setEmail("abcd@gmail.com");
        
        SessionFactory sessionFactory = HibernateUtils.getSessionFactory();
        Session s1 = sessionFactory.openSession();
        s1.beginTransaction();
        s1.persist(e1);
        s1.persist(e2);

        s1.getTransaction().commit();

        System.out.println("After saving : ");
        s1.createQuery("from Employee", Employee.class).list().forEach(System.out::println);
        s1.close();

        System.out.println("Second session : ");
        Session s2 = sessionFactory.openSession();
        s2.beginTransaction();

        Employee fetchEmp = s2.get(Employee.class, 1L);
        System.out.println(fetchEmp);

        fetchEmp.setEmail("ishita@accolitedigital.com");
        s2.merge(fetchEmp);

        s2.createQuery("from Employee", Employee.class).list().forEach(System.out::println);

        Employee emp = s2.get(Employee.class, 2L);
        System.out.println("Employee deleted : " + emp.getName());
        s2.remove(emp);


        s2.getTransaction().commit();

        s2.createQuery("from Employee", Employee.class).list().forEach(System.out::println);

        s2.close();
    }
}
