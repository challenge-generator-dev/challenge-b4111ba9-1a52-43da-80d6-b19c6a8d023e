# Integración de Resiliencia en el Core de Pagos

En el dominio de la banca, el core de pagos debe ser robusto y escalable para manejar un alto volumen de transacciones y garantizar la disponibilidad del servicio. El objetivo es aplicar al menos dos métodos de tolerancia a fallos, como CircuitBreaker, Retry, Fallback y RateLimit, para asegurar que el sistema pueda manejar fallos temporales y mantener la operatividad.

## Informacion General

| Campo | Valor |
|-------|-------|
| **Tema** | Construccion de Servicios REST Robustos y Escalables (reg 1109) |
| **Nivel** | senior-l2 |
| **Tipo** | practical |
| **Tiempo estimado** | 2 semanas |

## Fases del Reto

### Fase 0: Configuración del Proyecto

**Objetivo:** Obtener el proyecto base funcional enviando el Código Base a un asistente de IA, que lo analizará, corregirá errores y entregará cada archivo con su ruta.

**Tiempo estimado:** 15-30 minutos

**Instrucciones:**

- Asegúrate de tener instalado para ejecutar el proyecto: JDK 17+, Maven 3.9+, IDE con soporte Java.
- Copia todo el contenido del campo **Código Base** de este reto — incluyendo el texto de instrucciones que aparece al inicio.
- Abre un asistente de IA (Claude en claude.ai, ChatGPT o Gemini — se recomienda Claude), pega el contenido copiado en el chat y envíalo.
- El asistente analizará los archivos, corregirá errores y entregará cada archivo con su ruta. Guárdalos en la carpeta donde quieras trabajar, respetando las rutas.
- Ejecuta `mvn compile` en la raíz. Si no hay errores, estás listo.

**Entregable:** El proyecto compila/arranca sin errores.

<details>
<summary>Pistas de conocimiento</summary>

- Copia el Código Base completo incluyendo el texto de instrucciones al inicio — esas instrucciones le indican al asistente exactamente qué hacer con los archivos.
- Si el asistente no entrega todos los archivos al terminar el análisis, escríbele: "entrégame todos los archivos con su ruta".
- Si el proyecto tiene errores al arrancar, comparte el mensaje de error con el mismo asistente para que lo corrija.

</details>

### Fase 1: Evaluación del Sistema Actual

**Objetivo:** Identificar las debilidades actuales en la gestión de fallos y establecer las bases para la integración de métodos de resiliencia.

**Tiempo estimado:** 3 días

**Instrucciones:**

- Analiza el sistema actual de pagos y enumera las posibles fuentes de fallos.
- Identifica las áreas donde se pueden aplicar métodos de tolerancia a fallos.

**Entregable:** Reporte de evaluación con identificación de puntos débiles y propuestas de mejora.

<details>
<summary>Pistas de conocimiento</summary>

- Considera el impacto de los fallos en la disponibilidad y consistencia de los pagos.
- Piensa en cómo los métodos de resiliencia pueden mitigar los efectos de los fallos.

</details>

### Fase 2: Implementación de CircuitBreaker

**Objetivo:** Integrar el patrón CircuitBreaker para manejar fallos temporales en el sistema de pagos.

**Tiempo estimado:** 5 días

**Instrucciones:**

- Selecciona un servicio crítico en el core de pagos para aplicar el patrón CircuitBreaker.
- Implementa el CircuitBreaker y verifica que maneja correctamente los fallos temporales.

**Entregable:** Servicio de pagos con CircuitBreaker implementado y verificado.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo el CircuitBreaker puede prevenir cascadas de fallos.
- Evalúa diferentes bibliotecas o frameworks que pueden facilitar la implementación.

</details>

### Fase 3: Implementación de Retry y Fallback

**Objetivo:** Añadir patrones Retry y Fallback para mejorar la resiliencia del sistema de pagos.

**Tiempo estimado:** 5 días

**Instrucciones:**

- Identifica servicios donde se pueden aplicar los patrones Retry y Fallback.
- Implementa estos patrones y verifica que mejoran la resiliencia del sistema.

**Entregable:** Servicio de pagos con patrones Retry y Fallback implementados y verificados.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo el Retry puede manejar fallos transitorios.
- Evalúa cómo el Fallback puede proporcionar una respuesta alternativa en caso de fallo.

</details>

### Fase 4: Implementación de RateLimit

**Objetivo:** Integrar el patrón RateLimit para prevenir sobrecargas en el sistema de pagos.

**Tiempo estimado:** 4 días

**Instrucciones:**

- Identifica puntos de entrada donde se puede aplicar el patrón RateLimit.
- Implementa el RateLimit y verifica que previene sobrecargas en el sistema.

**Entregable:** Servicio de pagos con RateLimit implementado y verificado.

<details>
<summary>Pistas de conocimiento</summary>

- Considera cómo el RateLimit puede prevenir sobrecargas y mejorar la estabilidad del sistema.
- Evalúa diferentes estrategias para configurar el RateLimit.

</details>

## Dimensiones Evaluadas

- **queEs**: En fase 1, ¿qué es el patrón CircuitBreaker y cómo funciona?
- **paraQueSirve**: En fase 2, ¿para qué sirve el patrón CircuitBreaker en el sistema de pagos?
- **comoSeUsa**: En fase 3, ¿cómo se usa el patrón Retry para manejar fallos transitorios?
- **erroresComunes**: En fase 4, ¿cuáles son los errores comunes al implementar el patrón RateLimit?
- **queDecisionesImplica**: En fase 2, ¿qué decisiones implica la implementación del patrón CircuitBreaker en el sistema de pagos?

## Criterios de Evaluacion

- Identificación correcta de puntos débiles en la gestión de fallos del sistema actual.
- Implementación efectiva del patrón CircuitBreaker en un servicio crítico.
- Implementación efectiva de los patrones Retry y Fallback en servicios críticos.
- Implementación efectiva del patrón RateLimit en puntos de entrada críticos.
- Evaluación de trade-offs y justificación de decisiones al implementar patrones de resiliencia.

## Como trabajar con un asistente de IA

Hay dos caminos, elegi uno:

- **AGENTS.md** (recomendado) — instrucciones nativas del repo. Abri esta carpeta con tu agente local (Claude Code, Cursor, Codex, Copilot, Gemini) y las carga solo. Sabe que archivos faltan y con que comando se verifica, y completa el scaffold escribiendo en disco.
- **PROMPT_MEJORA.md** — para copiar y pegar en un chat (claude.ai, ChatGPT) si no tenes un agente en el IDE. Declara lo mismo que AGENTS.md; los archivos que te devuelva el chat los guardas en esta carpeta respetando las rutas.

Ninguno de los dos resuelve las fases del reto: eso es tu trabajo.

## Verificacion

El proyecto esta listo para trabajar cuando este comando corre sin errores:

```bash
mvn clean compile
```

---

*Reto generado automaticamente por Challenge Generator - Pragma*
