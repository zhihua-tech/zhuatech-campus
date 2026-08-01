/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.campus.controller;

import cn.zhuatech.campus.common.ApiResponse;
import cn.zhuatech.campus.service.ServiceTriageService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/admin/service-triage")
public class ServiceTriageController {
    private final ServiceTriageService service;
    public ServiceTriageController(ServiceTriageService service) { this.service = service; }
    @PostMapping
    ApiResponse<ServiceTriageService.TriageResult> triage(
        @Valid @RequestBody ServiceTriageService.TriageRequest request) {
        return ApiResponse.ok(service.triage(request));
    }
}
