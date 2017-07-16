package qe;

import org.springframework.stereotype.Service;

/**
 * Created by ymenuhin on 7/16/2017.
 */
@Service
public class HelloMessageService {
    private String message = "Hello ...";

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
