function log(message) {
	var logElement=document.getElementById("log");
	if(logElement!=null) {
		logElement.innerHTML+=message+"<br>";
	}
}