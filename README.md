# code-with-quarkus 

Este proyecto usa Quarkus, el Framework Java Supersonic Subatomic.

Si tu quieres aprender más sobre Quarkus, por favor visita el sitio web: https://quarkus.io/.

## Ejecutando la aplicación en modo dev

Tu puedes ejecutar a aplicación en modo dev que habilita el "código vivo" usando:
```shell script
./mvnw compile quarkus:dev
```

> **_NOTA:_**  Quarkus ahora viene con una interfaz de usuario de desarrollo, que está disponible en modo de desarrollo solo en http://localhost:8080/q/dev/.

## Empaquetamiento y ejecución de la aplicación

La aplicación puede ser empaquetada usando:
```shell script
./mvnw package
```
Esto produce el archivo `quarkus-run.jar` en el directorio `target/quarkus-app/`. Tenga en cuenta que no es un _über-jar_ ya que las dependencias se copian en el directorio `target/quarkus-app/lib/`.

La aplicación es ahora ejecutale usando `java -jar target/quarkus-app/quarkus-run.jar`.

si tu quieres construir un archivo _über-jar_, ejecuta el siguiente comando:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

La aplicación, epaquetada como un _über-jar_, es ahora ejecutable usando `java -jar target/*-runner.jar`.

## Creando un ejecutable nativo

Tu puedes crear un ejecutable nativo usando: 
```shell script
./mvnw package -Pnative
```

O, si no tiene GraalVM instalado, puede ejecutar la compilación ejecutable nativa en un contenedor usando: 
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

Luego puede ejecutar su ejecutable nativo con:`./target/code-with-quarkus-1.0.0-SNAPSHOT-runner`

Si desea obtener más información sobre la creación de ejecutables nativos, consulte https://quarkus.io/guides/maven-tooling.

## Código proporcionado

### RESTEasy Reactivo

Inicie fácilmente sus servicios web RESTful reactivos

[Sección de guía relacionada...](https://quarkus.io/guides/getting-started-reactive#reactive-jax-rs-resources)
