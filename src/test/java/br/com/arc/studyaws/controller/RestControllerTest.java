package br.com.arc.studyaws.controller;

import br.com.arc.studyaws.repository.entity.Message;
import br.com.arc.studyaws.repository.impl.MessageRepository;
import br.com.arc.studyaws.service.impl.SNSService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.messaging.MessagingException;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@MockitoSettings
class RestControllerTest {

    @Mock
    private SNSService service;

    @Mock
    private MessageRepository repos;

    @InjectMocks
    private RestController controller;


    @Test
    void getTeste() {
        doNothing().when(service).send(anyString(), anyString());
        when(repos.save(any())).thenReturn(new Message());

        controller.getTeste();

        verify(service, times(1)).send(anyString(), anyString());
        verify(repos, times(1)).save(any());
    }

    @Test
    void getTesteWithExpection() {
        doThrow(MessagingException.class).when(service).send(anyString(), anyString());

        try {
            controller.getTeste();
        } catch (Exception e) {
            verify(service, times(1)).send(anyString(), anyString());
            verify(repos, never()).save(any());
        }
    }
}