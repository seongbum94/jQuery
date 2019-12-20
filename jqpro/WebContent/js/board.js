/**
 * 
 */
var listServer = function(cpage){
	//db에 저장된 글 목록 가져오기 - listServer(1) listServer(2)
	$.ajax({
		url : "/jqpro/BoardList",
		type : "get",
		data : {
			"cpage" : cpage
		},
		dataType : "json",
		success : function(code){
			res = "";
			res += '<div class="panel-group" id="accordion">';
			
			$.each(code, function(i, v){
				
				res += '<div class="panel panel-default">';
			    res += '  <div class="panel-heading">';
			    res += '    <h4 class="panel-title">';
			    res += '      <a class="st action" name="list" idx="' + v.seq + '" data-toggle="collapse" data-parent="#accordion" href="#collapse' + v.seq + '">' + v.subject + '</a>';
			    res += '    </h4>';
			    res += '  </div>';
			    res += '  <div id="collapse' + v.seq + '" class="panel-collapse collapse">';
			    res += '    <div class="panel-body">';
			    res += '<p style="width: 70%; float: left;" class="pinfo">';
			    res += '작성자 : <span class="sw"> ' ;
			    res += v.writer + '</span>&nbsp; &nbsp; &nbsp; ';
			    res += '작성일 : ' + v.wdate + '&nbsp;&nbsp;&nbsp;';
			    res += '조회수 : <span class="hit">' + v.hit + '</span>' ;
			    res += '</p>';
			    res += '<p style="text-align: right;" class="pbutton">';
			    res += '<button idx="' + v.seq + '" type="button" name="modify" class="action">수정</button>';
			    res += '<button idx="' + v.seq + '" type="button" name="delete" class="action">삭제</button>';
			    res += '</p>';
			    res += '<hr>';
			    res += '<class="pinfo">';
			    res += '<span class="sc">' + v.cont+ '</span>';
			    res += '</p>';
			    res += '<hr>';
			    res += '<p>';
			    res += '<textarea class="area" rows="3" cols="50"></textarea>';
			    res += '<button type="button" idx="' + v.seq + '" name="reply" class="action">등록</button>';
			    res += '</p>';
			    res += ' 	 </div>';
			    res += '  </div>';
			    res += '</div>';
			})
			res += '</div>';
			$("#accordionList").empty().append(res);
		},
		error : function(xhr){
			alert("상태 : " + xhr.status);
		}
	});
}