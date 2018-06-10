function newVid() {
	window.location.assign("newVid.html");
}

function displayVids() {
	var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (this.readyState == 4 && this.status == 200) {
        	var videos = JSON.parse(this.responseText);
            getVids(videos);
        }
    }
    xhr.open('GET', 'vHome/get', true);
    xhr.send();
}

function getVids(videos) {
	var fragment = document.createDocumentFragment();
	for (var i = 0; i < videos.length; i++) {
		var vT = videos[i][0];
		var vC = videos[i][1];
		var vTy = videos[i][2];
		var vSE = videos[i][3];
		var vF = videos[i][4];
		var vU = videos[i][5];
		var vL = videos[i][6];
		var vD = videos[i][7];
		var vB = video[i][8];
		var vid;
		if (vB == false && vF == null) {
			vid = [vT, vC, vTy, vU, vI, vD];
		} else if (vB == false && vU == null) {
			vid = [vT, vC, vTy, vU, vI, vD];
		} else {
			vid = [vT, vC, vTy, vF, vU, vI, vD];
		}
		var m = makeList(vid);
		fragment.appendChild(m);
	}
	document.getElementById("list").appendFragment(fragment);
}

function makeList(vid) {
	var tb = document.createElement("table");
	var ro = document.createElement("tr");
	for (var n = 0; n < vid.length; n++) {
		var td = document.createElement("td");
		if (n == 0 || n == 1) {
			td.setAttribute("colspan", 3);
		}
		td.appendChild(vid[n]);
		ro.appendChild(td);
	}
	tb.appendChild(ro);
	var li = document.createElement("li");
	li.appendChild(li);
}