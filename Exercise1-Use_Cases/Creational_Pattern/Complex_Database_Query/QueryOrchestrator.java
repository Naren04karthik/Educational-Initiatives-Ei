// Director class used to orchestrate the building process step by step
public class QueryOrchestrator {
    private SQLQueryBuilder builder;

    public QueryOrchestrator(SQLQueryBuilder builder) {
        this.builder = builder;
    }

    // Constructs SQL query using builder according to QuerySpec
    public SQLQuery constructQuery(QuerySpec spec) {
        return builder.withSpec(spec)
                .selectTables()
                .addJoins()
                .setFilters()
                .setAggregations()
                .addGrouping()
                .addSorting()
                .setLimitOffset()
                .build();
    }
}
