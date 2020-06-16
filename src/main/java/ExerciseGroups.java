import java.util.ArrayList;
import java.util.Arrays;

public class ExerciseGroups {
    private final static String METEO_STRING = "Poniedzialek;15C wiatr wschod mocny\n" +
            "Wtorek}16C wiatr zachod mocny\n" +
            "Sroda[15C wiatr brak brak\n" +
            "Czwartek!9C wiatr polnoc sredni\n";

    private final static String[] TAXI_STRINGS = {"Poprosze taksowke na Dworzec",
            "Taksowka pod Galerie szybko",
            "Gdzie ta taksowka?Miala byc 30 minut temu na Sokolskiej",
            "Platnosc karta za 3 minuty w Supersamie dziekuje"};


    private final static String SOME_CODE = "private int i = 0;\n" +
            "public String abc = \"aaa\";\n" +
            "protected float mojaMetoda() {\n" +
            "\n" +
            "}\n" +
            "public double jakasZmienna = 2.3d;";


    public static void main(String[] args) {
        double averageTemperature = averageTemperature();
        System.out.println("AVG temp: " + averageTemperature);
        if (averageTemperature == 13.75) {
            System.out.println("Zadanie 1 zrobione");
        }

        String[] meteoHistory = meteoHistory();
        String[] expectedMeteoHistory = {"W Poniedzialek wiało mocny z wschod",
                "W Wtorek wiało mocny z zachod",
                "W Sroda wiało brak z brak",
                "W Czwartek wiało sredni z polnoc"};
        System.out.println("Meteo history: ");
        System.out.println(Arrays.toString(meteoHistory));
        if (Arrays.equals(expectedMeteoHistory, meteoHistory)) {
            System.out.println("Zadanie 2 zrobione");
        }

        String someCodePrivateScopes = someCodePrivateScopes();
        System.out.println("Private scopes");
        System.out.println(someCodePrivateScopes);

        String expectedCodePrivateScopes = "private int i = 0;\n" +
                "private String abc = \"aaa\";\n" +
                "private float mojaMetoda() {\n" +
                "\n" +
                "}\n" +
                "private double jakasZmienna = 2.3d;";

        if (someCodePrivateScopes.equals(expectedCodePrivateScopes)) {
            System.out.println("Zadanie 3 zrobione");
        }
        String someCodeFieldTypes = someCodeFieldTypes();
        String expectedSomeCodeFieldTypes =
                "private BigDecimal i = 0;\n" +
                        "public String abc = \"aaa\";\n" +
                        "protected float mojaMetoda() {\n" +
                        "\n" +
                        "}\n" +
                        "public BigDecimal jakasZmienna = 2.3d;";
        System.out.println("Field types");
        System.out.println(someCodeFieldTypes);
        if (expectedSomeCodeFieldTypes.equals(someCodeFieldTypes)) {
            System.out.println("Zadanie 4 zrobione");
        }

        String[] taxiOrder = taxiOrder();
        String[] expectedTaxiOrder = {"Zamowienie na Dworzec", "Zamowienie na Galerie", "Zamowienie na Sokolskiej", "Zamowienie na Supersamie"};
        if(Arrays.equals(taxiOrder, expectedTaxiOrder)) {
            System.out.println("Zadanie 5 zrobione");
        }
    }

    //1. simpleString przetwórz tak, aby wyliczyć średnią temperaturę
    public static double averageTemperature() {
        String[] days = METEO_STRING.split("[\n]");
        ArrayList<Integer> temperatures = new ArrayList<>();
        for (int i = 0; i < days.length; i++) {
            temperatures.add(Integer.parseInt(days[i].split("[\\W]")[1].substring(0,days[i].split("[\\W]")[1].length()-1)));
        }
        int temperaturesSum = 0;
        for (Integer temp:temperatures) {
            temperaturesSum += temp;
        }

        return (double)temperaturesSum/days.length;
    }

    //2. simpleString przetwórz tak, aby wyświetlić dla każdego rekordu "W <dzień tygodnia> wiało <siła wiatru> z <kierunek>"
    public static String[] meteoHistory() {
        String[] days = METEO_STRING.split("[\n]");

        String[] meteoHistory = new String[days.length];
        for (int i = 0; i < days.length; i++) {
            StringBuilder dayInfo = new StringBuilder();
            String[] temporaryInfo = days[i].split("[\\W]");
            dayInfo.append("W ");
            dayInfo.append(temporaryInfo[0]);
            dayInfo.append(" wiało ");
            dayInfo.append(temporaryInfo[temporaryInfo.length-1]);
            dayInfo.append(" z ");
            dayInfo.append(temporaryInfo[temporaryInfo.length-2]);
            meteoHistory[i] = dayInfo.toString();
        }
        return meteoHistory;
    }

    //3. W SOME_CODE zamień wszystkie zasięgi (metod i pol) na prywatny
    public static String someCodePrivateScopes() {
        String replacedPublic = SOME_CODE.replace("public","private");
        String replacedPublicAndProtected = replacedPublic.replace("protected","private");
        return replacedPublicAndProtected;
    }

    //4. W SOME_CODE Zamień typy wszystkich *pól* na BigDecimal
    public static String someCodeFieldTypes() {
        String noInt = SOME_CODE.replace("int","BigDecimal");
        String noIntNoDouble = noInt.replace("double","BigDecimal");
        return noIntNoDouble;
    }

    //5. TAXI_STRINGS przetwórz tak, żeby wypisać dla każdego elementu listy wiadomość według szablonu: „Zamowienie na <gdzie klient zamawial taksowke>”
    /*
    private final static String[] TAXI_STRINGS = {"Poprosze taksowke na Dworzec",
            "Taksowka pod Galerie szybko",
            "Gdzie ta taksowka?Miala byc 30 minut temu na Sokolskiej",
            "Platnosc karta za 3 minuty w Supersamie dziekuje"};
     */
    public static String[] taxiOrder() {
        String[] places = new String[TAXI_STRINGS.length];
        String[] taxiOrder = new String[TAXI_STRINGS.length];
        for (int i = 0; i < TAXI_STRINGS.length; i++) {
            String[] temp = TAXI_STRINGS[i].split(" ");
            for (int j = 1; j < temp.length; j++) {
                if (temp[j].matches("[A-Z].*")){
                    places[i] = temp[j];
                }
            }
            taxiOrder[i] = "Zamowienie na " + places[i];
        }
        return taxiOrder;
    }
}
