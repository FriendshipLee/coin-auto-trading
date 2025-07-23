package io.github.friendshiplee.coinautotrading.service;

import io.github.friendshiplee.coinautotrading.dto.request.WebhookRequest;
import io.github.friendshiplee.coinautotrading.entity.TradeHistory;
import io.github.friendshiplee.coinautotrading.repository.TradeHistoryRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class WebhookService {

    private final TradeHistoryRepository tradeHistoryRepository;

    public void processAlert(WebhookRequest request){

        int type = request.getAction().equalsIgnoreCase("long") ? 1 : 0;

        TradeHistory trade = new TradeHistory();
        trade.setTradeType(type);
        trade.setEntryPrice(request.getEntryPrice());
        trade.setExitPrice(request.getExitPrice());
        trade.setProfit(0.0F);
        trade.setQuantity(request.getQuantity());
        trade.setEntryDate(Timestamp.valueOf(LocalDateTime.now()));

        tradeHistoryRepository.save(trade);
        log.info("Trade saved to DB: {}", trade);
    }
}
