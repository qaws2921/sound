/**
 * various.js 와 연동
 */

////////////////////////////데이터/////////////////////////////////////

var main_data = {
    check: 'I',
    send_data: {},
    send_data_post: {},
    auth:{}
};

////////////////////////////시작 함수/////////////////////////////////////

$(document).ready(function () {
    jqGrid_main();
    jqGridResize("#mes_grid", $('#mes_grid').closest('[class*="col-"]'));

    datepickerInput();
    selectBox();
    modal_start1();
    authcheck();
    jqgridPagerIcons();
});

////////////////////////////클릭 함수/////////////////////////////////////

function get_btn(page) {
    main_data.send_data = value_return(".condition_main");
    main_data.send_data.start_date = main_data.send_data.start_date.replace(/\-/g, '');
    main_data.send_data.end_date = main_data.send_data.end_date.replace(/\-/g, '');
    console.log(main_data);
    $("#mes_grid").setGridParam({
        url: "/qmsProdListGet",
        datatype: "json",
        page: page,
        postData: main_data.send_data
    }).trigger("reloadGrid");
}

function excel_download() {
    if (confirm("엑셀로 저장하시겠습니까?")) {
        var $preparingFileModal = $("#preparing-file-modal");
        $preparingFileModal.dialog({modal: true});
        $("#progressbar").progressbar({value: false});
        $.fileDownload("/excel_download", {
            httpMethod: 'POST',
            data: {
                "name": "qmsProdList",
                "row0": $('#datepicker').val().replace(/-/gi, ""),
                "row1": $('#datepicker2').val().replace(/-/gi, ""),
                "row2": $("#result_select").val()
            },
            successCallback: function (url) {
                $preparingFileModal.dialog('close');
            },
            failCallback: function (responseHtml, url) {
                $preparingFileModal.dialog('close');
                $("#error-modal").dialog({modal: true});
            }
        });
        return false;
    }
}

////////////////////////////호출 함수/////////////////////////////////////

function authcheck() {
    ccn_ajax("/menuAuthGet", {keyword: "qmsProdList"}).then(function (data) {
        main_data.auth = data;
    });
}


function datepickerInput() {
    datepicker_makes("#datepicker", -1);
    datepicker_makes("#datepicker2", 0);
}

function selectBox() {
    $('#result_select').select2();
}

function jqGrid_main() {
    $('#mes_grid').jqGrid({
        mtype:'POST',
        datatype: "local",
        colNames: ['입고일자', '전표번호', '업체', '품번', '품명', '규격', '단위','검사구분', '입고수량', '검사수량', '불량수량', '검사결과','불량유형','불량상세','조치구분','성적서','부적합보고서','개선조치','file02','file03','검사자','검사일시'],
        colModel: [
            {name: 'work_date', index: 'work_date', sortable: false, width: 150, formatter: formmatterDate2,fixed:true},
            {name: 'in_no', index: 'in_no', sortable: false, width: 150,fixed:true},
            {name: 'supp_name', index: 'supp_name', sortable: false, width: 150,fixed:true},
            {name: 'part_code', index: 'part_code', sortable: false, width: 150,fixed:true},
            {name: 'part_name', index: 'part_name', sortable: false, width: 150,fixed:true},
            {name: 'spec', index: 'spec', sortable: false, width: 150,fixed:true},
            {name: 'unit_name', index: 'unit_name', sortable: false, width: 100,fixed:true},
            {name: 'qc_level_name', index: 'qc_level_name', sortable: false, width: 100,fixed:true},
            {name: 'in_qty', index: 'in_qty', sortable: false, width: 100, align: 'right',formatter:'number',fixed:true},
            {name: 'qc_qty', index: 'qc_qty', sortable: false, width: 100, align: 'right',formatter:'integer',fixed:true},
            {name: 'ng_qty', index: 'ng_qty', sortable: false, width: 100, align: 'right',formatter:'integer',fixed:true},
            {name: 'qc_result_name', index: 'qc_result_name', sortable: false, width: 100,fixed:true},
            {name: 'qc_name', index: 'qc_name', sortable: false, width: 100,fixed:true},
            {name: 'ng_name', index: 'ng_name', sortable: false, width: 100,fixed:true},
            {name: 'act_type_name', index: 'act_type_name', sortable: false, width: 100,fixed:true},
            {
                name: 'file1_name',
                index: 'file1_name',
                sortable: false,
                width: 100,
                align: 'center',
                formatter: file1_formatter,fixed:true
            },
            {
                name: 'file2_name',
                index: 'file2_name',
                sortable: false,
                width: 100,
                align: 'center',
                formatter: file2_formatter,fixed:true
            },
            {
                name: 'file3_name',
                index: 'file3_name',
                sortable: false,
                width: 100,
                align: 'center',
                formatter: file3_formatter,fixed:true
            },
            // {name: 'file1', index: 'file1', sortable: false, width: 60, hidden: true},
            {name: 'file2', index: 'file2', sortable: false, hidden: true},
            {name: 'file3', index: 'file3', sortable: false, hidden: true},
            {name: 'user_name', index: 'user_name', sortable: false, width: 150,fixed:true},
            {name: 'update_date', index: 'update_date', sortable: false, width: 180, formatter: formmatterDate,fixed:true}
        ],
        caption: "출하검사현황 | MES",
        autowidth: true,
        height:562,
        pager: '#mes_grid_pager',
        rowList: [100, 200, 300, 500, 1000],
        rowNum: 100,
        viewrecords: true,
        beforeSelectRow: function (rowid, e) {          // 클릭시 체크 방지
            var $myGrid = $(this),
                i = $.jgrid.getCellIndex($(e.target).closest('td')[0]),
                cm = $myGrid.jqGrid('getGridParam', 'colModel');
            return (cm[i].name === 'cb');
        },
        onCellSelect: function (rowid, icol, cellcontent, e) {

        },
        ondblClickRow: function (rowid, iRow, iCol, e) { // 더블 클릭시 수정 모달창
            var data = $('#mes_grid').jqGrid('getRowData', rowid);
        },
        loadComplete:function(){
            if ($("#mes_grid").jqGrid('getGridParam', 'reccount') === 0)
                $(".jqgfirstrow").css("height","1px");
            else
                $(".jqgfirstrow").css("height","0px");
        }
    });
}


