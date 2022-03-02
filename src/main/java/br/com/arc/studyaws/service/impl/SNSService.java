package br.com.arc.studyaws.service.impl;

import br.com.arc.studyaws.exception.SnsException;
import br.com.arc.studyaws.service.ISNSService;
import io.awspring.cloud.messaging.core.NotificationMessagingTemplate;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class SNSService implements ISNSService {

    @Autowired
    private NotificationMessagingTemplate notificationMessagingTemplate;

    @SneakyThrows
    @Override
    public void send(String topic_name, String message) {
        try {
            notificationMessagingTemplate.convertAndSend(topic_name, message);
            log.info("Mensagem postada no topico ({}) com sucesso.",topic_name);
        }catch (Exception e){
            throw new SnsException(e.getMessage());
        }
    }
}
