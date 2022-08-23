package com.soultech.ddd.clean.infrastructure.config;


import com.soultech.ddd.clean.core.port.GreetingGatewayOutputPort;
import com.soultech.ddd.clean.core.port.GreetingInputPort;
import com.soultech.ddd.clean.core.usecase.GreetSomeoneUseCase;
import com.soultech.ddd.clean.infrastructure.presenter.GreetingRestPresenter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import javax.servlet.http.HttpServletResponse;

@Configuration
public class AppConfig {

    @Bean(autowireCandidate = false)
    @Scope("request")
    public GreetingInputPort greetingRestUseCase(HttpServletResponse httpServletResponse,
                                                 MappingJackson2HttpMessageConverter jacksonConverter,
                                                 GreetingGatewayOutputPort greetingGateway) {
        return new GreetSomeoneUseCase(new GreetingRestPresenter(httpServletResponse, jacksonConverter),
                greetingGateway);
    }
}
