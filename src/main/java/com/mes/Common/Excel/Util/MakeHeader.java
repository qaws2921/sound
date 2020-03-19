package com.mes.Common.Excel.Util;

/** *
 * <pre>
 *     MakeHeader
 *     셀 헤더를 생성하는 클래스
 * </pre>
 * @author 김재일
 * @since 2019-11-27
 * @version 1.0
 * **/
public class MakeHeader {
    public String[] sysBPart_Header() {
        String[] data = {"품목구분", "품목코드", "품목명", "보관로케이션", "업체명", "규격", "단위", "L/T", "검사기준", "검사구분", "재고최대", "재고최소", "등록자", "수정일"};
        return data;
    }
    //자재단가
    public String[] sysPartPrice_Header() {
        String[] data ={"업체명", "시작일","종료일","품번","품명","화폐단위", "단가"};
        return data;
    }
    //발주현황
    public String[] scmOrderList_Header() {
        String[] data = {"발주일자","발주번호","업체명","품번","품명","규격","단위","상태","발주수량","입고수량","미입고","등록자","등록일시"};
        return data;
    }

    public String[] scmReqOrder_Header() {
        String[] data = {"일자","접수번호","수주번호","수주처","End User","납기일","품목그룹","품번","품명","규격","단위","수량"};
        return data;
    }

    public String[] scmInList_Header() {
        String[] data = {"입고일자","입고번호","업체명","품번","품명","규격","단위","입고수량","검사결과","MBR","상태","등록자","입고일시"};
        return data;
    }

    public String[] scmOutList_Header() {
        String[] data= {"출고일자","출고번호","공정명","품번","품명","규격","단위","출고수량","등록자","출고일시"};
        return data;
    }

    public String[] scmStockRetList_Header() {
        String[] data= {"반출일자","반출번호","업체명","품번","품명","규격","단위","반출수량","등록자","반출일시"};
        return data;
    }

    public String[] scmInLineList_Header() {
        String[] data= {"입고일자","입고번호","공정명","품번","품명","규격","단위","입고수량","등록자","입고일시"};
        return data;
    }

    public String[] scmStockList_Header() {
        String[] data= {"제품유형","품목군","제품군","품명","품목코드","규격", "단위", "공급업체", "적정재고(최소)", "적정재고(최대)", "재고량"};
        return data;
    }

    public String[] scmStockSumDayList_Header() {
        String[] data= {"품목구분","품목코드","품목명","규격","단위","전일재고","금일입고","금일출고","재고"};
        return data;
    }

    public String[] scmStockSumMonthList_Header() {
        String[] data= {"품목구분","품목코드","품목명","규격","단위","전월재고","금월입고","금월출고","재고"};
        return data;
    }

    public String[] crmWorkList_Header() {
        String[] data= {"접수일","수주번호","수주처","End User","진행상태","진행여부","납기일","지시구분","Part No","수량","단위","수축튜브","비고"};
        return data;
    }

    public String[] qmsRecvList_Header() {
        String[] data= {"입고일자","전표번호","업체","품번","품명","규격","단위","검사구분","입고수량","검사수량","불량수량","검사결과","불량유형","불량상세","조치구분","성적서","부적합보고서","개선조치","검사자","검사일시"};
        return data;
    }

    public String[] qmsProdList_Header() {
        String[] data = {"입고일자", "전표번호", "업체", "품번", "품명", "규격", "단위", "검사구분", "입고수량", "검사수량", "불량수량", "검사결과","불량유형","불량상세","조치구분","성적서","부적합보고서","개선조치","검사자","검사일시"};
        return data;
    }

    public String[] outsOutList_Header() {
        String[] data = {"출고일자", "출고번호", "업체", "품번", "품명", "규격", "단위", "수량", "등록자","등록일시"};
        return data;
    }

    public String[] outsInList_Header() {
        String[] data = {"입고일자", "입고번호", "업체", "품목그룹", "품번", "품명", "규격", "단위", "출고수량","외주 LOSS","검사 LOSS","양품량", "등록자","등록일시"};
        return data;
    }

    public String[] outsInReady_Header() {
        String[] data = {"출고일자", "출고번호", "업체", "품목그룹", "품번", "품명", "규격", "단위", "수량","바코드", "등록자","등록일시"};
        return data;
    }

