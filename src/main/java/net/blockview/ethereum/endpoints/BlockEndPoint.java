package net.blockview.ethereum.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.ethereum.core.Block;
import org.ethereum.jsonrpc.JsonRpc.BlockResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.blockview.ethereum.EthereumBean;

@Component
@Path("block")
@Api("block")
@Produces("application/json")
public class BlockEndPoint {
	@Autowired
	EthereumBean eth;

	@GET
	@Path("{id}")
	@ApiOperation(value = "Get details for a block by number, hash, 'latest' or 'genesis'", response = Block.class)
	public BlockResult get(@PathParam("id") String id) throws Exception {
		return eth.getBlock(id);
	}

}