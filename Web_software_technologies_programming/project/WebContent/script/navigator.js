$(document).ready(function(){
	
	$('#aboutlist').hover(
			function(){
				//shows action list submenu
				$('li', this).delay(50).slideDown(100);
			},
			function(){
				//hides  action list submenu
				$('li', this).slideUp(200);
			}
	);

	$('#loglist').hover(
			function(){
				//shows log submenu
				$('li', this).delay(50).slideDown(100);
			},
			function(){
				//hides log submenu
				$('li', this).slideUp(200);
			}
	);

	$('#prodlist').hover(
			function(){
				//shows prod submenu
				$('li', this).delay(50).slideDown(100);
			},
			function(){
				//hides log submenu
				$('li', this).slideUp(200);
			});

});

function searchPress(str){
	var dataList = document.getElementById('searching');
	if (str.length == 0) {
		dataList.innerHTML = '';
		return;
	}

	var xhttp = new XMLHttpRequest();
	xhttp.responseType = 'json';
	xhttp.onreadystatechange = function() {
		if (this.readyState == 4 && this.status == 200) {
			dataList.innerHTML = '';
			for ( var i in this.response) {
				var option = document.createElement('option');
				option.value = this.response[i];
				dataList.appendChild(option);
			}
		}
	}
    xhttp.open("GET", "Search?str="+str, true);
    xhttp.send();
}