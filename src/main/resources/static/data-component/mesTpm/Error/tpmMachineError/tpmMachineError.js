/**
 * various.js 와 연동
 */

////////////////////////////데이터/////////////////////////////////////

var main_data = {
    check: 'I',
    send_data: {},
    send_data_post: {},
    readonly: [],
    auth:{}
};


////////////////////////////시작 함수/////////////////////////////////////

$(document).ready(function () {
    selectBox();
    jqGrid_main();
    jqGridResize("#mes_grid", $('#mes_grid').closest('[class*="col-"]'));
    datepickerInput();
    modal_start1();
    authcheck();
    jqgridPagerIcons();
});

////////////////////////////클릭 함수/////////////////////////////////////

function get_btn(page) {
    main_data.send_data = value_return(".condition_main");
    main_data.send_data.start_date = main_data.send_data.start_date.replace(/\-/g, '');
    main_data.send_data.end_date = main_data.send_data.end_date.replace(/\-/g, '');
    main_data.send_data_post = main_data.send_data;
    $("#mes_grid").setGridParam({
        url: '/tpmMachineErrorGet',
        datatype: "json",
        page: page,
        postData: main_data.send_data
    }).trigger("reloadGrid");
}

function get_btn_post(page) {
    $("#mes_grid").setGridParam({
        url: '/tpmMachineErrorGet',
        datatype: "json",
        page: page,
        postData: main_data.send_data_post
    }).trigger("reloadGrid");
}

function add_btn() {
    if(main_data.auth.check_add != "N") {
        main_data.check = 'I';
        modal_reset(".modal_value", main_data.readonly);

        $("#datepicker3").datepicker('setDate', 'today');
        if ($('#line_select').val() !== '' && $('#line_select').val() !== null){
            $('#line_select2').val($('#line_select').val()).prop("selected",true).trigger("change");
        } else {
            $("select#line_select2 option:eq(0)").prop("selected", true).trigger("change");
        }
        $("select[name=error_type] option:eq(0)").prop("selected", true).trigger("change");
        $("select[name=error_result] option:eq(0)").prop("selected", true).trigger("change");

        $('#datepicker3').prop("disabled", false);
        $('#line_select2').prop("disabled", false);
        $('#machine_select2').prop("disabled", false);
        $("#addDialog").dialog('open');
    } else {
        alert("추가권한이 없습니다.");
    }

}

function select_change1(value) {
    if (value !== '' && value !== null ){
        select_makes_sub("#machine_select","/tpmMachineAllGet","machine_code","machine_name",{keyword:value},"Y");

    } else {
        $('#machine_select').empty();

        var option = $("<option></option>").text('전체').val('');

        $('#machine_select').append(option);

        $('#machine_select').select2();
    }
}

function update_btn(jqgrid_data) {
    if (main_data.auth.check_edit !="N") {
        main_data.check = 'U';
        modal_reset(".modal_value", []);
        var send_data = {};
        send_data.keyword = jqgrid_data.line_code;
        send_data.keyword2 = jqgrid_data.machine_code;

        ccn_ajax('/tpmMachineErrorOneGet', send_data).then(function (data) {
            data.work_date = formmatterDate2(data.work_date);
            modal_edits('.modal_value', main_data.readonly, data); // response 값 출력

            $('#datepicker3').prop("disabled", true);

            $('#line_select2').val(data.line_code).trigger("change");
            $('#machine_select2').empty();
            select_makes_sub_ajax2("#machine_select2","/tpmMachineAllGet","machine_code","machine_name",{keyword:data.line_code},"Y").then(function (data2) {
                $('#machine_select2').val(data.machine_code).trigger("change");
            });

            $('#line_select2').prop("disabled", true);
            $('#machine_select2').prop("disabled", true);
            // $('#datepicker3').datepicker('option','disabled','true');
            $("#addDialog").dialog('open');
        });
    } else {
        alert("수정권한이 없습니다.");
    }
}


