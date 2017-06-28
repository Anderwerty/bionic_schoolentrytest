package task1;

import java.util.Date;
import java.util.Optional;

/**
 * Class for describing the processes of selling fish.
 */
public class SaleOperation {
    // some value that contains overheads
    public static final double CONST = 1;
    private FishType fishName;

    private Date dateOfPurchase;
    private double priceOfPurchase;

    private Date dateOfSale;
    private double priceOfSale;
    private double weight;

    /**
     * Constructor with parameters to verification that parameters are not null.
     * @param fishName
     * @param dateOfPurchase
     * @param priceOfPurchase
     * @param dateOfSale
     * @param priceOfSale
     * @param weight
     * @throws IncorrectParamInput
     * @see SaleOperation#init(FishType, Date, Date, double, double)
     */
    public SaleOperation(FishType fishName, Date dateOfPurchase,
                         double priceOfPurchase, Date dateOfSale,
                         double priceOfSale, double weight) throws IncorrectParamInput {
        this(init(fishName, dateOfPurchase, dateOfSale,priceOfSale,weight),
                fishName, dateOfPurchase, priceOfPurchase,
                dateOfSale, priceOfSale, weight);
    }

    /**
     *
     * Constructor with parameters to initialize class fields.
     * @param isCreat
     * @param fishName
     * @param dateOfPurchase
     * @param priceOfPurchase
     * @param dateOfSale
     * @param priceOfSale
     * @param weight
     */

    private SaleOperation(boolean isCreat, FishType fishName, Date dateOfPurchase,
                          double priceOfPurchase, Date dateOfSale,
                          double priceOfSale, double weight) {
        this.fishName = fishName;
        this.dateOfPurchase = dateOfPurchase;
        this.priceOfPurchase = priceOfPurchase;
        this.dateOfSale = dateOfSale;
        this.priceOfSale = priceOfSale;
        this.weight = weight;
    }

    /**
     * Validation method.
     * @param fishName
     * @param dateOfPurchase
     * @param dateOfSale
     * @param priceOfSale
     * @param weight
     * @return
     * @throws IncorrectParamInput if one of parameters is null{@param fishName},
     * {@param dateOfSale}, {@param dataOfPurchase}or is negative {@param priceOfSale},
     * {@param weight}
     */
    private static boolean init(FishType fishName, Date dateOfPurchase,
                                Date dateOfSale, double priceOfSale, double weight)
            throws IncorrectParamInput {

        Optional.ofNullable(fishName).orElseThrow(IncorrectParamInput::new);
        Optional.ofNullable(dateOfPurchase).orElseThrow(IncorrectParamInput::new);
        Optional.ofNullable(dateOfSale).orElseThrow(IncorrectParamInput::new);
        if(priceOfSale<0||weight<0) throw new IncorrectParamInput("price or weight is negative");
        return true;
    }

    /**
     * Get value of the fishName variable.
     * @return value of the fish type.
     */
    public FishType getFishName() {
        return fishName;
    }
    /**
     * Get value of the dateOfPurchase variable.
     * @return date of purchase.
     */
    public Date getDateOfPurchase() {
        return dateOfPurchase;
    }

    /**
     * Get value of the priceOfPurchase variable.
     * @return value of the price.
     */
    public double getPriceOfPurchase() {
        return priceOfPurchase;
    }

    /**
     * Get value of the dateOfSale variable.
     * @return date of sale.
     */

    public Date getDateOfSale() {
        return dateOfSale;
    }

    /**
     * Get value of the priceOfSale.
     * @return price of sale.
     */

    public double getPriceOfSale() {
        return priceOfSale;
    }

    /**
     * Get value of the weight variable.
     * @return value of weight.
     */

    public double getWeight() {
        return weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SaleOperation that = (SaleOperation) o;

        if (Double.compare(that.priceOfPurchase, priceOfPurchase) != 0) return false;
        if (Double.compare(that.priceOfSale, priceOfSale) != 0) return false;
        if (Double.compare(that.weight, weight) != 0) return false;
        if (fishName != that.fishName) return false;
        if (!dateOfPurchase.equals(that.dateOfPurchase)) return false;
        return dateOfSale.equals(that.dateOfSale);
    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = fishName.hashCode();
        result = 31 * result + dateOfPurchase.hashCode();
        temp = Double.doubleToLongBits(priceOfPurchase);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        result = 31 * result + dateOfSale.hashCode();
        temp = Double.doubleToLongBits(priceOfSale);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public String toString() {
        return "SaleOperation{" +
                "fishName=" + fishName +
                ", dateOfPurchase=" + dateOfPurchase +
                ", priceOfPurchase=" + priceOfPurchase +
                ", dateOfSale=" + dateOfSale +
                ", priceOfSale=" + priceOfSale +
                ", weight=" + weight +
                '}';
    }

    double countIncome() {
        return priceOfSale - priceOfPurchase +
                CONST * (dateOfPurchase.getTime() - getDateOfSale().getTime()) / (24 * 60 * 60 * 1000);
    }


}
