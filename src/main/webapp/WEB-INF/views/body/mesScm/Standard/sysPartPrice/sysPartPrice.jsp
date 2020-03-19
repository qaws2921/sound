<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="false" %>
<script type="text/javascript" src="/ui-component/assets/js/jquery.fileDownload.js"></script>
<script type="text/javascript" src="/data-component/mesSCM/Standard/sysPartPrice/sysPartPrice.js" charset="UTF-8"></script>

<div id="progressbar1" data-value="0"></div>

<div class="main-content-inner">
    <div class="page-content">
        <div class="col-lg-12 padding0">
            <table class="table wt-100">
                <tbody>
                <tr>
                    <td class="wt-px-100 td-title t-align-c padding-a-0">조회기간</td>
                    <td class="wt-px-150">
                        <div class="input-icon input-icon-right">
                            <input type="text" name="start_date" id="datepicker"
                                   class="form-control h-25 condition_main" readonly>
                            <i class="ace-icon fa fa-calendar dark" style="top: -2px;"></i>
                        </div>
                    </td>
                    <td class="t-align-c" style="width:25px !important;">
                        ~
                    </td>
                    <td class="wt-px-150">
                        <div class="input-icon input-icon-right">
                            <input type="text" name="stop_date" id="datepicker2"
                                   class="form-control h-25 condition_main" readonly>
                            <i class="ace-icon fa fa-calendar dark" style="top: -2px;"></i>
                        </div>
                    </td>
                    <td class="wt-px-100 td-title t-align-c padding-a-0">업체</td>
                    <td class="wt-px-150">
                        <div class="input-icon input-icon-right">
                            <input type="text" name="supp_name" class="form-control h-25 condition_main"
                                   id="supp_name_main" onclick="supp_btn('A');" readonly>
                            <input type="hidden" name="keyword" class="form-control h-25 condition_main"
                                   id="supp_code_main">
                            <i class="ace-icon fa fa-search dark" style="top: -2px;" id="SuppSearch"></i>
                        </div>
                    </td>
                    <td class="wt-px-100 td-title t-align-c padding-a-0">제품유형</td>
                    <td class="wt-px-150">
                        <select name="keyword2" class="form-control condition_main" id="part_type_select" onchange="select_change1(this.value);" style="width: 100%">
                        </select>
                    </td>
                    <td class="wt-px-100 td-title t-align-c padding-a-0">품목군</td>
                    <td class="wt-px-150">
                        <select name="keyword3" class="form-control condition_main" id="part_group_select" onchange="select_change2(this.value)" style="width:100%">
                        </select>
                    </td>
                    <td class="wt-px-100 td-title t-align-c padding-a-0">제품군</td>
                    <td class="wt-px-150">
                        <select name="keyword4" class="form-control condition_main" id="part_group_select2" style="width:100%">
                        </select>
                    </td>
<%--                    <td class="wt-px-75 td-title t-align-c padding-a-0">품명</td>--%>
<%--                    <td class="wt-px-125">--%>
<%--                        <select name="keyword5" class="form-control condition_main" id="part_name_select" style="width:100%;">--%>
<%--                        </select>--%>
<%--                    </td>--%>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>

        <div class="clearfix">
            <div class="pull-left tableTools-container">
                <div class="dt-buttons btn-overlap btn-group">
                    <a  id="get_btn" class="dt-button buttons-collection buttons-colvis btn btn-white btn-primary btn-mini btn-bold" tabindex="0" aria-controls="dynamic-table" data-original-title="" title="" onclick="get_btn(1)">
                                <span>
                                    <i class="fa fa-search bigger-110 blue"></i>
                                    <span>조회</span>
                                </span>
                    </a>
                    <a id="add_btn" class="dt-button buttons-csv buttons-html5 btn btn-white btn-primary btn-mini btn-bold" tabindex="0" aria-controls="dynamic-table" data-original-title="" title="" id="showDialog" onclick="add_btn()">
                                <span><i class="fa fa-plus bigger-110 blue"></i>
                                    <span>추가</span>
                                </span>
                    </a>
                    <a id="delete_btn" class="dt-button buttons-copy buttons-html5 btn btn-white btn-primary btn-mini btn-bold" tabindex="0" aria-controls="dynamic-table" data-original-title="" title="" onclick="delete_btn()">
                                <span>
                                    <i class="fa fa-trash bigger-110 blue"></i>
                                    <span>삭제</span>
                                </span>
                    </a>
                    <a class="dt-button buttons-csv buttons-html5 btn btn-white btn-primary btn-mini btn-bold"
                       id="btn-excel" tabindex="0" aria-controls="dynamic-table" data-original-title="" title="" onclick="excel_download();">
                        <span><i class="fa fa-download bigger-110 blue"></i>
                            <span>저장</span>
                        </span>
                    </a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-xs-12 table-responsive">
                <table id="mes_grid"></table>
                <div id="mes_grid_pager"></div>
            </div>
        </div>
    </div>
    <div title="데이터 저장중입니다...." id="preparing-file-modal" style="display: none;">
        <div id="progressbar" style="width: 100%; height: 22px; margin-top: 20px;"></div>
    </div>
    <div title="알림" id="error-modal" style="display: none;">
        <p>저장 실패. 관리자에게 문의하세요</p>
    </div>
</div>

<%@include file="sysPartPrice_modal1.jsp" %>
<%@include file="/WEB-INF/views/body/common/modal/part_modal.jsp" %>
<%@include file="/WEB-INF/views/body/common/modal/supp_modal.jsp" %>


