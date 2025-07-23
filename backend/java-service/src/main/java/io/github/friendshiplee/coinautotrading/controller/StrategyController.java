package io.github.friendshiplee.coinautotrading.controller;

import io.github.friendshiplee.coinautotrading.dto.request.CreateStrategyRequest;
import io.github.friendshiplee.coinautotrading.dto.response.StrategyResponse;
import io.github.friendshiplee.coinautotrading.service.StrategyService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// /api/strategies 로 들어오는 HTTP 요청 받아 처리
// 요청을 Service 계층에 위임하고 응답 반환
@RestController // REST API 응답 전용 컨트롤러
@RequestMapping("/api/strategies") // API 기본 uri 설정
@RequiredArgsConstructor //초기화 되지않은 final 필드나, @NonNull 이 붙은 필드에 대해 생성자 생성
@Tag(name = "전략 관리", description = "전략 등록, 조회 등의 API")
public class StrategyController {
    private final StrategyService strategyService;

    // 전략 생성 API
    @PostMapping
    @Operation(summary = "전략 생성", description = "새로운 자동매매 전략을 등록합니다.")
    // RequestBody : JSON 요청 본문을 DTO로 바인딩
    public ResponseEntity<Void> createStrategy(@RequestBody CreateStrategyRequest request){
        strategyService.saveStrategy(request);
        return ResponseEntity.ok().build();
    }

    // 전략 전체 조회 API
    @GetMapping
    @Operation(summary = "전략 목록 조회", description = "등록된 모든 전략을 조회합니다.")
    public ResponseEntity<List<StrategyResponse>> getStrategies(){
        List<StrategyResponse> strategies = strategyService.getAllStrategies();
        return ResponseEntity.ok(strategies);
    }
}
