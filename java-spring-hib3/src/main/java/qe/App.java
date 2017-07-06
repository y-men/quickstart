package qe;

import java.util.List;

import org.hibernate.Session;

import qe.dao.UsersDao;
import qe.model.Users;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World! ---\n\n " );
        
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext( ConfigXml.class);
        UsersDao usersDao = context.getBean( UsersDao.class);     
        List l = usersDao.list();//.listUsers();
        if( l!=null ) System.out.println(" -++++-->>> Result :" + l.size());
        
    }
}
