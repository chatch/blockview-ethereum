package net.blockview.ethereum;

import org.ethereum.config.DefaultConfig;
import org.ethereum.facade.Ethereum;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BlockviewApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication
				.run(new Object[] { DefaultConfig.class, BlockviewApplication.class }, args);
		Ethereum ethereum = ctx.getBean(Ethereum.class);
		ethereum.addListener(new EthereumListener(ethereum));
	}
}
