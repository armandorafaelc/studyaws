package br.com.arc.studyaws.service.impl;

import br.com.arc.studyaws.exception.SnsException;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.messaging.MessagingException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@MockitoSettings
class SNSServiceTest {

    @Mock
    private NotificationMessagingTemplate notificationMessagingTemplate;

    @InjectMocks
    private SNSService service;

    @Test
    void send() {
        doNothing().when(notificationMessagingTemplate).convertAndSend(anyString(), anyString());

        service.send("queue", "message");

        verify(notificationMessagingTemplate, times(1)).convertAndSend(anyString(), anyString());
    }

    @Test
    void sendWithException() {
        doThrow(MessagingException.class).when(notificationMessagingTemplate).convertAndSend(anyString(), anyString());


        var exception = Assertions.assertThrows(SnsException.class,
                () -> service.send("queue", "message"));

        assertNotNull(exception);
        assertEquals(SnsException.class, exception.getClass());
    }
}