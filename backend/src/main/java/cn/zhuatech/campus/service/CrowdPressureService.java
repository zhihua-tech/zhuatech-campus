/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.campus.service;
import jakarta.validation.constraints.*;import org.springframework.stereotype.Service;import java.util.*;
@Service public class CrowdPressureService {
 public Result forecast(Request r){int projected=Math.max(0,r.currentOccupants()+r.expectedArrivals15Minutes()-r.expectedDepartures15Minutes());double rate=Math.round(projected*1000.0/r.safeCapacity())/10.0;List<String> actions=new ArrayList<>();if(rate>=90)actions.add("启动入口限流并引导人员分流");if(!r.allExitsAvailable())actions.add("立即恢复疏散出口可用性");if(r.criticalEvent())actions.add("通知校园应急和值守团队到场");if(r.securityStaff()<2)actions.add("补充现场秩序维护人员");String status=!r.allExitsAvailable()&&rate>=80||rate>=110?"EVACUATE":rate>=85||r.criticalEvent()?"CONTROL":"NORMAL";if(actions.isEmpty())actions.add("保持常态监测并每十五分钟刷新预测");return new Result(projected,rate,status,actions);}
 public record Request(@Min(0) int currentOccupants,@Min(1) int safeCapacity,@Min(0) int expectedArrivals15Minutes,@Min(0) int expectedDepartures15Minutes,@NotNull Boolean criticalEvent,@NotNull Boolean allExitsAvailable,@Min(0) int securityStaff){}
 public record Result(int projectedOccupants,double projectedOccupancyRate,String status,List<String> actions){}
}
