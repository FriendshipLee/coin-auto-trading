package io.github.friendshiplee.coinautotrading.repository;

import io.github.friendshiplee.coinautotrading.entity.TradeHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TradeHistoryRepository extends JpaRepository<TradeHistory, Long> {
}
