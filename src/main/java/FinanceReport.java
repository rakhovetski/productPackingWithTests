public class FinanceReport {
    private Payment[] reports;
    public FinanceReport(int n){

        reports = new Payment[n];
    }
    public Payment getReports(int i){
        return reports[i];
    }
    public void setReports(Payment reports, int i){

        this.reports[i] = reports;
    }
    public int sizeOfPayments(){

        return reports.length;
    }
    public Payment[] getReports(){

        return reports;
    }

    @Override
    public String toString() {
        StringBuilder n = new StringBuilder();
        String t = "Плательщик: %s, дата: %d.%d.%d сумма: %f.";
        String t_last = "Плательщик: %s, дата: %d.%d.%d сумма: %f.";
        for(int i = 0; i < reports.length; i++){
            if(i == reports.length - 1){
                n.append(String.format(t_last, reports[i].getFullName(), reports[i].getPaymentDay(), reports[i].getPaymentMonth(), reports[i].getPaymentYear(), reports[i].getSumInPenny()));
            }
            else{
                n.append(String.format(t, reports[i].getFullName(), reports[i].getPaymentDay(), reports[i].getPaymentMonth(), reports[i].getPaymentYear(), reports[i].getSumInPenny()));
            }
        }
        return n.toString();
    }

    private Payment[] arrayCopy(Payment[] arr){
        if(arr == null){
            return null;
        }
        else
        {
            Payment[] newArr = new Payment[arr.length];
            System.arraycopy(arr, 0, newArr, 0, newArr.length);
            return newArr;
        }
    }
}
