package com.mes.Mapper.mesWms.InOut;

import com.mes.Common.DataTransferObject.Message;
import com.mes.Common.DataTransferObject.Page;
import com.mes.mesWms.InOut.DTO.WMS_IN_SUB;
import com.mes.mesWms.InOut.DTO.WMS_OUT_ORD;
import com.mes.mesWms.InOut.DTO.WMS_OUT_ORD_SUB;
import com.mes.mesWms.InOut.DTO.WMS_OUT_SUB;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface WmsInOutMapper {

    List<WMS_IN_SUB> wmsInListGet(Page p);

    List<WMS_OUT_SUB> wmsOutListGet(Page p);

    List<WMS_OUT_ORD_SUB> wmsOutReadyGet(Page p);

    List<WMS_OUT_ORD> wmsOutOrderGet(Page p);

    List<WMS_OUT_ORD_SUB> wmsOutOrderSubGet(Page p);

    Message wmsOutOrderAdd(WMS_OUT_ORD_SUB woos);

    Message wmsOutOrderDel(Page p);
}
