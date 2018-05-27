src = "jquery-3.2.1.min.js";


var title, creator, type, released, length, link, file, isSeason, sName, sNum, eName, eNum;
var video;

$(document).ready(function() {
	title = document.getElementById("title");
	creator = document.getElementById("create");
	type = document.getElementById("type");
	released = document.getElementById("found");
	length = document.getElementById("lengt");
	length.parseInt();
	link = document.getElementById("Link");
	file = document.getElementById("fileN");
});
//../Java Resources/src/SS_servelets.vHome.java
function storeVid() {
	if (document.getElementById("isS").checked == true) {
		isSeasn = true;
		sName = document.getElementById("seasonName");
		sNum = document.getElementById("seasonNum");
		eName = document.getElementById("epiName");
		eNum = document.getElementById("epiNum");
	} else{
		isSeries = false;
		sName, sNum, eName,eNum = null;
	}
	var SE = {sName: {sNum: eName}, eName};
	video = {title, creator, series, type, length, fileName, link, SE, datePub, isSeries};
}

function showSeason() {
	if (document.getElementById("isS").checked == true) {
		document.getElementById("seasons").style.visibility = "Visible";
	} else {
		document.getElementById("seasons").style.visibility = "Hidden";
	}
}