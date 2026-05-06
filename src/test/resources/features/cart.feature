Feature: Carrito de compras en SauceDemo
  Como usuario autenticado
  Quiero agregar productos al carrito
  Para poder realizar una compra

  Background:
    Given el usuario está logueado en la aplicación

  Scenario: Agregar un producto al carrito
    When el usuario agrega el producto "Sauce Labs Backpack" al carrito
    Then el carrito debe mostrar 1 producto

  Scenario: Remover un producto del carrito
    When el usuario agrega el producto "Sauce Labs Backpack" al carrito
    And el usuario remueve el producto "Sauce Labs Backpack" del carrito
    Then el carrito debe estar vacío

  Scenario: Verificar precio del producto en el carrito
    When el usuario agrega el producto "Sauce Labs Backpack" al carrito
    And el usuario abre el carrito
    Then el precio del producto debe ser "$29.99"