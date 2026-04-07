# Prototipo Encargado - Kiosco San Antonio

Prototipo navegable realizado en **Java Swing estándar** para demo académica del rol **Encargado**.

## Importante
Este proyecto es **no funcional** a nivel de negocio real:
- No usa base de datos.
- No tiene persistencia.
- No implementa login.
- No usa frameworks externos.
- Solo simula pantallas, navegación y acciones con datos mock.

## Pantallas incluidas
1. Menú principal del Encargado.
2. Aprobación/Rechazo de apertura de cuenta corriente.
3. Registro de consumo personal.
4. Visualización de cierre de caja.
5. Consulta de productos consumidos y vencidos por período.

## Estructura
- `src/main/java/prototipo/kiosco/VentanaPrincipalEncargado.java`: clase principal ejecutable.
- `src/main/java/prototipo/kiosco/Panel*.java`: pantallas Swing.
- `src/main/java/prototipo/kiosco/EstilosUI.java`: estilos visuales simples compartidos.
- `src/main/java/prototipo/kiosco/NavegadorPantallas.java`: interfaz de navegación.
- `pom.xml`: configuración del proyecto Maven.

## Cómo ejecutar con Maven
```bash
mvn clean compile
mvn exec:java
```

## Abrir en NetBeans (Maven)
1. Abrir NetBeans.
2. Elegir **File > Open Project**.
3. Seleccionar la carpeta raíz de este repositorio.
4. Ejecutar el proyecto como aplicación Maven.
