package controllers;

import models.PreisModel;
import models.VerkaeuferModel;
import play.mvc.Controller;
import play.mvc.Result;
import models.BieteAnzeigeModel;
import views.html.biete;

import java.math.BigDecimal;

public class BieteAnzeige extends Controller {

    public static Result index() {

        BieteAnzeigeModel model = createBieteAnzeigeModel();

        return ok(biete.render(model));
    }

    // http://stackoverflow.com/questions/16135716/how-to-use-intellij-with-play-framework-and-scala

    private static BieteAnzeigeModel createBieteAnzeigeModel() {
        BieteAnzeigeModel m = new BieteAnzeigeModel();
        m.gehackt = createPreisModel("gehackt", "15", "22");
        m.ungehackt = createPreisModel("ungehackt","10", "16");
        m.verkaeufer = createVerkaeuferModel("Julian", "julian.lettner@gmail.com", 4);
        return m;
    }

    private static PreisModel createPreisModel(String typ, String preisAbLager, String preisFreiKunde) {
        PreisModel m = new PreisModel();
        m.typ = typ;
        m.preisAbLager = new BigDecimal(preisAbLager);
        m.presFreiKunde = new BigDecimal(preisFreiKunde);
        return m;
    }

    private static VerkaeuferModel createVerkaeuferModel(String nuterzname, String kontakt, int bewertung) {
        VerkaeuferModel m = new VerkaeuferModel();
        m.nutzername = nuterzname;
        m.kontakt = kontakt;
        m.bewertung = bewertung; // 4 of 5 stars
        return m;
    }

}
