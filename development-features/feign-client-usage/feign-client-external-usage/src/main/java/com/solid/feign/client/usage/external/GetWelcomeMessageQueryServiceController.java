package com.solid.feign.client.usage.external;

import com.solid.feign.client.usage.api.service.query.result.GetWelcomeMessageQueryResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class GetWelcomeMessageQueryServiceController {

    private final ClientGetWelcomeMessageQueryService clientHandler;
    private final UserGetWelcomeMessageQueryService userHandler;

    @GetMapping("/http-api/welcome/test")
    @ResponseBody
    public GetWelcomeMessageQueryResult handle(@RequestParam Boolean isUser) {
        if (isUser) return userHandler.handle("sth", "qp");
        return clientHandler.handle("something", "qp");
    }
}
