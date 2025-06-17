
# Plantilla para Listas de Comandos

## Estructura por Lenguaje/Herramienta
### Lenguaje/Herramienta: [Nombre del lenguaje o herramienta]

| **Comando**          | **Parámetros**                    | **Framework/Librería**    | **Descripción**                                                 |
|-----------------------|-----------------------------------|---------------------------|-----------------------------------------------------------------|
| [Escribe el comando]  | [Lista de parámetros o flags]    | [Framework o librería]    | [Descripción breve del propósito del comando]                 |

---

## Ejemplos

### Lenguaje/Herramienta: Java + Spring Boot

| **Comando**                 | **Parámetros**                               | **Framework/Librería** | **Descripción**                                                   |
|-----------------------------|----------------------------------------------|-------------------------|-------------------------------------------------------------------|
| `mvn spring-boot:run`       | `-Dspring.profiles.active=[profile]`         | Maven                  | Inicia la aplicación con el perfil especificado.                 |
| `java -jar`                 | `[archivo.jar]`                             | Java                   | Ejecuta una aplicación Java empaquetada en un archivo JAR.        |
| `@RestController`           | N/A                                          | Spring Boot            | Anotación para definir un controlador REST.                      |
| `@Query`                    | `[consulta SQL]`                            | Spring Data JPA        | Ejecuta una consulta personalizada en un repositorio.            |

---

### Lenguaje/Herramienta: JavaScript + Node.js

| **Comando**          | **Parámetros**            | **Framework/Librería** | **Descripción**                                  |
|-----------------------|---------------------------|-------------------------|------------------------------------------------|
| `npm install`         | `[paquete]`              | NPM                    | Instala un paquete en el proyecto actual.      |
| `npx create-react-app`| `[nombre_app]`           | Create React App       | Genera una aplicación React desde cero.        |
| `node [archivo.js]`   | N/A                      | Node.js                | Ejecuta un archivo JavaScript en el servidor.  |
| `express()`           | N/A                      | Express.js             | Crea una nueva instancia de la aplicación web. |

---

### Lenguaje/Herramienta: PostgreSQL

| **Comando**             | **Parámetros**                             | **Framework/Librería** | **Descripción**                                             |
|--------------------------|--------------------------------------------|-------------------------|-------------------------------------------------------------|
| `psql`                  | `-h [host] -U [usuario] -d [base de datos]`| PostgreSQL             | Abre una sesión interactiva con la base de datos.           |
| `\dt`                  | N/A                                        | PostgreSQL             | Muestra todas las tablas en la base de datos actual.        |
| `SELECT * FROM [tabla];`| N/A                                        | SQL                    | Recupera todos los datos de una tabla.                     |

---

### Lenguaje/Herramienta: Kubernetes (kubectl)

| **Comando**                | **Parámetros**                      | **Framework/Librería** | **Descripción**                                    |
|----------------------------|-------------------------------------|-------------------------|--------------------------------------------------|
| `kubectl get pods`         | `-n [namespace]`                   | Kubernetes             | Lista los pods en un namespace.                  |
| `kubectl apply`            | `-f [archivo.yaml]`                | Kubernetes             | Aplica la configuración especificada en un YAML. |
| `kubectl logs`             | `[pod] -n [namespace]`             | Kubernetes             | Muestra los logs de un pod.                      |

---

### Lenguaje/Herramienta: Git

| **Comando**               | **Parámetros**                        | **Framework/Librería** | **Descripción**                                      |
|---------------------------|---------------------------------------|-------------------------|----------------------------------------------------|
| `git clone`               | `[repositorio_url]`                  | Git                    | Clona un repositorio remoto.                      |
| `git commit`              | `-m "[mensaje]"`                     | Git                    | Crea un commit con un mensaje descriptivo.        |
| `git branch`              | N/A                                  | Git                    | Lista las ramas del repositorio actual.           |
| `git merge`               | `[rama]`                             | Git                    | Fusiona una rama en la actual.                    |

---

### Lenguaje/Herramienta: Python

#### Flask

| **Comando**                | **Parámetros**                       | **Framework/Librería** | **Descripción**                                         |
|----------------------------|--------------------------------------|-------------------------|-------------------------------------------------------|
| `flask run`                | `--host=[host] --port=[puerto]`      | Flask                  | Inicia la aplicación Flask en el host y puerto especificados. |
| `export FLASK_APP=[archivo.py]` | N/A                             | Flask                  | Define el archivo principal de la aplicación Flask.   |
| `flask routes`             | N/A                                  | Flask                  | Muestra todas las rutas registradas en la aplicación. |
| `flask shell`              | N/A                                  | Flask                  | Inicia una consola interactiva con el contexto de la aplicación Flask cargado. |

#### Django

