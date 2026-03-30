package com.auction.controller;

import com.auction.model.BidMessage;
import com.auction.service.AuctionService;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

@Controller
public class BidWebSocketController {

    private final AuctionService service;
    private final SimpMessagingTemplate template;

    public BidWebSocketController(AuctionService s, SimpMessagingTemplate t) {
        service = s;
        template = t;
    }

    @MessageMapping("/bid")
    public void bid(BidMessage b) {
        service.placeBid(b.getItemId(), b.getBidder(), b.getAmount());
        template.convertAndSend("/topic/bids", b);
    }
}