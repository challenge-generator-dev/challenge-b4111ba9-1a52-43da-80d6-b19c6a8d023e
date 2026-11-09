# Prompt para Mejorar el Codigo Base

Copia y pega el contenido del bloque de abajo en un asistente de IA (Claude, ChatGPT)
para obtener el proyecto completo y arrancable. Guarda los archivos que te devuelva en la
carpeta del repo, respetando exactamente las rutas.

Si preferis trabajar en tu editor con un agente local (Claude Code, Cursor, Copilot), usa `AGENTS.md` en vez de este archivo: dice lo mismo pero para que escriba los archivos en disco.

## Las dos reglas que no se negocian

1. **Completa el boilerplate.** Todo lo que el proyecto necesita para compilar y arrancar: manifiesto de dependencias, punto de entrada, configuracion, capa de interfaz, y las capas del patron arquitectonico declarado. Eso es andamiaje y es tu trabajo.
2. **NO resuelvas el reto.** Los entregables de las fases son el trabajo de la persona. El hueco pedagogico se deja como esta: el proyecto arranca, pero lo que el reto pide implementar NO esta implementado.

Dicho de otra forma: si algo impide compilar, arreglalo. Si algo es logica de negocio incompleta, validaciones ausentes, un secreto hardcodeado o un patron mejorable, dejalo exactamente como esta — es lo que la persona tiene que encontrar.

## Superficie de practica — NO resuelvas

Estos archivos SON el ejercicio de la persona. No los implementes; deja stubs.

- `src/main/java/com/pragma/payments/infrastructure/config/Resilience4jConfig.java` — El topic pide resiliencia: este archivo es el ejercicio.

## Lo que le falta a este proyecto

Esto NO lo tenes que adivinar: salio de comparar el proyecto contra la arquitectura declarada del reto y de un analisis estatico del codigo. Completalo TODO.

### Referencias colgando en el codigo que si esta

Cada una rompe la compilacion:

- `src/main/java/com/pragma/payments/infrastructure/adapter/JpaPaymentRepository.java` — `PaymentStatus.name`: Se invoca `name` sobre `PaymentStatus`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/application/usecase/PaymentUseCase.java` — `PaymentRequest.accountId`: Se invoca `accountId` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/application/usecase/PaymentUseCase.java` — `PaymentRequest.amount`: Se invoca `amount` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/application/usecase/PaymentUseCase.java` — `PaymentRequest.currency`: Se invoca `currency` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/application/usecase/PaymentUseCase.java` — `PaymentRequest.recipientAccount`: Se invoca `recipientAccount` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/infrastructure/adapter/PaymentEntityMapper.java` — `Payment.setStatus`: Se invoca `setStatus` sobre `Payment`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/infrastructure/adapter/PaymentEntityMapper.java` — `Payment.setFailureReason`: Se invoca `setFailureReason` sobre `Payment`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/infrastructure/controller/PaymentController.java` — `PaymentRequest.accountId`: Se invoca `accountId` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/infrastructure/controller/PaymentController.java` — `PaymentRequest.amount`: Se invoca `amount` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/infrastructure/controller/PaymentController.java` — `PaymentRequest.currency`: Se invoca `currency` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/infrastructure/controller/PaymentController.java` — `PaymentUseCase.createPayment`: Se invoca `createPayment` sobre `PaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/infrastructure/controller/PaymentController.java` — `PaymentRequest.recipientAccount`: Se invoca `recipientAccount` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/infrastructure/controller/PaymentController.java` — `PaymentUseCase.getPaymentsByAccountId`: Se invoca `getPaymentsByAccountId` sobre `PaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/main/java/com/pragma/payments/infrastructure/config/GlobalExceptionHandler.java` — `ErrorResponse.getDefaultMessage`: Se invoca `getDefaultMessage` sobre `ErrorResponse`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/application/usecase/PaymentUseCaseTest.java` — `PaymentRequest.accountId`: Se invoca `accountId` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/application/usecase/PaymentUseCaseTest.java` — `PaymentRequest.amount`: Se invoca `amount` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/application/usecase/PaymentUseCaseTest.java` — `PaymentRequest.currency`: Se invoca `currency` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/application/usecase/PaymentUseCaseTest.java` — `PaymentRequest.recipientAccount`: Se invoca `recipientAccount` sobre `PaymentRequest`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/application/usecase/PaymentUseCaseTest.java` — `PaymentUseCase.createPayment`: Se invoca `createPayment` sobre `PaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/application/usecase/PaymentUseCaseTest.java` — `Payment.get`: Se invoca `get` sobre `Payment`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/application/usecase/PaymentUseCaseTest.java` — `PaymentUseCase.getPaymentsByAccountId`: Se invoca `getPaymentsByAccountId` sobre `PaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/application/usecase/PaymentUseCaseTest.java` — `PaymentUseCase.completePayment`: Se invoca `completePayment` sobre `PaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/application/usecase/PaymentUseCaseTest.java` — `PaymentUseCase.failPayment`: Se invoca `failPayment` sobre `PaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/infrastructure/controller/PaymentControllerTest.java` — `PaymentUseCase.createPayment`: Se invoca `createPayment` sobre `PaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/infrastructure/controller/PaymentControllerTest.java` — `PaymentUseCase.getPaymentsByAccountId`: Se invoca `getPaymentsByAccountId` sobre `PaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/infrastructure/controller/PaymentControllerTest.java` — `PaymentUseCase.completePayment`: Se invoca `completePayment` sobre `PaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.
- `src/test/java/com/pragma/payments/infrastructure/controller/PaymentControllerTest.java` — `PaymentUseCase.failPayment`: Se invoca `failPayment` sobre `PaymentUseCase`, pero esa clase no declara ese metodo. Agregalo con su implementacion real, o usa uno de los que si declara.

## Como saber que terminaste

```bash
mvn clean compile
```

Ese comando corriendo sin errores es la definicion de "listo".

---

