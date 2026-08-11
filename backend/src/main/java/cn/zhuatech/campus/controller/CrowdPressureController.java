/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.campus.controller;
import cn.zhuatech.campus.common.ApiResponse;import cn.zhuatech.campus.service.CrowdPressureService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
@RestController @RequestMapping("/api/campus/insights/crowd-pressure") public class CrowdPressureController {private final CrowdPressureService service;public CrowdPressureController(CrowdPressureService service){this.service=service;}@PostMapping ApiResponse<CrowdPressureService.Result> forecast(@Valid @RequestBody CrowdPressureService.Request request){return ApiResponse.ok(service.forecast(request));}}