| **Comando**                | **Parámetros**                       | **Framework/Librería** | **Descripción**                                         |
|----------------------------|--------------------------------------|-------------------------|-------------------------------------------------------|
| `django-admin startproject`| `[nombre_proyecto]`                  | Django                 | Crea un nuevo proyecto Django con el nombre especificado. |
| `python manage.py runserver` | `[puerto]`                         | Django                 | Inicia el servidor de desarrollo Django.             |
| `python manage.py makemigrations` | N/A                          | Django                 | Crea archivos de migración para los modelos modificados. |
| `python manage.py migrate` | N/A                                  | Django                 | Aplica las migraciones a la base de datos.           |
| `python manage.py createsuperuser` | N/A                          | Django                 | Crea un usuario administrador para el panel de Django. |
| `python manage.py shell`   | N/A                                  | Django                 | Abre una consola interactiva con el contexto del proyecto. |

#### Manim

| **Comando**                | **Parámetros**                       | **Framework/Librería** | **Descripción**                                         |
|----------------------------|--------------------------------------|-------------------------|-------------------------------------------------------|
| `manim`                    | `[archivo.py] [NombreClase]`         | Manim                  | Renderiza una animación definida en la clase especificada dentro del archivo. |
| `manim -p -ql`             | `[archivo.py] [NombreClase]`         | Manim                  | Renderiza rápidamente la animación en baja calidad y la previsualiza. |
| `manim -p -qm`             | `[archivo.py] [NombreClase]`         | Manim                  | Renderiza la animación en calidad media y la previsualiza. |
| `manim -p -qh`             | `[archivo.py] [NombreClase]`         | Manim                  | Renderiza la animación en alta calidad y la previsualiza. |
| `manim --config_file`      | `[archivo_config.cfg]`               | Manim                  | Especifica un archivo de configuración personalizado para el renderizado. |

---

### Lenguaje/Herramienta: Shell (Linux)

#### Comandos Básicos

| **Comando**                | **Parámetros**                       | **Framework/Librería** | **Descripción**                                         |
|----------------------------|--------------------------------------|-------------------------|-------------------------------------------------------|
| `ls`                       | `-l`, `-a`, `-h`                    | N/A                    | Lista los archivos y directorios en el directorio actual. |
| `cd`                       | `[directorio]`                      | N/A                    | Cambia al directorio especificado.                   |
| `cp`                       | `[origen] [destino]`                | N/A                    | Copia archivos o directorios.                        |
| `mv`                       | `[origen] [destino]`                | N/A                    | Mueve o renombra archivos o directorios.            |
| `rm`                       | `-r`, `-f`, `[archivo/directorio]`  | N/A                    | Elimina archivos o directorios.                     |
| `chmod`                    | `[permisos] [archivo/directorio]`   | N/A                    | Cambia los permisos de un archivo o directorio.      |
| `grep`                     | `[patrón] [archivo]`                | N/A                    | Busca texto dentro de un archivo usando un patrón.   |
| `find`                     | `[directorio] -name [patrón]`       | N/A                    | Encuentra archivos o directorios que coincidan con el patrón. |
| `ps`                       | `-aux`                              | N/A                    | Muestra todos los procesos en ejecución.            |
| `kill`                     | `[PID]`                             | N/A                    | Termina un proceso usando su ID de proceso.          |

#### Administración del Sistema

| **Comando**                | **Parámetros**                       | **Framework/Librería** | **Descripción**                                         |
|----------------------------|--------------------------------------|-------------------------|-------------------------------------------------------|
| `sudo`                     | `[comando]`                         | N/A                    | Ejecuta un comando como administrador.               |
| `systemctl`                | `start`, `stop`, `status`, `[servicio]` | N/A                  | Controla los servicios del sistema.                  |
| `df`                       | `-h`                                | N/A                    | Muestra el espacio en disco disponible.              |
| `top`                      | N/A                                  | N/A                    | Monitorea los procesos en tiempo real.               |
| `ifconfig`                 | N/A                                  | N/A                    | Muestra la configuración de red.                     |
| `ping`                     | `[dirección]`                       | N/A                    | Envía paquetes ICMP a una dirección para verificar conectividad. |

---

### Lenguaje/Herramienta: Nmap

| **Comando**                | **Parámetros**                       | **Framework/Librería** | **Descripción**                                         |
|----------------------------|--------------------------------------|-------------------------|-------------------------------------------------------|
| `nmap`                     | `[dirección]`                       | Nmap                   | Realiza un escaneo básico de la dirección especificada. |
| `nmap -sS`                 | `[dirección]`                       | Nmap                   | Realiza un escaneo SYN (stealth).                    |
| `nmap -O`                  | `[dirección]`                       | Nmap                   | Detecta el sistema operativo del host escaneado.     |
| `nmap -p`                  | `[puerto] [dirección]`              | Nmap                   | Escanea puertos específicos de un host.             |
| `nmap -A`                  | `[dirección]`                       | Nmap                   | Escaneo avanzado, incluye sistema operativo y servicios. |
| `nmap -v`                  | `[dirección]`                       | Nmap                   | Muestra detalles del escaneo mientras se ejecuta.   |
| `nmap -Pn`                 | `[dirección]`                       | Nmap                   | Escanea ignorando pings previos.                    |
| `nmap -T4`                 | `[dirección]`                       | Nmap                   | Realiza un escaneo más rápido.                      |
| `nmap -script`             | `[script] [dirección]`              | Nmap                   | Ejecuta un script NSE para el escaneo.              |

---

