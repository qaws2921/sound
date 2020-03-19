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
    datepickerInput();
    jqGrid_main();
    jqgridPagerIcons();
    authcheck();
    jqGridResize('#mes_grid', $('#mes_grid').closest('[class*="col-"]'));
});

////////////////////////////클릭 함수//////////////////////////////////
function get_btn(page) {
    main_data.send_data = value_return(".condition_main");
    main_data.send_data.start_date = main_data.send_data.start_date.replace(/\-/g, '');
    main_data.send_data.end_date = main_data.send_data.end_date.replace(/\-/g, '');
    $("#mes_grid").setGridParam({
        url: '/scmHInListGet',
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
                "name":"scmHInList",
                "row0":$('#datepicker').val().replace(/-/gi,""),
                "row1": $('#datepicker2').val().replace(/-/gi,""),
                "row2":$('#line_select').val()
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
    ccn_ajax("/menuAuthGet", {keyword: "scmHInList"}).then(function (data) {
        main_data.auth = data;
    });
}

function selectBox() {
    select_makes_sub("#line_select", "/sysProdLineAllGet", "line_code", "line_name",{keyword:'1'},'Y');
}

function datepickerInput() {
    datepicker_makes("#datepicker", -1);
    datepicker_makes("#datepicker2", 0);

}

function jqGrid_main() {
    $('#mes_grid').jqGrid({
        datatype: "local",
        mtype: 'POST',

        colNames: ['입고일자', '입고번호', '공정', '품번', '품명', '규격', '단위', '입고수량', '등록자', '입고일시'],
        colModel: [
            {name: 'work_date', index: 'work_date', sortable: false, width: 150,formatter: formmatterDate2,fixed:true },
            {name: 'in_no', index: 'in_no',key:true, sortable: false, width: 150,fixed:true},
            {name: 'line_name', index: 'line_name', sortable: false, width: 150,fixed:true},
            {name: 'part_code', index: 'part_code', sortable: false, width: 150,fixed:true},
            {name: 'part_name', index: 'part_name', sortable: false, width: 150,fixed:true},
            {name: 'spec', index: 'spec', sortable: false, width: 150,fixed:true},
            {name: 'unit_name', index: 'unit_name', sortable: false, width: 100,fixed:true},
            {name: 'qty', index: 'qty', sortable: false, width: 100, align: 'right',formatter:'number',fixed:true},
            {name: 'user_name', index: 'user_name', sortable: false, width: 150,fixed:true},
            {name: 'update_date', index: 'update_date', sortable: false, width: 180,formatter: formmatterDate,fixed:true}
        ],

        caption: "반제품입고현황 | MES",
        autowidth: true,
        height: 562,
        pager: '#mes_grid_pager',
        rowNum: 100,
        rowList: [100, 200, 300, 500, 1000],
        viewrecords: true,
        loadComplete:function(){
            if ($("#mes_grid").jqGrid('getGridParam', 'reccount') === 0)
                $(".jqgfirstrow").css("height","1px");
            else
                $(".jqgfirstrow").css("height","0px");
        }
    });


}