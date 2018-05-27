src = "jquery-3.2.1.min.js";


var title, author, publisher, datePub, length, link, file, isSeries, series, sNum;
var book;

$(document).ready(function() {
	title = document.getElementById("title");
	author = document.getElementById("autho");
	publisher = document.getElementById("publish");
	datePub = document.getElementById("publishe");
	length = document.getElementById("lengt");
	link = document.getElementById("Link");
	file = document.getElementById("fileN");
	if (document.getElementById("isS").checked == true) {
		isSeries = true;
		series = document.getElementById("serName");
		sNum = document.getElementById("seriesN");
	} else{
		isSeries = false;
		series, sNum = null;
	}
});

function bindBook() {
	book = [tite, author, series, publisher, length, seriesNum, fileName, link, datePub,isSeries];
}