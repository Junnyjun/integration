package com.example.integration;

import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.messaging.handler.annotation.Header;

@MessagingGateway(defaultReplyChannel = "textInChannel")
public interface FileWriterGateway {

    void writeToFile(String filename, String date);
}
