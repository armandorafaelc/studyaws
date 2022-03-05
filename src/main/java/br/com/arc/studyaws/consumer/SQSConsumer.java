package br.com.arc.studyaws.consumer;

import br.com.arc.studyaws.consumer.dto.MessageDTO;
import io.awspring.cloud.messaging.config.annotation.EnableSqs;
import io.awspring.cloud.messaging.config.annotation.NotificationMessage;
import io.awspring.cloud.messaging.listener.Acknowledgment;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Slf4j
@Service
public class SQSConsumer {

    @SqsListener(value = "sqs-broadcast", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void consume(MessageDTO message) throws Exception{
        if (Objects.nonNull(message)) {
            log.info("Consumindo mensagem recebida na fila: {}", message);
        }
    }

}
