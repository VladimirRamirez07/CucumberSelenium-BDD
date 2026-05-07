# 🥒 CucumberSelenium-BDD

![CI](https://github.com/VladimirRamirez07/CucumberSelenium-BDD/actions/workflows/ci.yml/badge.svg)
![Java](https://img.shields.io/badge/Java-11-orange)
![Selenium](https://img.shields.io/badge/Selenium-4.18.1-green)
![Cucumber](https://img.shields.io/badge/Cucumber-7.15.0-brightgreen)

## 📋 Descripción

Proyecto de automatización de pruebas BDD usando **Cucumber + Selenium WebDriver** en Java con el patrón **Page Object Model** y reportes HTML.

---

## 🛠️ Stack tecnológico

| Tecnología | Versión |
|---|---|
| Java | 11 |
| Selenium WebDriver | 4.18.1 |
| Cucumber | 7.15.0 |
| WebDriverManager | 5.7.0 |
| Maven | 3.9.x |

---

## 📁 Estructura del proyecto
CucumberSelenium-BDD/
```
src/test/java/
├── pages/
│   ├── BasePage.java
│   ├── LoginPage.java
│   ├── CartPage.java
│   └── CheckoutPage.java
├── steps/
│   ├── Hooks.java
│   ├── LoginSteps.java
│   ├── CartSteps.java
│   └── CheckoutSteps.java
└── runner/
    └── TestRunner.java

src/test/resources/
└── features/
    ├── login.feature
    ├── cart.feature
    └── checkout.feature
```

## 🧪 Escenarios de prueba

### 🔐 Login (3 escenarios)
- ✅ Login exitoso con credenciales válidas
- ✅ Login fallido con contraseña incorrecta
- ✅ Login fallido con usuario bloqueado

### 🛒 Carrito (3 escenarios)
- ✅ Agregar producto al carrito
- ✅ Remover producto del carrito
- ✅ Verificar precio del producto

### 💳 Checkout (2 escenarios)
- ✅ Completar checkout exitosamente
- ✅ Checkout sin completar información personal

---

## 🚀 Cómo ejecutar

```bash
# Clonar el repositorio
git clone https://github.com/VladimirRamirez07/CucumberSelenium-BDD.git

# Entrar a la carpeta
cd CucumberSelenium-BDD

# Abrir en VS Code
code .

# Ejecutar todos los tests
mvn test

# Ejecutar en modo headless (sin abrir el navegador)
mvn test -Dheadless=true
```

---

## 📊 Reportes

Los reportes HTML se generan automáticamente en:
target/cucumber-reports/cucumber.html
---

## ⚙️ CI/CD

El proyecto usa **GitHub Actions** para ejecutar los tests automáticamente en cada push a `main`.

El pipeline incluye:
- ☕ Configuración de Java 11
- 🌐 Instalación de Google Chrome
- 📦 Cache de dependencias Maven
- 🧪 Ejecución de tests en modo headless
- 📊 Publicación del reporte HTML como artefacto

---

## 👤 Autor

**Vladimir Ramirez**  
QA Automation Engineer  
[![GitHub](https://img.shields.io/badge/GitHub-VladimirRamirez07-black?logo=github)](https://github.com/VladimirRamirez07)