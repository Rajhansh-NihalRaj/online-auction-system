package com.auction.service;

import com.auction.model.AuctionItem;
import com.auction.repository.AuctionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuctionService {

    private final AuctionRepository repo;

    public AuctionService(AuctionRepository repo) {
        this.repo = repo;
    }

    public List<AuctionItem> getAllItems() {
        return repo.findAll();
    }

    public void addItem(String name, String desc, double price) {
        AuctionItem item = new AuctionItem();
        item.setName(name);
        item.setDescription(desc);
        item.setHighestBid(price);
        item.setHighestBidder("None");
        item.setEndTime(System.currentTimeMillis() + 60000);
        item.setActive(true);
        repo.save(item);
    }

    public void placeBid(Long id, String bidder, double amount) {
        AuctionItem item = repo.findById(id).orElseThrow();

        if (System.currentTimeMillis() > item.getEndTime()) {
            item.setActive(false);
            return;
        }

        if (amount > item.getHighestBid()) {
            item.setHighestBid(amount);
            item.setHighestBidder(bidder);
            repo.save(item);
        }
    }
}