import java.util.Scanner;

import static java.lang.System.exit;

public class UserInterface {

    static Datenbank datenbank = new Datenbank();

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        datenbank.dummyDaten(20);
        UserInterface.menueVerity();
    }

    public static void menueVerity() {
        System.out.println("""
                - // - // - // - // - // - // - // - // - // - // - // -

                \t(1) Erstelle neues Auto
                \t(2) Rufe gesamten Autokorb auf
                \t(3) Lösche ein Auto aus dem Korb
                \t(4) Suche nach dem Attribut eines Autos
                \t(5) Sortieren nach Hersteller
                \t(6) Beenden

                - // - // - // - // - // - // - // - // - // - // - // -""");

        String userInput = sc.next().substring(0, 1);
        switch (userInput) {
            case "1":
                erstelleAuto();
            case "2":
                datenbank.alleAutos();
            case "3":
                toeteAuto();
            case "4":
                sucheAuto();
            case "5":
                datenbank.sortHerstellerCars();
            case "6":
                endIt();
            default:
                bad();
        }

    }

    public static void sucheAuto() {

        System.out.println("""

                - // - // - // - // - // - // - // - // - // - // - // -

                \t( ) Nach welchem Attribut suchen
                \t(1) Hersteller
                \t(2) Höchstgeschwindigkeit
                \t(3) Lieferbarkeit
                \t(4) Zurück zum Hauptmenü

                - // - // - // - // - // - // - // - // - // - // - // -""");

        String userInput = sc.next().substring(0, 1);
        switch (userInput) {
            case "1":
                herstellerSuche();
            case "2":
                hoechstGeschwindigkeitSuche();
            case "3":
                lieferbarSuche();
            case "4":
                zurueckHauptMenue();
            default:
                bado();
        }
    }

    public static void herstellerSuche() {
        System.out.println("Welcher Hersteller? (STRING[a, B, 1, 2, -, ,, ...])");
        String eingabeUser = sc.next();
        datenbank.sucheHersteller(eingabeUser);
        sucheAuto();
    }

    public static void hoechstGeschwindigkeitSuche() {
        System.out.println("Welche Höchstgeschwindigkeit? (INTEGER[1, 2, 3, ...])");
        int eingabeUser = sc.nextInt();
        datenbank.sucheHoechstGeschwindigkeit(eingabeUser);
        sucheAuto();
    }

    public static void lieferbarSuche() {
        System.out.println("Ist Lieferbar? (BOOLEAN[true/false])");
        boolean eingabeUser = sc.nextBoolean();
        datenbank.sucheLieferbar(eingabeUser);
        sucheAuto();
    }

    public static void zurueckHauptMenue() {
        menueVerity();
    }


    // weist auf eine Falscheingabe im Attribut-Menu hin
    public static void bado() {
        System.out.println("\nFalsche Eingabe!\n");
        UserInterface.sucheAuto();
    }


    // löscht den Datensatz eines Autos, abhängig der eingegebenen ID - zum Verstehen siehe (datenbank.entferneAuto(id))
    public static void toeteAuto() {
        System.out.println("\nId des zu löschenden Autos eingeben!\n");
        int id = sc.nextInt();
        datenbank.entferneAuto(id);
        menueVerity();
    }


    // beginnt die Abfrage für den User, welches Auto erstellt werden soll - die ID wird automatisch vergeben (siehe datenbank.alleAutos())
    public static void erstelleAuto() {
        System.out.println("Hersteller eingeben!");
        String hersteller = sc.next();
        System.out.println("Höchstgeschwindigkeit in natürlicher Zahl eingeben!");
        int hoechst = sc.nextInt();
        System.out.println("Ist das Auto lieferbar = (j)/(n)");
        String lieferbarString = sc.next().toLowerCase();
        boolean lieferbar = lieferbarString.equals("j");

        Auto auto = new Auto(hersteller, datenbank.autoZaehlen, hoechst, lieferbar);
        datenbank.createCars(auto);

        System.out.println("\nAngegebenes Auto erstellt!\n");
        menueVerity();
    }

    // beendet das Programm und verabschiedet sich freundlich
    public static void endIt() {
        System.out.println("\nDanke und Tschüssi!\n");
        sc.close();
        exit(0);
    }


    // weist auf eine Falscheingabe hin
    public static void bad() {
        System.out.println("\nFalsche Eingabe!\n");
        UserInterface.menueVerity();
    }
}