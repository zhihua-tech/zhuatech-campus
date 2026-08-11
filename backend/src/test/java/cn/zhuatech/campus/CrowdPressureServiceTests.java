/* Copyright 2026 上海如静知华信息科技有限公司 */
package cn.zhuatech.campus;
import cn.zhuatech.campus.service.CrowdPressureService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
class CrowdPressureServiceTests {private final CrowdPressureService service=new CrowdPressureService();@Test void evacuatesOverCapacityArea(){var r=service.forecast(new CrowdPressureService.Request(900,1000,300,50,false,true,4));assertEquals("EVACUATE",r.status());assertEquals(1150,r.projectedOccupants());}@Test void keepsQuietAreaNormal(){var r=service.forecast(new CrowdPressureService.Request(300,1000,50,100,false,true,3));assertEquals("NORMAL",r.status());}}
