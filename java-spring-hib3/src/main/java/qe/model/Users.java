package qe.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "users")
public class Users implements Serializable  {

//
//    @Id
//  //  @GeneratedValue
//    @Column(name = "id")
//    private int    id;
//
//
 

//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }

   public Users() {}
   public Users(Long id, String username) {
      this.id = id;
      this.username = username;
   } 


    Long id;

    @Id
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }


    private String username;
    
    @Column(name = "username")
    public String getUsername() {      return username;     }

    public void setUsername(String username) {
        System.out.println(">> setUsername");
        this.username = username;     }


}
