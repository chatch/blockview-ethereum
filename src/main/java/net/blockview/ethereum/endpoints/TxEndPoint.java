package net.blockview.ethereum.endpoints;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.ethereum.jsonrpc.TransactionResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.blockview.ethereum.EthereumBean;

@Component
@Path("tx")
@Api("tx")
@Produces("application/json")
public class TxEndPoint {

	@Autowired
	EthereumBean eth;

	@GET
	@Path("{hash}")
	@ApiOperation(value = "Get transaction by hash", response = TransactionResultDTO.class)
	public TransactionResultDTO get(@PathParam("hash") String hash) throws Exception {
		return eth.getTransactionByHash(hash);
	}

}