package br.com.arc.studyaws.controller;

import br.com.arc.studyaws.repository.entity.Message;
import br.com.arc.studyaws.repository.impl.MessageRepository;
import br.com.arc.studyaws.service.impl.SNSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;

@Slf4j
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static String queue_name = "topic_sns";

    @Autowired
    private SNSService service;

    @Autowired
    private MessageRepository repos;


    @GetMapping("/teste")
    public void getTeste() {

        try {
            service.send(queue_name, "Hello World");
            repos.save(
                    Message.builder()
                            .message("teste")
                            .dateTime(LocalDateTime.now())
                            .build()
            );

        }catch (Exception e){
            log.error("Erro ao postar mensagem fila: {}", e.getMessage());
        }

    }

}