function delete_btn() {
    if(main_data.auth.check_del != "N") {
        var gu4 = String.fromCharCode(4);
        var gu5 = String.fromCharCode(5);
        var ids = $("#mes_grid").getGridParam('selarrrow');
        var keywords = [];
        var code_list;

        if (ids.length === 0) {
            alert("삭제하는 데이터를 선택해주세요");
        } else {
            if (confirm("삭제하겠습니까?")) {
                main_data.check = 'D';
                for(i=0;i<ids.length;i++){
                    var data = $('#mes_grid').jqGrid('getRowData', ids[i]);
                    keywords.push(data.line_code+gu4+data.machine_code);
                }
                code_list=keywords.join(gu5);
                wrapWindowByMask2();
                ccn_ajax("/tpmMachineErrorDelete", {keyword:code_list}).then(function (data) {
                    if (data.result === 'NG') {
                        alert(data.message);
                    } else {
                        get_btn_post($("#mes_grid").getGridParam('page'));
                    }
                    closeWindowByMask();
                }).catch(function (err) {
                    closeWindowByMask();
                    console.error(err); // Error 출력
                });
            }
        }
    } else {
        alert("삭제권한이 없습니다.");
    }
}

////////////////////////////호출 함수/////////////////////////////////////
function datepickerInput() {
    datepicker_makes("#datepicker", -1);
    datepicker_makes("#datepicker2", 0);
}

function authcheck() {
    ccn_ajax("/menuAuthGet", {keyword: "tpmMachineError"}).then(function (data) {
        main_data.auth = data;
    });
}

function selectBox() {
    part_type_select_ajax_all("#line_select", "/sysProdLineAllGet", "line_code", "line_name",{keyword:''}).then(function (data){
        $('#machine_select').empty();

        var option = $("<option></option>").text('전체').val('');

        $('#machine_select').append(option);

        $('#machine_select').select2();


    });
}

function jqGrid_main() {
    $('#mes_grid').jqGrid({
        datatype: 'local',
        mtype: 'POST',
        colNames: ['seq','점검일', '라인','line_code', '설비','machine_code',  '고장내용','고장분류', '점검결과', '조치사항', '등록자', '점검일시'],
        colModel: [
            {name: 'seq', index: 'seq', sortable: false,hidden:true,key:true},
            {name: 'work_date', index: 'work_date', sortable: false, width: 150, formatter: formmatterDate2,fixed:true},
            {name: 'line_name', index: 'line_name', sortable: false, width: 100,fixed:true},
            {name: 'line_code', index: 'line_code', sortable: false, hidden:true},
            {name: 'machine_name', index: 'machine_name', sortable: false, width: 150,fixed:true},
            {name: 'machine_code', index: 'machine_code', sortable: false, hidden:true},
            {name: 'error_name', index: 'error_name', sortable: false, width: 150,fixed:true},
            {name: 'code_name1', index: 'code_name1', sortable: false, width: 150,fixed:true},
            {name: 'cn', index: 'cn', sortable: false, width: 150,fixed:true},
            {name: 'measure_name', index: 'measure_name', sortable: false, width: 200,fixed:true},
            {name: 'user_name', index: 'user_name', sortable: false, width: 150,fixed:true},
            {name: 'check_date', index: 'check_date', sortable: false, width: 180, formatter: formmatterDate,fixed:true}
        ],
        multiselect: true,
        caption: '사후보전관리 | MES',
        autowidth: true,
        height: 562,
        pager: '#mes_grid_pager',
        rowNum: 100,
        rowList: [100, 200, 300, 500, 1000],
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
            update_btn(data);
        },
        loadComplete:function(){
            if ($("#mes_grid").jqGrid('getGridParam', 'reccount') === 0)
                $(".jqgfirstrow").css("height","1px");
            else
                $(".jqgfirstrow").css("height","0px");
        }
    });
}