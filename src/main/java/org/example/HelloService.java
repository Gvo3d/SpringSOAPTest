package org.example;
import java.util.Calendar;
public interface HelloService {
    public String getHello(String name) throws Exception;
    public Calendar getCurrentTime();
}