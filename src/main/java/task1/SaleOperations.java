package task1;

import java.util.Optional;

/**
 * Class to present sale operations.
 */
public class SaleOperations {
    //According to the job, an array is used.
    // But it's better to implement the implementation using the list.
    private SaleOperation[] arraySales;

    /**
     * Factory method.
     * @param arraySales
     */
    private SaleOperations(SaleOperation[] arraySales) {
        this.arraySales = arraySales;
    }

    public static SaleOperations creat(SaleOperation[] arraySales) throws IncorrectParamInput {
        Optional.ofNullable(arraySales).orElseThrow(IncorrectParamInput::new);
        return new SaleOperations(arraySales);
    }


    public String[] printInfrom() {
        int N = FishType.values().length;
        String[] reports = new String[N];

        for (int i = 0; i < N; i++) {
            double sum = 0;
            for (int j = 0; j < arraySales.length; j++) {
                if (FishType.values()[i] == arraySales[j].getFishName()){
                    sum+=arraySales[i].countIncome();
                }
            }
            reports[i]=FishType.values()[i].name()+" "+" income "+sum +"$";
        }
        return reports;



    }
}
