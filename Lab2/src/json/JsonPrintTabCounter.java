package json;

public class JsonPrintTabCounter {

    public static int tab_counter = 0;

    public static int increase() {
        return tab_counter++;
    }

    public static int decrease() {
        return tab_counter--;
    }

    public static String tab() {
        return "    ".repeat(tab_counter);
    }

}
