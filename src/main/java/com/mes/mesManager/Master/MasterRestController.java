package com.mes.mesManager.Master;

import com.mes.Common.DataTransferObject.Message;
import com.mes.Common.DataTransferObject.Page;
import com.mes.Common.DataTransferObject.RESTful;
import com.mes.mesManager.Master.DTO.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class MasterRestController {

    @Autowired
    private MasterService masterService;
    //공통코드관리
    //공통코드관리 코드그룹 목록
    @RequestMapping(value="/getCommonGroup", method = RequestMethod.POST)
    public List<SYSCommon> getCommonGroup(HttpServletRequest req, Page p){ return masterService.getCommonGroup(req, p); }
    //공통코드관리 그리드 리스트 조회
    @RequestMapping(value="/sysCommonGet", method = RequestMethod.POST)
    public RESTful sysCommonGet(HttpServletRequest req, Page p){
        return masterService.sysCommonGet(req, p);
    }
    //공통코드관리 공통코드 추가
    @RequestMapping(value="/sysCommonAdd", method = RequestMethod.POST)
    public Message sysCommonAdd(HttpServletRequest req, SYSCommon vo) {
        return masterService.sysCommonAdd(req, vo);
    }
    //공통코드관리 공통코드 삭제
    @RequestMapping(value="/sysCommonDelete", method = RequestMethod.POST)
    public Message sysCommonDelete(HttpServletRequest req, Page p){
        return masterService.sysCommonDelete(req,p);
    }
    //공통코드관리 공통코드 수정 시 그리드에서 하나의 항목 값 조회
    @RequestMapping(value="/sysCommonOneGet", method = RequestMethod.POST)
    public SYSCommon sysCommonOneGet(HttpServletRequest req, Page p){
        return masterService.sysCommonOneGet(req, p);
    }

    //메세지관리
    //메세지관리 메세지 목록
    @RequestMapping(value="/sysMsgGet", method = RequestMethod.POST)
    public RESTful sysMsg(Page p){
        return masterService.sysMsgGet(p);
    }
    //메세지관리 메세지 추가
    @RequestMapping(value="/sysMsgAdd", method = RequestMethod.POST)
    public  Message sysMsgAdd(HttpServletRequest req, SYSMsg smv){
        return masterService.sysMsgAdd(req, smv);
    }
    //메세지관리 메세지 삭제
    @RequestMapping(value="/sysMsgDelete", method = RequestMethod.POST)
    public Message sysMsgDelete(Page p){
        return masterService.sysMsgDelete(p);
    }
    //메세지관리 메세지 수정 시 그리드에서 하나의 항목 값 조회
    @RequestMapping(value="/sysMsgOneGet", method = RequestMethod.POST)
    public SYSMsg sysMsgOneGet(Page p) { return masterService.sysMsgOneGet(p); }

    @RequestMapping(value="/sysBoardOneGet", method = RequestMethod.POST)
    public SYSBoard sysBoardOneGet(HttpServletRequest req, Page p) {
        return masterService.sysBoardOneGet(req, p);
    }

    @RequestMapping(value="/sysCommonDutyGet", method = RequestMethod.POST)
    public List<SYSCommon> sysCommonDutyGet(HttpServletRequest req, Page p){
        return masterService.sysCommonDutyGet(req, p);
    }

    @RequestMapping(value="/sysBoardGet", method = RequestMethod.POST)
    public RESTful sysBoardGet(Page p,HttpServletRequest req){
        return masterService.sysBoardGet(p,req);
    }


    @RequestMapping(value="/sysBoardAdd", method = RequestMethod.POST)
    public Message sysBoardAdd(HttpServletRequest req, SYSBoard sbv){
        return masterService.sysBoardAdd(req, sbv);
    }


    @RequestMapping(value="/sysBoardDelete", method = RequestMethod.POST)
    public Message sysBoardDelete(Page p,HttpServletRequest req){
        return masterService.sysBoardDelete(p,req);
    }



    @RequestMapping(value="/sysProdLineOneGet", method = RequestMethod.POST)
    public SYSProdLine sysProdLineOneGet(Page p, HttpServletRequest req){
        return masterService.sysProdLineOneGet(p,req);
    }

    @RequestMapping(value="/sysProdLineGet", method = RequestMethod.POST)
    public RESTful sysProdLineGet(Page p,HttpServletRequest req){
        return masterService.sysProdLineGet(p,req);
    }

    @RequestMapping(value="/sysProdLineAdd", method = RequestMethod.POST)
    public Message sysProdLineAdd(HttpServletRequest req, SYSProdLine spv){
        return masterService.sysProdLineAdd(req, spv);
    }


    @RequestMapping(value="/sysProdLineDelete")
    public Message sysProdLineDelete(Page p,HttpServletRequest req){
        return masterService.sysProdLineDelete(p,req);
    }


    @RequestMapping(value="/sysCargoGet", method = RequestMethod.POST)
    public RESTful sysCargoGet(Page p,HttpServletRequest req){
        return masterService.sysCargoGet(p,req);
    }

    @RequestMapping(value="/sysCargoOneGet", method = RequestMethod.POST)
    public SYSCargo sysCargoOneGet(Page p, HttpServletRequest req){
        return masterService.sysCargoOneGet(p,req);
    }

    @RequestMapping(value="/sysCargoBAllGet", method = RequestMethod.POST)
    public List<SYSCargo> sysCargoBAllGet(HttpServletRequest req,Page p){
        return masterService.sysCargoBAllGet(req,p);
    }

    @RequestMapping(value="/sysCargoAdd", method = RequestMethod.POST)
    public Message sysCargoAdd(HttpServletRequest req,SYSCargo scv){
        return masterService.sysCargoAdd(req, scv);
    }

    @RequestMapping(value="/sysCargoDelete", method = RequestMethod.POST)
    public Message sysCargoDelete(HttpServletRequest req,Page p){
        return masterService.sysCargoDelete(req,p);
    }

    @RequestMapping(value="/sysSuppListGet", method = RequestMethod.POST)
    public RESTful sysSuppListGet(Page p, HttpServletRequest req) {
        return masterService.sysSuppListGet(p,req);
    }

    @RequestMapping(value="/sysSuppOneGet", method = RequestMethod.POST)
    public SYSSupp sysSuppOneGet(HttpServletRequest req, Page p) { return masterService.sysSuppOneGet(req,p); }

    @RequestMapping(value="/sysSuppAdd", method = RequestMethod.POST)
    public Message sysSuppAdd(HttpServletRequest req, SYSSupp vo) { return masterService.sysSuppAdd(req,vo); }

    @RequestMapping(value="/sysSuppListDel", method = RequestMethod.POST)
    public Message sysSuppListDel(Page p) { return masterService.sysSuppListDel(p); }

    @RequestMapping(value="/sysERateGet", method = RequestMethod.POST)
    public RESTful sysERateGet(HttpServletRequest req, Page p){ return masterService.sysERateGet(req,p);}

    @RequestMapping(value="/sysERateOneGet", method = RequestMethod.POST)
    public SYSERate sysERateOneGet(HttpServletRequest req,SYSERate ser) { return masterService.sysERateOneGet(req, ser); }

    @RequestMapping(value="/sysERateAdd", method = RequestMethod.POST)
    public Message sysERateAdd(HttpServletRequest req, SYSERate vo) { return masterService.sysERateAdd(req,vo); }

    @RequestMapping(value="/sysERateDel", method = RequestMethod.POST)
    public Message sysERateDel(Page p) { return masterService.sysERateDel(p); }
}
