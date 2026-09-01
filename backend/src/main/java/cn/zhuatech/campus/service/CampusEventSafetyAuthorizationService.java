/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.campus.service;

import jakarta.validation.constraints.NotBlank;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;

@Service
public class CampusEventSafetyAuthorizationService {
    public Assessment assess(Request request) {
        List<String> blockers = new ArrayList<>();
        List<String> actions = new ArrayList<>();
        if (!request.permitApproved()) blockers.add("活动许可未批准");
        if (!request.capacityWithinLimit()) blockers.add("预计人数超过场地安全容量");
        if (!request.evacuationPlanApproved()) blockers.add("疏散方案未批准");
        if (!request.emergencyServicesCoordinated()) blockers.add("应急力量未协调");
        if (!request.accessControlReady()) blockers.add("人员与车辆准入控制未就绪");
        if (!request.medicalCoverageReady()) blockers.add("现场医疗保障未就绪");
        if (request.minorsInvolved() && !request.safeguardingApproved()) blockers.add("未成年人保护方案未批准");
        if (!request.finalApprovalComplete()) blockers.add("活动最终审批未完成");
        if (!blockers.isEmpty()) {
            actions.add("阻断活动举办并完成安全与许可整改");
            return new Assessment(Decision.BLOCKED, blockers, actions);
        }
        if (!request.weatherContingencyReady() || !request.trafficPlanReady() || !request.emergencyCommunicationTested()) {
            if (!request.weatherContingencyReady()) actions.add("补齐极端天气取消、延期或转场方案");
            if (!request.trafficPlanReady()) actions.add("完善人车分流与高峰疏导方案");
            if (!request.emergencyCommunicationTested()) actions.add("测试广播、短信和指挥通信链路");
            return new Assessment(Decision.CONDITIONAL, blockers, actions);
        }
        actions.add("批准活动并归档许可、容量、保障和演练证据");
        return new Assessment(Decision.AUTHORIZE, blockers, actions);
    }

    public record Request(@NotBlank String eventId, boolean permitApproved, boolean capacityWithinLimit,
                          boolean evacuationPlanApproved, boolean emergencyServicesCoordinated,
                          boolean accessControlReady, boolean medicalCoverageReady,
                          boolean minorsInvolved, boolean safeguardingApproved,
                          boolean weatherContingencyReady, boolean trafficPlanReady,
                          boolean emergencyCommunicationTested, boolean finalApprovalComplete) {}
    public record Assessment(Decision decision, List<String> blockers, List<String> actions) {}
    public enum Decision { AUTHORIZE, CONDITIONAL, BLOCKED }
}
