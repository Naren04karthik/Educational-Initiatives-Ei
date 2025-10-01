// Model class representing user input specifications for the query
import java.util.List;

public class QuerySpec {
    public List<String> tables;         // tables to query
    public String dateFrom;             // start date filter
    public String dateTo;               // end date filter
    public String status;               // optional status filter
    public List<String> groupBy;        // columns for GROUP BY
    public List<String> aggregations;   // columns/functions for SELECT
    public List<String> selectColumns;  // specific columns for SELECT
    public String orderBy;              // ORDER BY column
    public Integer limit;               // LIMIT clause
    public Integer offset;              // OFFSET clause
}
