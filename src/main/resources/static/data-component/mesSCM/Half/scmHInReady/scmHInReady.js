/**
 * various.js 와 연동
 */

////////////////////////////데이터/////////////////////////////////////
var main_data = {
    send_data: {},
    auth:{}
};

////////////////////////////시작 함수//////////////////////////////////

$(document).ready(function () {
    selectBox();
    jqGrid_main();
    jqgridPagerIcons();
    authcheck();
    jqGridResize('#mes_grid', $('#mes_grid').closest('[class*="col-"]'));
});

////////////////////////////클릭 함수//////////////////////////////////
function get_btn(page) {
    main_data.send_data = value_return(".condition_main");
    $("#mes_grid").setGridParam({
        url: '/scmHInReadyGet',
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
            data : {
                "name": "scmHInReady",
                "row0": $('#line_select').val()
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

////////////////////////////호출 함수//////////////////////////////////
function authcheck() {
    ccn_ajax("/menuAuthGet", {keyword: "scmHInReady"}).then(function (data) {
        main_data.auth = data;
    });
}

function selectBox() {
    select_makes_sub("#line_select", "/getLine", "line_code", "line_name",{keyword:''},'Y');

}

function jqGrid_main() {
    $('#mes_grid').jqGrid({
        datatype: "local",
        mtype: 'POST',
        colNames: ['공정','제품유형','품목군','제품군', '품번', '품명', '규격','바코드', '공정완료일시'],
        colModel: [
            {name: 'line_name', index: 'line_name', sortable: false, width: 150,fixed:true},
            {name: 'part_type_name', index: 'part_type_name', sortable: false, width: 150,fixed:true},
            {name: 'part_grp_name', index: 'part_grp_name', sortable: false, width: 150,fixed:true},
            {name: 'part_grp_name2', index: 'part_grp_name2', sortable: false, width: 150,fixed:true},
            {name: 'part_code', index: 'part_code', sortable: false, width: 150,fixed:true},
            {name: 'part_name', index: 'part_name', sortable: false, width: 150,fixed:true},
            {name: 'spec', index: 'spec', sortable: false, width: 150,fixed:true},
            {name: 'bcr_no', index: 'bcr_no', sortable: false, width: 150,fixed:true},
            {name: 'create_date', index: 'create_date', sortable: false, width: 180,formatter: formmatterDate,fixed:true}
        ],
        caption: "반제품입고대기현황 | MES",
        autowidth: true,
        height: 562,
        pager: '#mes_grid_pager',
        rowNum: 100,
        rowList: [100, 200, 300, 500, 1000],
        viewrecords: true
    });
}