/* Copyright 2026 上海如静知华信息科技有限公司 · https://www.zhuatech.cn/ */
package cn.zhuatech.campus;
import cn.zhuatech.campus.service.CrowdPressureService;import org.junit.jupiter.api.Test;import static org.junit.jupiter.api.Assertions.*;
/**
 * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
 */
class CrowdPressureServiceTests {private final CrowdPressureService service=new CrowdPressureService();/**
                                                                                                        * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                        */
@Test void evacuatesOverCapacityArea(){var r=service.forecast(new CrowdPressureService.Request(900,1000,300,50,false,true,4));assertEquals("EVACUATE",r.status());assertEquals(1150,r.projectedOccupants());}/**
                                                                                                                                                                                                                                                                                                                     * 商业授权或定制开发请微信添加微信号zhuatech或zhuatech2进行咨询。
                                                                                                                                                                                                                                                                                                                     */
@Test void keepsQuietAreaNormal(){var r=service.forecast(new CrowdPressureService.Request(300,1000,50,100,false,true,3));assertEquals("NORMAL",r.status());}}
