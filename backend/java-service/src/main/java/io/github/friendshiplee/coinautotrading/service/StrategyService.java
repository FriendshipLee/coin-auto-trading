package io.github.friendshiplee.coinautotrading.service;

import io.github.friendshiplee.coinautotrading.dto.request.CreateStrategyRequest;
import io.github.friendshiplee.coinautotrading.dto.response.StrategyResponse;
import io.github.friendshiplee.coinautotrading.entity.StrategyStatus;
import io.github.friendshiplee.coinautotrading.repository.StrategyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

// 실제 전략 저장 및 조회 로직 처리
@Service
@RequiredArgsConstructor // 생성자 자동 주입 (final 필드 대상)
public class StrategyService {
    private final StrategyRepository strategyRepository;

    public void saveStrategy(CreateStrategyRequest request){
        StrategyStatus strategyStatus = new StrategyStatus();
        strategyStatus.setName(request.getName());
        strategyStatus.setContent(request.getDescription());
        strategyRepository.save(strategyStatus);
    }

    public List<StrategyResponse> getAllStrategies(){
        return strategyRepository.findAll()
                .stream() // 리스트를 가공, 변환, 필터링
                //Entity -> DTO변환 (Strategy 객체를 StrategyResponse 생성자로 변환)
                // map(strategy -> new StrategyResponse(strategy))와 동일
                .map(StrategyResponse::new)
                .collect(Collectors.toList()); //steam 작업이 끝난 후 다시 List로 수집

        //List<Strategy> entityList = strategyRepository.findAll();
        //List<StrategyResponse> dtoList = new ArrayList<>();
        //for (Strategy strategy : entityList) {
        //  dtoList.add(new StrategyResponse(strategy));
        //}
        //return dtoList;
    }
}
