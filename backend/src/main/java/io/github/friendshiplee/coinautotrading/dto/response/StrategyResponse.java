package io.github.friendshiplee.coinautotrading.dto.response;

import io.github.friendshiplee.coinautotrading.entity.StrategyStatus;
import lombok.Getter;
import org.springframework.boot.autoconfigure.web.WebProperties;

// 클라이언트에게 전략 정보를 응답으로 줄 때 사용하는 DTO
// Entity를 그대로 반환하지 않고 필요한 정보만 선택적 제공
@Getter
public class StrategyResponse {
    private Integer id;
    private String name;
    private String description;

    // Entity <-> DTO 변환
    public StrategyResponse(StrategyStatus strategy) {
        // 사용자에게 보여줄 전략 정보 필드
        this.id = strategy.getId();
        this.name = strategy.getName();
        this.description = strategy.getContent();
    }
}
