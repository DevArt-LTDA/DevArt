package com.DevArt.Usuarios;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.assertThat;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import com.DevArt.Usuarios.controller.UsuariosController;

// Java
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, properties = { "spring.profiles.active=dev" })
public class UsuariosApplicationTests {

	@Autowired
	private UsuariosController usuarioController;

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	public void contextLoads() {
		System.out.println("Testing the context loading...");
	}

	@Test
	public void contextLoads2() throws Exception {
		System.out.println("Testing the context loading. and the controller...");
		assertThat(usuarioController).isNotNull();
	}


	@Test
	public void testGetUsuarios() throws Exception {
		System.out.println("Testing the getUsuarios method...");
		String url = "http://localhost:" + port + "/api/v1/usuarios";
		String response = this.restTemplate.getForObject(url, String.class);
		assertThat(response).contains("usuarios");
		System.out.println("Response: " + response);
	}


	@Test
	public void testGetUsuariosByRut() throws Exception {
		System.out.println("Testing the getUsuariosById method...");
		String url = "http://localhost:" + port + "/api/v1/usuarios/22.222.222-4";
		String response = this.restTemplate.getForObject(url, String.class);
		assertThat(response).contains("rut");
		System.out.println("Response: " + response);
	}

	@Test
	public void testGetUsuarioPrimerNombre() throws Exception {
		System.out.println("Testing the getUsuarioPrimerNombre method...");
		String url = "http://localhost:" + port + "/api/v1/usuarios/nombre/Aaron";
		String response = this.restTemplate.getForObject(url, String.class);
		assertThat(response).contains("Aaron");
		System.out.println("Response: " + response);
	}

	@Test 
	public void testGetUsuarioSegundoNombre() throws Exception {
		System.out.println("Testing the getUsuarioSegundoNombre method...");
		String url = "http://localhost:" + port + "/api/v1/usuarios/segundoNombre/Josue";
		String response = this.restTemplate.getForObject(url, String.class);
		assertThat(response).contains("Josue");
		System.out.println("Response: " + response);
	}

	@Test 
	public void testGetUsuarioPrimerApellido() throws Exception {
		System.out.println("Testing the getUsuarioPrimerApellido method...");
		String url = "http://localhost:" + port + "/api/v1/usuarios/primerApellido/Lorca";
		String response = this.restTemplate.getForObject(url, String.class);
		assertThat(response).contains("Lorca");
		System.out.println("Response: " + response);
	}

	@Test
	public void testCreateUsuario() throws Exception {
		System.out.println("Testing the createUsuario method...");
		String url = "http://localhost:" + port + "/api/v1/usuarios";
		String newUsuario = "{\"rut\":\"33.333.333-3\",\"nombre\":\"Juan\",\"apellido\":\"Perez\",\"email\":\"juan.perez@email.com\"}";

		var response = this.restTemplate.postForEntity(url, newUsuario, String.class);
		assertThat(response.getStatusCodeValue()).isEqualTo(201);
		assertThat(response.getBody()).contains("33.333.333-3");
		assertThat(response.getBody()).contains("Juan");
		assertThat(response.getBody()).contains("Perez");
		assertThat(response.getBody()).contains("juan.perez@email.com");
		System.out.println("Response: " + response.getBody());
	}
	


	}