package br.com.arc.studyaws.controller;

import br.com.arc.studyaws.service.impl.SQSService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;


@Slf4j
@org.springframework.web.bind.annotation.RestController
public class RestController {

    private static String queue_name = "sqs-broadcast";

    @Autowired
    private SQSService service;

    @GetMapping("/teste")
    public void getTeste() {

        try {
            service.send(queue_name, "Hello World");
        }catch (Exception e){
            log.error("Erro ao postar mensagem fila: {}", e.getMessage());
        }

    }

}
