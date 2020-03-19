<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<script type="text/javascript" src="/data-component/mesCRM/Crm/crmAssyCable/crmAssyCable.js" charset="UTF-8"></script>

<div class="main-content-inner">
    <div class="page-content">
        <div class="col-lg-12 padding0">
            <div class="col-lg-12 padding0">
                <table class="table wt-100">
                    <tbody>
                    <tr>
                        <td class="wt-px-100 t-align-c td-title padding-a-0">품목군</td>
                        <td class="wt-px-200">
                            <select class="form-control condition_main" name="keyword2" id="part_group_select" onchange="select_change1(this.value)"  style="width:100%">
                            </select>
                        </td>
                        <td class="wt-px-100 t-align-c td-title padding-a-0">제품군</td>
                        <td class="wt-px-200">
                            <select class="form-control condition_main" name="keyword3" id="part_prod_select" onchange="select_change2(this.value)" style="width:100%">
                            </select>
                        </td>
                        <td class="wt-px-100 t-align-c td-title padding-a-0">제품명</td>
                        <td class="wt-px-200">
                            <select class="form-control condition_main" name="keyword5" id="part_name_select" style="width:100%">
                            </select>
                        </td>
                        <td></td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="row">
                <div class="col-md-6">
                    <div class="clearfix">
                        <div class="pull-left tableTools-container">
                            <div class="dt-buttons btn-overlap btn-group">
                                <a class="dt-button buttons-collection buttons-colvis btn btn-white btn-primary btn-mini btn-bold"
                                   tabindex="0" aria-controls="dynamic-table" data-original-title="" title="" onclick="get_btn(1);">
                                    <span>
                                        <i class="fa fa-search bigger-110 blue"></i>
                                        <span>조회</span>
                                    </span>
                                </a>
                                <a id="add_btn" class="dt-button buttons-csv buttons-html5 btn btn-white btn-primary btn-mini btn-bold" tabindex="0" aria-controls="dynamic-table" data-original-title="" title="" id="showDialog" onclick="add_btn();">
                                <span><i class="fa fa-plus bigger-110 blue"></i>
                                    <span>추가</span>
                                </span>
                                </a>
                                <a class="dt-button buttons-copy buttons-html5 btn btn-white btn-primary btn-mini btn-bold"
                                   tabindex="0" aria-controls="dynamic-table" data-original-title="" title="" onclick="delete_btn();">
                                    <span>
                                        <i class="fa fa-trash bigger-110 blue"></i>
                                        <span>삭제</span>
                                    </span>
                                </a>
                            </div>
                        </div>
                    </div>
                </div>


            </div>

            <div class="row">
                <div class="col-xs-12 table-responsive">
                    <div class="row">
                        <div class="col-md-6 ">
                            <table id="mes_grid"></table>
                            <div id="mes_grid_pager"></div>
                        </div>
                        <div class="col-md-6">
                            <table id="mes_grid2"></table>
                            <div id="mes_grid2_pager"></div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<%@include file="crmAssyCable_modal1.jsp"%>

