
////////////////////////////시작 함수/////////////////////////////////////
function modal_start1() {
    modal_make1();
    selectBox_modal1();
}


////////////////////////////클릭 함수/////////////////////////////////////
function addUdate_btn() {
    var modal_objact = value_return(".modal_value");
    if (effectiveness1(modal_objact)) {
        var text = '저장하겠습니까?';
        if (main_data.check === "U") {
            text = '수정하겠습니까?';
        }
        if (confirm(text)) {
            modal_objact.keyword = main_data.check;
            modal_objact.route_type = main_data.condition_check;
            ccn_ajax("/popRouteAdd", modal_objact).then(function (data) {
                if (data.result === 'NG') {
                    alert(data.message);
                } else {
                    if (main_data.check === "I") {
                        get_btn(1);
                    } else {
                        get_btn($("#mes_grid").getGridParam('page'));
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
    select_makes_sub("#line_select1", "/getLine", "line_code", "line_name",{keyword:'1'},'N');
    select_makes_sub("#line_select2", "/getLine", "line_code", "line_name",{keyword:'1'},'N');
    select_makes_sub("#line_select3", "/getLine", "line_code", "line_name",{keyword:'1'},'N');
    select_makes_sub("#line_select4", "/getLine", "line_code", "line_name",{keyword:'1'},'N');
    select_makes_sub("#line_select5", "/getLine", "line_code", "line_name",{keyword:'1'},'N');
    select_makes_sub("#line_select6", "/getLine", "line_code", "line_name",{keyword:'1'},'N');
    select_makes_sub("#line_select7", "/getLine", "line_code", "line_name",{keyword:'1'},'N');
    select_makes_sub("#line_select8", "/getLine", "line_code", "line_name",{keyword:'1'},'N');
}


function modal_make1() {
    $("#addDialog").dialog({
        autoOpen:false,
        modal: true,
        width: 'auto',
        height: 'auto',
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
    if (modal_objact.route_code === '') {
        alert("라우팅코드를 입력해주세요");
        return false;
    }
    else if (modal_objact.route_name === '') {
        alert("라우팅명을 입력해주세요");
        return false;
    } else {
        return true;
    }
}


