//不支持谷歌浏览器
  function printsetup(){ 
  // 打印页面设置 
  wb.execwb(8,1); 
  } 
  function printpreview(){ 
  // 打印页面预览 
     
  wb.execwb(7,1); 
  } 
  function printit() 
  { 
  if (confirm('确定打印吗？')) { 
  wb.execwb(6,6);
  } 
  } 

 