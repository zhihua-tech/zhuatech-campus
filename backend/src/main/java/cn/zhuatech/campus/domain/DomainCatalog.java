/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.campus.domain;
import org.springframework.stereotype.Component;
import java.util.List;
@Component public class DomainCatalog {
    public String systemName(){return "知华 Campus 智慧校园运营平台";}
    public String sceneName(){return "教学空间、设施、活动与师生服务";}
    public List<SeedItem> seedItems(){return List.of(
        new SeedItem("CAMPUS-20260801-001","一号教学楼空调异常处理","处理中","设施运维组","紧急"),
        new SeedItem("CAMPUS-20260801-002","新生报到服务点准备","待处理","学生服务组","高"),
        new SeedItem("CAMPUS-20260801-003","实验室安全巡检闭环","已完成","安全管理组","中"),
        new SeedItem("CAMPUS-20260801-004","报告厅活动资源协调","处理中","场地运营组","高"));}
    public List<String> recommendedActions(){return List.of("优先恢复影响教学的设施故障","复核大型活动场地与人员保障","跟踪安全巡检问题的责任闭环");}
    public record SeedItem(String recordNo,String title,String status,String owner,String priority){}
}
