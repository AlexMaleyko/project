/**
 * Created by Alexey on 27.03.2017.
 */
function checkAll(mainCheckbox){
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
        //    document.getElementById("mainCheckBox").checked=false; SWITCHES OFF THE MAIN CHECKBOX when one of checkboxes is unchecked
        }
    }
        if (checkedBoxNumber > 1) {
            document.getElementById("updateContact").disabled = true;
        }
        else {
            document.getElementById("updateContact").disabled = false;
        }
}


function search() {
    var input, filter, table,tbody, tr, a, i;
    input = document.getElementById("searchInput");
    filter = input.value.toUpperCase();
    table = document.getElementById("contactTable");
    tbody=table.getElementsByTagName("tbody")[0];
    tr = tbody.getElementsByTagName("tr");

    // Loop through all table rows, and hide those who don't match the search query
    for (i = 0; i < tr.length; i++) {
        a = tr[i].getElementsByTagName("a")[0];
        if (a) {
            if (a.innerHTML.toUpperCase().indexOf(filter) > -1) {
                tr[i].style.display = "";
            } else {
                tr[i].style.display = "none";
            }
        }
    }
}
/*
function addCheckBoxListener(){
    alert("dfd");
    var checkboxes=document.getElementsByName("checkBoxGroup");
    for (var i=0; i<checkboxes.length;i){
        checkboxes[i].addEventListener("change",manageUpdateButton);
    }
}

document.onload = addCheckBoxListener();
*/
