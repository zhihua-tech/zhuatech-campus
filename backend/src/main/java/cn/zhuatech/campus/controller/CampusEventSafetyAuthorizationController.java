/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.campus.controller;

import cn.zhuatech.campus.common.ApiResponse;
import cn.zhuatech.campus.service.CampusEventSafetyAuthorizationService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/enterprise/campus")
public class CampusEventSafetyAuthorizationController {
    private final CampusEventSafetyAuthorizationService service;
    public CampusEventSafetyAuthorizationController(CampusEventSafetyAuthorizationService service) { this.service = service; }
    @PostMapping("/event-safety-authorization")
    public ApiResponse<CampusEventSafetyAuthorizationService.Assessment> assess(
            @Valid @RequestBody CampusEventSafetyAuthorizationService.Request request) {
        return ApiResponse.ok(service.assess(request));
    }
}
