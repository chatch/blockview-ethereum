package net.blockview.ethereum;

import java.util.concurrent.Executors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Config {

	@Bean
	EthereumBean ethereumBean() throws Exception {
		EthereumBean ethereumBean = new EthereumBean();
		Executors.newSingleThreadExecutor().submit(ethereumBean::start);
		return ethereumBean;
	}
}
