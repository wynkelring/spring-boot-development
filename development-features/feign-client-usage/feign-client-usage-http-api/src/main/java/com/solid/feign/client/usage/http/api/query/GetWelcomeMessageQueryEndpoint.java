package com.solid.feign.client.usage.http.api.query;

import com.solid.feign.client.usage.api.service.query.result.GetWelcomeMessageQueryResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// request mapping not allowed on inherited interface
public interface GetWelcomeMessageQueryEndpoint {

    String STH = "STH";
    String QP = "qp";

    @GetMapping("/message/welcome/{" + STH + "}")
    @ResponseBody
    GetWelcomeMessageQueryResult handle(@PathVariable(STH) String sth, @RequestParam(QP) String qp);
}
