package com.hibernate.oneToManyAndManyToOne;

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
        cg.configure("com/hibernate/oneToManyAndManyToOne/hibernate.cfg.xml");
        
        SessionFactory fact = cg.buildSessionFactory();
        System.out.println(fact);
        
        User user = new User();
        user.setUserId(123);
        user.setUserName("Ishita");
        
        Orders order1 = new Orders();
        order1.setOrderId(234);
        order1.setOrderPrice(1200);
        order1.setUser(user);
        
        
        Orders order2 = new Orders();
        order2.setOrderId(456);
        order2.setOrderPrice(1450); 
        order2.setUser(user);
        
        List<Orders> list = new ArrayList<Orders>();
        
        list.add(order1);
        list.add(order2);
        
        user.setOrder(list);
        
        Session s = fact.openSession();
        
        Transaction tx = s.beginTransaction();
        
        s.persist(user);
        s.persist(order1);
        s.persist(order2);
        
        tx.commit();
        
        User u = s.get(User.class, 123);
        
        System.out.println("User name : " + u.getUserName());
        for(Orders o : u.getOrder())
        {
        	System.out.println("Order Id : " + o.getOrderId() + " ; Order price : " + o.getOrderPrice());
        }
        
        s.close();
        fact.close(); 
    }
}
