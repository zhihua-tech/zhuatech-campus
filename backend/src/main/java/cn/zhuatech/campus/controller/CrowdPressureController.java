/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.campus.controller;
import cn.zhuatech.campus.common.ApiResponse;import cn.zhuatech.campus.service.CrowdPressureService;import jakarta.validation.Valid;import org.springframework.web.bind.annotation.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
@RestController @RequestMapping("/api/campus/insights/crowd-pressure") public class CrowdPressureController {private final CrowdPressureService service;/**
                                                                                                                                                         * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                         */
public CrowdPressureController(CrowdPressureService service){this.service=service;}/**
                                                                                                                                                                                                                                            * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                            */
@PostMapping ApiResponse<CrowdPressureService.Result> forecast(@Valid @RequestBody CrowdPressureService.Request request){return ApiResponse.ok(service.forecast(request));}}