function file1_formatter(cellvalue, options, rowObject) {
    if (cellvalue === "Y") {
        return "" +
            " <a class='dt-button buttons-csv buttons-html5 btn btn-white btn-primary btn-mini btn-bold'" +
            "tabindex='0' aria-controls='dynamic-table' data-original-title='' title='' onclick='file1_Modal(\"" + rowObject.in_no + "\",\"" + rowObject.part_code + "\");'>" +
            "<span><i class='fa fa-download bigger-110 blue'></i>" +
            "<span> 조회</span>" +
            "</span>" +
            "</a>";
    } else {
        return "" +
            " <a class='dt-button buttons-csv buttons-html5 btn btn-white btn-danger btn-mini btn-bold'" +
            "tabindex='0' aria-controls='dynamic-table' style='cursor: not-allowed;'>" +
            "<span><i class='fa fa-ban bigger-110 red'></i>" +
            "<span> 없음</span>" +
            "</span>" +
            "</a>";
    }
}

function file2_formatter(cellvalue, options, rowObject) {
    if (cellvalue === "Y") {
        return "" +
            " <a class='dt-button buttons-csv buttons-html5 btn btn-white btn-primary btn-mini btn-bold'" +
            "tabindex='0' aria-controls='dynamic-table' data-original-title='' title='' onclick='file_download(\"" + rowObject.file2 + "\");'>" +
            "<span><i class='fa fa-download bigger-110 blue'></i>" +
            "<span> 저장</span>" +
            "</span>" +
            "</a>";
    } else {
        return "" +
            " <a class='dt-button buttons-csv buttons-html5 btn btn-white btn-danger btn-mini btn-bold'" +
            "tabindex='0' aria-controls='dynamic-table' style='cursor: not-allowed;'>" +
            "<span><i class='fa fa-ban bigger-110 red'></i>" +
            "<span> 없음</span>" +
            "</span>" +
            "</a>";
    }
}

function file3_formatter(cellvalue, options, rowObject) {
    if (cellvalue === "Y") {
        return "" +
            " <a class='dt-button buttons-csv buttons-html5 btn btn-white btn-primary btn-mini btn-bold'" +
            "tabindex='0' aria-controls='dynamic-table' data-original-title='' title='' onclick='file_download(\"" + rowObject.file3 + "\");'>" +
            "<span><i class='fa fa-download bigger-110 blue'></i>" +
            "<span> 저장</span>" +
            "</span>" +
            "</a>";
    } else {
        return "" +
            " <a class='dt-button buttons-csv buttons-html5 btn btn-white btn-danger btn-mini btn-bold'" +
            "tabindex='0' aria-controls='dynamic-table' style='cursor: not-allowed;'>" +
            "<span><i class='fa fa-ban bigger-110 red'></i>" +
            "<span> 없음</span>" +
            "</span>" +
            "</a>";
    }
}

function file_download(file_name) {
    if (confirm('파일을 저장하시겠습니까?')) {
        $.fileDownload('/FileUploads', {
            httpMethod: "POST",
            data: { key_value: file_name },
            successCallback: function(url){
            },
            failCallback: function(){
            }
        });
    }
}

