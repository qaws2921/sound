package com.mes.mesWms.Stock;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WmsStockController {
    @RequestMapping(value = "/wmsStock")
    public String wmsStock() {
        return "mesWms/Stock/wmsStock/wmsStock";
    }

    @RequestMapping(value = "/wmsStockIOSumDay")
    public String wmsStockIOSumDay() {
        return "mesWms/Stock/wmsStockIOSumDay/wmsStockIOSumDay";
    }

    @RequestMapping(value = "/wmsStockIOSumMonth")
    public String wmsstockiosummonth() {
        return "mesWms/Stock/wmsStockIOSumMonth/wmsStockIOSumMonth";
    }


}
