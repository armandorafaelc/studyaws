package br.com.arc.studyaws.consumer;

import io.awspring.cloud.messaging.config.annotation.EnableSqs;
import io.awspring.cloud.messaging.listener.SqsMessageDeletionPolicy;
import io.awspring.cloud.messaging.listener.annotation.SqsListener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class SQSConsumer {

    @SqsListener(value = "sqs-broadcast", deletionPolicy = SqsMessageDeletionPolicy.ON_SUCCESS)
    public void consume(String  message) {
        if (message != null) {
            log.info("Consumindo mensagem recebida na fila: {}", message);
        }
    }

}
