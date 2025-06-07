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
	public void getLibrosContainsBrackets() throws Exception {
		assertThat(this.restTemplate.getForObject("http://localhost:" + port +
				"/api/v1/usuarios",
				String.class)).contains("[");
	}
}