package midtermjavatwo.Test;

import midtermjavatwo.TotalPayments;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class TotalPaymentsTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(midtermjavatwo.TotalPayments.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private TotalPayments totalPayments;
    private double testDouble;

    @Before
    public void setUp() throws Exception {
        totalPayments = new TotalPayments("test",0);
        testDouble = 10.00;
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addPayment() {
        totalPayments.addPayment(testDouble);
        assertEquals("Correct",10.00,totalPayments.getTotal());
    }

    @Test
    public void getName() {
    }

    @Test
    public void display() {
    }

}
