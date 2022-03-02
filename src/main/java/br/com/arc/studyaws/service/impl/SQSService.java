package br.com.arc.studyaws.service.impl;

import br.com.arc.studyaws.exception.SqsException;
import br.com.arc.studyaws.service.ISQSService;
import io.awspring.cloud.messaging.core.QueueMessagingTemplate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SQSService implements ISQSService {

    @Autowired
    private QueueMessagingTemplate messagingTemplate;

    @SneakyThrows
    @Override
    public void send(final String queue,final String message) {
        try {
            Message<String> msg = MessageBuilder.withPayload(message).build();
            messagingTemplate.convertAndSend(queue, msg);
            log.info("Mensagem postada na fila({}}) com sucesso.",queue);
        }catch (Exception e){
            throw new SqsException(e.getMessage());
        }
    }
}
