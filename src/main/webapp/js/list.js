/*
* 调用批量删除方法
* */
function deleteBatch(basePath) {

//设定action
    $("#mainForm").attr("action", basePath + "DeleteBatchServlet.action");
    $("#mainForm").submit();
}