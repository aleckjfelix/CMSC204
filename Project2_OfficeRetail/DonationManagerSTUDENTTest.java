
import static org.junit.Assert.*;

import java.util.EmptyStackException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author khandan Monshi, revised by Professor Kartchner
 *
 */
public class DonationManagerSTUDENTTest {
	DonationManager manager;

	@Before
	public void setUp() throws Exception {

		manager = new DonationManager(5, 5, 5);

	}

	@After
	public void tearDown() throws Exception {

		manager = null;
	}

	/**
	 * Student test that a new DonationPackage is created and the manager correctly
	 * calls load the container
	 */
	@Test
	public void testManagerLoadcontainer() {
		try {
			manager.managerLoadContainer(new DonationPackage("A", 20));
			manager.managerLoadContainer(new DonationPackage("B", 15));
			manager.managerLoadContainer(new DonationPackage("C", 10));
			manager.managerLoadContainer(new DonationPackage("D", 10));
			manager.managerLoadContainer(new DonationPackage("E", 20));

		} catch (ContainerException e) {
			System.out.println("Should not throw exception");
			fail("Should not throw exception");
		}

		try {
			manager.managerLoadContainer(new DonationPackage("F", 20));
			fail("Should throw exception");
		} catch (ContainerException e) {

		}

	}

	/**
	 * Student test that a new Volunteer is created and the manager correctly queues
	 * the volunteer
	 */
	@Test
	public void testManagerQueueVolunteer() {
		try {
			manager.managerQueueVolunteer(new Volunteer("A"));
			manager.managerQueueVolunteer(new Volunteer("B"));
			manager.managerQueueVolunteer(new Volunteer("C"));
			manager.managerQueueVolunteer(new Volunteer("D"));
			manager.managerQueueVolunteer(new Volunteer("E"));

		} catch (VolunteerException e) {
			fail("Should not throw exception");
			System.out.println(e + "here");
		}

		try {
			manager.managerQueueVolunteer(new Volunteer("F"));
			fail("Should throw exception");
		} catch (VolunteerException e) {
			// success
		}

	}

	/**
	 * Student test that a new Recipient is created and the manager correctly queues
	 * the recipient
	 */
	@Test
	public void testManagerQueueRecipient() {
		try {
			manager.managerQueueRecipient(new Recipient("A"));
			manager.managerQueueRecipient(new Recipient("B"));
			manager.managerQueueRecipient(new Recipient("C"));
			manager.managerQueueRecipient(new Recipient("D"));
			manager.managerQueueRecipient(new Recipient("E"));

		} catch (RecipientException e) {
			fail("Should not throw exception");
			System.out.println(e + "here");
		}

		try {
			manager.managerQueueRecipient(new Recipient("F"));
			fail("Should throw exception");
		} catch (RecipientException e) {
			// success
		}
	}

	/**
	 * Student test that the manager correctly calls donatePackage, testing the
	 * situations noted in the assignment document
	 */
	@Test
	public void testDonatePackage() {
		Volunteer v1;
		Recipient r1;
		DonationPackage d1, d2;

		v1 = new Volunteer("Monica");
		r1 = new Recipient("MC College");

		d1 = new DonationPackage("Pens", 10);
		d2 = new DonationPackage("Books", 20);

		try {
			manager.managerLoadContainer(d1);
			manager.managerLoadContainer(d2);

			assertEquals(manager.donatePackage(), 1); // Can not donate package, There are no volunteers in the queue

			manager.managerQueueVolunteer(v1); // add a volunteer
			assertEquals(manager.donatePackage(), 2); // Still Can not donate package,There are no recipients in the
														// queue

			manager.managerQueueRecipient(r1); // Add a recipient
			assertEquals(manager.donatePackage(), 0); // donation process should be successful, this should remove the
														// package from
														// the container and recipients from the queue, Volunteer is
														// enqueued again to the
														// Volunteer line.

			assertEquals(manager.donatePackage(), 2); // There is no recipient in the queue

		} catch (ContainerException | VolunteerException | RecipientException e) {
			System.out.println(e.getMessage());
		}
	}

}
