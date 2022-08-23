package com.soultech.ddd.clean.infrastructure.gateway;

import com.soultech.ddd.clean.core.model.Greeting;
import com.soultech.ddd.clean.core.port.GreetingGatewayOutputPort;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class InMemoryGreetingGateway implements GreetingGatewayOutputPort {

    private static final Map<String, String> greetings =
            Stream.of(new String[]{"Jorge", "Hola %s, como vas? "},
                            new String[]{"Hernán", "Como estás %s?"},
                            new String[]{"Don Polo", "Que más pues %s?"},
                            new String[]{"Katherine", "Como está su merced %s"})
                    .collect(Collectors.toUnmodifiableMap(pair -> pair[0], pair -> pair[1]));

    @Override
    public Greeting retrievePersonalGreeting(String forWhom) {
        return Optional.ofNullable(greetings
                        .get(forWhom))
                .map(template -> template.formatted(forWhom))
                .map(message -> Greeting.builder()
                        .forWhom(forWhom)
                        .message(message)
                        .build())
                .orElse(Greeting.builder()
                        .forWhom("Alguien")
                        .message("Hola, estraño")
                        .build());
    }
}
