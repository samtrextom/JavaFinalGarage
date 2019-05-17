package midtermjavatwo.Test;

import midtermjavatwo.BestValueParkingGarageFees.LostFee;
import midtermjavatwo.BestValueParkingGarageFees.MinMaxFee;
import midtermjavatwo.Ticket;
import midtermjavatwo.TicketDataStorage;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.asset.EmptyAsset;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class TicketDataStorageTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(midtermjavatwo.TicketDataStorage.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private TicketDataStorage dataStorage;
    private ArrayList<Ticket> tickets;
    private Ticket ticket1;
    private Ticket ticket2;

    @Before
    public void setUp() throws Exception {

        ticket1 = new Ticket(10.00, new LostFee());
        ticket2 = new Ticket(20.00, new MinMaxFee());
        tickets.add(ticket1);
        tickets.add(ticket2);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void addExistingTotal() {
        dataStorage.addExistingTotal("TestFee%10.00%1");
        assertEquals("Correct",dataStorage.getTotalPaymentsArray().get(0).getTotal(),10.00);
        assertEquals("Correct",dataStorage.getTotalPaymentsArray().get(0).getName(),"TestFee");
        assertEquals("Correct",dataStorage.getTotalPaymentsArray().get(0).getCount(),1);

    }

    @Test
    public void addTotals() {
        dataStorage.addTotals(tickets);
        assertEquals("Correct",dataStorage.getTotalPaymentsArray().get(0).getName(),"Lost Fee");
        assertEquals("Correct",dataStorage.getTotalPaymentsArray().get(0).getTotal(),10.00);
        assertEquals("Correct",dataStorage.getTotalPaymentsArray().get(0).getCount(),1);
        assertEquals("Correct",dataStorage.getTotalPaymentsArray().get(0).getName(),"Min/Max Fee");
        assertEquals("Correct",dataStorage.getTotalPaymentsArray().get(0).getTotal(),10);
        assertEquals("Correct",dataStorage.getTotalPaymentsArray().get(0).getCount(),1);
    }

    @Test
    public void displayAllTotals() {
    }

    @Test
    public void hasTotal() {
        assertEquals("Correct",false,dataStorage.hasTotal());
    }

    @Test
    public void writeToFile() {
    }

    @Test
    public void getInstance() {
    }
}
