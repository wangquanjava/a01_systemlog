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
.switchPage_no{
	display:none;
}
</style>
<script type="text/javascript">
	$(function() {
		query(1);
		$("#search").click(function() {
			search(1);
		});
	})
	function addEvent() {
		//给页面中的删除按钮增加事件
		$(".delete").click(deleteLog);
		
		//给页面的中的上下页增加事件
		
		$(".switchPage").click(function() {
			if($(this).attr("type")==1){
				query($(this).attr("page"));
			}else if($(this).attr("type")==2){
				search($(this).attr("page"));
			}
		});
		
	}

	function addTable(data) {
		$("td").remove();
		var systemLogTable = $("#systemLogTable");
		for (i in data.systemLogList) {
			var oneLine = data.systemLogList[i]
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
		systemLogTable.append(data.pageHtml);
		addEvent()
	}
	function deleteLog() {
		var logId = $(this).closest("tr").find(".logId").html();
		$.ajax({
			url : '${pageContext.request.contextPath}'
					+ "/systemLogController/deleteSystemLogById.do?id="
					+ logId,
			success : function(data) {
				$(".data_"+logId).remove();
			},
		});
	}
	function dataConvert(date) {
		var dateObject = new Date(date);
		return dateObject.getFullYear()+"-"+(dateObject.getMonth()+1)+"-"+dateObject.getDate();
	}
	
	
	function search(page) {
		var description = $("#description").val();
		var startTime = $("#startTime").val();
		var endTime = $("#endTime").val();
		
		$.ajax({
			url:'${pageContext.request.contextPath}'
				+ "/systemLogController/findByCriteria.do?description="
				+ description+"&startTime="+startTime+"&endTime="+endTime+"&page="+page,
			dataType:"json",
			success : function(data) {
				addTable(data);
			}
		});
	}
	function query(page) {
		$.ajax({
			url : '${pageContext.request.contextPath }'
					+ "/systemLogController/querySystemLogListByPage.do?page="
					+ page,
			dataType : "json",
			success : function(data) {
				addTable(data);
			}
		});
	}
</script>
</html>