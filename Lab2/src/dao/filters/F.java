package dao.filters;

public class F {

    public static IntEqual E(String field_name, int right) { return new IntEqual(field_name, right); }
    public static StringEqual E(String field_name, String right) { return new StringEqual(field_name, right); }

    public static IntGreater G(String field_name, int right) { return new IntGreater(field_name, right); }
    public static IntLess L(String field_name, int right) { return new IntLess(field_name, right); }

    public static And And(Filter first, Filter second) { return new And(first, second); }
    public static Or Or(Filter first, Filter second) { return new Or(first, second); }

    public static StringLike Like(String field_name, String right) { return new StringLike(field_name, right); }


}
