/* AJAX Module : 객체(속성과 메소드)를 이용하여 AJAX 기능 제공 */
/* => 효율적인 비동기 요청에 대한 응답처리 제공  */
var site={};
site.itwill={};

//생성자 함수
site.itwill.Ajax=function(method, url, param, callback) {
	//객체 속성 추가
	this.method=method;
	this.url=url;
	this.param=param;
	this.callback=callback;
	this.send();//메소드 호출
}

site.itwill.Ajax.prototype={
	//XMLHttpRequest 객체를 생성하여 반환하는 메소드	
	getXMLHttpRequest:function() {
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
	},
	//XMLHttpRequest 객체를 이용하여 AJAX 요청하기 위한 메소드
	send:function() {
		//XMLHttpRequest 객체를 반환받아 객체 속성 추가
		this.xhr=this.getXMLHttpRequest();
		
		//요청방식에 대한 검증과 저장
		var httpMethod=this.method?this.method:"GET";
		if(httpMethod!="GET" && httpMethod!="POST") {
			httpMethod="GET";
		}
		
		//전달값에 대한 검증과 저장
		var httpParam=(this.param==null || this.param=="")?null:this.param;
		
		//요청 URL 주소 저장
		var httpUrl=this.url;
		
		//GET 방식으로 요청시 전달값이 존재할 경우 URL 주소에 QueryString 추가
		if(httpMethod=="GET" && httpParam!=null) {
			httpUrl=httpUrl+"?"+httpParam;
		}
			
		//응답결과를 제공받아 처리하기 위한 함수 등록
		// => 응답결과 처리함수에 XMLHttpRequest 객체 제공
		// => 객체 내부의 XMLHttpRequest 객체에 접근하지 못하도록 복사본 제공
		var request=this;
		this.xhr.onreadystatechange=function() {
			//call 함수를 메소드의 this 변수에 전달될 객체 변경
			request.onStateChange.call(request);
		}
		
		//웹어플리케이션 요청
		this.xhr.open(httpMethod, httpUrl);
		this.xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
		this.xhr.send(httpMethod=="POST"?httpParam:null);
	},
	//응답결과를 처리하는 함수를 호출하는 메소드
	onStateChange:function() {
		this.callback(this.xhr);
	}
};