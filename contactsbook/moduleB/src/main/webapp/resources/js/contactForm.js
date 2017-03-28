/* PHONE NUMBER TABLE*/
function checkAllPhones(mainCheckbox){
    var checkboxes=document.getElementsByName("checkBoxGroup");
    for (var i=0; i<checkboxes.length;i++) {
        checkboxes[i].checked=mainCheckbox.checked;
    }
}


var checkedBoxNumber = 0;
function manageUpdateButton(checkBox){
    if(checkBox.id =="mainCheckBox" && checkBox.checked==true){
        checkedBoxNumber=document.getElementsByName("checkBoxGroup").length;
    }
    if(checkBox.id =="mainCheckBox" && checkBox.checked==false){
        checkedBoxNumber=0;
    }
    if(checkBox.id !="mainCheckBox") {
        if (checkBox.checked) {
            checkedBoxNumber++;
        }
        else {
            checkedBoxNumber = checkedBoxNumber - 1;
        }
    }
    if (checkedBoxNumber > 1) {
        document.getElementById("updatePhoneBtn").disabled = true;
    }
    else {
        document.getElementById("updatePhoneBtn").disabled = false;
    }
}

/*ATTACHMENT TABLE*/
function checkAllAttachs(mainCheckbox){
    var checkboxes=document.getElementsByName("checkBoxGroup1");
    for (var i=0; i<checkboxes.length;i++) {
        checkboxes[i].checked=mainCheckbox.checked;
    }
}

var checkedBoxNumber1 = 0;
function manageUpdateButton1(checkBox){
    if(checkBox.id =="mCheckBox" && checkBox.checked==true){
        checkedBoxNumber1=document.getElementsByName("checkBoxGroup1").length;
    }
    if(checkBox.id =="mCheckBox" && checkBox.checked==false){
        checkedBoxNumber1=0;
    }
    if(checkBox.id !="mCheckBox") {
        if (checkBox.checked) {
            checkedBoxNumber1++;
        }
        else {
            checkedBoxNumber1 = checkedBoxNumber1 - 1;
        }
    }
    if (checkedBoxNumber1 > 1) {
        document.getElementById("updateAttachBtn").disabled = true;
    }
    else {
        document.getElementById("updateAttachBtn").disabled = false;
    }
    alert(checkedBoxNumber1);
}