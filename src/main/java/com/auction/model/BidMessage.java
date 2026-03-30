package com.auction.model;

public class BidMessage {

    private Long itemId;
    private String bidder;
    private double amount;

    public Long getItemId() { return itemId; }
    public void setItemId(Long itemId) { this.itemId = itemId; }

    public String getBidder() { return bidder; }
    public void setBidder(String bidder) { this.bidder = bidder; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }
}