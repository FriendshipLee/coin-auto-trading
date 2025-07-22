package io.github.friendshiplee.coinautotrading.repository;

import io.github.friendshiplee.coinautotrading.entity.StrategyStatus;
import org.springframework.data.jpa.repository.JpaRepository;

// JPA를 활용한 DB 접근
// CRUD 쿼리 자동 처리
public interface StrategyRepository extends JpaRepository<StrategyStatus, Integer>{

}