    public String[] tpmMachineError_Header() {
        String[] data ={"점검일", "라인","설비","고장내용", "점검결과", "조치사항", "등록자", "점검일시"};
        return data;
    }

    public String[] scmHInList_Header() {
        String[] data ={"입고일자", "입고번호", "공정", "품번", "품명", "규격", "단위", "입고수량", "등록자", "입고일시"};
        return data;
    }


    public String[] wmsInList_Header() {
        String[] data ={"입고일자", "입고번호", "품번", "품명", "규격", "단위", "입고수량", "등록자", "입고일시"};
        return data;
    }

    public String[] wmsOutList_Header() {
        String[] data ={"출고일자", "출고번호", "업체명","품번", "품명", "규격", "단위", "출고수량","등록자","출고일시"};
        return data;
    }

    public String[] wmsOutReady_Header() {
        String[] data ={"요청일자", "요청번호", "업체명",  "품번", "품명", "규격","조립정보", "단위", "요청수량", "등록자","요청일시"};
        return data;
    }

    public String[] crmProdOrder_Header() {
        String[] data ={"접수일", "수주번호", "수주처", "End User", "진행상태", "진행여부", "납기일", "지시상태", "Part No","규격","수량","단위","수축튜브","비고"};
        return data;
    }

    public String[] crmOutList_Header() {
        String[] data ={"출고일자", "출고번호", "업체명","품번", "품명", "규격", "단위","단가", "출고수량", "수주등록자"};
        return data;
    }

    public String[] scmIOList_Header() {
        String[] data={"제품유형", "품목군", "제품군", "품번", "품명", "규격", "일자", "수량", "구분"};
        return data;
    }

    public String[] scmHInReadyList_Header() {
        String[] data={"공정","제품유형","품목군","제품군", "품번", "품명", "규격","바코드", "공정완료일시"};
        return data;
    }

    public String[] scmHOutList_Header() {
        String[] data={"출고일자", "출고번호", "공장명", "품번", "품명", "규격", "단위", "출고수량", "등록자", "출고일시"};
        return data;
    }

    public String[] scmStockRevList_Header() {
        String[] data={"조정일자","조정번호","제품유형","품목군","제품군","품번","품명","규격","단위","바코드","조정전수량","조정후수량","증가","조정사유","등록자","조정일시"};
        return data;
    }

    public String[] scmPartCloseList_Header() {
        String[] data={"마감일자","마감번호","업체","금액","비고"};
        return data;
    }

    public String[] wmsStockList_Header() {
        String[] data={"품목구분", "품목코드", "품목명", "규격", "단위","재고량"};
        return data;
    }

    public String[] wmsStockIOSumDayList_Header() {
        String[] data={"제품유형", "품목코드", "품목명", "규격", "단위", "전일재고", "금일입고", "금일출고", "재고"};
        return data;
    }

    public String[] wmsStockIOSumMonthList_Header() {
        String[] data={"제품유형", "품목코드", "품목명", "규격", "단위", "전월재고", "금월입고", "금월출고", "재고"};
        return data;
    }

    public String[] crmPlan_Header1() {
        String[] data={"제품명","분류", "1월", "2월", "3월", "소계", "전체계", "차이", "생산량","시점재고","생산시기"};
        return data;
    }
    public String[] crmPlan_Header2() {
        String[] data={"제품명","분류", "4월", "5월", "6월", "소계", "전체계", "차이", "생산량","시점재고","생산시기"};
        return data;
    }
    public String[] crmPlan_Header3() {
        String[] data={"제품명","분류", "7월", "8월", "9월", "소계", "전체계", "차이", "생산량","시점재고","생산시기"};
        return data;
    }
    public String[] crmPlan_Header4() {
        String[] data={"제품명","분류", "10월", "11월", "12월", "소계", "전체계", "차이", "생산량","시점재고","생산시기"};
        return data;
    }

    public String[] qmsProdError_Header() {
        String[] data={"입고일자", "전표번호", "업체", "품번", "품명", "규격", "단위", "출고수량", "불량수량", "검사결과","불량유형","불량내용","검사자","검사일시"};
        return data;
    }

    public String[] qmsRecvError_Header() {
        String[] data={"입고일자", "전표번호", "업체", "품번", "품명", "규격", "단위", "검사등급", "입고수량", "불량수량", "검사결과","불량유형","불량내용","조치구분","검사자","검사일시"};
        return data;
    }
}
