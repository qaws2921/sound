package com.mes.Mapper.mesPop.Pop;

import com.mes.Common.DataTransferObject.Message;
import com.mes.Common.DataTransferObject.Page;
import com.mes.mesPop.Pop.DTO.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MesPopPopMapper {
    List<POP_PLAN1_CD> popPlan1Get(Page p);

    Message popPlan1Add(POP_PLAN1_CD pp1c);

    Message popPlan2Add2(Page p);

    List<POP_PLAN2_CD> popPlan2Get(Page p);

    POP_PLAN1_CD popPlan1OneGet(POP_PLAN1_CD pp1c);

    Message popPlan1Del(POP_PLAN1_CD pp1c);

    Message popPlan2Add(POP_PLAN2_CD ppc);

    List<POP_PLAN2_CD> popPlan2Get2(Page p);

    Message popPlan3Add(POP_PLAN3_CD ppc3);

    List<POP_PLAN3_CD> popPlan3Get(Page p);

    List<POP_PLAN_SUB_CD> popPlanSubGet(Page p);

    Message popPlanSubAdd(POP_PLAN_SUB_CD ppsc);

    POP_PLAN_SUB_CD popPlanSubOneGet(POP_PLAN_SUB_CD ppsc);

    Message popPlanSubDel(POP_PLAN_SUB_CD ppsc);

    List<POP_PLAN_ASSY_CD> popPlanASSYGet(Page p);

    Message popPlanASSYAdd(POP_PLAN_ASSY_CD ppac);

    POP_PLAN_ASSY_CD popPlanASSYOneGet(POP_PLAN_ASSY_CD ppac);

    Message popPlanASSYDel(POP_PLAN_ASSY_CD ppac);
}
