package br.com.arc.studyaws.repository.impl;

import br.com.arc.studyaws.exception.DynamoException;
import br.com.arc.studyaws.repository.entity.Message;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.messaging.MessagingException;

import java.time.LocalDateTime;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;

@MockitoSettings
class MessageRepositoryTest {

    public static final String ID = "1";
    public static final String MESSAGE = "hello";
    @Mock
    private DynamoDBMapper mapper;

    @InjectMocks
    private MessageRepository mRepository;

    private Message message;

    @BeforeEach
    void setup(){
        message = Message.builder().id(ID).message(MESSAGE).dateTime(LocalDateTime.now()).build();
    }

    @Test
    void shouldSaveMessage() {
        doNothing().when(mapper).save(any());

        var result = mRepository.save(message);

        assertNotNull(result);
        assertEquals(ID, result.getId());
        assertEquals(MESSAGE, result.getMessage());
    }

    @Test
    void whenSaveMessageThenThrowDynamoException() {
        doThrow(MessagingException.class).when(mapper).save(any());

        var result = assertThrows(DynamoException.class,
                () -> mRepository.save(message));

        assertNotNull(result);
        assertEquals(DynamoException.class, result.getClass());
    }

    @Test
    void findByDate() {

        var result = mRepository.findByDate(message);

        assertEquals(Optional.empty(), result);
    }
}