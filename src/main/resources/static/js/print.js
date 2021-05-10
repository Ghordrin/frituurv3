function PrintDiv() {
    var divContents = document.getElementById("printable").innerHTML;
    var printWindow = window.open('', ' ', 'width=1000,height=1000');
    printWindow.document.write('<html><head><title>Order</title>' +
        '<style> \n' +
        '#orderOverviewForm{\n' +
        '    display: flex;\n' +
        '    flex-direction: column;\n' +
        '}\n' +
        '\n' +
        '#header{\n' +
        '    display: flex;\n' +
        '    margin: auto;\n' +
        '}\n' +
        '\n' +
        '#orderRow{\n' +
        '    display: flex;\n' +
        '    flex-direction: row;\n' +
        '}\n' +
        '#unprintable{\n' +
        '    display: none;\n' +
        '}</style>');
    printWindow.document.write('</head><body >');
    printWindow.document.write(divContents);
    printWindow.document.write('</body></html>');
    printWindow.document.close();
    printWindow.print();
}