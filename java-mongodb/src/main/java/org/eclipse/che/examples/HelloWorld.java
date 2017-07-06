package org.eclipse.che.examples;

import java.net.UnknownHostException;

import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoDatabase;

public class HelloWorld {
    public static void main(String... argvs) {
        //        String a = "Che";
        //        System.out.println("Hello World " + a + "!");

        try {

            System.out.println(" ------------------");
            MongoClientURI uri =
             new MongoClientURI(
                "\mongodb://admin:admin@cluster0-shard-00-00-x3a8q.mongodb.net:27017,cluster0-shard-00-01-x3a8q.mongodb.net:27017,cluster0-shard-00-02-x3a8q.mongodb.net:27017/<DATABASE>?ssl=true&replicaSet=Cluster0-shard-0&authSource=admin");

            MongoClient mongoClient = new MongoClient(uri);
            MongoDatabase database = mongoClient.getDatabase("qe");
            System.out.println(">> Db = " + database);
            
            MyService service = new MyService();
            service.addOneToCollection(database, "quickstart");
            service.displayCollection(database, "quickstart");
            
            
        } catch (Exception unknownHostException) {
            System.out.println("E  \n ");
            unknownHostException.printStackTrace();
        }


    }

}
