# Tarjetas de Usuario en Compose Multiplatform

### ¿Qué se ha hecho?
Se ha diseñado y replicado una interfaz gráfica compuesta por 3 tarjetas (`Card`) informativas verticales. Cada tarjeta presenta los datos de una persona: una fotografía/avatar con recorte circular y borde, su nombre en negrita, su puesto en texto secundario, una línea separadora horizontal (`HorizontalDivider`) y los datos de contacto (correo y ciudad).

### ¿Cómo se ha hecho?
- **Componente reutilizable (`Tarjeta`)**: Se implementó una función `@Composable Tarjeta(...)` que recibe como parámetros el nombre, puesto, correo, ciudad y la imagen (`DrawableResource`).
- **Recursos de imagen**: Se integraron imágenes individuales (`foto1`, `foto2`, `foto3`) en la carpeta `composeResources/drawable/`, utilizándolas dinámicamente mediante `painterResource(imagen)`.
- **Estructura visual**:
  - `Column` principal con scroll vertical (`verticalScroll`) y espaciado entre tarjetas.
  - `Card` con elevación y color de fondo.
  - `Row` alineado verticalmente al centro para contener la imagen y la columna de texto.
  - Modificadores `.clip(CircleShape)` y `.border(...)` para el estilo circular del avatar.
  - `HorizontalDivider` con espaciado vertical para estructurar el contenido.

### ¿Por qué de esta forma?
1. **Principio DRY (Don't Repeat Yourself)**: Parametrizar la imagen y los textos en el composable evita la duplicación de código y permite que cada tarjeta use una foto y datos propios de forma limpia.
2. **Modularidad y escalabilidad**: Si se requiere añadir más personas o cambiar el diseño visual, solo se modifica el componente `Tarjeta` en un único lugar sin afectar al resto de la aplicación.
3. **Buenas prácticas en Compose**: El uso de `DrawableResource` aprovecha el sistema oficial de recursos de Compose Multiplatform, garantizando compatibilidad multiplataforma y tipado seguro.
