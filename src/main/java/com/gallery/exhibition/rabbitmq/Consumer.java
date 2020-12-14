package com.gallery.exhibition.rabbitmq;

import com.gallery.exhibition.model.Exhibition;
import com.gallery.exhibition.service.ExhibitionService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    ExhibitionService exhibitionsService;

    @RabbitListener(queues = "${rabbitmq.queue}")
    public void consume(Exhibition exhibition) {
        exhibitionsService.addExhibition(exhibition);
    }
}
