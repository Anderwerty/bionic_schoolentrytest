package testTask1;

import org.junit.After;
import org.junit.Test;
import task1.IncorrectParamInput;
import task1.SaleOperation;

import java.util.Date;

/**
 * Created by admin on 01.06.2017.
 */
public class TestSaleOperation {
    public SaleOperation operation;

    @After
    public void clean() {
        operation = null;
    }

    @Test(expected = IncorrectParamInput.class)
    public void nullArgumentInput() throws IncorrectParamInput {
        operation= new SaleOperation(null,new Date(1000000),100,new Date(120000),120,5);
    }
}
