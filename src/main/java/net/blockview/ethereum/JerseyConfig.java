package net.blockview.ethereum;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.stereotype.Component;

import io.swagger.jaxrs.config.BeanConfig;
import io.swagger.jaxrs.listing.ApiListingResource;
import io.swagger.jaxrs.listing.SwaggerSerializers;
import net.blockview.ethereum.endpoints.AccountEndPoint;
import net.blockview.ethereum.endpoints.BlockEndPoint;
import net.blockview.ethereum.endpoints.TxEndPoint;

@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		registerEndpoints();
		configureSwagger();
	}

	private void registerEndpoints() {
		register(AccountEndPoint.class);
		register(BlockEndPoint.class);
		register(TxEndPoint.class);
	}

	private void configureSwagger() {
		register(ApiListingResource.class);
		register(SwaggerSerializers.class);
		swaggerBeanConfig();
	}

	private void swaggerBeanConfig() {
		BeanConfig beanConfig = new BeanConfig();
		beanConfig.setVersion("1.0.0");
		beanConfig.setSchemes(new String[] { "http" });
		beanConfig.setHost("localhost:8080");
		beanConfig.setBasePath("/api");
		beanConfig.setResourcePackage("net.blockview.ethereum.endpoints");
		beanConfig.setPrettyPrint(true);
		beanConfig.setScan(true);
	}
}
