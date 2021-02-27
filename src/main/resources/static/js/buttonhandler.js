function addProductToOrderWindow(formId, buttonId){
    var form = document.getElementById(formId);
    var button = document.getElementById((buttonId));

    if(form.value === "") {
        form.value += button.name + ' - ' + button.value + '\r\n';
    }else {
        form.value += (button.name + ' - ' + button.value) + '\r\n';
    }
}