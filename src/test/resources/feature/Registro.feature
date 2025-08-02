Feature: Registro de nuevo usuario

  Scenario: Crear cuenta con datos validos
    Given Navego a la pagina de "customer/account/create"
    When Completar formulario de login con el nombre "Gloria" apellido "Moraga" correo "moragagloria@gmail.com" pass "Isitomi2015#" confirpass "Isitomi2015#"
    Then Verifico que el mensaje de bienvenida sea "Welcome, Gloria Moraga!"


    Scenario: Validar campos requeridos vacios
      Given Navego a la pagina de "customer/account/create"
      When Dejar todos los campos de registro vacio
      Then Verifico que el mensaje de advertencia sea "This is a required field."