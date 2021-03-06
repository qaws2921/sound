<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript" src="/data-component/admin/bom/sysPart/sysPart.js" charset="UTF-8"></script>

<div class="main-content-inner">

    <div class="page-content">
        <div class="col-lg-12 padding0">
            <table class="table wt-100">
                <tbody>
                <tr>
                    <td class="wt-px-100 t-align-c td-title padding-a-0" id="part_type">제품유형</td>
                    <td class="wt-px-200">
                        <select id="part_type_select" name="keyword" class="form-control keyword condition_main" onchange="select_type_change(this.value);"  style="width:100%">
                            <option value="D" >자재</option>
                            <option value="A">상품</option>
                        </select>
                    </td>
                    <td class="wt-px-100 t-align-c td-title padding-a-0" id="part_group1">품목군</td>
                    <td class="wt-px-200">
                        <select id="part_group1_select" name="keyword2" class="form-control keyword condition_main" onchange="select_change1(this.value);" style="width:100%">
                        </select>
                    </td>
                    <td class="wt-px-100 t-align-c td-title padding-a-0" id="part_group2">제품군</td>
                    <td class="wt-px-200">
                        <select id="part_group2_select" name="keyword3" class="form-control keyword condition_main"  style="width:100%">
                        </select>
                    </td>
                    <td class="wt-px-100 t-align-c td-title padding-a-0" id="part_group3">품명</td>
                    <td class="wt-px-200">
                        <select id="part_name_select" name="keyword4" class="form-control keyword condition_main" style="width:100%">
                        </select>
                    </td>
                    <td></td>
                </tr>
                </tbody>
            </table>
        </div>
        <div class="clearfix">
            <div class="pull-left tableTools-container">
                <div class="dt-buttons btn-overlap btn-group">
                    <a class="dt-button btn btn-white btn-primary btn-mini btn-bold"
                       tabindex="0" aria-controls="dynamic-table" data-original-title="" title="" onclick="get_btn(1)">
                            <span>
                                <i class="fa fa-search bigger-110 blue"></i>
                                <span>조회</span>
                            </span>
                    </a>
                    <a class="dt-button btn btn-white btn-primary btn-mini btn-bold"
                       tabindex="0" aria-controls="dynamic-table" data-original-title="" title="" onclick="add_btn()">
                            <span>
                                <i class="fa fa-plus bigger-110 blue"></i>
                                <span>추가</span>
                            </span>
                    </a>
                    <a class="dt-button btn btn-white btn-primary btn-mini btn-bold"
                       tabindex="0" aria-controls="dynamic-table" data-original-title="" title="" onclick="delete_btn();">
                            <span>
                                <i class="fa fa-trash bigger-110 blue"></i>
                                <span>삭제</span>
                            </span>
                    </a>
<%--                    <a class="dt-button btn btn-white btn-primary btn-mini btn-bold"--%>
<%--                       tabindex="0" aria-controls="dynamic-table" data-original-title="" title="">--%>
<%--                            <span>--%>
<%--                                <i class="fa fa-download bigger-110 blue"></i>--%>
<%--                                <span>저장</span>--%>
<%--                            </span>--%>
<%--                    </a>--%>
<%--                    <a class="dt-button btn btn-white btn-primary btn-mini btn-bold"--%>
<%--                       tabindex="0" aria-controls="dynamic-table" data-original-title="" title="">--%>
<%--                            <span>--%>
<%--                                <i class="fa fa-upload bigger-110 blue"></i>--%>
<%--                                <span>엑셀업로드</span>--%>
<%--                            </span>--%>
<%--                    </a>--%>
                </div>
            </div>
            <div class="row">
                <div class="col-xs-12 table-responsive">
                    <table id="mes_grid"></table>
                    <div id="mes_grid_pager"></div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="sysPart_modal1.jsp" %>




