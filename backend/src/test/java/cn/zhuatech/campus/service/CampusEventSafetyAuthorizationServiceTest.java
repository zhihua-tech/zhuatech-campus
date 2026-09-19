/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.campus.service;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class CampusEventSafetyAuthorizationServiceTest {
    private final CampusEventSafetyAuthorizationService service = new CampusEventSafetyAuthorizationService();
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void authorizesSafeEvent() {
        var r = service.assess(new CampusEventSafetyAuthorizationService.Request("E1", true, true, true,
                true, true, true, true, true, true, true, true, true));
        assertThat(r.decision()).isEqualTo(CampusEventSafetyAuthorizationService.Decision.AUTHORIZE);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void conditionallyApprovesOperationalGaps() {
        var r = service.assess(new CampusEventSafetyAuthorizationService.Request("E2", true, true, true,
                true, true, true, false, false, false, false, false, true));
        assertThat(r.actions()).hasSize(3);
    }
    /**
     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
     */
    @Test void blocksUnsafeEvent() {
        var r = service.assess(new CampusEventSafetyAuthorizationService.Request("E3", false, false, false,
                false, false, false, true, false, true, true, true, false));
        assertThat(r.blockers()).hasSize(8);
    }
}
