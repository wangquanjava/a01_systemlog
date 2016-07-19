<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/js/jquery-1.8.3.js"></script>
</head>
<body>
	<table id="systemLogTable" class="systemlog">
		<tr>
			<th>序号</th>
			<th>错误码</th>
			<th>任务ID</th>
			<th>流程ID</th>
			<th>日志时间</th>
			<th>操作</th>
		</tr>
	</table>
	<a href="javascript:void()" class="page_up" value="0">上一页</a>
	<a href="javascript:void()" class="page_down" value="0">下一页</a>
</body>
描述<input id="description" type="text">
开始时间<input id="startTime" type="text">
结束时间<input id="endTime" type="text">
<input id="search" type="button" value="搜索">


<style type="text/css">
table {
	border: 1px solid black;
	border-collapse: collapse;
	margin: 0px auto;
}

th {
	font-size: 30px;
	border: 1px solid black;
}

td {
	font-size: 30px;
	border: 1px solid black;
	text-align: center;
}
</style>
<script type="text/javascript">
	$(function() {
		getData(1);
		$("#search").click(search);
	})
	
	function getData(page) {
		$.ajax({
			url : '${pageContext.request.contextPath }'
					+ "/systemLogController/querySystemLogListByPage.do?page="
					+ page,
			success : function(data) {
				addTable(data);
			},
			dataType : "json"
		});
	}
	function addTable(data) {
		$("tr[class^='data_']").remove();
		var systemLogTable = $("#systemLogTable");
		for (i in data) {
			var oneLine = data[i]
			var html = "";
			html = html.concat("<tr class='data_"+oneLine.logId+"'>");
			html = html.concat("<td class='logId'>" + oneLine.logId + "</td>");
			html = html.concat("<td>" + oneLine.code + "</td>");
			html = html.concat("<td>" + oneLine.taskId + "</td>");
			html = html.concat("<td>" + oneLine.piId + "</td>");
			html = html.concat("<td>" + dataConvert(oneLine.logDate) + "</td>");
			html = html.concat("<td><a class='delete' href='javascript:void(0)'>删除</a><a class='view' href='javascript:void(0)'>查看</a></td>");
			html = html.concat("</tr>");
			systemLogTable.append(html);
		}
		
		$(".delete").click(deleteLog);
	}
	function deleteLog() {
		var logId = $(this).closest("tr").find(".logId").html();
		$.ajax({
			url : '${pageContext.request.contextPath}'
					+ "/systemLogController/deleteSystemLogById.do?id="
					+ logId,
			success : function(data) {
				window.location.reload();
			},
		});
	}
	function dataConvert(date) {
		var dateObject = new Date(date);
		return dateObject.getFullYear()+"-"+dateObject.getMonth()+1+"-"+dateObject.getDate();
	}
	function search() {
		var description = $("#description").val();
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		
		$.ajax({
			url:'${pageContext.request.contextPath}'
				+ "/systemLogController/findByCriteria.do?description="
				+ description+"&startTime="+startTime+"&endTime="+endTime,
			success : function(data) {
				addTable(data);
			},
			
		});
		
	}
	
</script>
</html>