package com.mes.mesManager.BOM;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BOMController {
    @RequestMapping(value = "/sysPartNameGroup")
    public String sysPartNameGroup() { return "mesManager/BOM/sysPartNameGroup/sysPartNameGroup"; }

    @RequestMapping(value = "/sysPartNameGroup2")
    public String sysPartNameGroup2() { return "mesManager/BOM/sysPartNameGroup2/sysPartNameGroup2"; }





    @RequestMapping(value = "/sysSPart")
    public String sysSPart() {
        return "mesManager/BOM/sysSPart/sysSPart";
    }

}
