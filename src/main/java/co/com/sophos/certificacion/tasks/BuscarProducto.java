package co.com.sophos.certificacion.tasks;

import co.com.sophos.certificacion.useerinterface.BuscarProductoPage;
import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.Tasks;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;

import java.util.List;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class BuscarProducto implements Task {

    private String descripcion;

    public BuscarProducto(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(BuscarProductoPage.BTN_NO, isVisible()),
                Click.on(BuscarProductoPage.BTN_NO),
                Enter.theValue(descripcion).into(BuscarProductoPage.TXT_BUSCAR));
        escogerProducto(actor);
        actor.attemptsTo(WaitUntil.the(BuscarProductoPage.BTN_AGREGAR_CARRITO, isVisible()),
                Click.on(BuscarProductoPage.BTN_AGREGAR_CARRITO),
                Click.on(BuscarProductoPage.BTN_VER_CARRITO));

    }

    public <T extends Actor> void escogerProducto(T actor) {
        List<WebElementFacade> listaProductos= BuscarProductoPage.LST_PRODUCTOS.resolveAllFor(actor);
        for (WebElementFacade productos: listaProductos) {
            actor.remember("NombreProducto",productos.getText());
            if(productos.getText().equals(descripcion)){
                actor.attemptsTo(Click.on(BuscarProductoPage.BTN_VER_PRODUCTO));
                break;
            }
        }
    }

    public static BuscarProducto conLaSigueiente(String descripcion){
        return Tasks.instrumented(BuscarProducto.class,descripcion);
    }
}
