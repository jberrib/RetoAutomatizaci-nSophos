package co.com.sophos.certificacion.useerinterface;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class BuscarProductoPage {

    public static Target BTN_NO=Target.the("Clic en el boton no").located(By.xpath("//button[contains(text(),'No')]"));
    public static Target TXT_BUSCAR=Target.the("Ingresar el texto a buscar").located(By.xpath("//input[@id='search_box']"));
    public static Target LST_PRODUCTOS=Target.the("lista de productos").located(By.xpath("//div[@class='SuggestionItem__productName']//a[contains(text(),'')]"));
    public static Target BTN_VER_PRODUCTO=Target.the("lista de productos").located(By.xpath("//a[contains(text(),'Ver producto')]"));
    public static Target BTN_AGREGAR_CARRITO=Target.the("lista de productos").located(By.xpath("//a[@class='ProductCard__buttons__button']"));
    public static Target BTN_VER_CARRITO=Target.the("lista de productos").located(By.xpath("/html/body/div[3]/header/div[1]/section[3]/div/div[1]/div[1]"));
    public static Target PRODUCTO_AGREGADO_AL_CARRITO=Target.the("lista de productos").located(By.xpath("//div[@class='minicart__card is-un']"));
    public static Target TXT_PRODUCTO_AGREGADO_AL_CARRITO=Target.the("lista de productos").located(By.xpath("//a[@class='minicart__card__name']"));

}
