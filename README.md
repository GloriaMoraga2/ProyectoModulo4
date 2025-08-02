# Proyecto Módulo 4 - Automatización de Pruebas con Selenium

Este proyecto es una **suite de automatización** desarrollada para practicar y validar el flujo de registro de usuario e inicio de sesión en el sitio web 
[Magento Testing Board](https://magento.softwaretestingboard.com/).

La suite automatiza escenarios positivos y negativos, incluyendo:
- Creación de cuenta con datos válidos.
- Validación de campos requeridos vacíos.
- Inicio de sesión con credenciales inválidas.
- Inicio de sesión con credenciales válidas.

---
Si  ejecutan  la prueba de registro de usuario  dos veces se sugiere realizar cambio de email 
## 🛠 Tecnologías utilizadas
- **Java 17**
- **Maven**
- **JUnit 5 / JUnit Platform**
- **Selenium WebDriver**
- **Cucumber (BDD)**
- **Allure Report**
- **WebDriverManager**

---

## Escenarios Implementados

### **Registro de nuevo usuario**
- Registro exitoso con datos válidos.
- Validación de mensajes de error para campos obligatorios vacíos.

### **Login**
- Inicio de sesión exitoso con credenciales correctas.
- Mensaje de error para credenciales incorrectas.

---

## Reporte generado
Incluye:
- Resumen de ejecución.
- Escenarios pasados y fallidos.
- Evidencias gráficas.

---

## Lecciones Aprendidas
- Uso de WebDriverWait para evitar problemas de sincronización.
- Integración de Selenium con Cucumber siguiendo el enfoque **BDD**.
- Manejo de drivers de forma automática con **WebDriverManager**.
- Creación de reportes interactivos con **Allure**.
- Buenas prácticas en la organización de carpetas para proyectos de automatización.

---
##Sugerencias
Para ejecutar la prueba de registro de usuario se sugiere cambiar el Email, va con uno nuevo pero si se desea ejecutar nuevamente
se suguiere el cambio de este.

## Estructura del proyecto
ProyectoModulo4/
├── pom.xml
├── README.md
├── src
│ ├── test
│ │ ├── java
│ │ │ └── steps # Clases de definición de pasos (Selenium + Cucumber)
│ │ │ ├── World.java
│ │ │ ├── RegistroSteps.java
│ │ │ └── LoginSteps.java
│ │ └── resources
│ │ ├── feature # Archivos .feature con escenarios de prueba
│ │ │ ├── Registro.feature
│ │ │ └── Login.feature
└── allure-results/ # Carpeta generada tras la ejecución para reportes Allure

```bash
git clone https://github.com/GloriaMoraga2/ProyectoModulo4.git
cd ProyectoModulo4
mvn clean install

Ejecución de pruebas
mvn clean test

Generar y abrir reporte Allure
mvn allure:serve

