package com.mes.mesQms.Shipment;


import lombok.extern.slf4j.Slf4j;
import com.mes.Common.DataTransferObject.Message;
import com.mes.Common.DataTransferObject.Page;
import com.mes.Common.DataTransferObject.RESTful;
import com.mes.Common.File.DTO.Files;
import com.mes.Common.File.Function.UploadFunction;
import com.mes.mesQms.Shipment.DTO.QMS_PROD_NG_SUM;
import com.mes.mesQms.Shipment.DTO.QMS_PROD_RPT;
import com.mes.mesQms.Shipment.DTO.QMS_PROD_SUB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@Slf4j
public class QmsShipmentRestController extends UploadFunction {

    @Autowired
    private QmsShipmentService qmsShipmentService;

    @RequestMapping(value ="/qmsProdErrorManGet", method = RequestMethod.POST)
    public RESTful qmsProdErrorManGet(Page p, HttpServletRequest req) { return qmsShipmentService.qmsProdErrorManGet(p, req); }

    @RequestMapping(value = "/qmsProdGet", method = RequestMethod.POST)
    public RESTful qmsProdGet(Page p, HttpServletRequest req) {
        return qmsShipmentService.qmsProdGet(p, req);
    }
    @RequestMapping(value = "/qmsProdSubGet", method = RequestMethod.POST)
    public RESTful qmsProdSubGet(Page p, HttpServletRequest req) {
        return qmsShipmentService.qmsProdSubGet(p, req);
    }
    @RequestMapping(value = "/qmsProdSubAllGet", method = RequestMethod.POST)
    public List<QMS_PROD_SUB> qmsProdSubAllGet(Page p, HttpServletRequest req) {
        return qmsShipmentService.qmsProdSubAllGet(p, req);
    }
    @RequestMapping(value = "/qmsProdAdd", method = RequestMethod.POST)
    public Message qmsProdAdd(HttpServletRequest req, QMS_PROD_SUB qps) {
        return qmsShipmentService.qmsProdAdd(req, qps);
    }

    @RequestMapping(value = "/qmsProdListGet", method = RequestMethod.POST)
    public RESTful qmsProdListGet(Page p, HttpServletRequest req) { return qmsShipmentService.qmsProdListGet(p, req); }

    @RequestMapping(value = "/qmsProdListRPTGet", method = RequestMethod.POST)
    public List<QMS_PROD_RPT> qmsProdListRPTGet(Page p, HttpServletRequest req) { return qmsShipmentService.qmsProdListRPTGet(p, req); }

    @RequestMapping(value ="/qmsProdErrorManOneGet", method = RequestMethod.POST)
    public QMS_PROD_SUB qmsProdErrorManOneGet(QMS_PROD_SUB qmsProdSub, HttpServletRequest req){
        return qmsShipmentService.qmsProdErrorManOneGet(qmsProdSub, req);
    }

    @RequestMapping(value = "/qmsProdMRBGet", method = RequestMethod.POST)
    public RESTful qmsProdMRBGet(Page p, HttpServletRequest req){ return qmsShipmentService.qmsProdMRBGet(p, req); }

    @RequestMapping(value = "/qmsProdMRBAdd", method = RequestMethod.POST)
    public Message qmsProdMRBAdd(HttpServletRequest req, QMS_PROD_SUB qps) {
        return qmsShipmentService.qmsProdMRBAdd(req, qps);
    }

    @RequestMapping(value = "/qmsProdMRBCancel", method = RequestMethod.POST)
    public Message qmsProdMRBCancel(HttpServletRequest req, QMS_PROD_SUB qps) {
        return qmsShipmentService.qmsProdMRBCancel(req, qps);
    }
    @RequestMapping(value = "/qmsProdErrorManAdd", method = RequestMethod.POST)
    public String qmsProdErrorManAdd(MultipartHttpServletRequest req){
        Files files = new Files();
        files.setKey1(req.getParameter("in_no"));
        files.setKey2(req.getParameter("part_code"));
        files.setKey3(req.getParameter("act_type"));
        int check1 = Integer.parseInt(req.getParameter("check1"));
        int check2 = Integer.parseInt(req.getParameter("check2"));
        if(check1+check2 == 0)
        {
            qmsShipmentService.qmsProdErrorManAdd_NoneFile(files, req);
        }
        if(check1 == 0 && check2 == 1)
        {
            qmsShipmentService.qmsProdErrorManAdd_File3(files, req);
        }
        if(check2 == 0 && check1 == 1)
        {
            qmsShipmentService.qmsProdErrorManAdd_File2(files, req);
        }
        if(check1+check2 == 2)
        {
            qmsShipmentService.qmsProdErrorManAdd_AllFile(files, req);
        }
        return "수정되었습니다.";
    }

    @RequestMapping(value = "/qmsProdErrorListSumGet", method = RequestMethod.POST)
    public List<QMS_PROD_NG_SUM> qmsProdErrorListSumGet(Page p, HttpServletRequest req) {
        return qmsShipmentService.qmsProdErrorListSumGet(p, req);
    }

}
