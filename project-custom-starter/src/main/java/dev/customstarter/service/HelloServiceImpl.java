package dev.customstarter.service;

import lombok.extern.java.Log;

@Log
public class HelloServiceImpl implements HelloService {
    @Override
    public String sayHello() {

        log.info("Hello from the default starter hello service.");
        return "Hello from the default starter hello service.";
    }
}
