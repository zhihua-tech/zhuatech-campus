/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.campus.controller;

import cn.zhuatech.campus.common.ApiResponse;
import cn.zhuatech.campus.service.ServiceTriageService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController
@RequestMapping("/api/admin/service-triage")
public class ServiceTriageController {
    private final ServiceTriageService service;
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    public ServiceTriageController(ServiceTriageService service) { this.service = service; }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @PostMapping
    ApiResponse<ServiceTriageService.TriageResult> triage(
        @Valid @RequestBody ServiceTriageService.TriageRequest request) {
        return ApiResponse.ok(service.triage(request));
    }
}
