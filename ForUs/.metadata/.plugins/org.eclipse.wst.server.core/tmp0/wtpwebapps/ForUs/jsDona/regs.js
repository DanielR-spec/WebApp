/**
 * AUTHOR: Daniel Reyes
 */
function getCookie(cname) {
  let name = cname + "=";
  let decodedCookie = decodeURIComponent(document.cookie);
  let ca = decodedCookie.split(';');
  for(let i = 0; i <ca.length; i++) {
    let c = ca[i];
    while (c.charAt(0) == ' ') {
      c = c.substring(1);
    }
    if (c.indexOf(name) == 0) {
      return c.substring(name.length, c.length);
    }
  }
  return "";
}
async function loadData(url) {
	
	var correo = getCookie("correo");
	var clave = getCookie("clave");
	
	url.searchParams.append('correo',correo);
	url.searchParams.append('clave',clave);
	
	console.log(correo);
	console.log(clave);
	console.log(url);
	
	const nombres = document.getElementById("nombres")
	const apellidos = document.getElementById("apellidos");
	const email = document.getElementById("correo");
	const passw = document.getElementById("clave");
	const cell = document.getElementById("cell");
	const doc = document.getElementById("doc");
	const direccion = document.getElementById("direccion");
	
	let headers = new Headers();

    headers.append('Accept', 'application/json');
	headers.append('Origin','http://localhost:8085');

    const response =await fetch(url,{
		mode:'cors',
        method: 'GET',
        headers: headers
    });
	console.log(response);

 	const data = await response.json();
  
	console.log(data.nombres);
	
	if(data.nombres != ""){
			
			nombres.placeholder = data.nombres;
			
		}
	if(data.apellidos != ""){
			
		apellidos.placeholder = data.apellidos;
			
		}
	if(data.correo != ""){
			
		email.placeholder = data.correo;
			
		}
	if(data.clave != ""){
			
		passw.placeholder = data.clave;
			
		}
	if(data.cell != ""){
			
		cell.placeholder = data.cell;
			
		}
	if(data.doc != ""){
			
		doc.placeholder = data.doc;
			
		}
	if(data.direccion != ""){
			
		direccion.placeholder = data.direccion;
			
		}
	console.log(data);

	console.log(nombres);
	console.log(apellidos);
	console.log(email);	
}
var url = new URL("http://localhost:9080/ApiEndpoint/rest/user/auth");
loadData(url);
