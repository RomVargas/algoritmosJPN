// === SPRING FRAMEWORK: CONCEPTOS FUNDAMENTALES ===
//
// 1. ¿Qué es Spring Framework?
//    - Un framework para desarrollo de aplicaciones Java empresariales.
//    - Principios: Inversión de Control (IoC), Inyección de Dependencias (DI), modularidad, testabilidad.
//
// 2. Conceptos clave:
//    - Bean: Objeto gestionado por el contenedor de Spring.
//    - ApplicationContext: Contenedor principal de Spring, gestiona el ciclo de vida de los beans.
//    - Inversión de Control (IoC): El framework controla la creación y ensamblaje de objetos.
//    - Inyección de Dependencias (DI): Las dependencias se inyectan automáticamente (por constructor, setter o campo).
//    - Configuración: XML, JavaConfig (@Configuration), anotaciones.
//
// 3. Anotaciones principales de Spring Core:
//    @Component        // Marca una clase como bean gestionado
//    @Service          // Especialización de @Component para lógica de negocio
//    @Repository       // Especialización de @Component para acceso a datos
//    @Controller       // Especialización de @Component para controladores web
//    @Configuration    // Clase de configuración Java
//    @Bean             // Método que expone un bean
//    @Autowired        // Inyección automática de dependencias
//    @Qualifier        // Especifica el bean a inyectar cuando hay varios candidatos
//    @Value            // Inyecta valores desde properties
//    @PostConstruct    // Método a ejecutar después de la inyección
//    @PreDestroy       // Método a ejecutar antes de destruir el bean
//    @Primary          // Marca un bean como preferido
//    @Scope            // Define el alcance del bean (singleton, prototype, request, session)
//
// 4. Ejemplo avanzado de configuración y uso de beans:

import org.springframework.beans.factory.annotation.*;
import org.springframework.context.annotation.*;
import org.springframework.stereotype.*;
import javax.annotation.*;

@Configuration
public class SpringConfig {
    @Bean
    public Motor motor() {
        return new Motor("V8");
    }

    @Bean
    public Coche coche(Motor motor) {
        return new Coche(motor);
    }
}

@Component
class Motor {
    private String tipo;
    public Motor(String tipo) { this.tipo = tipo; }
    public String getTipo() { return tipo; }
}

@Component
class Coche {
    private final Motor motor;
    @Autowired
    public Coche(Motor motor) { this.motor = motor; }
    @PostConstruct
    public void init() { System.out.println("Coche listo con motor: " + motor.getTipo()); }
}

// Uso en una aplicación:
// ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
// Coche coche = context.getBean(Coche.class);
//
// === FIN DE LA PRIMERA PARTE ===
