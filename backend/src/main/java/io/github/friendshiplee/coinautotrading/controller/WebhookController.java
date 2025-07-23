package io.github.friendshiplee.coinautotrading.controller;

import io.github.friendshiplee.coinautotrading.dto.request.WebhookRequest;
import io.github.friendshiplee.coinautotrading.service.WebhookService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/webhook")
@RequiredArgsConstructor
@Slf4j //로그 생성
public class WebhookController {

    private final WebhookService webhookService;

    @PostMapping
    public ResponseEntity<String> receiveAlert(@RequestBody WebhookRequest request){
        log.info("Webhook Received: {}", request);
        webhookService.processAlert(request);
        return ResponseEntity.ok("Webhook received");
    }
}
