package dev.demoprojectcustomstarter.service;

import dev.customstarter.service.HelloService;
import lombok.extern.java.Log;
import org.springframework.stereotype.Service;


@Service
@Log
public class CustomHelloService implements HelloService {
    @Override
    public String sayHello() {
        log.info("Hello from Custom Application!");
        return "Hello from Custom Application!";
    }
}
