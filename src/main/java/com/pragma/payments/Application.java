package com.pragma.payments;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.retry.annotation.EnableRetry;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import io.github.resilience4j.timelimiter.annotation.TimeLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import jakarta.annotation.PostConstruct;
import java.time.Duration;
import java.util.concurrent.TimeoutException;

@SpringBootApplication
@EnableRetry
public class Application {
    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${resilience4j.circuitbreaker.configs.default.failureRateThreshold}")
    private float failureRateThreshold;

    @Value("${resilience4j.retry.configs.default.maxAttempts}")
    private int maxRetryAttempts;

    @PostConstruct
    public void init() {
        logger.info("Inicializando aplicación: {}", applicationName);
        logger.info("Configuración de resiliencia - CircuitBreaker: failureRateThreshold={}%, Retry: maxAttempts={}",
                failureRateThreshold, maxRetryAttempts);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public ApplicationListener<ApplicationReadyEvent> onApplicationReady() {
        return event -> {
            logger.info("Aplicación lista para recibir peticiones");
            // Simulación de carga inicial para verificar configuración de resiliencia
            simulateInitialLoad();
        };
    }

    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackInitialLoad")
    @Retry(name = "paymentService")
    @TimeLimiter(name = "paymentService", fallbackMethod = "fallbackInitialLoad")
    private void simulateInitialLoad() {
        logger.info("Simulando carga inicial para verificar patrones de resiliencia");
        // Simulación de una operación crítica que podría fallar
        boolean success = performCriticalOperation();
        if (!success) {
            throw new RuntimeException("Fallo en operación crítica durante carga inicial");
        }
    }

    private boolean performCriticalOperation() {
        // Simulación de una operación externa con posible fallo
        try {
            Thread.sleep(Duration.ofMillis(200).toMillis());
            // Simulación aleatoria de fallo (30% probabilidad)
            if (Math.random() < 0.3) {
                logger.warn("Operación crítica falló (simulado)");
                return false;
            }
            logger.info("Operación crítica completada con éxito");
            return true;
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            logger.error("Operación crítica interrumpida", e);
            return false;
        }
    }

    private void fallbackInitialLoad(Exception e) {
        logger.warn("Fallback activado para carga inicial: {}", e.getMessage());
        // Lógica de contingencia
        logger.info("Sistema continúa en modo degradado - funcionalidades críticas disponibles");
    }

    @Component
    public static class ApplicationHealthCheck {
        private final ApplicationContext context;
        private static final Logger logger = LoggerFactory.getLogger(ApplicationHealthCheck.class);

        public ApplicationHealthCheck(ApplicationContext context) {
            this.context = context;
        }

        @PostConstruct
        public void checkDependencies() {
            logger.info("Verificando dependencias críticas de la aplicación");
            try {
                // Verificación de contexto de Spring
                if (context == null) {
                    throw new IllegalStateException("Contexto de Spring no inicializado");
                }
                logger.info("Contexto de Spring verificado");
            } catch (Exception e) {
                logger.error("Fallo en verificación de dependencias", e);
                throw new IllegalStateException("Dependencias críticas no disponibles", e);
            }
        }
    }
}