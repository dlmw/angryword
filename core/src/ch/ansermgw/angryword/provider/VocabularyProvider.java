package ch.ansermgw.angryword.provider;

import ch.ansermgw.angryword.activities.Play;
import ch.ansermgw.angryword.models.Language;
import ch.ansermgw.angryword.models.SemanticWord;
import ch.ansermgw.angryword.resource.VocabularyResource;
import ch.ansermgw.angryword.resource.WordResource;

import java.util.ArrayList;
import java.util.List;

public class VocabularyProvider {
    private static VocabularyProvider instance;
    private List<VocabularyResource> vocabularies;
    private List<Language> languages;

    private VocabularyProvider() {
        Language frenchLanguage = new Language("Français", "fr");
        Language englishLanguage = new Language("Anglais", "en");
        Language spanishLanguage = new Language("Espagnol", "es");
        languages.add(frenchLanguage);
        languages.add(englishLanguage);
        languages.add(spanishLanguage);

        vocabularies = new ArrayList<>();
        SemanticWord sw;
        VocabularyResource voc = new VocabularyResource("L'argent");

        try {
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la banque"); sw.addTranslation(englishLanguage,"the bank"); sw.addTranslation(spanishLanguage,"el Banco"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"l''argent liquide"); sw.addTranslation(englishLanguage,"cash"); sw.addTranslation(spanishLanguage,"efectivo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le paiement"); sw.addTranslation(englishLanguage,"payment"); sw.addTranslation(spanishLanguage,"pago"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un carnet de chèques"); sw.addTranslation(englishLanguage,"checkbook"); sw.addTranslation(spanishLanguage,"talonario de cheques"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"déposer de l''argent"); sw.addTranslation(englishLanguage,"to deposit money"); sw.addTranslation(spanishLanguage,"depositar dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"prêter de l''argent"); sw.addTranslation(englishLanguage,"to borrow money"); sw.addTranslation(spanishLanguage,"pedir dinero prestado"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"les services financiers"); sw.addTranslation(englishLanguage,"financial services"); sw.addTranslation(spanishLanguage,"servicios financieros"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la commission"); sw.addTranslation(englishLanguage,"commission"); sw.addTranslation(spanishLanguage,"comisión"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un investissement"); sw.addTranslation(englishLanguage,"an investment"); sw.addTranslation(spanishLanguage,"una inversión"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un virement"); sw.addTranslation(englishLanguage,"transfer"); sw.addTranslation(spanishLanguage,"transferir"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la gestion de l''argent"); sw.addTranslation(englishLanguage,"money management"); sw.addTranslation(spanishLanguage,"administración del dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une transaction"); sw.addTranslation(englishLanguage,"a transaction"); sw.addTranslation(spanishLanguage,"una transacción"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un guichet automatique"); sw.addTranslation(englishLanguage,"ATM machine"); sw.addTranslation(spanishLanguage,"cajero automático"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"attendre dans la queue"); sw.addTranslation(englishLanguage,"to wait in line"); sw.addTranslation(spanishLanguage,"a esperar en línea"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une carte bancaire"); sw.addTranslation(englishLanguage,"banking/ATM card"); sw.addTranslation(spanishLanguage,"tarjeta bancaria / ATM"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"faire des économies"); sw.addTranslation(englishLanguage,"to save money"); sw.addTranslation(spanishLanguage,"para ahorrar dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le montant"); sw.addTranslation(englishLanguage,"sum/total amount"); sw.addTranslation(spanishLanguage,"suma / monto total"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un compte-chèques"); sw.addTranslation(englishLanguage,"checking account"); sw.addTranslation(spanishLanguage,"cuenta de cheques"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"l''argent"); sw.addTranslation(englishLanguage,"money"); sw.addTranslation(spanishLanguage,"dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"les fonds"); sw.addTranslation(englishLanguage,"funds"); sw.addTranslation(spanishLanguage,"fondos"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un chèque"); sw.addTranslation(englishLanguage,"check"); sw.addTranslation(spanishLanguage,"cheque"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un dépôt"); sw.addTranslation(englishLanguage,"deposit"); sw.addTranslation(spanishLanguage,"depositar"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le crédit"); sw.addTranslation(englishLanguage,"credit"); sw.addTranslation(spanishLanguage,"crédito"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"les marchés financiers"); sw.addTranslation(englishLanguage,"financial markets"); sw.addTranslation(spanishLanguage,"mercados financieros"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la clientèle"); sw.addTranslation(englishLanguage,"clientele"); sw.addTranslation(spanishLanguage,"clientela"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"les frais"); sw.addTranslation(englishLanguage,"fees"); sw.addTranslation(spanishLanguage,"Tarifa"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une institution financière"); sw.addTranslation(englishLanguage,"financial institution"); sw.addTranslation(spanishLanguage,"institución financiera"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le taux d''intérêt"); sw.addTranslation(englishLanguage,"interest rate"); sw.addTranslation(spanishLanguage,"tasa de interés"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la monnaie"); sw.addTranslation(englishLanguage,"currency"); sw.addTranslation(spanishLanguage,"moneda"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le bilan"); sw.addTranslation(englishLanguage,"balance"); sw.addTranslation(spanishLanguage,"equilibrar"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"prendre un numéro"); sw.addTranslation(englishLanguage,"to take a number"); sw.addTranslation(spanishLanguage,"tomar un número"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une carte de crédit"); sw.addTranslation(englishLanguage,"credit card"); sw.addTranslation(spanishLanguage,"tarjeta de crédito"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un emprunt"); sw.addTranslation(englishLanguage,"a loan"); sw.addTranslation(spanishLanguage,"un préstamo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"retirer de l''argent"); sw.addTranslation(englishLanguage,"to take out money"); sw.addTranslation(spanishLanguage,"sacar dinero"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un compte d''épargne"); sw.addTranslation(englishLanguage,"savings account"); sw.addTranslation(spanishLanguage,"cuenta de ahorros"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un distributeur automatique"); sw.addTranslation(englishLanguage,"ATM machine"); sw.addTranslation(spanishLanguage,"cajero automático"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un reçu"); sw.addTranslation(englishLanguage,"receipt"); sw.addTranslation(spanishLanguage,"recibo"); voc.addSemanticWord(sw);
        } catch (Exception e) {

        }

        vocabularies.add(voc);

        voc = new VocabularyResource("Les meubles");

        try {
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une table"); sw.addTranslation(englishLanguage,"a table"); sw.addTranslation(spanishLanguage,"una mesa"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une chaise"); sw.addTranslation(englishLanguage,"a chair"); sw.addTranslation(spanishLanguage,"una silla"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une bibliothèque"); sw.addTranslation(englishLanguage,"a bookcase"); sw.addTranslation(spanishLanguage,"una estantería"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une table basse"); sw.addTranslation(englishLanguage,"a coffee table"); sw.addTranslation(spanishLanguage,"una mesa para cafe"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une cheminée"); sw.addTranslation(englishLanguage,"a fireplace"); sw.addTranslation(spanishLanguage,"una chimenea"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une table de chevet"); sw.addTranslation(englishLanguage,"a bedside table"); sw.addTranslation(spanishLanguage,"una mesita de noche"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une étagère"); sw.addTranslation(englishLanguage,"a shelf"); sw.addTranslation(spanishLanguage,"un estante"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une armoire"); sw.addTranslation(englishLanguage,"a wardrobe"); sw.addTranslation(spanishLanguage,"un armario"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une commode"); sw.addTranslation(englishLanguage,"a dresser"); sw.addTranslation(spanishLanguage,"un vestidor"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"une moquette"); sw.addTranslation(englishLanguage,"a carpet"); sw.addTranslation(spanishLanguage,"Una alfombra"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un siège"); sw.addTranslation(englishLanguage,"a seat"); sw.addTranslation(spanishLanguage,"un asiento"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un tabouret"); sw.addTranslation(englishLanguage,"a stool"); sw.addTranslation(spanishLanguage,"un taburete"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un placard"); sw.addTranslation(englishLanguage,"a cupboard"); sw.addTranslation(spanishLanguage,"un armario"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un tiroir"); sw.addTranslation(englishLanguage,"a drawer"); sw.addTranslation(spanishLanguage,"un cajon"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un fauteuil"); sw.addTranslation(englishLanguage,"a armchair"); sw.addTranslation(spanishLanguage,"un sillón"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un lit"); sw.addTranslation(englishLanguage,"a bed"); sw.addTranslation(spanishLanguage,"una cama"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un bureau"); sw.addTranslation(englishLanguage,"a desk"); sw.addTranslation(spanishLanguage,"un escritorio"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un miroir"); sw.addTranslation(englishLanguage,"a mrror"); sw.addTranslation(spanishLanguage,"un mrror"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un meuble"); sw.addTranslation(englishLanguage,"a piece of furniture"); sw.addTranslation(spanishLanguage,"un mueble"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"un oreiller"); sw.addTranslation(englishLanguage,"a pillow"); sw.addTranslation(spanishLanguage,"una almohada"); voc.addSemanticWord(sw);
        } catch (Exception e) {

        }
        vocabularies.add(voc);

