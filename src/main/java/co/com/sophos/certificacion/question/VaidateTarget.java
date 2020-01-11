package co.com.sophos.certificacion.question;

import co.com.sophos.certificacion.useerinterface.BuscarProductoPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class VaidateTarget implements Question<Boolean> {

    private String descripcion;
    Target target;

    public VaidateTarget(String descripcion, Target target){
        this.descripcion = descripcion;
        this.target=target;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
            return Text.of(target).viewedBy(actor).asString().equals(descripcion);
    }

    public static VaidateTarget attach(String descripcion,Target target) {
        return new VaidateTarget(descripcion,target);
    }
}
