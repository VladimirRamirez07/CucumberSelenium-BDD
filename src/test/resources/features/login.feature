Feature: Login en SauceDemo
  Como usuario registrado
  Quiero iniciar sesión en la aplicación
  Para acceder a los productos

  Background:
    Given el usuario está en la página de login

  Scenario: Login exitoso con credenciales válidas
    When el usuario ingresa el usuario "standard_user"
    And el usuario ingresa la contraseña "secret_sauce"
    And el usuario hace click en el botón login
    Then el usuario debe ver la página de productos

  Scenario: Login fallido con contraseña incorrecta
    When el usuario ingresa el usuario "standard_user"
    And el usuario ingresa la contraseña "wrong_password"
    And el usuario hace click en el botón login
    Then el usuario debe ver el mensaje de error "Epic sadface: Username and password do not match any user in this service"

  Scenario: Login fallido con usuario bloqueado
    When el usuario ingresa el usuario "locked_out_user"
    And el usuario ingresa la contraseña "secret_sauce"
    And el usuario hace click en el botón login
    Then el usuario debe ver el mensaje de error "Epic sadface: Sorry, this user has been locked out."