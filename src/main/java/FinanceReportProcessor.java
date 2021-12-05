public class FinanceReportProcessor
{
    public static FinanceReport nameStartsOnChar(FinanceReport reports, char a)
    {

        FinanceReport n = new FinanceReport(reports.sizeOfPayments());
        for(int i = 0; i<reports.sizeOfPayments(); i++)
        {
            int j = 0;
            if(Character.toLowerCase((char)reports.getReports(i).getFullName().charAt(0)) == Character.toLowerCase((char)a))
            {
                n.setReports(reports.getReports(i), j);
                j++;
            }
        }
        return n;

    }
    public static FinanceReport PaymentsSmallSize(FinanceReport reports, double a)
    {
        FinanceReport n = new FinanceReport(reports.sizeOfPayments());
        for(int i = 0; i<reports.sizeOfPayments(); i++)
        {
            if(Double.compare(a,reports.getReports(i).getSumInPenny()) > 0)
            {
                n.setReports(reports.getReports(i), i);
            }
        }
        return n;
    }
}
