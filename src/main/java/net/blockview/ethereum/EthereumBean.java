package net.blockview.ethereum;

import org.ethereum.core.Block;
import org.ethereum.facade.Ethereum;
import org.ethereum.facade.EthereumFactory;
import org.ethereum.jsonrpc.TypeConverter;

public class EthereumBean {

	Ethereum ethereum;

	public void start() {
		this.ethereum = EthereumFactory.createEthereum();
		this.ethereum.addListener(new EthereumListener(ethereum));
	}

	public Block getBestBlock() {
		return ethereum.getBlockchain().getBestBlock();
	}

	public Block getBlockByHash(String blockHash) throws Exception {
		byte[] bhash = TypeConverter.StringHexToByteArray(blockHash);
		return ethereum.getBlockchain().getBlockByHash(bhash);
	}

	public Block getBlock(Long id) {
		return ethereum.getBlockchain().getBlockByNumber(id);
	}

}
