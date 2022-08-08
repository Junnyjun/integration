package com.example.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.messaging.MessageChannel;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


@Configuration
public class FileWrtiterIntegrationConfig {

    @Bean
    public IntegrationFlow fileWriterFlow() throws IOException {
        return IntegrationFlows
                .from(MessageChannels.direct("textInChannel"))
                .<String, String>transform(String::toUpperCase)
                .handle(Files.getFileStore(Path.of("./text")))
                .get();
    }

    @Bean
    public MessageChannel textInChannel(){return new DirectChannel();}
    @Bean
    public MessageChannel fileWriterChannel(){return new DirectChannel();}

}
