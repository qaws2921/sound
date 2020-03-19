package com.mes.mesWms.InOut;

import com.mes.Common.DataTransferObject.Message;
import com.mes.Common.DataTransferObject.Page;
import com.mes.Common.DataTransferObject.RESTful;
import com.mes.mesWms.InOut.DTO.WMS_OUT_ORD_SUB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class WmsInOutRestController {
    @Autowired
    private WmsInOutService wmsInOutService;

    @RequestMapping(value="/wmsInListGet" , method = RequestMethod.POST)
    public RESTful wmsInListGet(HttpServletRequest req, Page p){
        return wmsInOutService.wmsInListGet(req, p);
    }

    @RequestMapping(value="/wmsOutListGet" , method = RequestMethod.POST)
    public RESTful wmsOutListGet(HttpServletRequest req, Page p){
        return wmsInOutService.wmsOutListGet(req, p);
    }

    @RequestMapping(value="/wmsOutReadyGet" , method = RequestMethod.POST)
    public RESTful wmsOutReadyGet(HttpServletRequest req, Page p){
        return wmsInOutService.wmsOutReadyGet(req, p);
    }

    @RequestMapping(value="/wmsOutOrderGet" , method = RequestMethod.POST)
    public RESTful wmsOutOrderGet(HttpServletRequest req, Page p){
        return wmsInOutService.wmsOutOrderGet(req, p);
    }

    @RequestMapping(value="/wmsOutOrderSubGet" , method = RequestMethod.POST)
    public RESTful wmsOutOrderSubGet(HttpServletRequest req, Page p){
        return wmsInOutService.wmsOutOrderSubGet(req, p);
    }
    @RequestMapping(value="/wmsOutOrderSubOneGet" , method = RequestMethod.POST)
    public List<WMS_OUT_ORD_SUB> wmsOutOrderSubOneGet(HttpServletRequest req, Page p){
        return wmsInOutService.wmsOutOrderSubOneGet(req, p);
    }

    @RequestMapping(value="/wmsOutOrderAdd" , method = RequestMethod.POST)
    public Message wmsOutOrderAdd(HttpServletRequest req, WMS_OUT_ORD_SUB woos){
        return wmsInOutService.wmsOutOrderAdd(req, woos);
    }
    @RequestMapping(value="/wmsOutOrderDel" , method = RequestMethod.POST)
    public Message wmsOutOrderDel(HttpServletRequest req,  Page p){
        return wmsInOutService.wmsOutOrderDel(req, p);
    }
}
