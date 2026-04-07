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
- `src/prototipo/kiosco/VentanaPrincipalEncargado.java`: clase principal ejecutable.
- `src/prototipo/kiosco/Panel*.java`: pantallas Swing.
- `src/prototipo/kiosco/EstilosUI.java`: estilos visuales simples compartidos.
- `src/prototipo/kiosco/NavegadorPantallas.java`: interfaz de navegación.
- `build.xml` + `nbproject/`: estructura Java with Ant compatible con NetBeans.

## Cómo abrir y ejecutar en NetBeans
1. Abrir NetBeans.
2. Elegir **File > Open Project**.
3. Seleccionar la carpeta raíz de este repositorio.
4. Ejecutar el proyecto (la clase principal ya está configurada en `prototipo.kiosco.VentanaPrincipalEncargado`).

## Ejecución rápida por consola
```bash
javac -d out src/prototipo/kiosco/*.java
java -cp out prototipo.kiosco.VentanaPrincipalEncargado
```
