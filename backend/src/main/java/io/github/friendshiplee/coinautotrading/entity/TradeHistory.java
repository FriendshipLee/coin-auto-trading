package io.github.friendshiplee.coinautotrading.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "trade_history")
public class TradeHistory {

    @Id //pk
    @GeneratedValue(strategy = GenerationType.IDENTITY) //auto_increment
    private int id;

    // 전략 참조 : 다대일
    // fetch : Straegy는 실제로 필요할 때만 DB에서 불러옴
    // Strategy() 를 호출할 때 SELECT 실행 (성능최적)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "strategy_id", nullable = false)
    private StrategyStatus strategyStatus;

    @Column(name = "trade_type", columnDefinition = "INT DEFAULT 0")
    private Integer tradeType;

    @Column(name = "entry_price")
    private float entryPrice;

    @Column(name = "exit_price")
    private float exitPrice;

    @Column
    private float quantity;

    @Column
    private float profit;

    @CreationTimestamp
    @Column(name = "entry_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp entryDate;

    @UpdateTimestamp
    @Column(name = "exit_date")
    private Timestamp exitDate;

}
