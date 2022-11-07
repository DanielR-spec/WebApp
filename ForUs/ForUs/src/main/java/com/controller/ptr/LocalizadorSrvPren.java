/**
 * 
 */
package com.controller.ptr;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputFilter.Config;
import java.io.UnsupportedEncodingException;
import java.net.http.HttpClient;
import java.util.ArrayList;

import javax.ws.rs.QueryParam;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.UriBuilder;

import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;

/**
 * @author danie
 *
 */
public class LocalizadorSrvPren {

	/**
	 * 
	 */
	public LocalizadorSrvPren() {
		// TODO Auto-generated constructor stub
	}

	// FUNCIONES PRINCIPALES
	public String getUser(String usr, String pss) throws IOException {

		System.out.println("Invocaci�n al m�todo getUser del Localizador de servicios");

		// your url i.e fetch data from .
		String url = getUrl(1);

		String charset = "UTF-8";

		String queryNam = String.format("correo=%s", URLEncoder.encode(usr, charset));
		String queryPass = String.format("clave=%s", URLEncoder.encode(pss, charset));

		URI usrr = null;

		try {
			usrr = appendUri(url, queryNam);
			usrr = appendUri(usrr.toString(), queryPass);
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("Creando conexion con servidor...");
		System.out.println("EndPoint: " + usrr);
//	
		URLConnection connection = (HttpURLConnection) usrr.toURL().openConnection();
		connection = (HttpURLConnection) connection;
		((HttpURLConnection) connection).setRequestMethod("GET");
		connection.setRequestProperty("Accept", "application/json");
	
		if (((HttpURLConnection) connection).getResponseCode() == 200) {

			System.out.println("Conexi�n establecida con el servidor:");
		} else if (((HttpURLConnection) connection).getResponseCode() != 200) {

			System.out.println("No se pudo establecer conexi�n con el servidor");
			throw new RuntimeException(
					"Failed : HTTP Error code not found: " + ((HttpURLConnection) connection).getResponseCode());
		}

		InputStreamReader in = new InputStreamReader(connection.getInputStream());
		BufferedReader br = new BufferedReader(in);
		String output = br.toString();
		

		System.out.println("Respuesta del server en el metodo getUSer (Lcz):");
		ArrayList<String> infoUs = new ArrayList<String>();

		while ((output = br.readLine()) != null) {
			infoUs.add(output);
			System.out.println(output);

		}

		((HttpURLConnection) connection).disconnect();
		
		return infoUs.get(0);

	}

	// FUNCIONES AUXILIARES

	public static URI appendUri(String uri, String appendQuery) throws URISyntaxException {
		URI oldUri = new URI(uri);
		return new URI(oldUri.getScheme(), oldUri.getAuthority(), oldUri.getPath(),
				oldUri.getQuery() == null ? appendQuery : oldUri.getQuery() + "&" + appendQuery, oldUri.getFragment());
	}

	public String getUrl(int urlCs) {

		switch (urlCs) {
		case 1: {
			return "http://localhost:9080/ApiEndpoint/rest/user/auth";
		}
		case 2: {
			return "http://localhost:9080/ApiEndpoint/rest/user/add";
		}
		case 3: {
			return "http://localhost:9080/ApiEndpoint/rest/user/upd";
		}
		case 4: {
			return "http://localhost:9080/ApiEndpoint/rest/user/del";
		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + urlCs);
		}

	}

}
