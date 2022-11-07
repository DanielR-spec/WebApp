async function loadTable(url, table) {
  const tableBody = table.querySelector("div.row");

  const response = await fetch(url);

  const {rows} = await response.json();

  console.log(response);
  console.log(rows);
  console.log(tableBody);

 for (const row of rows) {
    const rowElement = document.createElement("div");
	rowElement.className = "col-lg-12";

	console.log(rowElement);

    for (const cellText of row) {
		
	  const item = document.createElement("div");
	  item.className = "item";
	  const row = document.createElement("div");
	  row.className = "row"
	  const imagen = document.createElement("div");
 	  const text = document.createElement("div");

	  imagen.className = "col-lg-4 col-sm-5";
 	  text.className = "col-lg-8 col-sm-7";

	  const uniqueImg = document.createElement("div");
	  uniqueImg.className = "image";

      const url = document.createElement("img");

	  console.log(cellText);

	  url.src = cellText;

	
	  
	  uniqueImg.appendChild(url);
	  imagen.appendChild(uniqueImg);
	  row.appendChild(imagen);
	  item.appendChild(row);


      rowElement.appendChild(item);
    }

    tableBody.appendChild(rowElement);

	console.log(tableBody);
	}
  // Clear boton

}

function getCookie(name) {
  const value = `; ${document.cookie}`;
  const parts = value.split(`; ${name}=`);
  if (parts.length === 2) return parts.pop().split(';').shift();
  
}

var url = new URL("http://localhost:9080/ApiEndpoint/rest/donacion/getPrendDonFun?");
url.searchParams.append('idUsuario', getCookie("idUsuario"));
url.searchParams.append('idDonaFire', getCookie("idDonaFire"));


/*url.searchParams.append('idUsuario', "1");
url.searchParams.append('idDonaFire', "1_05_11_2022_12_32_47_3247");*/

console.log(url);
loadTable(url, document.querySelector("div.items"));
//console.log(getCookie("id"));

//Creando botona para cambiar de estado de donacion
const infoContainer = document.querySelector("div.visit-country")
const button = document.createElement("a");
button.className = "button";
button.href = "http://localhost:8085/ForUs/UpdDona?idDonaBack="+getCookie("idDonaBack");
button.textContent = "Confirmar"
infoContainer.appendChild(button);




