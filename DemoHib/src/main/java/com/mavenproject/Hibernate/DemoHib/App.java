package com.mavenproject.Hibernate.DemoHib;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	AlienName an= new AlienName();
    	an.setFname("vinay");
    	an.setMname("kumar");
    	an.setLname("k");
    	
        Alien a= new Alien();
        a.setAid(106);
        a.setAname(an);
        a.setColor("pink");          //  to fetch data from sql we need comment this part & save part, implement tostring in pojo
        a.setRollNo(30);
        
        Configuration con =new Configuration().configure().addAnnotatedClass(Alien.class);
        
        ServiceRegistry reg= new ServiceRegistryBuilder().applySettings(con.getProperties()).buildServiceRegistry(); 
        
        SessionFactory sf=con.buildSessionFactory(reg);
        
        Session session=sf.openSession();
        
        Transaction tx =session.beginTransaction();
        
        session.save(a);
        
//      a=(Alien)session.get(Alien.class, 105);  // To fetch from mysql data
        
        tx.commit();
        
        System.out.println(a);
        
        
        
    }
}
