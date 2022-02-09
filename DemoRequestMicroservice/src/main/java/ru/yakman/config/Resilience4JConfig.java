/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ru.yakman.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import java.time.Duration;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JConfigBuilder;
import org.springframework.cloud.client.circuitbreaker.Customizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author Test
 */
@Configuration
public class Resilience4JConfig {
    @Bean
    Customizer<Resilience4JCircuitBreakerFactory> defaultCustomizer() {
        return factory -> factory.configureDefault(id -> new Resilience4JConfigBuilder(id)
                .circuitBreakerConfig(
                        CircuitBreakerConfig.from(CircuitBreakerConfig.ofDefaults())
                                .slidingWindowSize(3)
                                .failureRateThreshold(30)
                                .build()
                        
                )
                .build());
    }
}