package com.mes.mesWms.InOut;

import com.mes.Common.DataTransferObject.Message;
import com.mes.Common.DataTransferObject.Page;
import com.mes.Common.DataTransferObject.RESTful;
import com.mes.Common.Function.ReturnFunction;
import com.mes.Mapper.mesWms.InOut.WmsInOutMapper;
import com.mes.mesWms.InOut.DTO.WMS_IN_SUB;
import com.mes.mesWms.InOut.DTO.WMS_OUT_ORD;
import com.mes.mesWms.InOut.DTO.WMS_OUT_ORD_SUB;
import com.mes.mesWms.InOut.DTO.WMS_OUT_SUB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Service
public class WmsInOutService extends ReturnFunction {
    @Autowired
    private WmsInOutMapper wmsInOutMapper;

    public RESTful wmsInListGet(HttpServletRequest req, Page p) {
        p.setSite_code(getSessionData(req).getSite_code());
        List<WMS_IN_SUB> rows = wmsInOutMapper.wmsInListGet(p);
        return getListData(rows , p);
    }

    public RESTful wmsOutListGet(HttpServletRequest req, Page p) {
        p.setSite_code(getSessionData(req).getSite_code());
        List<WMS_OUT_SUB> rows = wmsInOutMapper.wmsOutListGet(p);
        return getListData(rows , p);
    }

    public RESTful wmsOutReadyGet(HttpServletRequest req, Page p) {
        p.setSite_code(getSessionData(req).getSite_code());
        List<WMS_OUT_ORD_SUB> rows = wmsInOutMapper.wmsOutReadyGet(p);
        return getListData(rows , p);
    }

    public RESTful wmsOutOrderGet(HttpServletRequest req, Page p) {
        p.setSite_code(getSessionData(req).getSite_code());
        List<WMS_OUT_ORD> rows = wmsInOutMapper.wmsOutOrderGet(p);
        return getListData(rows , p);
    }

    public RESTful wmsOutOrderSubGet(HttpServletRequest req, Page p) {
        p.setSite_code(getSessionData(req).getSite_code());
        List<WMS_OUT_ORD_SUB> rows = wmsInOutMapper.wmsOutOrderSubGet(p);
        return getListData(rows , p);
    }

    public List<WMS_OUT_ORD_SUB> wmsOutOrderSubOneGet(HttpServletRequest req, Page p) {
        p.setSite_code(getSessionData(req).getSite_code());
        return wmsInOutMapper.wmsOutOrderSubGet(p);
    }

    public Message wmsOutOrderAdd(HttpServletRequest req, WMS_OUT_ORD_SUB woos) {
        woos.setSite_code(getSessionData(req).getSite_code());
        woos.setUser_code(getSessionData(req).getUser_code());
        return wmsInOutMapper.wmsOutOrderAdd(woos);
    }

    public Message wmsOutOrderDel(HttpServletRequest req, Page p) {
        p.setSite_code(getSessionData(req).getSite_code());
        return wmsInOutMapper.wmsOutOrderDel(p);
    }
}
