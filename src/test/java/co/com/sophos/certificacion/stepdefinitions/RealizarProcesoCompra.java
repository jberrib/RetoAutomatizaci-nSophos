package co.com.sophos.certificacion.stepdefinitions;

import co.com.sophos.certificacion.GeneralStepDefinitions;
import co.com.sophos.certificacion.question.VaidateTarget;
import co.com.sophos.certificacion.tasks.BuscarProducto;
import co.com.sophos.certificacion.useerinterface.BuscarProductoPage;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.util.List;
import java.util.Map;

import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;

public class RealizarProcesoCompra extends GeneralStepDefinitions {

    @Given("^Despues de encontrarme en la pagina de plazavea$")
    public void despuesDeEncontrarmeEnLaPaginaDePlazavea() {
        setUp();
    }

    @When("^procedo a buscar el producto y lo agrego al carrito de compras$")
    public void procedoABuscarElProductoYLoAgregoAlCarritoDeCompras(List<Map<String,String>> listaDatos) {
        theActorInTheSpotlight().wasAbleTo(BuscarProducto.conLaSigueiente(listaDatos.get(0).get("Producto")));
    }

    @Then("^se visualiza que fue agregado exitosamente$")
    public void seVisualizaQueFueAgregadoExitosamente() {
        theActorInTheSpotlight().should(seeThat(VaidateTarget.attach(theActorInTheSpotlight().recall("NombreProducto"), BuscarProductoPage.TXT_PRODUCTO_AGREGADO_AL_CARRITO)));
    }
}
