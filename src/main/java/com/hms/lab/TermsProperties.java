package com.hms.lab;

import com.hms.lab.model.ExternalReference;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "terms")
public class TermsProperties {

    private List<ExternalReference> references;

    public List<ExternalReference> getReferences() {
        return references;
    }

    public void setReferences(List<ExternalReference> references) {
        this.references = references;
    }
}
