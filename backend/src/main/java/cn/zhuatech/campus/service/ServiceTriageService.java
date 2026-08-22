/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.campus.service;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceTriageService {
    public TriageResult triage(TriageRequest request) {
        int score = request.severity() * 12
            + Math.min(20, request.affectedPeople() / 10)
            + (request.safetyRelated() ? 25 : 0)
            + (request.accessibilityBlocked() ? 15 : 0)
            + Math.min(10, request.hoursOpen() / 12);
        score = Math.min(100, score);
        String priority = score >= 75 ? "EMERGENCY" : score >= 50 ? "HIGH" : score >= 25 ? "NORMAL" : "LOW";
        int responseMinutes = switch (priority) {
            case "EMERGENCY" -> 10;
            case "HIGH" -> 30;
            case "NORMAL" -> 240;
            default -> 480;
        };
        List<String> actions = new ArrayList<>();
        if (request.safetyRelated()) actions.add("通知校园安全值班人员并建立现场警戒");
        if (request.accessibilityBlocked()) actions.add("优先恢复无障碍通行并提供临时引导");
        if (request.affectedPeople() >= 100) actions.add("发布服务影响通知并设置分流方案");
        if (actions.isEmpty()) actions.add("按服务目录分派责任部门并跟踪处理时限");
        return new TriageResult(score, priority, responseMinutes, actions);
    }

    public record TriageRequest(@NotNull @Min(1) @Max(5) Integer severity,
        @NotNull @Min(0) @Max(100000) Integer affectedPeople,
        @NotNull Boolean safetyRelated, @NotNull Boolean accessibilityBlocked,
        @NotNull @Min(0) @Max(10000) Integer hoursOpen) {}
    public record TriageResult(int score, String priority, int responseMinutes, List<String> actions) {}
}
