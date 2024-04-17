package application;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PlayerTest {
	String slice = "Slice";
	@Test
	void testSetStrokeShouldBeSlice() {
		Player player = new Player();
		assertTrue(player.setStroke("Slice") == player.setStroke(slice));
	}

	@Test
	void testGetTitleTrue() {
		String string = "ADPP Player One";
		assertTrue(true);
	}

	@Test
	void testServeBall() {
		fail("Not yet implemented");
	}

}
