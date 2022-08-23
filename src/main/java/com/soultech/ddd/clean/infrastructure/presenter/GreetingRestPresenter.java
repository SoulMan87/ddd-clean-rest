package com.soultech.ddd.clean.infrastructure.presenter;

import com.soultech.ddd.clean.core.model.Greeting;
import com.soultech.ddd.clean.core.port.GreetingPresenterOutputPort;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.DelegatingServerHttpResponse;
import org.springframework.http.server.ServletServerHttpResponse;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class GreetingRestPresenter implements GreetingPresenterOutputPort {

    private final HttpServletResponse httpServletResponse;

    private final MappingJackson2HttpMessageConverter jacksonConverter;

    @Override
    public void presentGreeting(Greeting greeting) {
        final DelegatingServerHttpResponse httpOutputMessage =
                new DelegatingServerHttpResponse(new ServletServerHttpResponse(httpServletResponse));

        httpOutputMessage.setStatusCode(HttpStatus.OK);

        try {
            jacksonConverter.write(greeting, MediaType.APPLICATION_JSON, httpOutputMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
