import java.util.Arrays;
import java.util.Random;

public class Datenbank {
    // Variablen welche die Farbe des Konsolen texts zuerst auf colorRed (rot) setzen und anschließend zurück zum Normalwert (weiß)
    private final String colorReset = "\u001B[0m";
    private final String colorRed = "\u001B[31m";
    private final Auto[] autoArray;
    public int autoZaehlen = 0;

    // Konstruktor Datenbank - limitiert auf 50 Indexes
    public Datenbank() {
        autoArray = new Auto[50];
    }

    public void sucheHersteller(String eingabeUser) {
        int information = 1;
        for (int i = 0; i < autoZaehlen; i++) {

            if (eingabeUser.equalsIgnoreCase(autoArray[i].getHersteller())) {
                System.out.println(autoArray[i].toString());
                information = 0;
            }
        }

        if (information == 1) {
            System.out.println(colorRed + "\nKein Auto mit angegebenem Attribut gefunden!\n" + colorReset);
        }
    }

    public void sucheHoechstGeschwindigkeit(int eingabeUser) {
        int information = 1;
        for (int i = 0; i < autoZaehlen; i++) {
            if (eingabeUser - 20 <= autoArray[i].getHoechstgeschwindigkeit() && eingabeUser + 20 >= autoArray[i].getHoechstgeschwindigkeit()) {
                System.out.println(autoArray[i].toString());
                information = 0;
            }

            if (i == autoZaehlen - 1) {
                System.out.println(colorRed + "\nAutos im Geschwindigkeitsbereich " + colorReset + (eingabeUser - 20) + " - " + (eingabeUser + 20) + colorRed + " werden angezeigt!\n" + colorReset);
            }
        }

        if (information == 1) {
            System.out.println(colorRed + "\nKein Auto mit angegebenem Attribut gefunden!\n" + colorReset);
        }
    }

    public void sucheLieferbar(boolean eingabeUser) {
        int information = 1;
        for (int i = 0; i < autoZaehlen; i++) {
            if (eingabeUser == autoArray[i].getLieferbar()) {
                System.out.println(autoArray[i].toString());
                information = 0;
            }
        }

        if (information == 1) {
            System.out.println(colorRed + "\nKein Auto mit angegebenem Attribut gefunden!\n" + colorReset);
        }
    }

    /*
     verbildlichung wie die Methode entferneAuto() funktioniert
     Auto 3 soll entfernt werden, wir zählen das Array eins nach unten und übergeben die aktuell ausgewählte Stelle (jetzt Index 6 mit einem vorhandenen Object),
     an die zu entfernende Stelle (Index 3) und überschreiben das dort vorhandene Object mit dem Object aus Index 6,
     anschließend wird die übergebene Stelle, also Index 6 mit null überschrieben und das nächste Object wird dort erstellt

            autoZaehlen = 7
            0 1 2 3 4 5 6 7 8 9
            a s r a g h j 0 0 0

            entferneAuto id 3

            autoZaehlen = 6
            0 1 2 3 4 5 6 7 8 9
            a s r j g h 0 0 0 0
     */
    public void entferneAuto(int id) {
        autoZaehlen--;
        autoArray[id] = autoArray[autoZaehlen];
        autoArray[autoZaehlen] = null;
    }

    // Erstellt ein neues Auto, beginnt beim 0 Index und springt nach der Erstellung zur nächsten Stelle
    public void createCars(Auto neuesAuto) {
        autoArray[autoZaehlen] = neuesAuto;
        autoZaehlen++;
    }

    // Printet die Hersteller aller vorhandenen Autos chronologisch nach dem Index
    public void alleAutos() {
        for (int i = 0; i < autoZaehlen; i++) {
            System.out.println(autoArray[i].toString());
        }
        UserInterface.menueVerity();
    }

    /*
    ursprungs Arrays.sort, die Version in sortHerstellerCars() wurde von IntelliJ optimiert
    der Methode wird das autoArray übergeben, sie zählt vom Index 0, bis wohin autoZaehlen geht, und vergleicht es anhand eines übergebenen Auto[]Objects
    es werden 2 Auto[]Objects übergeben und davon die Hersteller verglichen, sortiert und returned

            Arrays.sort(autoArray, 0, autoZaehlen, new Comparator<Auto>() {
                @Override
                public int compare(Auto o1, Auto o2) {
                    return o1.getHersteller().compareTo(o2.getHersteller());
                }
            });
    */
    public void sortHerstellerCars() {
        Arrays.sort(autoArray, 0, autoZaehlen, (poggi1, poggi2) -> poggi1.getHersteller().compareTo(poggi2.getHersteller()));
        System.out.println("\nAutos wurden nach Hersteller sortiert!\n");
        UserInterface.menueVerity();
    }

    // erstellt Random fertige komplette Datensätze für die Klasse Auto, welche der/dem Datenbank/Array hinzugefügt werden können
    public void dummyDaten(int menge) {
        String[] hersteller = new String[]{"BMW", "Audi", "VW", "Opel", "Dacia", "Subaru", "Suzuki"};
        Random rand = new Random();
        for (int i = 0; i < menge; i++) {
            int herstellerINT = rand.nextInt(hersteller.length);
            int hoechstgeschwindigkeit = rand.nextInt(50, 150);
            boolean lieferbar = rand.nextBoolean();
            autoArray[i] = new Auto(hersteller[herstellerINT], i, hoechstgeschwindigkeit, lieferbar);
            autoZaehlen++;
        }
    }
}