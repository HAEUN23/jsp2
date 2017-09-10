<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="/common/header.jsp"%>
<title>게시판</title>
<script>
	function callback(result) {
		result = JSON.parse(result);
		var str = "";
		for (var i = 0, max = result.length; i < max; i++) {
			var b = result[i];
			str += "<tr>";
			str += "<td>" + b.bNum + "</td>";
			str += "<td>" + b.title + "</td>";
			str += "<td>" + b.content + "</td>";
			str += "<td>" + b.writer + "</td>";
			str += "<td>" + b.regDate + "</td>";
			str += "</tr>";
		}
		$("#r_tbody").html(str);
	}

	$(document).ready(function() {
		var param = "?command=list";
		param = encodeURI(param);
		var au = new AjaxUtil("list.board", param, "post");
		au.changeCallBack(callback);
		au.send();
	})
</script>
</head>
<body>
	<table id="table" data-height="460" 
	class="table table-bordered table-hover">
		<thead>
			<tr>
				<th data-field="bNum" class="text-center">번호</th>
				<th data-field="title" class="text-center">제목</th>
				<th data-field="content" class="text-center">내용</th>
				<th data-field="writer" class="text-center">게시자</th>
				<th data-field="regDate" class="text-center">게시일자</th>
			</tr>
		</thead>
		<tbody id="r_tbody">
		</tbody>
	</table>
</body>
</html>