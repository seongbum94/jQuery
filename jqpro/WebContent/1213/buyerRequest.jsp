<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<script src = "../js/jquery-3.4.1.min.js"></script>
<link rel = "stylesheet" href = "../css/mycss.css">
<script>
	$(function(){
		$.get(
			'buyerList.jsp',
			function(res){
				code = "";
				$.each(res, function(i){
					code += "<p id = '" + this.id + "'>" + this.name + "</p>"
// 					$('<p/>',{
// 						'id' : this.id,
// 						'name' : this.name
// 					}).appendTo($('#names'));
				});
				$('#names').html(code);
			},
			'json'
		);
		
		$('#names').on('click', 'p', function(){
			idvalue = $(this).attr('id');
			$.ajax({
				url : 'buyerDetail.jsp',
				data : {"id" : idvalue},
				type : 'get',
				dataType : 'json',
				success : function(res){
					code = "";
					code += "<table border = '1' class = 'table table-hover'>";
					code += "<tr><td>buyer_id</td><td>" + res.id + "</td></tr>"
					code += "<tr><td>buyer_name</td><td>" + res.name + "</td></tr>"
					code += "<tr><td>buyer_bank</td><td>" + res.bank + "</td></tr>"
					code += "<tr><td>buyer_bankNO</td><td>" + res.bankNO + "</td></tr>"
					code += "<tr><td>buyer_bankName</td><td>" + res.bankName + "</td></tr>"
					code += "<tr><td>buyer_zip</td><td>" + res.zip + "</td></tr>"
					code += "<tr><td>buyer_addr</td><td>" + res.addr + "</td></tr>"
					code += "<tr><td>buyer_fax</td><td>" + res.fax + "</td></tr>"
					code += "</table>";
					$('#details').html(code);
				},
				error : function(xhr){
					alert("상태 : " + xhr	.status);
				}
			})
		})
	})
</script>
<style>
	table{
		border : 2px solid orange;
		border-collapse: collapse;
		text-align: center;
		margin : 20px auto;
	}
	td{
		width : 150px;
		height : 20px;
	}
	#details{
		width : 500px;
	}
	p:hover{
		background : lime;
	}
</style>
</head>
<body>
	<table border="1">
		<tr>
			<td>거래처명</td>
			<td>거래처상세정보</td>
		</tr>
		<tr>
			<td id = "names"></td>
			<td id = "details"></td>
		</tr>
	</table>
</body>
</html>