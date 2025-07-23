package io.github.friendshiplee.coinautotrading.dto.request;

import lombok.Getter;
import lombok.Setter;

//전략을 생성할 때 보내는 요청 값을 담는 DTO
//Entity와 분리되어 외부에서 입력받는 값만 포함
@Setter
@Getter
public class CreateStrategyRequest {
    // 프론트에서 입력한 전략 이름, 설명
    private String name;
    private String description;
}
