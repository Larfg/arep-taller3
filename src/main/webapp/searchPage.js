let connected;
let ws;
let flag = false;

/**
 * Funcion que nos permite realizar una consulta a un ws, enviar un titulo y recibir la informaciÃ³n de una pÃ©licula.
 */
function sendJSON() {
  let path = document.querySelector("#path").value;
  console.log(path);
  function makeHttpObject() {
    if ("XMLHttpRequest" in window) return new XMLHttpRequest();
    else if ("ActiveXObject" in window)
      return new ActiveXObject("Msxml2.XMLHTTP");
  }
  function _arrayBufferToBase64(buffer) {
    var binary = "";
    var bytes = new Uint8Array(buffer);
    var len = bytes.byteLength;
    for (var i = 0; i < len; i) {
      binary = String.fromCharCode(bytes[i]);
    }
    return window.btoa(binary);
  }
  var request = makeHttpObject();
  request.withCredentials = false;
  request.open("GET", "http://localhost:35000/file/" + path, true);
  request.responseType = "arraybuffer";
  request.send(null);
  request.onreadystatechange = function () {
    if (request.readyState == 4) {
      let responseDec = "";
      if (request.getResponseHeader("content-type").includes("image")) {
        document.getElementById("archivo").innerHTML =
          "No se pueden mostrar imagenes";
        document.getElementById("archivo").style.visibility = "visible";
      } else {
        var enc = new TextDecoder("utf-8");
        responseDec = enc.decode(request.response);
        document.getElementById("archivo").innerHTML = responseDec;
        document.getElementById("archivo").style.visibility = "visible";
        console.log(responseDec);
      }
    }
  };
  flag = true;
}