```
## Briefing del reto (autoridad)
Este bloque manda sobre los archivos adjuntos. El stack y el rol salen de AQUÍ, no de un topic genérico ni de markdown placeholder.

### Perfil
Chapter Backend, Especialidad Desarrollador, Tecnología Java, Senior L2

### Brecha de conocimiento
Aplica al menos dos metodos de tolerancia a fallos a traves de codigo, como CircuitBreaker, Retry, Fallback y RateLimit

### Misión / candidato
Integrar un modelo de resiliencia en el core de pagos

### Datos adicionales
Candidato con 5 años de experiencia, equipo distribuido

### Reto
- Tema: Construccion de Servicios REST Robustos y Escalables (reg 1109)
- Seniority: senior-l2
- Tipo: practical
- Título: Integración de Resiliencia en el Core de Pagos
- Tiempo estimado: 2 semanas

### Fases (trabajo del HUMANO — PROHIBIDO completarlas)
No implementes estos entregables. Dejalos como hueco pedagógico. El asistente solo materializa el proyecto arrancable para que el participante pueda trabajar.
- Fase 1: Evaluación del Sistema Actual — objetivo: Identificar las debilidades actuales en la gestión de fallos y establecer las bases para la integración de métodos de resiliencia. — entregable (NO resolver): Reporte de evaluación con identificación de puntos débiles y propuestas de mejora.
- Fase 2: Implementación de CircuitBreaker — objetivo: Integrar el patrón CircuitBreaker para manejar fallos temporales en el sistema de pagos. — entregable (NO resolver): Servicio de pagos con CircuitBreaker implementado y verificado.
- Fase 3: Implementación de Retry y Fallback — objetivo: Añadir patrones Retry y Fallback para mejorar la resiliencia del sistema de pagos. — entregable (NO resolver): Servicio de pagos con patrones Retry y Fallback implementados y verificados.
- Fase 4: Implementación de RateLimit — objetivo: Integrar el patrón RateLimit para prevenir sobrecargas en el sistema de pagos. — entregable (NO resolver): Servicio de pagos con RateLimit implementado y verificado.

Eres un asistente experto en análisis, corrección y generación de archivos de cualquier tipo:
código fuente, documentación, hojas de cálculo, documentos Word, configuraciones, entre otros.
Voy a enviarte una cadena de texto que contiene uno o más archivos. Cada archivo está delimitado por un marcador con el siguiente formato:
// === ARCHIVO: ruta/del/archivo.extension ===
o también puede aparecer como:
## === ARCHIVO: ruta/del/archivo.extension ===
Lo que sigue al marcador puede ser:

El contenido real del archivo (código, texto, YAML, etc.)
Una descripción en lenguaje natural de lo que debe contener el archivo


TU TAREA
PASO 0 — ¿Esto es un proyecto o una carcasa?
Antes de extraer archivos, leé el Briefing (si está) y diagnosticá el adjunto.

Es CARCASA si ocurre CUALQUIERA de estas:
- No hay manifiesto de dependencias del stack del briefing (manifest.json de VTEX IO / package.json / pom.xml / build.gradle / requirements.txt / go.mod / *.tf / *.csproj, según corresponda)
- Hay un "binario" que en realidad es un comentario ("no puede ser mostrado como texto plano", placeholder .fig/.docx vacío)
- Los markdowns ya completan entregables de fases posteriores ("se implementó fade-in", lista de áreas ya resuelta)

Si es CARCASA:
- MATERIALIZÁ un proyecto que arranca en el stack del briefing (VTEX IO Store Framework, Angular, Terraform, pytest, Nest, etc.). Incluí manifiesto, punto de entrada y capa de interfaz reales.
- NO copies los markdowns de "solución" como si fueran el producto. Son ruido de generación.
- NO resuelvas las fases del briefing (están marcadas PROHIBIDO). Dejá el hueco pedagógico: el flujo existe, las microinteracciones/calidad/infra que el reto pide NO están hechas.
- Después seguí al PASO 5 (entrega de archivos).

Si es un proyecto REAL (manifiesto + código que compila o arranca):
- Seguí PASO 1 en adelante. 🔴 compilación sí. 🟡 pedagógico no.

PASO 1 — Detección y extracción
Identifica todos los archivos presentes en la cadena. Para cada archivo extrae:

Su ruta completa (ej: src/main/java/com/pragma/Service.java)
Su contenido o descripción

PASO 2 — Clasificación por tipo
Clasifica cada archivo en una de estas categorías:
A) Código fuente (Java, Python, TypeScript, JavaScript, Kotlin, etc.)
B) Configuración / documentación (YAML, properties, Markdown, JSON, txt, etc.)
C) Excel (.xlsx, .xls, .csv)
D) Word (.docx, .doc)
E) Otro tipo de archivo binario o especial
PASO 3 — Clasificación de errores en código fuente

Objetivo prioritario: que el proyecto compile. No corrijas flujo de negocio ni lógica funcional.

Antes de modificar cualquier archivo de código fuente, clasifica cada problema encontrado en una de estas dos categorías:
🔴 ERROR DE COMPILACIÓN — corregir siempre
Son errores que impiden que el proyecto arranque, sin valor pedagógico:

Import faltante o incorrecto
Clase, método o variable referenciada que no existe en ningún archivo del proyecto
Error de sintaxis
Anotación con atributos inválidos
Dependencia ausente en pom.xml, package.json, etc.
Archivo referenciado que no existe y debe ser creado con implementación mínima

→ CORREGIR estos errores.
🟡 PROBLEMA FUNCIONAL O DE CALIDAD — preservar siempre
Son problemas que no impiden compilar. Pueden ser intencionales para el aprendizaje:

Clave secreta hardcodeada ("secret", "password123")
API deprecada que funciona pero tiene reemplazo moderno
Lógica de negocio incorrecta o incompleta
Código redundante o de baja legibilidad
Falta de validaciones en flujo de negocio
Patrones de diseño incorrectos pero funcionales
Concurrencia no segura
Configuración funcional pero no óptima

→ PRESERVAR tal cual. No corregir, no mejorar, no comentar.
PASO 4 — Procesamiento según tipo de archivo
Tipo A — Código fuente
Aplica únicamente las correcciones clasificadas como 🔴 ERROR DE COMPILACIÓN.
No alteres ningún elemento clasificado como 🟡 PROBLEMA FUNCIONAL O DE CALIDAD.
Si falta un archivo referenciado, créalo con la implementación mínima necesaria para compilar.
Tipo B — Configuración / documentación
Extrae el contenido tal cual, sin modificaciones salvo errores evidentes de sintaxis
(ej: YAML mal indentado).
Tipo C — Excel (.xlsx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un archivo Excel funcional con:

Fila de encabezados en negrita con color de fondo distintivo
Columnas con ancho ajustado al contenido
Tipos de dato correctos por columna
Validaciones si la descripción lo indica
Hojas nombradas descriptivamente si hay más de una
Filas de ejemplo si no hay datos reales

Tipo D — Word (.docx)
Si viene con contenido real, genera el archivo respetando ese contenido.
Si viene con descripción en lenguaje natural, genera un documento Word funcional con:

Estilos de título (Título 1, Título 2) para jerarquía de secciones
Fuente legible (Calibri o equivalente), tamaño 11-12pt para cuerpo
Márgenes estándar
Tabla de contenido si tiene múltiples secciones
Tablas con encabezados en negrita si aplica

Tipo E — Otro
Genera el archivo con el contenido o estructura más apropiada según la descripción.
PASO 5 — Entrega de archivos
Entregá cada archivo con su ruta completa, respetando exactamente la estructura de rutas
indicada por los marcadores: un bloque por archivo, precedido por su ruta. No generes ZIPs
ni archivos adjuntos.
La entrega debe incluir:

Archivos de código con únicamente los errores de compilación corregidos
Archivos de configuración y documentación sin cambios
Archivos nuevos creados para resolver dependencias de compilación faltantes
Archivos Excel y Word generados desde descripción

IMPORTANTE: Entregá los archivos completos al finalizar. No preguntes si el usuario
quiere recibirlos. Simplemente entregalos; No debes desplegar en el chat el resumen de lo que arreglaste, solo entregá los archivos.

REGLAS IMPORTANTES

No omitas ningún archivo aunque no tenga errores ni modificaciones
Respeta los nombres y rutas exactas indicadas por los marcadores
Si un archivo no tiene marcador claro, infiere el nombre desde su contenido
Si la cadena contiene solo documentación, placeholders o binarios fake, NO la reproduzcas:
aplicá PASO 0 (materializar el proyecto del briefing). Reproducir la carcasa es un fallo.
No agregues texto después del último archivo entregado
No preguntes si el usuario quiere los archivos: simplemente entregalos siempre
Si detectas que falta un archivo de configuración necesario para compilar
(pom.xml, package.json, requirements.txt, build.gradle, etc.), créalo e inclúyelo
inferiendo su contenido desde los imports y frameworks detectados en el código
Nunca corrijas problemas 🟡 aunque parezcan obvios o fáciles de mejorar.
El participante que recibirá este proyecto los debe encontrar y resolver él mismo.


INPUT
Aquí está la cadena con los archivos:

// === ARCHIVO: pom.xml ===
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 https://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>
    <parent>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-parent</artifactId>
        <version>3.5.6</version>
        <relativePath/>
    </parent>

    <groupId>com.pragma</groupId>
    <artifactId>payments</artifactId>
    <version>0.0.1-SNAPSHOT</version>
    <name>payments</name>
    <description>Core de pagos con resiliencia integrada</description>

    <properties>
        <java.version>21</java.version>
        <resilience4j.version>2.2.0</resilience4j.version>
    </properties>

    <dependencies>
        <!-- Spring Boot Starters -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-web</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-data-jpa</artifactId>
        </dependency>
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-validation</artifactId>
        </dependency>

        <!-- Resilience4j -->
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-spring-boot3</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>
        <dependency>
            <groupId>io.github.resilience4j</groupId>
            <artifactId>resilience4j-reactor</artifactId>
            <version>${resilience4j.version}</version>
        </dependency>

        <!-- Database -->
        <dependency>
            <groupId>org.postgresql</groupId>
            <artifactId>postgresql</artifactId>
            <scope>runtime</scope>
        </dependency>

        <!-- Lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
            <version>1.18.32</version>
            <scope>provided</scope>
        </dependency>

        <!-- Test -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-test</artifactId>
            <scope>test</scope>
        </dependency>

        <!-- Configuration Processor -->
        <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-configuration-processor</artifactId>
            <optional>true</optional>
        </dependency>
    </dependencies>

    <build>
        <plugins>
            <plugin>
                <groupId>org.springframework.boot</groupId>
                <artifactId>spring-boot-maven-plugin</artifactId>
                <configuration>
                    <excludes>
                        <exclude>
                            <groupId>org.projectlombok</groupId>
                            <artifactId>lombok</artifactId>
                        </exclude>
                    </excludes>
                </configuration>
            </plugin>
        </plugins>
    </build>
</project>

// === ARCHIVO: src/main/java/com/pragma/payments/Application.java ===
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

// === ARCHIVO: src/main/resources/application.yml ===
spring:
  application:
    name: payments-core
  datasource:
    url: jdbc:postgresql://localhost:5432/payments_db
    username: payments_user
    password: secure_password_123
    driver-class-name: org.postgresql.Driver
    hikari:
      connection-timeout: 2000
      maximum-pool-size: 10
      minimum-idle: 2
  jpa:
    database-platform: org.hibernate.dialect.PostgreSQLDialect
    hibernate:
      ddl-auto: update
    show-sql: true
    properties:
      hibernate:
        format_sql: true
        jdbc:
          time_zone: UTC

server:
  port: 8080
  servlet:
    context-path: /api/v1

resilience4j:
  circuitbreaker:
    configs:
      default:
        registerHealthIndicator: true
        slidingWindowSize: 10
        minimumNumberOfCalls: 5
        permittedNumberOfCallsInHalfOpenState: 3
        automaticTransitionFromOpenToHalfOpenEnabled: true
        waitDurationInOpenState: 5s
        failureRateThreshold: 50
        eventConsumerBufferSize: 10
        recordExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.io.IOException
          - java.util.concurrent.TimeoutException
          - org.springframework.transaction.TransactionSystemException
    instances:
      paymentService:
        baseConfig: default
        waitDurationInOpenState: 10s
        failureRateThreshold: 60

  retry:
    configs:
      default:
        maxAttempts: 3
        waitDuration: 1000
        retryExceptions:
          - org.springframework.web.client.HttpServerErrorException
          - java.io.IOException
          - java.util.concurrent.TimeoutException
    instances:
      paymentService:
        baseConfig: default

  timelimiter:
    configs:
      default:
        timeoutDuration: 2s
        cancelRunningFuture: true
    instances:
      paymentService:
        baseConfig: default

  ratelimiter:
    configs:
      default:
        limitForPeriod: 100
        limitRefreshPeriod: 1s
        timeoutDuration: 0
    instances:
      paymentService:
        baseConfig: default
        limitForPeriod: 50

logging:
  level:
    root: INFO
    com.pragma.payments: DEBUG
    io.github.resilience4j: DEBUG
    org.hibernate.SQL: DEBUG
    org.hibernate.type.descriptor.sql.BasicBinder: TRACE

management:
  endpoints:
    web:
      exposure:
        include: health,metrics,circuitbreakers,retryevents
  endpoint:
    health:
      show-details: always
  health:
    circuitbreakers:
      enabled: true

// === ARCHIVO: src/main/java/com/pragma/payments/domain/model/Payment.java ===
package com.pragma.payments.domain.model;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public class Payment {
    private final UUID id;
    private final String accountId;
    private final BigDecimal amount;
    private final String currency;
    private final String recipientAccount;
    private final LocalDateTime createdAt;
    private PaymentStatus status;
    private String failureReason;

    public Payment(UUID id, String accountId, BigDecimal amount, String currency,
                  String recipientAccount, LocalDateTime createdAt, PaymentStatus status) {
        this.id = id;
        this.accountId = accountId;
        this.amount = amount;
        this.currency = currency;
        this.recipientAccount = recipientAccount;
        this.createdAt = createdAt;
        this.status = status;
        this.failureReason = null;
    }

    public Payment(String accountId, BigDecimal amount, String currency, String recipientAccount) {
        this(UUID.randomUUID(), accountId, amount, currency, recipientAccount, LocalDateTime.now(), PaymentStatus.PENDING);
    }

    public UUID getId() {
        return id;
    }

    public String getAccountId() {
        return accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public String getCurrency() {
        return currency;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void markAsCompleted() {
        this.status = PaymentStatus.COMPLETED;
    }

    public void markAsFailed(String reason) {
        this.status = PaymentStatus.FAILED;
        this.failureReason = reason;
    }

    public enum PaymentStatus {
        PENDING,
        COMPLETED,
        FAILED
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/domain/port/PaymentRepository.java ===
package com.pragma.payments.domain.port;


import com.pragma.payments.domain.model.PaymentStatus;
import com.pragma.payments.domain.model.Payment;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PaymentRepository {
    Payment save(Payment payment);
    
    Optional<Payment> findById(UUID id);
    
    List<Payment> findByAccountId(String accountId);
    
    List<Payment> findByStatus(Payment.PaymentStatus status);
}

// === ARCHIVO: src/main/java/com/pragma/payments/application/dto/PaymentRequest.java ===
package com.pragma.payments.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;

public record PaymentRequest(
    @NotBlank(message = "Account ID is required")
    String accountId,
    
    @NotNull(message = "Amount is required")
    @Positive(message = "Amount must be positive")
    BigDecimal amount,
    
    @NotBlank(message = "Currency is required")
    String currency,
    
    @NotBlank(message = "Recipient account is required")
    String recipientAccount) {
}

// === ARCHIVO: src/main/java/com/pragma/payments/application/dto/PaymentResponse.java ===
package com.pragma.payments.application.dto;


import com.pragma.payments.domain.model.PaymentStatus;
import com.pragma.payments.domain.model.Payment;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

public record PaymentResponse(
    UUID id,
    String accountId,
    BigDecimal amount,
    String currency,
    String recipientAccount,
    LocalDateTime createdAt,
    String status,
    String failureReason
) {
    public static PaymentResponse fromDomain(Payment payment) {
        return new PaymentResponse(
            payment.getId(),
            payment.getAccountId(),
            payment.getAmount(),
            payment.getCurrency(),
            payment.getRecipientAccount(),
            payment.getCreatedAt(),
            payment.getStatus().name(),
            payment.getFailureReason()
        );
    }

    public static PaymentResponse pending(UUID id, String accountId, BigDecimal amount, 
            String currency, String recipientAccount) {
        return new PaymentResponse(
            id,
            accountId,
            amount,
            currency,
            recipientAccount,
            LocalDateTime.now(),
            Payment.PaymentStatus.PENDING.name(),
            null
        );
    }

    public boolean isSuccessful() {
        return Payment.PaymentStatus.COMPLETED.name().equals(status);
    }

    public boolean isFailed() {
        return Payment.PaymentStatus.FAILED.name().equals(status);
    }

    public boolean isPending() {
        return Payment.PaymentStatus.PENDING.name().equals(status);
    }

    public PaymentResponse withStatus(String newStatus) {
        return new PaymentResponse(
            this.id,
            this.accountId,
            this.amount,
            this.currency,
            this.recipientAccount,
            this.createdAt,
            newStatus,
            this.failureReason
        );
    }

    public PaymentResponse withFailureReason(String reason) {
        return new PaymentResponse(
            this.id,
            this.accountId,
            this.amount,
            this.currency,
            this.recipientAccount,
            this.createdAt,
            this.status,
            reason
        );
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/adapter/JpaPaymentRepository.java ===
package com.pragma.payments.infrastructure.adapter;

import com.pragma.payments.domain.model.Payment;
import com.pragma.payments.domain.model.Payment.PaymentStatus;
import com.pragma.payments.domain.port.PaymentRepository;
import com.pragma.payments.infrastructure.adapter.entity.PaymentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class JpaPaymentRepository implements PaymentRepository {

    private final PaymentJpaAdapter paymentJpaAdapter;

    public JpaPaymentRepository(PaymentJpaAdapter paymentJpaAdapter) {
        this.paymentJpaAdapter = paymentJpaAdapter;
    }

    @Override
    public Payment save(Payment payment) {
        PaymentEntity entity = toEntity(payment);
        PaymentEntity savedEntity = paymentJpaAdapter.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        return paymentJpaAdapter.findById(id)
                .map(this::toDomain);
    }

    @Override
    public List<Payment> findByAccountId(String accountId) {
        return paymentJpaAdapter.findByAccountId(accountId)
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    @Override
    public List<Payment> findByStatus(PaymentStatus status) {
        return paymentJpaAdapter.findByStatus(status.name())
                .stream()
                .map(this::toDomain)
                .collect(Collectors.toList());
    }

    private PaymentEntity toEntity(Payment payment) {
        PaymentEntity entity = new PaymentEntity();
        entity.setId(payment.getId());
        entity.setAccountId(payment.getAccountId());
        entity.setAmount(payment.getAmount());
        entity.setCurrency(payment.getCurrency());
        entity.setRecipientAccount(payment.getRecipientAccount());
        entity.setCreatedAt(payment.getCreatedAt());
        entity.setStatus(payment.getStatus().name());
        entity.setFailureReason(payment.getFailureReason());
        return entity;
    }

    private Payment toDomain(PaymentEntity entity) {
        Payment payment = new Payment(
            entity.getId(),
            entity.getAccountId(),
            entity.getAmount(),
            entity.getCurrency(),
            entity.getRecipientAccount(),
            entity.getCreatedAt(),
            PaymentStatus.valueOf(entity.getStatus())
        );
        if (entity.getFailureReason() != null) {
            payment.markAsFailed(entity.getFailureReason());
        }
        return payment;
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/application/usecase/PaymentUseCase.java ===
package com.pragma.payments.application.usecase;

import com.pragma.payments.application.dto.PaymentRequest;
import com.pragma.payments.application.dto.PaymentResponse;
import com.pragma.payments.domain.model.Payment;
import com.pragma.payments.domain.model.Payment.PaymentStatus;
import com.pragma.payments.domain.port.PaymentRepository;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PaymentUseCase {

    private static final Logger logger = LoggerFactory.getLogger(PaymentUseCase.class);
    private static final String PAYMENT_SERVICE = "paymentService";

    private final PaymentRepository paymentRepository;

    public PaymentUseCase(PaymentRepository paymentRepository) {
        this.paymentRepository = paymentRepository;
    }

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "processPaymentFallback")
    @Retry(name = PAYMENT_SERVICE)
    @RateLimiter(name = PAYMENT_SERVICE)
    public PaymentResponse processPayment(PaymentRequest request) {
        logger.info("Iniciando procesamiento de pago para cuenta: {} amount: {}", 
                request.accountId(), request.amount());

        validatePaymentRequest(request);

        Payment payment = new Payment(
            UUID.randomUUID(),
            request.accountId(),
            request.amount(),
            request.currency(),
            request.recipientAccount(),
            LocalDateTime.now(),
            PaymentStatus.PENDING
        );

        Payment savedPayment = paymentRepository.save(payment);
        
        boolean processed = executePaymentProcessing(savedPayment);
        
        if (processed) {
            savedPayment.markAsCompleted();
            logger.info("Pago completado exitosamente: {}", savedPayment.getId());
        } else {
            savedPayment.markAsFailed("Procesamiento fallido");
            logger.warn("Pago marcado como fallido: {}", savedPayment.getId());
        }
        
        Payment updatedPayment = paymentRepository.save(savedPayment);
        return PaymentResponse.fromDomain(updatedPayment);
    }

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "getPaymentByIdFallback")
    public PaymentResponse getPaymentById(UUID paymentId) {
        logger.info("Consultando pago con ID: {}", paymentId);
        
        return paymentRepository.findById(paymentId)
                .map(PaymentResponse::fromDomain)
                .orElseThrow(() -> new PaymentNotFoundException("Pago no encontrado: " + paymentId));
    }

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "getPaymentsByAccountFallback")
    public List<PaymentResponse> getPaymentsByAccount(String accountId) {
        logger.info("Consultando pagos para cuenta: {}", accountId);
        
        return paymentRepository.findByAccountId(accountId)
                .stream()
                .map(PaymentResponse::fromDomain)
                .collect(Collectors.toList());
    }

    @CircuitBreaker(name = PAYMENT_SERVICE, fallbackMethod = "getPaymentsByStatusFallback")
    public List<PaymentResponse> getPaymentsByStatus(PaymentStatus status) {
        logger.info("Consultando pagos con estado: {}", status);
        
        return paymentRepository.findByStatus(status)
                .stream()
                .map(PaymentResponse::fromDomain)
                .collect(Collectors.toList());
    }

    private void validatePaymentRequest(PaymentRequest request) {
        if (request.accountId() == null || request.accountId().isBlank()) {
            throw new InvalidPaymentException("Account ID es requerido");
        }
        if (request.amount() == null || request.amount().compareTo(BigDecimal.ZERO) <= 0) {
            throw new InvalidPaymentException("El monto debe ser mayor a cero");
        }
        if (request.currency() == null || request.currency().isBlank()) {
            throw new InvalidPaymentException("Currency es requerido");
        }
        if (request.recipientAccount() == null || request.recipientAccount().isBlank()) {
            throw new InvalidPaymentException("Recipient account es requerido");
        }
    }

    private boolean executePaymentProcessing(Payment payment) {
        logger.debug("Ejecutando lógica de procesamiento para pago: {}", payment.getId());
        
        if (payment.getAmount().compareTo(new BigDecimal("10000")) > 0) {
            logger.info("Monto mayor a 10000 requiere validación adicional");
        }
        
        return true;
    }

    private PaymentResponse processPaymentFallback(PaymentRequest request, Exception ex) {
        logger.error("Fallback activado para processPayment. Error: {}", ex.getMessage());
        return PaymentResponse.pending(
            UUID.randomUUID(),
            request.accountId(),
            request.amount(),
            request.currency(),
            request.recipientAccount()
        ).withFailureReason("Servicio temporalmente no disponible: " + ex.getMessage());
    }

    private PaymentResponse getPaymentByIdFallback(UUID paymentId, Exception ex) {
        logger.error("Fallback activado para getPaymentById. Error: {}", ex.getMessage());
        throw new PaymentServiceUnavailableException(
            "No se pudo obtener el pago. Servicio no disponible.");
    }

    private List<PaymentResponse> getPaymentsByAccountFallback(String accountId, Exception ex) {
        logger.error("Fallback activado para getPaymentsByAccount. Error: {}", ex.getMessage());
        throw new PaymentServiceUnavailableException(
            "No se pudieron obtener los pagos. Servicio no disponible.");
    }

    private List<PaymentResponse> getPaymentsByStatusFallback(PaymentStatus status, Exception ex) {
        logger.error("Fallback activado para getPaymentsByStatus. Error: {}", ex.getMessage());
        throw new PaymentServiceUnavailableException(
            "No se pudieron obtener los pagos por estado. Servicio no disponible.");
    }

    public static class PaymentNotFoundException extends RuntimeException {
        public PaymentNotFoundException(String message) {
            super(message);
        }
    }

    public static class InvalidPaymentException extends RuntimeException {
        public InvalidPaymentException(String message) {
            super(message);
        }
    }

    public static class PaymentServiceUnavailableException extends RuntimeException {
        public PaymentServiceUnavailableException(String message) {
            super(message);
        }
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/adapter/PaymentJpaAdapter.java ===
package com.pragma.payments.infrastructure.adapter;

import com.pragma.payments.domain.model.Payment;
import com.pragma.payments.domain.model.Payment.PaymentStatus;
import com.pragma.payments.domain.port.PaymentRepository;
import com.pragma.payments.infrastructure.adapter.entity.PaymentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PaymentJpaAdapter implements PaymentRepository {

    private final JpaPaymentRepository jpaRepository;
    private final PaymentEntityMapper mapper;

    public PaymentJpaAdapter(JpaPaymentRepository jpaRepository, PaymentEntityMapper mapper) {
        this.jpaRepository = jpaRepository;
        this.mapper = mapper;
    }

    @Override
    public Payment save(Payment payment) {
        PaymentEntity entity = mapper.toEntity(payment);
        PaymentEntity savedEntity = jpaRepository.save(entity);
        return mapper.toDomain(savedEntity);
    }

    @Override
    public Optional<Payment> findById(UUID id) {
        return jpaRepository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<Payment> findByAccountId(String accountId) {
        return jpaRepository.findByAccountId(accountId).stream()
                .map(mapper::toDomain)
                .toList();
    }

    @Override
    public List<Payment> findByStatus(PaymentStatus status) {
        return jpaRepository.findByStatus(status).stream()
                .map(mapper::toDomain)
                .toList();
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/adapter/PaymentEntityMapper.java ===
package com.pragma.payments.infrastructure.adapter;

import com.pragma.payments.domain.model.Payment;
import com.pragma.payments.domain.model.Payment.PaymentStatus;
import com.pragma.payments.infrastructure.adapter.entity.PaymentEntity;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class PaymentEntityMapper {

    public Payment toDomain(PaymentEntity entity) {
        if (entity == null) {
            return null;
        }
        
        Payment payment = new Payment(
                entity.getId(),
                entity.getAccountId(),
                entity.getAmount(),
                entity.getCurrency(),
                entity.getRecipientAccount()
        );
        
        payment.setStatus(PaymentStatus.valueOf(entity.getStatus()));
        payment.setFailureReason(entity.getFailureReason());
        
        return payment;
    }

    public PaymentEntity toEntity(Payment payment) {
        if (payment == null) {
            return null;
        }
        
        PaymentEntity entity = new PaymentEntity();
        entity.setId(payment.getId());
        entity.setAccountId(payment.getAccountId());
        entity.setAmount(payment.getAmount());
        entity.setCurrency(payment.getCurrency());
        entity.setRecipientAccount(payment.getRecipientAccount());
        entity.setCreatedAt(payment.getCreatedAt() != null ? payment.getCreatedAt() : LocalDateTime.now());
        entity.setStatus(payment.getStatus() != null ? payment.getStatus().name() : PaymentStatus.PENDING.name());
        entity.setFailureReason(payment.getFailureReason());
        
        return entity;
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/adapter/entity/PaymentEntity.java ===
package com.pragma.payments.infrastructure.adapter.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "payments")
public class PaymentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "account_id", nullable = false)
    private String accountId;

    @Column(nullable = false, precision = 19, scale = 4)
    private BigDecimal amount;

    @Column(nullable = false, length = 3)
    private String currency;

    @Column(name = "recipient_account", nullable = false)
    private String recipientAccount;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private String status;

    @Column(name = "failure_reason", length = 500)
    private String failureReason;

    public PaymentEntity() {
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getRecipientAccount() {
        return recipientAccount;
    }

    public void setRecipientAccount(String recipientAccount) {
        this.recipientAccount = recipientAccount;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFailureReason() {
        return failureReason;
    }

    public void setFailureReason(String failureReason) {
        this.failureReason = failureReason;
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/controller/PaymentController.java ===
package com.pragma.payments.infrastructure.controller;

import com.pragma.payments.application.dto.PaymentRequest;
import com.pragma.payments.application.dto.PaymentResponse;
import com.pragma.payments.application.usecase.PaymentUseCase;
import com.pragma.payments.domain.model.Payment;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private static final Logger log = LoggerFactory.getLogger(PaymentController.class);
    
    private final PaymentUseCase paymentUseCase;

    public PaymentController(PaymentUseCase paymentUseCase) {
        this.paymentUseCase = paymentUseCase;
    }

    @PostMapping
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackProcessPayment")
    @Retry(name = "paymentServiceRetry")
    @RateLimiter(name = "paymentServiceRateLimiter")
    public ResponseEntity<PaymentResponse> processPayment(@Valid @RequestBody PaymentRequest request) {
        log.info("Procesando pago para cuenta: {}, monto: {} {}", 
                request.accountId(), request.amount(), request.currency());
        
        Payment payment = paymentUseCase.createPayment(
                request.accountId(),
                request.amount(),
                request.currency(),
                request.recipientAccount()
        );
        
        PaymentResponse response = mapToResponse(payment);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{id}")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackGetPayment")
    @Retry(name = "paymentServiceRetry")
    public ResponseEntity<PaymentResponse> getPayment(@PathVariable UUID id) {
        log.info("Consultando pago con ID: {}", id);
        
        Payment payment = paymentUseCase.getPaymentById(id);
        
        if (payment == null) {
            return ResponseEntity.notFound().build();
        }
        
        return ResponseEntity.ok(mapToResponse(payment));
    }

    @GetMapping("/account/{accountId}")
    @CircuitBreaker(name = "paymentService", fallbackMethod = "fallbackGetPaymentsByAccount")
    @Retry(name = "paymentServiceRetry")
    public ResponseEntity<List<PaymentResponse>> getPaymentsByAccount(@PathVariable String accountId) {
        log.info("Consultando pagos para cuenta: {}", accountId);
        
        List<Payment> payments = paymentUseCase.getPaymentsByAccountId(accountId);
        List<PaymentResponse> responses = payments.stream()
                .map(this::mapToResponse)
                .toList();
        
        return ResponseEntity.ok(responses);
    }

    @GetMapping("/health")
    public ResponseEntity<String> healthCheck() {
        return ResponseEntity.ok("Payment service is running");
    }

    private PaymentResponse mapToResponse(Payment payment) {
        return new PaymentResponse(
                payment.getId(),
                payment.getAccountId(),
                payment.getAmount(),
                payment.getCurrency(),
                payment.getRecipientAccount(),
                payment.getCreatedAt(),
                payment.getStatus().name(),
                payment.getFailureReason()
        );
    }

    private ResponseEntity<PaymentResponse> fallbackProcessPayment(PaymentRequest request, Throwable t) {
        log.error("Fallback activado para processPayment. Razón: {}", t.getMessage());
        PaymentResponse errorResponse = new PaymentResponse(
                null,
                request.accountId(),
                request.amount(),
                request.currency(),
                request.recipientAccount(),
                null,
                "FAILED",
                "Servicio temporalmente no disponible: " + t.getMessage()
        );
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(errorResponse);
    }

    private ResponseEntity<PaymentResponse> fallbackGetPayment(UUID id, Throwable t) {
        log.error("Fallback activado para getPayment con ID: {}. Razón: {}", id, t.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }

    private ResponseEntity<List<PaymentResponse>> fallbackGetPaymentsByAccount(String accountId, Throwable t) {
        log.error("Fallback activado para getPaymentsByAccount con cuenta: {}. Razón: {}", accountId, t.getMessage());
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).build();
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/config/Resilience4jConfig.java ===
package com.pragma.payments.infrastructure.config;

import io.github.resilience4j.circuitbreaker.CircuitBreakerConfig;
import io.github.resilience4j.circuitbreaker.CircuitBreakerRegistry;
import io.github.resilience4j.ratelimiter.RateLimiterConfig;
import io.github.resilience4j.ratelimiter.RateLimiterRegistry;
import io.github.resilience4j.retry.RetryConfig;
import io.github.resilience4j.retry.RetryRegistry;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;

@Configuration
public class Resilience4jConfig {

    @Bean
    public CircuitBreakerRegistry circuitBreakerRegistry() {
        CircuitBreakerConfig config = CircuitBreakerConfig.custom()
                .failureRateThreshold(50)
                .waitDurationInOpenState(Duration.ofSeconds(60))
                .slidingWindowSize(10)
                .minimumNumberOfCalls(5)
                .permittedNumberOfCallsInHalfOpenState(3)
                .automaticTransitionFromOpenToHalfOpenEnabled(true)
                .waitDurationInOpenState(Duration.ofSeconds(60))
                .build();
        return CircuitBreakerRegistry.of(config);
    }

    @Bean
    public RetryRegistry retryRegistry() {
        RetryConfig config = RetryConfig.custom()
                .maxAttempts(3)
                .waitDuration(Duration.ofMillis(500))
                .build();
        return RetryRegistry.of(config);
    }

    @Bean
    public RateLimiterRegistry rateLimiterRegistry() {
        RateLimiterConfig config = RateLimiterConfig.custom()
                .limitRefreshPeriod(Duration.ofSeconds(1))
                .limitForPeriod(10)
                .timeoutDuration(Duration.ofMillis(500))
                .build();
        return RateLimiterRegistry.of(config);
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/infrastructure/config/GlobalExceptionHandler.java ===
package com.pragma.payments.infrastructure.config;

import com.pragma.payments.application.dto.ErrorResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(NoSuchElementException ex) {
        logger.warn("Recurso no encontrado: {}", ex.getMessage());
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                "NOT_FOUND",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        logger.warn("Argumento inválido: {}", ex.getMessage());
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "BAD_REQUEST",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        logger.warn("Errores de validación: {}", errors);
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "VALIDATION_ERROR",
                "Los datos proporcionados no son válidos",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {
        String message = String.format("El parámetro '%s' tiene un valor inválido: '%s'", 
                ex.getName(), ex.getValue());
        logger.warn("Tipo de argumento inválido: {}", message);
        ErrorResponse error = new ErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                "TYPE_MISMATCH",
                message,
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(UnsupportedOperationException.class)
    public ResponseEntity<ErrorResponse> handleUnsupportedOperation(UnsupportedOperationException ex) {
        logger.warn("Operación no soportada: {}", ex.getMessage());
        ErrorResponse error = new ErrorResponse(
                HttpStatus.METHOD_NOT_ALLOWED.value(),
                "METHOD_NOT_ALLOWED",
                ex.getMessage(),
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.METHOD_NOT_ALLOWED).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        logger.error("Error interno del servidor: ", ex);
        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "INTERNAL_SERVER_ERROR",
                "Ha ocurrido un error inesperado. Por favor, contacte al administrador.",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex) {
        logger.error("Runtime exception: ", ex);
        ErrorResponse error = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "RUNTIME_ERROR",
                ex.getMessage() != null ? ex.getMessage() : "Error de tiempo de ejecución",
                LocalDateTime.now()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}

// === ARCHIVO: src/test/java/com/pragma/payments/application/usecase/PaymentUseCaseTest.java ===
package com.pragma.payments.application.usecase;

import com.pragma.payments.domain.model.Payment;
import com.pragma.payments.domain.model.Payment.PaymentStatus;
import com.pragma.payments.domain.port.PaymentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@DisplayName("PaymentUseCase - Tests de unidad")
class PaymentUseCaseTest {

    @Mock
    private PaymentRepository paymentRepository;

    @InjectMocks
    private PaymentUseCase paymentUseCase;

    private Payment testPayment;
    private UUID paymentId;

    @BeforeEach
    void setUp() {
        paymentId = UUID.randomUUID();
        testPayment = new Payment(
            paymentId,
            "ACC-12345",
            new BigDecimal("1000.00"),
            "USD",
            "REC-67890",
            LocalDateTime.now(),
            PaymentStatus.PENDING,
            null
        );
    }

    @Test
    @DisplayName("Crear pago exitosamente cuando los datos son válidos")
    void createPayment_WhenDataIsValid_ReturnsCreatedPayment() {
        PaymentRequest request = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("1000.00"),
            "USD",
            "REC-67890"
        );

        Payment savedPayment = new Payment(
            paymentId,
            request.accountId(),
            request.amount(),
            request.currency(),
            request.recipientAccount(),
            LocalDateTime.now(),
            PaymentStatus.PENDING,
            null
        );

        when(paymentRepository.save(any(Payment.class))).thenReturn(savedPayment);

        Payment result = paymentUseCase.createPayment(request);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(paymentId);
        assertThat(result.getAccountId()).isEqualTo(request.accountId());
        assertThat(result.getAmount()).isEqualByComparingTo(request.amount());
        assertThat(result.getStatus()).isEqualTo(PaymentStatus.PENDING);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    @DisplayName("Crear pago falla cuando el monto es negativo")
    void createPayment_WhenAmountIsNegative_ThrowsException() {
        PaymentRequest request = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("-100.00"),
            "USD",
            "REC-67890"
        );

        assertThatThrownBy(() -> paymentUseCase.createPayment(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("monto");

        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    @DisplayName("Crear pago falla cuando el monto es cero")
    void createPayment_WhenAmountIsZero_ThrowsException() {
        PaymentRequest request = new PaymentRequest(
            "ACC-12345",
            BigDecimal.ZERO,
            "USD",
            "REC-67890"
        );

        assertThatThrownBy(() -> paymentUseCase.createPayment(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("mayor que cero");

        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    @DisplayName("Obtener pago por ID exitosamente")
    void getPaymentById_WhenExists_ReturnsPayment() {
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(testPayment));

        Optional<Payment> result = paymentUseCase.getPaymentById(paymentId);

        assertThat(result).isPresent();
        assertThat(result.get().getId()).isEqualTo(paymentId);
        assertThat(result.get().getAccountId()).isEqualTo("ACC-12345");
        verify(paymentRepository, times(1)).findById(paymentId);
    }

    @Test
    @DisplayName("Obtener pago por ID cuando no existe retorna vacio")
    void getPaymentById_WhenNotExists_ReturnsEmpty() {
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.empty());

        Optional<Payment> result = paymentUseCase.getPaymentById(paymentId);

        assertThat(result).isEmpty();
        verify(paymentRepository, times(1)).findById(paymentId);
    }

    @Test
    @DisplayName("Obtener pagos por cuenta exitosamente")
    void getPaymentsByAccountId_ReturnsListOfPayments() {
        Payment secondPayment = new Payment(
            UUID.randomUUID(),
            "ACC-12345",
            new BigDecimal("500.00"),
            "EUR",
            "REC-11111",
            LocalDateTime.now(),
            PaymentStatus.COMPLETED,
            null
        );

        when(paymentRepository.findByAccountId("ACC-12345"))
            .thenReturn(List.of(testPayment, secondPayment));

        List<Payment> result = paymentUseCase.getPaymentsByAccountId("ACC-12345");

        assertThat(result).hasSize(2);
        assertThat(result).extracting(Payment::getAccountId)
            .containsOnly("ACC-12345");
        verify(paymentRepository, times(1)).findByAccountId("ACC-12345");
    }

    @Test
    @DisplayName("Obtener pagos por estado exitosamente")
    void getPaymentsByStatus_ReturnsListOfPayments() {
        when(paymentRepository.findByStatus(PaymentStatus.PENDING))
            .thenReturn(List.of(testPayment));

        List<Payment> result = paymentUseCase.getPaymentsByStatus(PaymentStatus.PENDING);

        assertThat(result).hasSize(1);
        assertThat(result.get(0).getStatus()).isEqualTo(PaymentStatus.PENDING);
        verify(paymentRepository, times(1)).findByStatus(PaymentStatus.PENDING);
    }

    @Test
    @DisplayName("Completar pago exitosamente")
    void completePayment_WhenPaymentExists_MarksAsCompleted() {
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(testPayment));
        when(paymentRepository.save(any(Payment.class))).thenReturn(testPayment);

        Payment result = paymentUseCase.completePayment(paymentId);

        assertThat(result.getStatus()).isEqualTo(PaymentStatus.COMPLETED);
        verify(paymentRepository, times(1)).findById(paymentId);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    @DisplayName("Completar pago falla cuando no existe")
    void completePayment_WhenPaymentNotExists_ThrowsException() {
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.empty());

        assertThatThrownBy(() -> paymentUseCase.completePayment(paymentId))
            .isInstanceOf(RuntimeException.class)
            .hasMessageContaining("no encontrado");

        verify(paymentRepository, times(1)).findById(paymentId);
        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    @DisplayName("Fallar pago exitosamente con razón")
    void failPayment_WhenPaymentExists_MarksAsFailed() {
        String failureReason = "Fondos insuficientes";
        when(paymentRepository.findById(paymentId)).thenReturn(Optional.of(testPayment));
        when(paymentRepository.save(any(Payment.class))).thenReturn(testPayment);

        Payment result = paymentUseCase.failPayment(paymentId, failureReason);

        assertThat(result.getStatus()).isEqualTo(PaymentStatus.FAILED);
        verify(paymentRepository, times(1)).findById(paymentId);
        verify(paymentRepository, times(1)).save(any(Payment.class));
    }

    @Test
    @DisplayName("Validar que cuenta origen no este vacia")
    void createPayment_WhenAccountIdIsEmpty_ThrowsException() {
        PaymentRequest request = new PaymentRequest(
            "",
            new BigDecimal("100.00"),
            "USD",
            "REC-67890"
        );

        assertThatThrownBy(() -> paymentUseCase.createPayment(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("cuenta");

        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    @DisplayName("Validar que cuenta destino no este vacia")
    void createPayment_WhenRecipientAccountIsEmpty_ThrowsException() {
        PaymentRequest request = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("100.00"),
            "USD",
            ""
        );

        assertThatThrownBy(() -> paymentUseCase.createPayment(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("destino");

        verify(paymentRepository, never()).save(any(Payment.class));
    }

    @Test
    @DisplayName("Validar que moneda sea valida")
    void createPayment_WhenCurrencyIsInvalid_ThrowsException() {
        PaymentRequest request = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("100.00"),
            "INVALID",
            "REC-67890"
        );

        assertThatThrownBy(() -> paymentUseCase.createPayment(request))
            .isInstanceOf(IllegalArgumentException.class)
            .hasMessageContaining("moneda");

        verify(paymentRepository, never()).save(any(Payment.class));
    }

    static class PaymentRequest {
        private final String accountId;
        private final BigDecimal amount;
        private final String currency;
        private final String recipientAccount;

        public PaymentRequest(String accountId, BigDecimal amount, String currency, String recipientAccount) {
            this.accountId = accountId;
            this.amount = amount;
            this.currency = currency;
            this.recipientAccount = recipientAccount;
        }

        public String accountId() { return accountId; }
        public BigDecimal amount() { return amount; }
        public String currency() { return currency; }
        public String recipientAccount() { return recipientAccount; }
    }
}

// === ARCHIVO: src/test/java/com/pragma/payments/infrastructure/controller/PaymentControllerTest.java ===
package com.pragma.payments.infrastructure.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.pragma.payments.application.dto.PaymentRequest;
import com.pragma.payments.application.dto.PaymentResponse;
import com.pragma.payments.application.usecase.PaymentUseCase;
import com.pragma.payments.domain.model.Payment;
import com.pragma.payments.domain.model.Payment.PaymentStatus;
import com.pragma.payments.infrastructure.config.GlobalExceptionHandler;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PaymentController.class)
@Import(GlobalExceptionHandler.class)
@DisplayName("PaymentController - Tests de integración con Resilience4j")
class PaymentControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private PaymentUseCase paymentUseCase;

    private Payment testPayment;
    private UUID paymentId;
    private PaymentRequest validRequest;

    @BeforeEach
    void setUp() {
        paymentId = UUID.randomUUID();
        testPayment = new Payment(
            paymentId,
            "ACC-12345",
            new BigDecimal("1000.00"),
            "USD",
            "REC-67890",
            LocalDateTime.now(),
            PaymentStatus.PENDING,
            null
        );

        validRequest = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("1000.00"),
            "USD",
            "REC-67890"
        );
    }

    @Test
    @DisplayName("Crear payment retorna 201 cuando la peticion es valida")
    void createPayment_WhenRequestIsValid_ReturnsCreated() throws Exception {
        PaymentResponse response = toResponse(testPayment);
        when(paymentUseCase.createPayment(any(PaymentRequest.class))).thenReturn(testPayment);

        mockMvc.perform(post("/api/v1/payments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validRequest)))
            .andExpect(status().isCreated())
            .andExpect(jsonPath("$.id").value(paymentId.toString()))
            .andExpect(jsonPath("$.accountId").value("ACC-12345"))
            .andExpect(jsonPath("$.amount").value(1000.00))
            .andExpect(jsonPath("$.status").value("PENDING"));

        verify(paymentUseCase, times(1)).createPayment(any(PaymentRequest.class));
    }

    @Test
    @DisplayName("Crear payment retorna 400 cuando el monto es negativo")
    void createPayment_WhenAmountIsNegative_ReturnsBadRequest() throws Exception {
        PaymentRequest invalidRequest = new PaymentRequest(
            "ACC-12345",
            new BigDecimal("-100.00"),
            "USD",
            "REC-67890"
        );

        when(paymentUseCase.createPayment(any(PaymentRequest.class)))
            .thenThrow(new IllegalArgumentException("El monto debe ser mayor que cero"));

        mockMvc.perform(post("/api/v1/payments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)))
            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Crear payment retorna 400 cuando la cuenta es vacia")
    void createPayment_WhenAccountIdIsEmpty_ReturnsBadRequest() throws Exception {
        PaymentRequest invalidRequest = new PaymentRequest(
            "",
            new BigDecimal("100.00"),
            "USD",
            "REC-67890"
        );

        mockMvc.perform(post("/api/v1/payments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(invalidRequest)))
            .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Obtener payment por ID retorna 200 cuando existe")
    void getPaymentById_WhenExists_ReturnsOk() throws Exception {
        when(paymentUseCase.getPaymentById(paymentId)).thenReturn(Optional.of(testPayment));

        mockMvc.perform(get("/api/v1/payments/{id}", paymentId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.id").value(paymentId.toString()))
            .andExpect(jsonPath("$.accountId").value("ACC-12345"));

        verify(paymentUseCase, times(1)).getPaymentById(paymentId);
    }

    @Test
    @DisplayName("Obtener payment por ID retorna 404 cuando no existe")
    void getPaymentById_WhenNotExists_ReturnsNotFound() throws Exception {
        when(paymentUseCase.getPaymentById(paymentId)).thenReturn(Optional.empty());

        mockMvc.perform(get("/api/v1/payments/{id}", paymentId))
            .andExpect(status().isNotFound());

        verify(paymentUseCase, times(1)).getPaymentById(paymentId);
    }

    @Test
    @DisplayName("Obtener payments por cuenta retorna 200 con lista")
    void getPaymentsByAccountId_ReturnsOkWithList() throws Exception {
        List<Payment> payments = List.of(testPayment);
        when(paymentUseCase.getPaymentsByAccountId("ACC-12345")).thenReturn(payments);

        mockMvc.perform(get("/api/v1/payments")
                .param("accountId", "ACC-12345"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].accountId").value("ACC-12345"));

        verify(paymentUseCase, times(1)).getPaymentsByAccountId("ACC-12345");
    }

    @Test
    @DisplayName("Obtener payments por estado retorna 200 con lista")
    void getPaymentsByStatus_ReturnsOkWithList() throws Exception {
        List<Payment> payments = List.of(testPayment);
        when(paymentUseCase.getPaymentsByStatus(PaymentStatus.PENDING)).thenReturn(payments);

        mockMvc.perform(get("/api/v1/payments")
                .param("status", "PENDING"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.length()").value(1))
            .andExpect(jsonPath("$[0].status").value("PENDING"));

        verify(paymentUseCase, times(1)).getPaymentsByStatus(PaymentStatus.PENDING);
    }

    @Test
    @DisplayName("Completar payment retorna 200 cuando existe")
    void completePayment_WhenExists_ReturnsOk() throws Exception {
        testPayment.markAsCompleted();
        when(paymentUseCase.completePayment(paymentId)).thenReturn(testPayment);

        mockMvc.perform(put("/api/v1/payments/{id}/complete", paymentId))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("COMPLETED"));

        verify(paymentUseCase, times(1)).completePayment(paymentId);
    }

    @Test
    @DisplayName("Completar payment retorna 404 cuando no existe")
    void completePayment_WhenNotExists_ReturnsNotFound() throws Exception {
        when(paymentUseCase.completePayment(paymentId))
            .thenThrow(new RuntimeException("Payment no encontrado"));

        mockMvc.perform(put("/api/v1/payments/{id}/complete", paymentId))
            .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Fallar payment retorna 200 con razon")
    void failPayment_WhenExists_ReturnsOk() throws Exception {
        testPayment.markAsFailed("Fondos insuficientes");
        when(paymentUseCase.failPayment(paymentId, "Fondos insuficientes"))
            .thenReturn(testPayment);

        mockMvc.perform(put("/api/v1/payments/{id}/fail", paymentId)
                .param("reason", "Fondos insuficientes"))
            .andExpect(status().isOk())
            .andExpect(jsonPath("$.status").value("FAILED"));

        verify(paymentUseCase, times(1)).failPayment(paymentId, "Fondos insuficientes");
    }

    @Test
    @DisplayName("Eliminar payment retorna 204 cuando existe")
    void deletePayment_WhenExists_ReturnsNoContent() throws Exception {
        mockMvc.perform(delete("/api/v1/payments/{id}", paymentId))
            .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Crear payment con CircuitBreaker retorna 503 cuando el servicio falla")
    void createPayment_WhenCircuitBreakerIsOpen_ReturnsServiceUnavailable() throws Exception {
        when(paymentUseCase.createPayment(any(PaymentRequest.class)))
            .thenThrow(new RuntimeException("Servicio no disponible"));

        mockMvc.perform(post("/api/v1/payments")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(validRequest)))
            .andExpect(status().isServiceUnavailable());
    }

    @Test
    @DisplayName("Obtener payments sin parametros retorna 400")
    void getPayments_WhenNoParams_ReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/v1/payments"))
            .andExpect(status().isBadRequest());
    }

    private PaymentResponse toResponse(Payment payment) {
        return new PaymentResponse(
            payment.getId(),
            payment.getAccountId(),
            payment.getAmount(),
            payment.getCurrency(),
            payment.getRecipientAccount(),
            payment.getCreatedAt(),
            payment.getStatus().name(),
            payment.getFailureReason()
        );
    }
}

// === ARCHIVO: src/main/java/com/pragma/payments/application/dto/ErrorResponse.java ===
package com.pragma.payments.application.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public record ErrorResponse(
    int status,
    String code,
    String message,
    LocalDateTime timestamp
) {
    public ErrorResponse {
        if (code == null || code.isBlank()) {
            throw new IllegalArgumentException("El código de error no puede ser nulo o vacío");
        }
        if (message == null || message.isBlank()) {
            throw new IllegalArgumentException("El mensaje de error no puede ser nulo o vacío");
        }
        Objects.requireNonNull(timestamp, "El timestamp no puede ser nulo");
    }

    public static ErrorResponse of(int status, String code, String message) {
        return new ErrorResponse(status, code, message, LocalDateTime.now());
    }

    public static ErrorResponse badRequest(String message) {
        return new ErrorResponse(400, "BAD_REQUEST", message, LocalDateTime.now());
    }

    public static ErrorResponse notFound(String message) {
        return new ErrorResponse(404, "NOT_FOUND", message, LocalDateTime.now());
    }

    public static ErrorResponse internalError(String message) {
        return new ErrorResponse(500, "INTERNAL_SERVER_ERROR", message, LocalDateTime.now());
    }

    public static ErrorResponse unauthorized(String message) {
        return new ErrorResponse(401, "UNAUTHORIZED", message, LocalDateTime.now());
    }

    public static ErrorResponse forbidden(String message) {
        return new ErrorResponse(403, "FORBIDDEN", message, LocalDateTime.now());
    }

    public static ErrorResponse serviceUnavailable(String message) {
        return new ErrorResponse(503, "SERVICE_UNAVAILABLE", message, LocalDateTime.now());
    }

    public boolean isClientError() {
        return status >= 400 && status < 500;
    }

    public boolean isServerError() {
        return status >= 500;
    }

    public boolean isSuccess() {
        return status >= 200 && status < 300;
    }

    public String getStatusText() {
        return switch (status) {
            case 200 -> "OK";
            case 201 -> "Created";
            case 204 -> "No Content";
            case 400 -> "Bad Request";
            case 401 -> "Unauthorized";
            case 403 -> "Forbidden";
            case 404 -> "Not Found";
            case 500 -> "Internal Server Error";
            case 503 -> "Service Unavailable";
            default -> "Unknown";
        };
    }

    public ErrorResponse withStatus(int newStatus) {
        return new ErrorResponse(newStatus, code, message, timestamp);
    }

    public ErrorResponse withCode(String newCode) {
        return new ErrorResponse(status, newCode, message, timestamp);
    }

    public ErrorResponse withMessage(String newMessage) {
        return new ErrorResponse(status, code, newMessage, timestamp);
    }

    public ErrorResponse withTimestamp(LocalDateTime newTimestamp) {
        return new ErrorResponse(status, code, message, newTimestamp);
    }

    @Override
    public String toString() {
        return "ErrorResponse{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                '}';
    }
}
```
