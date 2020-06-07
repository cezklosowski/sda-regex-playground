import java.util.Arrays;
public class Exercise {
    private static final String testString1 = "Oceny Joli to: 5,5,5,5,2,3,6";
    private static final String[] fileNames = {"grafika.jpg", "koty.png", "MyCode.java", "smieszne-link.txt",
            "wydatki.csv", "MainMain.java", "test-10-10-2010.log", "logowanie-13-05-2010.log", "Student.java",
            "formatowanie.exe", "smieszne-linki-kot.png", "App-20-01-2020.log"};
    // Pomoc:
    // Do zamiany String na int uzyj metody Integer.parseInt(), np Integer.parseInt("1") zwroci 1
    public static void main(String[] args) {
        //to uruchamiamy, żeby sprawdzić poprawne wykonanie zadania, nic nie modyfikujemy w tym mainie:)
        int minGrade = gradeExerciseMin();
        System.out.println("Min grade: " + minGrade);
        if (minGrade == 2) {
            System.out.println("Zadanie 1 zrobione");
        }
        int maxGrade = gradeExerciseMax();
        System.out.println("Max grade: " + maxGrade);
        if (maxGrade == 6) {
            System.out.println("Zadanie 2 zrobione");
        }
        String[] javaFiles = findJavaFiles();
        String[] expectedJavaFiles = {"MyCode.java","MainMain.java"};
        System.out.println("Java files:");
        System.out.println(Arrays.toString(javaFiles));
        if (Arrays.equals(expectedJavaFiles, javaFiles)) {
            System.out.println("Zadanie 3 zrobione");
        }
        String[] expectedCatFiles = {"koty.png","smieszne-linki-kot.png"};
        String[] catFiles = findCatFiles();
        System.out.println("Cat files:");
        System.out.println(Arrays.toString(catFiles));
        if (Arrays.equals(catFiles, expectedCatFiles)) {
            System.out.println("Zadanie 4 zrobione");
        }
        int patternFiles = findPatternFiles();
        System.out.println("Pattern files: " + patternFiles);
        if (patternFiles == 3) {
            System.out.println("Zadanie 5 zrobione");
        }
    }
    //1. Znajdź najwyższą ocenę Joli
    public static int gradeExerciseMax() {
        //1. Najpierw wyekstraktuj z Stringa testString1 same liczby i przerzuc je do tablicy intow (osobnej)
        String[] split = testString1.replaceAll("\\D","").split("");
        int[] grades = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            grades[i] = Integer.parseInt(split[i]);
        }
        //2. Nastepnie znajdz najwyzsza ocene Math.max
        int max = grades[0];
        for (int i = 1; i < grades.length; i++) {
            max = Math.max(max,grades[i]);
        }
        //Podpowiedz: uzyj metody split
        return max;
    }
    //2. Znajdź najniższą ocenę Joli
    public static int gradeExerciseMin() {
        //1. Najpierw wyekstraktuj z Stringa testString1 same liczby i przerzuc je do tablicy intow (osobnej)
        String[] split = testString1.replaceAll("\\D","").split("");
        int[] grades = new int[split.length];
        for (int i = 0; i < split.length; i++) {
            grades[i] = Integer.parseInt(split[i]);
        }
        //2. Nastepnie znajdz najnizsza ocene
        int min = grades[0];
        for (int i = 1; i < grades.length; i++) {
            min = Math.min(min,grades[i]);
        }
        //Podpowiedz: uzyj metody split
        return min;//ta linijka jest tylko po to, żeby nie podkreslało
    }
    //3. Zwróć nazwy plików z rozszerzeniem .java, które zawieraja w sobie literę "M"
    /*
    fileNames = {"grafika.jpg", "koty.png", "MyCode.java", "smieszne-link.txt",
            "wydatki.csv", "MainMain.java", "test-10-10-2010.log", "logowanie-13-05-2010.log", "Student.java",
            "formatowanie.exe", "smieszne-linki-kot.png", "App-20-01-2020.log"};
     */
    public static String[] findJavaFiles() {
        //1. Utwórz nową tablicę javaFiles, która będzie mogła pomieścić maksymalnie tyle elementów ile ma tablica fileNames
        String[] javaFiles = new String[fileNames.length];
        //2. Sprawdzaj element po elemencie za pomocą pętli czy zadane wyrazenie regularne (lancuch konczy sie na .java i ma w srodku literę "M")
        int j = 0;
        for (int i = 0; i < fileNames.length; i++) {
            if(fileNames[i].matches(".*M.*\\.java")){
                javaFiles[j++]=fileNames[i];
            }
        }
        String[] javaFilesResult = new String[j];
        for (int i = 0; i < j; i++) {
            javaFilesResult[i] = javaFiles[i];
        }
        //3. Zwróć tablicę
        return javaFilesResult;//ta linijka jest tylko po to, żeby nie podkreslało
    }
    //4. Zwróć nazwy plików z rozszerzeniem .png, które zawierają słowo "kot"
    public static String[] findCatFiles() {
        //1. Utwórz nową tablicę javaFiles, która będzie mogła pomieścić maksymalnie tyle elementów ile ma tablica fileNames
        String[] javaFiles = new String[fileNames.length];
        //2. Sprawdzaj element po elemencie za pomocą pętli czy zadane wyrazenie regularne (lancuch konczy sie na .png i ma w srodku słowo "kot")
        int j = 0;
        for (int i = 0; i < fileNames.length; i++) {
            if(fileNames[i].matches(".*kot.*\\.png")){
                javaFiles[j++]=fileNames[i];
            }
        }
        String[] javaFilesResult = new String[j];
        for (int i = 0; i < j; i++) {
            javaFilesResult[i] = javaFiles[i];
        }
        //3. Zwróć tablicę
        return javaFilesResult;//ta linijka jest tylko po to, żeby nie podkreslało
    }
    //5. Zlicz nazwy plikow, ktorych nazwa spelnia szablon <jakiestamlitery><dzień>-<miesiąc>-<rok>.<dowolnerozszerzenie>
    public static int findPatternFiles() {
        //1. Utwórz nową zmienną licznik, która będzie służyła do przechowywania aktualnej ilości znalezionych plikow, które spełniają założenie zadania
        int counter = 0;
        //2. Sprawdzaj element po elemencie za pomocą pętli czy zadane wyrazenie regularne (lancuch spelnia: <jakiestamlitery><dzień>-<miesiąc>-<rok>.<dowolnerozszerzenie>)
        // np. "logowanie-13-05-2010.log"
        for (int i = 0; i < fileNames.length; i++) {
            if(fileNames[i].matches("\\D+\\-\\d{1,2}\\-\\d{1,2}\\-\\d{4}\\..+")){
                counter++;
            }
        }
        //3. Zwróć liczbe znalezionych plikow
        return counter;//ta linijka jest tylko po to, żeby nie podkreslało
    }
}