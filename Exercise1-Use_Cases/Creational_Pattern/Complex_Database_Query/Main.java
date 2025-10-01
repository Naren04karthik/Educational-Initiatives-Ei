// Main console application for user interaction and query building
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Choose mode: 1) Report  2) Dashboard  3) Export");
        int mode = Integer.parseInt(sc.nextLine().trim());

        QuerySpec spec = new QuerySpec();

        System.out.println("Enter base tables (comma separated):");
        spec.tables = Arrays.asList(sc.nextLine().split(","));

        System.out.println("Enter dateFrom (YYYY-MM-DD) or blank:");
        String df = sc.nextLine().trim();
        spec.dateFrom = df.isEmpty() ? null : df;

        System.out.println("Enter dateTo (YYYY-MM-DD) or blank:");
        String dt = sc.nextLine().trim();
        spec.dateTo = dt.isEmpty() ? null : dt;

        System.out.println("Enter status filter or blank:");
        String st = sc.nextLine().trim();
        spec.status = st.isEmpty() ? null : st;

        System.out.println("Enter group by columns (comma separated) or blank:");
        String gb = sc.nextLine().trim();
        spec.groupBy = gb.isEmpty() ? null : Arrays.asList(gb.split(","));

        System.out.println("Enter aggregations (comma separated) or blank:");
        String ag = sc.nextLine().trim();
        spec.aggregations = ag.isEmpty() ? null : Arrays.asList(ag.split(","));

        System.out.println("Enter order by column or blank:");
        String ob = sc.nextLine().trim();
        spec.orderBy = ob.isEmpty() ? null : ob;

        System.out.println("Enter select columns (comma separated) or blank:");
        String sel = sc.nextLine().trim();
        spec.selectColumns = sel.isEmpty() ? null : Arrays.asList(sel.split(","));

        System.out.println("Enter limit or blank:");
        String lim = sc.nextLine().trim();
        spec.limit = lim.isEmpty() ? null : Integer.parseInt(lim);

        System.out.println("Enter offset or blank:");
        String off = sc.nextLine().trim();
        spec.offset = off.isEmpty() ? null : Integer.parseInt(off);

        SQLQueryBuilder builder;
        switch (mode) {
            case 1: builder = new ReportQueryBuilder(); break;
            case 2: builder = new DashboardQueryBuilder(); break;
            case 3: builder = new ExportQueryBuilder(); break;
            default: builder = new ReportQueryBuilder();
        }

        QueryOrchestrator orchestrator = new QueryOrchestrator(builder);
        SQLQuery query = orchestrator.constructQuery(spec);

        System.out.println("\nGenerated SQL:");
        System.out.println(query.getSql());

        sc.close();
    }
}
