package com.soultech.ddd.clean.infrastructure.controller;

import com.soultech.ddd.clean.core.port.GreetingInputPort;
import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GreetingController {

    private final ApplicationContext applicationContext;

    @GetMapping("/greet")
    public void greet(@RequestParam String name) {

        final GreetingInputPort greetingUseCase = applicationContext.getBean(GreetingInputPort.class);

        greetingUseCase.sayHello(name);
    }

}
