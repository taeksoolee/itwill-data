/* AJAX Module : 전역변수와 함수를 이용하여 AJAX 기능 제공 */
var xhr=null;
	
function getXMLHttpRequest() {
	if(window.ActiveXObject) {//IE4 ~ IE6
		try {
			return new ActiveXObject("msxml2.XMLHTTP");//IE5 ~ IE6
		} catch (e) {
			try {
				return new ActiveXObject("MicrosoftXMLHTTP");//IE4
			} catch (e) {
				return null;
			}
		}
	} else if(window.XMLHttpRequest) {//IE7 이상 또는 기타 브라우저
		return new XMLHttpRequest();
	} else {
		return null;
	}
}

/* 요청과 응답 처리를 위한 함수 선언 */
function sendRequest(method, url, param, callback) {
	xhr=getXMLHttpRequest();
	
	//요청방식에 대한 검증과 저장
	var httpMethod=method?method:"GET";
	if(httpMethod!="GET" && httpMethod!="POST") {
		httpMethod="GET";
	}
	
	//전달값에 대한 검증과 저장
	var httpParam=(param==null || param=="")?null:param;
	
	//요청 URL 주소 저장
	var httpUrl=url;
	
	//GET 방식으로 요청시 전달값이 존재할 경우 URL 주소에 QueryString 추가
	if(httpMethod=="GET" && httpParam!=null) {
		httpUrl=httpUrl+"?"+httpParam;
	}
		
	//응답결과를 제공받아 처리하기 위한 함수 등록
	xhr.onreadystatechange=callback;
	
	//웹어플리케이션 요청
	xhr.open(httpMethod, httpUrl);
	xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	xhr.send(httpMethod=="POST"?httpParam:null);
}
