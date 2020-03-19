var grid_data=[];
////////////////////////////시작 함수/////////////////////////////////////
function modal_start1() {
    modal_make1();
    selectBox_modal1();
    datepickerInput_modal1();
}

////////////////////////////클릭 함수/////////////////////////////////////
function num_keyup(e) {
    $(e).val($(e).val().replace(/[^0-9]/g,''));
}

function select_change2(value) {
    if (main_data.check === "I"){
        $('#machine_select2').empty();
        select_makes_sub_ajax("#machine_select2","/tpmMachineAllGet","machine_code","machine_name",{keyword:value}).then(function (data) {
            if ($("#machine_select").val() !== ''){
                $("#machine_select2").val($("#machine_select").val()).trigger("change");
                if ($("#machine_select2").val() === null){
                    $("#machine_select2 option:eq(0)").prop("selected", true).trigger("change");
                }
            }else {
                $("#machine_select2 option:eq(0)").prop("selected", true).trigger("change");
            }

        });
    }
}

function addUdate_btn() {


    var modal_objact = value_return(".modal_value");
    modal_objact.line_code= $('#line_select2').val();
    modal_objact.start_date=modal_objact.start_date.replace(/\-/g, '');
    if (effectiveness1(modal_objact)) {
        var text = '저장하겠습니까?';
        if (main_data.check === "U") {
            text = '수정하겠습니까?';
        }
        if (confirm(text)) {

            modal_objact.keyword = main_data.check;

            ccn_ajax("/tpmMachineRegAdd", modal_objact).then(function (data) {
                if (data.result === 'NG') {
                    alert(data.message);
                } else {
                    if (main_data.check === "I") {
                        get_btn(1);
                    } else {
                        get_btn_post($("#mes_grid").getGridParam('page'));
                    }
                }
                $("#addDialog").dialog('close');
            }).catch(function (err) {
                alert("저장실패");
            });
        }
    }
}

////////////////////////////호출 함수/////////////////////////////////////

function selectBox_modal1() {
    select_makes_sub_ajax("#line_select2", "/sysProdLineAllGet", "line_code", "line_name",{keyword:''}).then(function (data){

        //select_makes_sub("#machine_select2","/tpmMachineAllGet","machine_code","machine_name",{keyword:data},"N");
    });
    select_makes3("#qc_select", "/tpmMachineRegItemAllGet","qc_code","qc_name",{keyword:'Y'});
    $('#cycle_select').select2();
}
function modal_make1() {

    $("#addDialog").dialog({
        modal: true,
        width: 'auto',
        height: 'auto',
        autoOpen: false,
        resizable: false,
        buttons: [
            {
                text: '저장',
                'class': 'btn btn-primary btn-minier',
                click: function () {
                    addUdate_btn();
                }
            },
            {
                text: '취소',
                'class': 'btn btn-minier',
                click: function () {
                    $(this).dialog('close');
                }
            }
        ],
        open: function () {
            if ($.ui && $.ui.dialog && !$.ui.dialog.prototype._allowInteractionRemapped && $(this).closest(".ui-dialog").length) {
                if ($.ui.dialog.prototype._allowInteraction) {
                    $.ui.dialog.prototype._allowInteraction = function (e) {
                        if ($(e.target).closest('.select2-drop').length) return true;

                        if (typeof ui_dialog_interaction!="undefined") {
                            return ui_dialog_interaction.apply(this, arguments);
                        } else {
                            return true;
                        }
                    };
                    $.ui.dialog.prototype._allowInteractionRemapped = true;
                }
                else {
                    $.error("You must upgrade jQuery UI or else.");
                }
            }
        },
        _allowInteraction: function (event) {
            return !!$(e.target).closest('.ui-dialog, .ui-datepicker, .select2-drop').length;
        }
    });
}

function effectiveness1(modal_objact) { // 유효성 검사
    if (modal_objact.line_code === '') {
        alert("라인을 선택해주세요");
        return false;
    } else if (modal_objact.machine_code === '') {
        alert("설비명을 선택해주세요");
        return false;
    } else if (modal_objact.qc_code === '') {
        alert("점검항목을 선택해주세요");
        return false;
    }  else if (modal_objact.cycle_qty === '' || modal_objact.cycle_qty == 0) {
        alert("반복횟수를 다시 확인해주세요");
        return false;
    } else {

    return true;
    }
}

function datepickerInput_modal1() {
    datepicker_makes1("#datepicker3", 1);
}