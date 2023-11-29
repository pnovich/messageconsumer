package com.example.messageconsumer;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
public class TicketsKafkaListener {

    @Autowired
    ModelMapper modelMapper;
//    @Autowired
//    TicketServiceInMemoryImplementation ticketService;
//
//    @Autowired
//    GeneralTicketService generalTicketService;

//    volatile int kafkaCount = 0;

   @Autowired
   TicketService ticketService;

    @KafkaListener(topics = "topic1",
            groupId = "tickets1",
            properties = {"bootstrap.server=localhost:9092"})
//            topics = "topic1",
//            groupId = "allTicketsGroup1",
////            properties = {"spring.json.value.default.type=com.example.service2.TicketDTO"},
//            containerFactory = "kafkaListenerContainerFactory"
//    )
    public void listenTicketsGroup(
            @Payload String ticket
    ) {
//        kafkaCount++;
        System.out.println("received ticket from kafka");
        ticketService.saveTicket(ticket);
//        generalTicketService.applyTicket(ticket, "kafka", kafkaCount);
    }
}
