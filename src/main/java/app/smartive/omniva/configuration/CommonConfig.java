package app.smartive.omniva.configuration;

import app.smartive.omniva.model.LocationDto;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Configuration
public class CommonConfig {

    private final HostAddressConfig hostAddressConfig;

    public CommonConfig(HostAddressConfig hostAddressConfig) {
        this.hostAddressConfig = hostAddressConfig;
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper();
    }

    @Bean
    public WebClient createWebClient(){
        return WebClient.builder()
                .baseUrl(hostAddressConfig.getAddress())
                .build();
    }

    @Bean
    public List<LocationDto> locationDtoList() {
        return createWebClient()
                .get()
                .uri(hostAddressConfig.getUri())
                .retrieve()
                .bodyToFlux(LocationDto.class)
                .collectList()
                .block();
    }
}