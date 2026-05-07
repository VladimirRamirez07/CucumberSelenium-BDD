Feature: Checkout en SauceDemo
  Como usuario autenticado
  Quiero completar el proceso de compra
  Para finalizar mi pedido

  Background:
    Given el usuario está logueado en la aplicación
    And el usuario tiene productos en el carrito

  Scenario: Completar checkout exitosamente
    When el usuario abre el carrito
    And el usuario hace click en Checkout
    And el usuario ingresa su nombre "John"
    And el usuario ingresa su apellido "Doe"
    And el usuario ingresa su código postal "12345"
    And el usuario hace click en Continue
    And el usuario hace click en Finish
    Then el usuario debe ver el mensaje "Thank you for your order!"

  Scenario: Checkout sin completar información personal
    When el usuario abre el carrito
    And el usuario hace click en Checkout
    And el usuario hace click en Continue
    Then el usuario debe ver el error de checkout "Error: First Name is required"