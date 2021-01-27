package sandbox.selenium.util;

import java.util.concurrent.ThreadLocalRandom;

public class RandomHelper {
	
	private static ThreadLocalRandom random = ThreadLocalRandom.current();
	
	public static int getRandomNumberFromInterval(int min, int max) {
		return random.nextInt(min, max);
	}

}
