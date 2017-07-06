package org.eclipse.che.examples;

import org.eclipse.che.examples.model.Person;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.mongodb.MongoClient;

/*
 * TODO
 * - Annotation based configuration instead of XML based
 * - Read JPA, JPA+MongoDB
 */

public class HelloWorld {
    public static void main(String... argvs) {
        //ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("springConfig.xml");
        MongoOperations mongoOps = new MongoTemplate(new MongoClient(), "database");
        mongoOps.insert(new Person("Joe", 34));
    }
}
