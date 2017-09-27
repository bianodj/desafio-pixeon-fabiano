var ws;

function connect() {
    var host = document.location.host;
    var pathname = document.location.pathname;

    var username = document.getElementById("username").value;

	document.getElementById("log").innerHTML = "";
    document.getElementById("msg").value = "";
    document.getElementById("msg").disenabled = false;
    
    ws = new WebSocket("ws://" +host  + pathname + "chat/" + username);
    ws.onmessage = function(event) {
    	var log = document.getElementById("log");
        console.log(event.data);
        var message = JSON.parse(event.data);
        log.innerHTML += message.from + " : " + message.content + "\n";
    };
}

function send() {
    var content = document.getElementById("msg").value;
    document.getElementById("msg").value = "";
    var json = JSON.stringify({
        "content":content
    });
    ws.send(json);
}

function leaveRoom() {
    ws.onclose = function () {}; // disable onclose handler first
    document.getElementById("username").value = "";
	document.getElementById("log").innerHTML = "";
    document.getElementById("msg").value = "";
	ws.close();
}
