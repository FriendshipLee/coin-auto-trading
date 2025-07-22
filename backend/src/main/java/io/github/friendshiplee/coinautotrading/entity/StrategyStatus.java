package io.github.friendshiplee.coinautotrading.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
@NoArgsConstructor
@Table(name = "strategy_status")
public class StrategyStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false, columnDefinition = "INT DEFAULT 0")
    private Integer enabled;

    //Hibernate가 Insert시 자동으로 현재 시간 입력
    @CreationTimestamp
    @Column(name = "create_date", nullable = false, updatable = false, columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp createDate;
    
    //Hibernate가 Update시 자동으로 현재 시간 입력
    @UpdateTimestamp
    @Column(name = "update_date")
    private Timestamp updateDate;

    //TEXT타입과 매핑되는 JPA 어노테이션 (Lob)
    @Lob
    @Column(columnDefinition = "TEXT")
    private String content;

    //양방향 매핑 (1:N)
    //cascade : Strategy 엔티티에 대한 작업(CRUD)를 하면, 연관된 TradeHistory도 자동 전파
    //orphanRemoval : 부모(Strategy)에서 거래내역을 리스트에서 제거하면 DB에서도 삭제
    @OneToMany(mappedBy = "strategyStatus", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TradeHistory> tradeHistories = new ArrayList<>();

}
