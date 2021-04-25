package app.smartive.omniva.configuration;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix="external.host")
@Getter
@Setter
public class HostAddressConfig {
    private String address;
    private String uri;
}