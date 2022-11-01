package br.com.arc.studyaws.service.impl;

import br.com.arc.studyaws.exception.SqsException;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessagingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@MockitoSettings
class SQSServiceTest {

    @Mock
    private QueueMessagingTemplate messagingTemplate;

    @InjectMocks
    private SQSService service;


    @Test
    void send() {
        doNothing().when(messagingTemplate).convertAndSend(anyString(), any(Message.class));

        service.send("queue", "message");

        verify(messagingTemplate, times(1)).convertAndSend(anyString(), any(Message.class));
    }


    @Test
    void sendWithException() {
        doThrow(MessagingException.class).when(messagingTemplate).convertAndSend(anyString(), any(Message.class));

        var exception = assertThrows(SqsException.class,
                () -> service.send("queue", "message"));

        assertNotNull(exception);
        assertEquals(SqsException.class, exception.getClass());
        verify(messagingTemplate, times(1)).convertAndSend(anyString(), any(Message.class));
    }
}