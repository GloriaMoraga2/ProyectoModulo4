Feature: Login

  Background: Precondicion
    Given Navego a la pagina de "customer/account/login"

    Scenario: Credencial inconrrecta
      When Completar formulario de login con el username "izidora@gmail.com" y el password "123456789"
      Then Verifico que el mensaje de error sea "The account sign-in was incorrect or your account is disabled temporarily. Please wait and try again later."


    Scenario: Verificar la UI
      Then Verifico la UI de la pagina de login

      Scenario: Login Exitoso
        Given Completar formulario de login con el username "izidora@gmail.com" y el password "Isitomi2015#"
        Then Verifico la UI de la pagina de login Exitoso




