package midtermjavatwo.Test;

import midtermjavatwo.BestValueParkingGarageFees.LostFee;
import midtermjavatwo.BestValueParkingGarageFees.MinMaxFee;
import midtermjavatwo.BestValueParkingGarageFees.SpecialEventFee;
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

import java.time.LocalTime;

import static org.junit.Assert.*;

@RunWith(Arquillian.class)
public class TicketTest {
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(midtermjavatwo.Ticket.class)
                .addAsManifestResource(EmptyAsset.INSTANCE, "beans.xml");
    }


    private Ticket testLostTicket;
    private Ticket testMinMaxTicket;
    private Ticket testMinMaxTicket2;
    private Ticket testSpecialTicket;
    private LocalTime inTime;
    private LocalTime outTime;
    private LocalTime outTime2;

    @Before
    public void setUp() throws Exception {

        inTime.of(8,0);
        outTime.of(20,0);
        outTime.of(12,0);
        testLostTicket = new Ticket(inTime,new LostFee());
        testMinMaxTicket = new Ticket(inTime,outTime, new MinMaxFee());
        testMinMaxTicket2 = new Ticket(inTime,outTime2, new MinMaxFee());
        testSpecialTicket = new Ticket(inTime, new SpecialEventFee());
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void getTime() {
    }

    @Test
    public void getID() {
    }

    @Test
    public void setID() {
    }

    @Test
    public void display() {
    }

    @Test
    public void calculateTotal() {
        testLostTicket.calculateTotal();
        testSpecialTicket.calculateTotal();
        testMinMaxTicket.calculateTotal();
        testMinMaxTicket2.calculateTotal();

        assertEquals("Correct",25.00,testLostTicket.getTotal());
        assertEquals("Correct",20.00,testSpecialTicket.getTotal());
        assertEquals("Correct",15.00,testMinMaxTicket.getTotal());
        assertEquals("Correct",9.00,testMinMaxTicket2.getTotal());
    }

    @Test
    public void displayOutTime() {
    }

    @Test
    public void getTotal() {
    }

    @Test
    public void getPaymentType() {
    }

    @Test
    public void setPaymentType() {
    }
}
