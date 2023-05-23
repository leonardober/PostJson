package com.example.PostJson;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class PostJsonApplication {

	public static void main(String[] args)
	{
		// define una variable de tipo String llamada url que contiene la URL de
		// la API REST que se va a llamar.

		String url = "https://jsonplaceholder.typicode.com/posts";

		// crea un objeto HttpHeaders, que se utiliza para especificar las cabeceras HTTP de la solicitud.
		HttpHeaders headers = new HttpHeaders();

		// establece el tipo de contenido de la solicitud en application/json.
		headers.setContentType(MediaType.APPLICATION_JSON);

		// define una variable de tipo String llamada requestBody que contiene el cuerpo de la solicitud.
		// En este caso, es un objeto JSON con las propiedades title, body y userId.
		String requestBody = "{\"title\": \"foo\", \"body\": \"bar\", \"userId\": 1}";

		// crea una instancia de RestTemplate utilizando RestTemplateBuilder,
		// que es una clase de ayuda para construir instancias de RestTemplate.
		RestTemplate restTemplate = new RestTemplateBuilder().build();

		//  crea un objeto HttpEntity que representa la solicitud HTTP completa,
		//  incluyendo el cuerpo y las cabeceras de la solicitud.
		HttpEntity<String> request = new HttpEntity<>(requestBody, headers);
        //ALMACENA LA INFORMACION
		// realiza una llamada HTTP POST a la URL especificada, utilizando el objeto RestTemplate.
		// La solicitud se construye utilizando el objeto HttpEntity creado anteriormente.
		// La respuesta se almacena en un objeto ResponseEntity que contiene el cuerpo de la respuesta
		// y la información de la cabecera.
		ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.POST, request, String.class);
                 //MANDA A IMPRIMIR A LA CONSOLA PREVIAMENTE INICIALIZADO
		//  imprime el código de estado de la respuesta HTTP en la consola.
		System.out.println("Response status: " + response.getStatusCode());
           //ERROR 404 NO ENCONTRADO
		// imprime el cuerpo de la respuesta HTTP en la consola.
		System.out.println("Response body: " + response.getBody());
	}   // RESPUESTA 200 ES SOLICTUD CORRECTA

}
