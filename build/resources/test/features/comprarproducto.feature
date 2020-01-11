Feature: Realizar compra en la pagina metro

  Scenario: ingresar a la URL indicada
    Given Despues de encontrarme en la pagina de plazavea
    When procedo a buscar el producto y lo agrego al carrito de compras
    |Producto|
    |   Recirculador AIR MONSTER 15880     |
    Then se visualiza que fue agregado exitosamente
