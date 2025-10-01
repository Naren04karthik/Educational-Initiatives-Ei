// Concrete Builder for building large dataset export queries with pagination
public class ExportQueryBuilder extends SQLQueryBuilder {

    @Override
    public SQLQueryBuilder selectTables() {
        query.append("SELECT ");
        if (spec.selectColumns != null && !spec.selectColumns.isEmpty()) {
            query.append(String.join(", ", spec.selectColumns));
        } else {
            query.append("*");
        }
        query.append(" ");
        return this;
    }

    @Override
    public SQLQueryBuilder addJoins() {
        // LEFT JOINs for export data combining
        if (spec.tables == null || spec.tables.isEmpty()) return this;
        query.append("FROM ").append(spec.tables.get(0)).append(" ");
        for (int i = 1; i < spec.tables.size(); i++) {
            query.append("LEFT JOIN ").append(spec.tables.get(i))
                 .append(" ON ").append(spec.tables.get(0)).append(".id = ")
                 .append(spec.tables.get(i)).append(".id ");
        }
        return this;
    }

    @Override
    public SQLQueryBuilder setFilters() {
        // optional status filter
        if (spec.status != null) {
            query.append("WHERE status = '").append(spec.status).append("' ");
        }
        return this;
    }

    @Override
    public SQLQueryBuilder addGrouping() { return this; }

    @Override
    public SQLQueryBuilder setAggregations() { return this; }

    @Override
    public SQLQueryBuilder addSorting() {
        if (spec.orderBy != null) query.append("ORDER BY ").append(spec.orderBy).append(" ");
        return this;
    }

    @Override
    public SQLQueryBuilder setLimitOffset() {
        if (spec.limit != null) query.append("LIMIT ").append(spec.limit).append(" ");
        if (spec.offset != null) query.append("OFFSET ").append(spec.offset).append(" ");
        return this;
    }

    @Override
    public SQLQuery build() {
        return new SQLQuery(query.toString().trim());
    }
}
