// Product class representing the final SQL query
public class SQLQuery {
    private final String sql;

    public SQLQuery(String sql) {
        this.sql = sql;
    }

    public String getSql() {
        return sql;
    }

    @Override
    public String toString() {
        return sql;
    }
}
