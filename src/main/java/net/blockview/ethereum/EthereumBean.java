package net.blockview.ethereum;

import static org.ethereum.jsonrpc.TypeConverter.*;

import org.apache.commons.lang3.math.NumberUtils;
import org.ethereum.db.TransactionStore;
import org.ethereum.facade.Blockchain;
import org.ethereum.facade.Ethereum;
import org.ethereum.jsonrpc.JsonRpc;
import org.ethereum.jsonrpc.JsonRpc.BlockResult;
import org.ethereum.jsonrpc.TransactionResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EthereumBean {
	private static final Logger LOG = LoggerFactory.getLogger(EthereumBean.class);

	private static final boolean FETCH_FULL_TX = false;

	@Autowired
	Ethereum ethereum;

	@Autowired
	Blockchain bc;

	@Autowired
	TransactionStore txStore;

	@Autowired
	JsonRpc rpc;

	public BlockResult getBlock(String id) throws Exception {
		if ("genesis".equalsIgnoreCase(id)) {
			return rpc.eth_getBlockByNumber("0x0", FETCH_FULL_TX);
		} else if ("latest".equalsIgnoreCase(id)) {
			return rpc.eth_getBlockByNumber(rpc.eth_blockNumber(), FETCH_FULL_TX);
		}

		String blockNumber;
		if (id.startsWith("0x")) {
			blockNumber = StringHexToBigInteger(id).toString();
		} else if (NumberUtils.isNumber(id)) {
			blockNumber = id;
		} else {
			return null;
		}

		return rpc.eth_getBlockByNumber(blockNumber, FETCH_FULL_TX);
	}

	public TransactionResultDTO getTransactionByHash(String hash) throws Exception {
		return rpc.eth_getTransactionByHash(hash);
	}

}
