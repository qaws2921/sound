package com.mes.Mapper.mesQms.Shipment;

import com.mes.Common.DataTransferObject.Message;
import com.mes.Common.DataTransferObject.Page;
import com.mes.mesQms.Shipment.DTO.QMS_PROD;
import com.mes.mesQms.Shipment.DTO.QMS_PROD_NG_SUM;
import com.mes.mesQms.Shipment.DTO.QMS_PROD_RPT;
import com.mes.mesQms.Shipment.DTO.QMS_PROD_SUB;
import com.mes.Common.File.DTO.Files;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QmsShipmentMapper {
    List<QMS_PROD_SUB> qmsProdErrorManGet(Page p);

    List<QMS_PROD> qmsProdGet(Page p);

    List<QMS_PROD_SUB> qmsProdSubGet(Page p);

    QMS_PROD_SUB qmsProdErrorManOneGet(QMS_PROD_SUB qmsProdSub);

    List<QMS_PROD_SUB> qmsProdMRBGet(Page p);

    Message qmsProdMRBAdd(QMS_PROD_SUB qps);

    Message qmsProdMRBCancel(QMS_PROD_SUB qps);

    Message qmsProdAdd(QMS_PROD_SUB qps);

    List<QMS_PROD_SUB> qmsProdListGet(Page p);

    List<QMS_PROD_RPT> qmsProdListRPTGet(Page p);

    void qmsProdErrorManAdd_NoneFile(Files files);

    void qmsProdErrorManAdd_File2(Files files);

    void qmsProdErrorManAdd_File3(Files files);

    void qmsProdErrorManAdd_AllFile(Files newFiles);

    List<QMS_PROD_NG_SUM> qmsProdErrorListSumGet(Page p);
}
