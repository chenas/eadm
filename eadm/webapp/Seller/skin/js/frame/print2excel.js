//全部打印到excel表
function AutomateExcelall() {
	var i, j;
	alert("ther");
	// Start Excel and get Application object.
	var oXL = new ActiveXObject("Excel.Application");

	oXL.Visible = true;

	// Get a new workbook.
	var oWB = oXL.Workbooks.Add();
	var oSheet = oWB.ActiveSheet;

	// Add table headers going cell by cell.
	oSheet.Cells(1, 1).Value = "订单编号";
	oSheet.Cells(1, 2).Value = "目的地";
	oSheet.Cells(1, 3).Value = "下单时间";
	oSheet.Cells(1, 4).Value = "联系方式";
	oSheet.Cells(1, 5).Value = "订单总价";
	oSheet.Cells(1, 6).Value = "二维码";
	
	for (i = 1; i < tblout.rows.length; i++) {
		for (j = 1; j < tblout.rows(i).cells.length; j++) {
			oSheet.Cells(i + 1, j).Value = tblout.rows(i).cells(j).innerText;
		}
	}
	oXL.Visible = true;
	oXL.UserControl = true;
}
// 选种打印到excel表
function AutomateExcel() {
	var i = 0;
	// var j=0; //i是行，j是列
	var oXL = new ActiveXObject("Excel.Application");
	oXL.Visible = true;
	var oWB = oXL.Workbooks.Add();
	var oSheet = oWB.ActiveSheet;
	oSheet.Cells(1, 1).Value = "订单编号";
	oSheet.Cells(1, 2).Value = "目的地";
	oSheet.Cells(1, 3).Value = "下单时间";
	oSheet.Cells(1, 4).Value = "联系方式";
	oSheet.Cells(1, 5).Value = "订单总价";
	oSheet.Cells(1, 6).Value = "二维码";
	var s = 0;
	for (i = 1; i < tblout.rows.length + 1; i++) {

		if (document.list1form.checkbox[i].checked == true) {
			s = s + 1;
			for (var j = 0; j < tblout.rows(i).cells.length; j++) {
				oSheet.Cells(s + 1, j + 1).Value = tblout.rows(i).cells(j).innerText;
			}
		}
	}
	oXL.Visible = true;
	oXL.UserControl = true;
}
// 得到选种的复选框
function check() {
	var checkboxvalue = 0;
	for ( var i = 0; i < document.list1form.checkbox.length; i++) {
		if (document.myform.checkbox[i].checked == true) {
			checkboxvalue = checkboxvalue + 1;
		}
	}
	document.list1form.dayin.value = checkboxvalue;
}