package com.soultech.ddd.clean.core.port;

import com.soultech.ddd.clean.core.model.Greeting;

public interface GreetingGatewayOutputPort {

    Greeting retrievePersonalGreeting(String forWhom);
}
