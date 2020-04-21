<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- RSS 서비스를 제공하는 웹어플리케이션을 요청하여 응답결과를 
클라이언트에게 전달하는 JSP 문서 --%>
<%-- RSS(Really Simple Syndication 또는 Rich Site Summary) : 실시간으로
변경되는 정보를 제공하기 위한 웹서비스의 종류 --%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AJAX</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
</head>
<body>
	<h1>RSS Reader</h1>
	<hr>
	<div id="display"></div>
	
	<script type="text/javascript">
	$.ajax({
		type: "GET",
		//AJAX 기능은 같은 서버에 존재하는 웹어플리케션만 요청 가능
		// => 다른 서버의 웹어플리케이션을 요청 불가능(에러코드 : 0)
		//url: "http://www.khan.co.kr/rss/rssdata/kh_entertainment.xml",
		//현재 서버의 웹어플리케이션(프록시 기능) 요청
		url: "rss_proxy.jsp",
		dataType: "xml",
		success: function(xmlDoc) {
			var channelTitle=$(xmlDoc).find("channel").children("title").text();
			var html="<h2>"+channelTitle+"</h2>";
			
			html+="<ul>";
			$(xmlDoc).find("item").each(function() {
				var title=$(this).find("title").text();
				var link=$(this).find("link").text();
				var date;
				if($(this).find("pubDate").size()!=0) {
					date=$(this).find("pubDate").text();
				} else {
					date=$(this).find("dc\\:date").text();
				}
				html+="<li><a href='"+link+"'>"+title+"["+date+"]</a></li>";
			});
			html+="</ul>";
			
			$("#display").html(html);
		},
		error: function(xhr) {
			alert("에러코드 = "+xhr.status);
		}
	});
	</script>
</body>
</html>








