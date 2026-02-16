package br.com.yctus.api.comment.service.infraestructure.dataproviders.services.utils;

import br.com.yctus.api.comment.service.infraestructure.dataproviders.services.ModerationServices;
import br.com.yctus.api.comment.service.infraestructure.dataproviders.services.RestClientFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@Slf4j
public class RestClientConfig {

    @Bean
    public RestClient.Builder restClientBuilder() {
        return RestClient.builder();
    }

    @Bean
    public ModerationServices sensorMonitoring(RestClientFactory restClientFactory) {
        RestClient restClient = restClientFactory.moderationServiceClient();
        RestClientAdapter restClientAdapter = RestClientAdapter.create(restClient);

        HttpServiceProxyFactory proxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();

        log.info("Creating ModerationServices client proxy: {}", proxyFactory);

        return proxyFactory.createClient(ModerationServices.class);
    }
}