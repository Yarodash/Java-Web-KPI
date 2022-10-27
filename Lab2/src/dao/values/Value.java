package dao.values;

public interface Value {

    public Object getValue();

    public void setDeclaredField(java.lang.reflect.Field f, Object obj) throws IllegalAccessException;

    public String toSQLData();

}
