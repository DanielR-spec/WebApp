function getCookie(name) {
  const value = `; ${document.cookie}`;
  const parts = value.split(`; ${name}=`);
  if (parts.length === 2) return parts.pop().split(';').shift();
  
}
async function loadTable(url, table) {
  //const tableHead = table.querySelector("thead");
  const tableBody = table.querySelector("tbody");
  const response = await fetch(url);
  console.log(response)
  const { headers, rows } = await response.json();

  console.log(tableBody);
  // Clear table

  console.log(headers);
  console.log(rows); 

  //tableHead.innerHTML = "<tr></tr>";
  tableBody.innerHTML = "<tr></tr>";

  // Get Values of Json
  for (const headerText of headers){
  	for (const cellText of headerText) {
	
		var idUsr =  cellText.idUsr;
		var idDonaFire =  cellText.idDonaFire;
		var idDonaBack =  cellText.idDonaBack;
	   //for (const key of cellText){
		//}
    }
  }
	
  console.log(idUsr);
  console.log(idDonaFire);
  console.log(idDonaBack);	
  //Pupilate the rows

  for (const row of rows) {
    const rowElement = document.createElement("tr");

    for (const cellText of row) {
      const cellElement = document.createElement("td");
      const style = document.createElement("span");
      const acc = document.createElement("div");
      const acc2 = document.createElement("button");
      const perz = document.createAttribute("data-bs-toggle");
      perz.value = "dropdown";
      const acc3 = document.createElement("i");
      const acc4 = document.createElement("div");
      const acc5 = document.createElement("a");
      const acc6 = document.createElement("i");

      if (cellText == "Activa") {
        style.className = "badge bg-label-info me-1";
        style.textContent = cellText;
        cellElement.appendChild(style);
      } else if (cellText == "En proceso") {
        style.className = "badge bg-label-warning me-1";
        style.textContent = cellText;
        cellElement.appendChild(style);
      } else if (cellText == "Finalizado") {
        style.className = "badge bg-label-success me-1";
        style.textContent = cellText;
        cellElement.appendChild(style);
      } else {
        cellElement.textContent = cellText;
      }

/*IMPORTANTE ESTA PARTE SE CREA EL BOTON QUE PASA A GESTIONAR 
SI NO SE CREA QUEDA VACIO Y NO SE PUEDE CREAR ESTATICAMENTE EN L
EL HTML PORQUE EL TAG PAdRE DE LA TABLA CON LA INFORMACION SE ESTA 
CREANDO DIRECTAMENTE EN JS ENTONCES CUaNDO SE EJECUTA QUEDA VACIO, 
TAMBIEN EL JSON DE RESPUESTA DEBE LLEVAR UN CAMPO VACIO QUE ES LA VALIDACION
PARA CREAR EL ULTIMO ELEMENTO DE LA TABLA DE DONACIONES QUE EN DEFINITIVA ES EL 
BOTON QUE PASA A LA PANTALLA DE GESTIONAR DONACIONES Y SE VALIDA EN EL SIGUIENTE 
IF STATEMENT*/

      if (cellText == "") {
        acc.className = "dropdown";
        acc2.type = "button";
        acc2.className = "btn p-0 dropdown-toggle hide-arrow";
        acc3.className = "bx bx-dots-vertical-rounded";
        acc2.setAttributeNode(perz);
        acc2.appendChild(acc3);
        acc.appendChild(acc2);
        acc4.className = "dropdown-menu";
        acc5.className = "dropdown-item";
        acc5.href = "http://localhost:8085/ForUs/PrendasSrv?idUsuario="+idUsr+"&"+"idDonaFire="+idDonaFire+"&"+"idDonaBack="+idDonaBack;
        acc6.className = "bx bx-edit-alt me-1";
        acc6.textContent = "Gestionar";
        acc5.appendChild(acc6);
        acc4.appendChild(acc5);

        acc.appendChild(acc4);
        cellElement.appendChild(acc);
      }

      rowElement.appendChild(cellElement);
    }

    tableBody.appendChild(rowElement);
  }
}



var url = new URL("http://localhost:9080/ApiEndpoint/rest/donacion/getFun?");
//url.searchParams.append('idFundacion', getCookie(name));
url.searchParams.append('idFundacion', getCookie("id"));

loadTable(url, document.querySelector("table"));

//loadTable("./data3.json", document.querySelector("table"));
