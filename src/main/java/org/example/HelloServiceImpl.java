package org.example;
import java.util.Calendar;
import org.springframework.stereotype.Service;
@Service
public class HelloServiceImpl implements HelloService {
    public String getHello(String name) throws Exception {
        return "Hello, " + name + "!";
    }
    public Calendar getCurrentTime() {
        return Calendar.getInstance();
    }
}