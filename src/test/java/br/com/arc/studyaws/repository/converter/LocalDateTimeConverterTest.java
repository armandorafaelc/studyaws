package br.com.arc.studyaws.repository.converter;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoSettings;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.assertEquals;

@MockitoSettings
class LocalDateTimeConverterTest {

    @InjectMocks
    private LocalDateTimeConverter localDateTimeConverter;

    private LocalDateTime localDateTime = LocalDateTime.now();
    private String localDateTimeString = localDateTime.toString();

    @Test
    void convert() {

        var result = localDateTimeConverter.convert(localDateTime);

        assertEquals(localDateTimeString, result);
    }

    @Test
    void unconvert() {
        var result = localDateTimeConverter.unconvert(localDateTimeString);

        assertEquals(localDateTime, result);
    }
}