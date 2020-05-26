package lab9and10;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TestGoalieStatisticsClass{

	@Test
	public void testNoGamesInSeasonReturnZeroPercentage() {
		Season season1 = new Season();
		GoalieStatistics statistics = season1.getGoalieStatistics();
		assertEquals(0.0, statistics.getSavePercentage());
	}
}