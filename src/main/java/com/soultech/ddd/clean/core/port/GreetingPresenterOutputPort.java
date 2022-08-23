package com.soultech.ddd.clean.core.port;

import com.soultech.ddd.clean.core.model.Greeting;

public interface GreetingPresenterOutputPort {

    void presentGreeting(Greeting greeting);

}
