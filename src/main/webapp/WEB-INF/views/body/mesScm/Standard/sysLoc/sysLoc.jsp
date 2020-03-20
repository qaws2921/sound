<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<script type="text/javascript" src="/data-component/mesSCM/Standard/sysLoc/sysLoc.js"
        charset="UTF-8"></script>

<div class="main-content-inner">

    <div class="page-content">
        <div class="col-lg-12 padding0">
            <table class="table wt-100">
                <tbody>
                <tr>
                    <td class="wt-px-100 t-align-c td-title padding-a-0">구분</td>
                    <td class="wt-px-200">
                        <select name="keyword" id="cargo_select" class="form-control keyword condition_main" style="width:100%">
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
                    <a class="dt-button buttons-collection buttons-colvis btn btn-white btn-primary btn-mini btn-bold"
                       title="" onclick="get_btn(1);">
                            <span>
                                <i class="fa fa-search bigger-110 blue"></i>
                                <span>조회</span>
                            </span>
                    </a>
                    <a class="dt-button buttons-csv buttons-html5 btn btn-white btn-primary btn-mini btn-bold"
                       tabindex="0" aria-controls="dynamic-table" data-original-title="" title=""
                       onclick="add_btn()">
                            <span>
                                <i class="fa fa-plus bigger-110 blue"></i>
                                <span>추가</span>
                            </span>
                    </a>
                    <a class="dt-button buttons-copy buttons-html5 btn btn-white btn-primary btn-mini btn-bold"
                       title=""
                       onclick="delete_btn();">
                            <span>
                                <i class="fa fa-trash bigger-110 blue"></i>
                                <span>삭제</span>
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
</div>


<%@include file="sysLoc_modal1.jsp" %>



