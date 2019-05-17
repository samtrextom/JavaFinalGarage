package midtermjavatwo.Test;

import midtermjavatwo.Garage;
import midtermjavatwo.Ticket;
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
public class GarageTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(midtermjavatwo.Garage.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }

    private ArrayList<Ticket> openTickets;
    private Ticket ticket1;
    private Ticket ticket2;
    private Garage garage;

    @Before
    public void setUp() throws Exception {
        ticket1 = new Ticket(1);
        ticket2 = new Ticket(2);
        openTickets.add(ticket1);
        openTickets.add(ticket2);
        garage.addOpenTickets(openTickets);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setPaymentStructure() {
    }

    @Test
    public void getGarageName() {
    }

    @Test
    public void addTicket() {
    }

    @Test
    public void findTicket() {

        assertEquals("Correct",1,garage.findTicket(1).getID());
        assertEquals("Correct",2,garage.findTicket(2).getID());
    }

    @Test
    public void displayAll() {
    }

    @Test
    public void addLostTicket() {
    }

    @Test
    public void addClosedTicket() {
    }

    @Test
    public void openGarage() {
    }

    @Test
    public void closeGarage() {
    }

    @Test
    public void getInstance() {
    }
}
