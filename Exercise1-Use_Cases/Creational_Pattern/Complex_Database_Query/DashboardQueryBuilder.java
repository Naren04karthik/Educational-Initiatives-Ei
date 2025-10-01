// Concrete Builder for building optimized real-time dashboard queries
public class DashboardQueryBuilder extends SQLQueryBuilder {

    @Override
    public SQLQueryBuilder selectTables() {
        // select only specific columns for dashboard
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
        // add INNER JOINs for optimized dashboard performance
        if (spec.tables == null || spec.tables.isEmpty()) return this;
        query.append("FROM ").append(spec.tables.get(0)).append(" ");
        for (int i = 1; i < spec.tables.size(); i++) {
            query.append("INNER JOIN ").append(spec.tables.get(i))
                 .append(" ON ").append(spec.tables.get(0)).append(".id = ")
                 .append(spec.tables.get(i)).append(".id ");
        }
        return this;
    }

    @Override
    public SQLQueryBuilder setFilters() {
        // add WHERE clauses for dashboard
        if (spec.dateFrom != null && spec.dateTo != null) {
            query.append("WHERE date BETWEEN '").append(spec.dateFrom)
                 .append("' AND '").append(spec.dateTo).append("' ");
        }
        return this;
    }

    @Override
    public SQLQueryBuilder addGrouping() {
        // optional GROUP BY for dashboard
        if (spec.groupBy != null && !spec.groupBy.isEmpty()) {
            query.append("GROUP BY ").append(String.join(", ", spec.groupBy)).append(" ");
        }
        return this;
    }

    @Override
    public SQLQueryBuilder setAggregations() { return this; }

    @Override
    public SQLQueryBuilder addSorting() {
        if (spec.orderBy != null) query.append("ORDER BY ").append(spec.orderBy).append(" ");
        return this;
    }

    @Override
    public SQLQueryBuilder setLimitOffset() {
        if (spec.limit == null) spec.limit = 50; // default limit for dashboards
        query.append("LIMIT ").append(spec.limit).append(" ");
        return this;
    }

    @Override
    public SQLQuery build() {
        return new SQLQuery(query.toString().trim());
    }
}
