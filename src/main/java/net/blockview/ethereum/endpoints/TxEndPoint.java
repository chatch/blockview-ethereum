package net.blockview.ethereum.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("tx")
@Api("tx")
@Produces("application/json")
public class TxEndPoint {
	@GET
	@Path("{id}")
	@ApiOperation(value = "Get transaction details", response = String.class)
	public String get(@PathParam("id") String id) {
		return id;
	}
}