        voc = new VocabularyResource("Les couleurs");

        try {
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"blanc"); sw.addTranslation(englishLanguage,"white"); sw.addTranslation(spanishLanguage,"blanco"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"bleu clair"); sw.addTranslation(englishLanguage,"light blue"); sw.addTranslation(spanishLanguage,"azul claro"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"multicolore"); sw.addTranslation(englishLanguage,"muli-colored"); sw.addTranslation(spanishLanguage,"multicolor"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"gris"); sw.addTranslation(englishLanguage,"grey"); sw.addTranslation(spanishLanguage,"gris"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"vert"); sw.addTranslation(englishLanguage,"green"); sw.addTranslation(spanishLanguage,"verde"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"noir"); sw.addTranslation(englishLanguage,"black"); sw.addTranslation(spanishLanguage,"negro"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"argenté"); sw.addTranslation(englishLanguage,"silver"); sw.addTranslation(spanishLanguage,"plata"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"jaune"); sw.addTranslation(englishLanguage,"yellow"); sw.addTranslation(spanishLanguage,"amarillo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"orange"); sw.addTranslation(englishLanguage,"orange"); sw.addTranslation(spanishLanguage,"naranja"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"bleu"); sw.addTranslation(englishLanguage,"blue"); sw.addTranslation(spanishLanguage,"azul"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"bleu foncé"); sw.addTranslation(englishLanguage,"dark blue"); sw.addTranslation(spanishLanguage,"azul oscuro"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"rose"); sw.addTranslation(englishLanguage,"pink"); sw.addTranslation(spanishLanguage,"rosado"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"rouge"); sw.addTranslation(englishLanguage,"red"); sw.addTranslation(spanishLanguage,"rojo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"marron"); sw.addTranslation(englishLanguage,"brown"); sw.addTranslation(spanishLanguage,"marrón"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"violet"); sw.addTranslation(englishLanguage,"purple"); sw.addTranslation(spanishLanguage,"púrpura"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"beige"); sw.addTranslation(englishLanguage,"beige"); sw.addTranslation(spanishLanguage,"beige"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"turquoise"); sw.addTranslation(englishLanguage,"turquoise"); sw.addTranslation(spanishLanguage,"turquesa"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"doré"); sw.addTranslation(englishLanguage,"golden"); sw.addTranslation(spanishLanguage,"dorado"); voc.addSemanticWord(sw);
        } catch (Exception e) {

        }
        vocabularies.add(voc);

        voc = new VocabularyResource("La famille");

        try {
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le père"); sw.addTranslation(englishLanguage,"the father"); sw.addTranslation(spanishLanguage,"el padre"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"les parents"); sw.addTranslation(englishLanguage,"the parents"); sw.addTranslation(spanishLanguage,"los padres"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la sœur"); sw.addTranslation(englishLanguage,"the sister"); sw.addTranslation(spanishLanguage,"la hermana"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la fille"); sw.addTranslation(englishLanguage,"the daughter"); sw.addTranslation(spanishLanguage,"la hija"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le bébé"); sw.addTranslation(englishLanguage,"the baby"); sw.addTranslation(spanishLanguage,"el bebé"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la femme"); sw.addTranslation(englishLanguage,"the wife"); sw.addTranslation(spanishLanguage,"La esposa"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la fiancée"); sw.addTranslation(englishLanguage,"the fiancée"); sw.addTranslation(spanishLanguage,"la prometida"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la grand-mère"); sw.addTranslation(englishLanguage,"the grandmother"); sw.addTranslation(spanishLanguage,"la abuela"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"les petits-enfants"); sw.addTranslation(englishLanguage,"the grandchildren"); sw.addTranslation(spanishLanguage,"los nietos"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la tante"); sw.addTranslation(englishLanguage,"the aunt"); sw.addTranslation(spanishLanguage,"la tía"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la nièce"); sw.addTranslation(englishLanguage,"the niece"); sw.addTranslation(spanishLanguage,"la sobrina"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la belle-mère"); sw.addTranslation(englishLanguage,"the step mother"); sw.addTranslation(spanishLanguage,"La Madrastra"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la cousine"); sw.addTranslation(englishLanguage,"the cousin (female)"); sw.addTranslation(spanishLanguage,"la prima (mujer)"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la belle-sœur"); sw.addTranslation(englishLanguage,"sister in-law"); sw.addTranslation(spanishLanguage,"cuñada"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"la mère"); sw.addTranslation(englishLanguage,"the mother"); sw.addTranslation(spanishLanguage,"La madre"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le frère"); sw.addTranslation(englishLanguage,"the brother"); sw.addTranslation(spanishLanguage,"el hermano"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le fils"); sw.addTranslation(englishLanguage,"the son"); sw.addTranslation(spanishLanguage,"el hijo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"l’enfant"); sw.addTranslation(englishLanguage,"the child"); sw.addTranslation(spanishLanguage,"el niño"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le mari"); sw.addTranslation(englishLanguage,"the husband"); sw.addTranslation(spanishLanguage,"el esposo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le fiancé"); sw.addTranslation(englishLanguage,"the fiancé"); sw.addTranslation(spanishLanguage,"el prometido"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le grand-père"); sw.addTranslation(englishLanguage,"the grandfather"); sw.addTranslation(spanishLanguage,"el abuelo"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"les grand-parents"); sw.addTranslation(englishLanguage,"the grandparents"); sw.addTranslation(spanishLanguage,"los abuelos"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"l’oncle"); sw.addTranslation(englishLanguage,"the uncle"); sw.addTranslation(spanishLanguage,"el tío"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le neveu"); sw.addTranslation(englishLanguage,"the nephew"); sw.addTranslation(spanishLanguage,"el sobrino"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le beau-père"); sw.addTranslation(englishLanguage,"the step father"); sw.addTranslation(spanishLanguage,"el padrastro"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le cousin"); sw.addTranslation(englishLanguage,"the cousin (male)"); sw.addTranslation(spanishLanguage,"el primo (hombre)"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le beau-frère"); sw.addTranslation(englishLanguage,"brother in-law"); sw.addTranslation(spanishLanguage,"cuñado"); voc.addSemanticWord(sw);
            sw = new SemanticWord(); sw.addTranslation(frenchLanguage,"le beau-père"); sw.addTranslation(englishLanguage,"father in-law"); sw.addTranslation(spanishLanguage,"suegro"); voc.addSemanticWord(sw);
        } catch (Exception e) {

        }
        vocabularies.add(voc);
    }

    public static VocabularyProvider getInstance() {
        if (instance == null)
            VocabularyProvider.instance = new VocabularyProvider();

        return instance;
    }

    public VocabularyResource getRandomVocabulary() {
        return vocabularies.get(Play.rand.nextInt(vocabularies.size()));
    }
}
