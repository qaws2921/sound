<%@ page language="java" contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<script type="text/javascript" src="/data-component/mesPOP/PopStatus/popMonitoring/popMonitoring.js" charset="UTF-8"></script>

<div class="main-content-inner">

    <div class="page-content">
        <div class="col-lg-12 padding0">
            <table class="table wt-100">
                <tbody>
                <tr>
                    <td class="wt-px-100 t-align-c td-title padding-a-0">공정</td>
                    <td class="wt-px-200">
                        <select name="keyword" id="line_select" class="form-control keyword condition_main" style="width:100%">
                            <option value="">전체</option>
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
                       tabindex="0" aria-controls="dynamic-table" data-original-title="" title="" onclick="">
                            <span>
                                <i class="fa fa-search bigger-110 blue"></i>
                                <span>조회</span>
                            </span>
                    </a>
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