### Lenguaje/Herramienta: Unity

#### Comandos Básicos de C# en Unity

| **Comando**                      | **Parámetros**                         | **Framework/Librería** | **Descripción**                                         |
|----------------------------------|----------------------------------------|-------------------------|-------------------------------------------------------|
| `Debug.Log`                      | `"mensaje"`                            | UnityEngine            | Imprime un mensaje en la consola.                    |
| `transform.Translate`            | `(x, y, z)`                            | UnityEngine            | Mueve un objeto en el espacio local.                 |
| `Instantiate`                    | `(objeto, posición, rotación)`         | UnityEngine            | Crea una instancia de un prefab.                     |
| `Destroy`                        | `(objeto, tiempo)`                     | UnityEngine            | Destruye un objeto después de un tiempo opcional.    |
| `GetComponent<T>()`              | `()`                                   | UnityEngine            | Obtiene un componente adjunto al objeto actual.      |
| `Input.GetAxis`                  | `("Horizontal" o "Vertical")`          | UnityEngine            | Obtiene la entrada del usuario en ejes específicos.  |
| `Physics.Raycast`                | `(origen, dirección, longitud)`        | UnityEngine            | Detecta colisiones en una dirección.                 |
| `SceneManager.LoadScene`         | `"nombreEscena"`                       | UnityEngine.SceneManagement | Cambia a una nueva escena.                      |

#### Comandos para Animaciones y UI

| **Comando**                      | **Parámetros**                         | **Framework/Librería** | **Descripción**                                         |
|----------------------------------|----------------------------------------|-------------------------|-------------------------------------------------------|
| `Animator.SetBool`               | `(nombreParametro, valor)`             | UnityEngine            | Cambia un parámetro booleano en el Animator.         |
| `CanvasGroup.alpha`              | `(valor entre 0 y 1)`                  | UnityEngine.UI         | Cambia la transparencia de un grupo de UI.           |
| `Button.onClick.AddListener`     | `(() => { acción })`                   | UnityEngine.UI         | Agrega una acción al clic de un botón.               |
| `Text.text`                      | `"nuevoTexto"`                         | UnityEngine.UI         | Cambia el texto de un componente Text.               |

---

### Lenguaje/Herramienta: Unreal Engine

#### Comandos Básicos en Blueprints

| **Comando**                      | **Parámetros**                         | **Framework/Librería** | **Descripción**                                         |
|----------------------------------|----------------------------------------|-------------------------|-------------------------------------------------------|
| `BeginPlay`                      | N/A                                    | Unreal Engine          | Evento que se ejecuta al inicio del juego.           |
| `AddActorLocalOffset`            | `(Vector)`                             | Unreal Engine          | Mueve un actor en el espacio local.                  |
| `SetActorRotation`               | `(Rotator)`                            | Unreal Engine          | Cambia la rotación de un actor.                      |
| `Print String`                   | `"mensaje"`                            | Unreal Engine          | Imprime un mensaje en la pantalla.                   |
| `SpawnActor`                     | `(ClaseActor, Transform)`              | Unreal Engine          | Crea un nuevo actor en el juego.                     |

#### Comandos Básicos en C++

| **Comando**                      | **Parámetros**                         | **Framework/Librería** | **Descripción**                                         |
|----------------------------------|----------------------------------------|-------------------------|-------------------------------------------------------|
| `GEngine->AddOnScreenDebugMessage` | `(ID, duración, color, mensaje)`      | Unreal Engine          | Muestra un mensaje en la pantalla para debugging.     |
| `GetWorld()`                     | N/A                                    | Unreal Engine          | Obtiene el contexto del mundo actual.                |
| `FVector`                        | `(x, y, z)`                            | Unreal Engine          | Define una posición o dirección en 3D.               |
| `FRotator`                       | `(Pitch, Yaw, Roll)`                   | Unreal Engine          | Define una rotación en el espacio 3D.                |
| `UGameplayStatics::SpawnEmitterAtLocation` | `(World, Emitter, Transform)` | Unreal Engine          | Crea un efecto visual en una posición.               |

#### Comandos para Gestión de UI y Widgets

| **Comando**                      | **Parámetros**                         | **Framework/Librería** | **Descripción**                                         |
|----------------------------------|----------------------------------------|-------------------------|-------------------------------------------------------|
| `CreateWidget`                   | `(ClaseWidget, Propietario)`           | Unreal Engine          | Crea un widget UI en pantalla.                       |
| `AddToViewport`                  | N/A                                    | Unreal Engine          | Muestra un widget en la interfaz.                    |
| `SetVisibility`                  | `(ESlateVisibility::Visible)`          | Unreal Engine          | Cambia la visibilidad de un widget.                  |

---

## Instrucciones para Usar el Template

1. **Agrupa los comandos** por lenguaje o herramienta.
2. Llena los campos: comando, parámetros (opcional), framework/librería, y descripción.
3. Si hay comandos relacionados, agrúpalos bajo subtítulos adicionales, como "Despliegue", "Consultas", "Configuraciones", etc.
4. Guarda este template en un archivo markdown (`.md`) o una hoja de cálculo para facilitar su consulta.
