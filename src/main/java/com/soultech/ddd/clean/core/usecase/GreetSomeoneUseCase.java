package com.soultech.ddd.clean.core.usecase;

import com.soultech.ddd.clean.core.port.GreetingGatewayOutputPort;
import com.soultech.ddd.clean.core.port.GreetingInputPort;
import com.soultech.ddd.clean.core.port.GreetingPresenterOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GreetSomeoneUseCase implements GreetingInputPort {

    private final GreetingPresenterOutputPort greetingPresenter;

    private final GreetingGatewayOutputPort greetingGateway;

    @Override
    public void sayHello(String toWhom) {
        greetingPresenter.presentGreeting(greetingGateway.retrievePersonalGreeting(toWhom));
    }
}
