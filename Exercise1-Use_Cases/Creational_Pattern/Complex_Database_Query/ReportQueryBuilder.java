// Concrete Builder for building complex analytical report queries
public class ReportQueryBuilder extends SQLQueryBuilder {

    @Override
    public SQLQueryBuilder selectTables() {
        // select columns or aggregations for report
        query.append("SELECT ");
        if (spec.aggregations != null && !spec.aggregations.isEmpty()) {
            query.append(String.join(", ", spec.aggregations));
        } else {
            query.append("*");
        }
        query.append(" ");
        return this;
    }

    @Override
    public SQLQueryBuilder addJoins() {
        // add LEFT JOINs for combining multiple tables in report
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
        // add WHERE clauses for date and status
        boolean first = true;
        if (spec.dateFrom != null && spec.dateTo != null) {
            query.append("WHERE date BETWEEN '").append(spec.dateFrom)
                 .append("' AND '").append(spec.dateTo).append("' ");
            first = false;
        }
        if (spec.status != null) {
            if (first) query.append("WHERE ");
            else query.append("AND ");
            query.append("status = '").append(spec.status).append("' ");
        }
        return this;
    }

    @Override
    public SQLQueryBuilder addGrouping() {
        // add GROUP BY clause
        if (spec.groupBy != null && !spec.groupBy.isEmpty()) {
            query.append("GROUP BY ").append(String.join(", ", spec.groupBy)).append(" ");
        }
        return this;
    }

    @Override
    public SQLQueryBuilder setAggregations() {
        // handled in SELECT clause, no action needed here
        return this;
    }

    @Override
    public SQLQueryBuilder addSorting() {
        // add ORDER BY clause
        if (spec.orderBy != null) {
            query.append("ORDER BY ").append(spec.orderBy).append(" ");
        }
        return this;
    }

    @Override
    public SQLQueryBuilder setLimitOffset() {
        // add LIMIT and OFFSET for pagination
        if (spec.limit != null) query.append("LIMIT ").append(spec.limit).append(" ");
        if (spec.offset != null) query.append("OFFSET ").append(spec.offset).append(" ");
        return this;
    }

    @Override
    public SQLQuery build() {
        // return final SQLQuery product
        return new SQLQuery(query.toString().trim());
    }
}
