// Abstract Builder used as base for different SQL query builders
public abstract class SQLQueryBuilder {
    protected StringBuilder query = new StringBuilder(); // stores SQL during building
    protected QuerySpec spec; // user input for building SQL

    // Assign user specifications to builder
    public SQLQueryBuilder withSpec(QuerySpec spec) {
        this.spec = spec;
        this.query = new StringBuilder();
        return this;
    }

    public abstract SQLQueryBuilder selectTables();    // defines SELECT clause
    public abstract SQLQueryBuilder addJoins();        // defines JOINs
    public abstract SQLQueryBuilder setFilters();      // defines WHERE filters
    public abstract SQLQueryBuilder addGrouping();     // defines GROUP BY
    public abstract SQLQueryBuilder setAggregations(); // defines aggregations
    public abstract SQLQueryBuilder addSorting();      // defines ORDER BY
    public abstract SQLQueryBuilder setLimitOffset();  // defines LIMIT/OFFSET

    public abstract SQLQuery build();                  // returns final SQLQuery product
}
