package com.mes.mesPop.Pop;

import com.mes.Common.DataTransferObject.Message;
import com.mes.Common.DataTransferObject.Page;
import com.mes.Common.DataTransferObject.RESTful;
import com.mes.mesPop.Pop.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class PopRestController {
    @Autowired
    private PopService popService;

    @RequestMapping(value = "/popPlan1Get", method = RequestMethod.POST)
    public RESTful popPlan1Get(HttpServletRequest req, Page p) {
        return popService.popPlan1Get(req, p);
    }

    @RequestMapping(value = "/popPlan1Add", method = RequestMethod.POST)
    public Message popPlan1Add(HttpServletRequest req, POP_PLAN1_CD pp1c) { return popService.popPlan1Add(req, pp1c); }

    @RequestMapping(value = "/popPlan1OneGet", method = RequestMethod.POST)
    public POP_PLAN1_CD popPlan1OneGet(HttpServletRequest req, POP_PLAN1_CD pp1c) {
        return popService.popPlan1OneGet(req, pp1c);
    }

    @RequestMapping(value = "/popPlan1Del", method = RequestMethod.POST)
    public Message popPlan1Del(HttpServletRequest req, POP_PLAN1_CD pp1c) {
        return popService.popPlan1Del(req, pp1c);
    }


    @RequestMapping(value ="/popPlan2Add2", method = RequestMethod.POST)
    public Message popPlan2Add2(HttpServletRequest req, Page p) {
        return popService.popPlan2Add2(req, p);
    }

    @RequestMapping(value = "/popPlan2Get", method = RequestMethod.POST)
    public RESTful popPlan2Get(HttpServletRequest req, Page p) {
        return popService.popPlan2Get(req, p);
    }


    @RequestMapping(value ="/popPlan2Add", method = RequestMethod.POST)
    public Message popPlan2Add(HttpServletRequest req, POP_PLAN2_CD ppc) {
        return popService.popPlan2Add(req, ppc);
    }

    @RequestMapping(value = "/popPlan2Get2", method = RequestMethod.POST)
    public RESTful popPlan2Get2(HttpServletRequest req, Page p) {
        return popService.popPlan2Get2(req, p);
    }

    @RequestMapping(value ="/popPlan3Add", method = RequestMethod.POST)
    public Message popPlan3Add(HttpServletRequest req, POP_PLAN3_CD ppc3) {
        return popService.popPlan3Add(req, ppc3);
    }

    @RequestMapping(value = "/popPlan3Get", method = RequestMethod.POST)
    public RESTful popPlan3Get(HttpServletRequest req, Page p) {
        return popService.popPlan3Get(req, p);
    }

    @RequestMapping(value = "/popPlan3AllGet", method = RequestMethod.POST)
    public List<POP_PLAN3_CD> popPlan3AllGet(HttpServletRequest req, Page p) {
        return popService.popPlan3AllGet(req, p);
    }

    @RequestMapping(value = "/popPlanSubGet", method = RequestMethod.POST)
    public RESTful popPlanSubGet(HttpServletRequest req, Page p) { return popService.popPlanSubGet(req, p); }

    @RequestMapping(value ="/popPlanSubAdd", method = RequestMethod.POST)
    public Message popPlanSubAdd(HttpServletRequest req, POP_PLAN_SUB_CD ppsc) { return popService.popPlanSubAdd(req,ppsc); }

    @RequestMapping(value ="/popPlanSubOneGet", method = RequestMethod.POST)
    public POP_PLAN_SUB_CD popPlanSubOneGet(HttpServletRequest req, POP_PLAN_SUB_CD ppsc) {
        return popService.popPlanSubOneGet(req, ppsc);
    }

    @RequestMapping(value = "/popPlanSubDel", method = RequestMethod.POST)
    public Message popPlanSubDel(HttpServletRequest req, POP_PLAN_SUB_CD ppsc) {
        return popService.popPlanSubDel(req, ppsc);
    }

    @RequestMapping(value = "/popPlanASSYGet", method = RequestMethod.POST)
    public RESTful popPlanASSYGet(HttpServletRequest req, Page p) {
        return popService.popPlanASSYGet(req, p);
    }

    @RequestMapping(value = "/popPlanASSYAdd", method = RequestMethod.POST)
    public Message popPlanASSYAdd(HttpServletRequest req, POP_PLAN_ASSY_CD ppac) { return popService.popPlanASSYAdd(req, ppac);}

    @RequestMapping(value = "/popPlanASSYOneGet", method = RequestMethod.POST)
    public POP_PLAN_ASSY_CD popPlanASSYOneGet(HttpServletRequest req, POP_PLAN_ASSY_CD ppac) {
        return popService.popPlanASSYOneGet(req, ppac);
    }

    @RequestMapping(value = "/popPlanASSYDel", method = RequestMethod.POST)
    public Message popPlanASSYDel(HttpServletRequest req, POP_PLAN_ASSY_CD ppac){
        return popService.popPlanASSYDel(req, ppac);
    }
}
