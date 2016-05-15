package net.blockview.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Component
@Path("/block")
@Api("block")
@Produces("application/json")
public class BlockEndPoint {
	@GET
	@ApiOperation(value = "Get details for a block", response = String.class)
	public String get() {
		return "Block";
	}
}