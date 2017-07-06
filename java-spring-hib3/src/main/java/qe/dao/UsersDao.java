package qe.dao;

import java.util.List;





import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import qe.ConfigXml;
import qe.model.Users;


@Repository
@Transactional
public class UsersDao {
    
    
   @Autowired
   SessionFactory sessionFactory;
 
    public List listUsers(){
        Session session = getCurrentSession();
        // -------------
              //---------------------
        System.out.println(" Query:");
        Query q = session.createQuery("FROM qe.model.Users" );
        List  result = q.list();
//        if( result!=null ) System.out.println(" ### Result :" + result.size());
        System.out.println(" ------------------ ");
        for ( Users e : (List<Users>) result ) {
            System.out.println( "Users (" + e.getId() + ") : " + e.getUsername() );
        }
//       session.close();
        return result;
    }
 
//    @Override
    @Transactional
    public List<Users> list() {
        @SuppressWarnings("unchecked")
        List<Users> listUser = (List<Users>) sessionFactory.getCurrentSession()
                .createCriteria(Users.class)
                .setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY).list();
 
        return listUser;
    }
   
    
   public Session getCurrentSession(){
      return sessionFactory.openSession();//.getCurrentSession();
   }
}
