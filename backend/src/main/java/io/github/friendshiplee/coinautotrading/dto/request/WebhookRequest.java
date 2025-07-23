package io.github.friendshiplee.coinautotrading.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WebhookRequest {
    private String symbol;
    private String action;
    private Float entryPrice;
    private Float exitPrice;
    private String strategy;
    private Float Quantity;

    public Float getEffectivePrice(){
        return entryPrice != null ? entryPrice : exitPrice;
    }

    @Override
    public String toString(){
        return "[Webhook] " + strategy + " | " + action + " | " + symbol + " | " + Quantity + " | price = " + getEffectivePrice();
    }
}
