package net.blockview.ethereum;

import static com.jayway.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.boot.test.WebIntegrationTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jayway.restassured.RestAssured;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = BlockviewApplication.class)
@WebIntegrationTest(randomPort = true)
public class BlockviewApplicationTests {

	@Value("${local.server.port}")
	int port;

	@Before
	public void setUp() {
		RestAssured.port = port;
	}

	@Test
	public void checkSwaggerApi() {
		when().get("/api/swagger.json").then().body("swagger", is("2.0"));
	}

	@Test
	public void checkSwaggerUi() {
		when().get("/webjars/swagger-ui/2.1.4/index.html?url=http://localhost:" + port).then()
				.body(containsString("body class=\"swagger-section\""));
	}

	@Test
	public void getBlock() {
		when().get("/api/block/12").then().body(is("12"));
	}

	@Test
	public void getTx() {
		when().get("/api/tx/13").then().body(is("13"));
	}

	@Test
	public void getAccount() {
		when().get("/api/account/14").then().body(is("14"));
	}

}
