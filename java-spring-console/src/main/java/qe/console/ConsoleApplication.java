package qe.console;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class ConsoleApplication  implements ApplicationListener<ApplicationReadyEvent> {

    private static final Logger logger= LoggerFactory.getLogger( ConsoleApplication.class);
    public static void main(String[] args) { SpringApplication.run(ConsoleApplication.class, args); }

 // TODO: Before and after aspects for methods

    @Override
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        String leftAlignFormat = "| %-15s | %-20s |%n";

        String s = String.format( "%n+-----------------+----------------------+%n" )
                .concat( String.format( "| Column name     | ID                   |%n" ))
                .concat( String.format( "+-----------------+----------------------+%n" ));

        // Display some System information
        s=s .concat(String.format(leftAlignFormat, "OS" , String.valueOf(System.getProperty("os.name"))))
                .concat(String.format(leftAlignFormat, "Max Memory" , String.valueOf(Runtime.getRuntime().maxMemory())))
                .concat(String.format(leftAlignFormat, "Free Memory" , String.valueOf(Runtime.getRuntime().freeMemory())  ));

        //for (int i = 0; i < 5; i++) s = s.concat(String.format(leftAlignFormat, "some data" + i, i * i));
        logger.info(s);

    }
}
