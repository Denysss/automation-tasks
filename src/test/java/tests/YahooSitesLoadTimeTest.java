package tests;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.joda.time.LocalTime;
import org.joda.time.Seconds;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.*;

import pages.yahoo.YahooPage;
import tests.templates.TestTemplate;

/**
 * Automate following scenario: Goto www.yahoo.com and fetch the Yahoo sites
 * (Mail, Autos etc) in the Left dynamically and click over each site to verify
 * if the page loads in 7 seconds
 * 
 */

public class YahooSitesLoadTimeTest extends TestTemplate {

	private final int expectedMaxLoadTime = 7;

	private Map<String, Integer> loadTimeResults;
	private YahooPage yahooPage;

	public YahooSitesLoadTimeTest() {
		loadTimeResults = new HashMap<String, Integer>();
	}

	@Test
	public void checkYahooSitesLoadTime() {
		yahooPage = new YahooPage(driver);

		// find out load time for main Yahoo site
		// loadTimeResults.put(yahooPage.getUrlMainPage(), getSiteLoadTime(""));
		yahooPage.open();

		List<String> yahooSites = yahooPage.getYahooSites();

		// find out load time for each Yahoo site
		for (String url : yahooSites)
			loadTimeResults.put(url, getSiteLoadTime(url));

		// print test results
		for (String key : loadTimeResults.keySet())
			System.out.println(key + " was loaded in " + loadTimeResults.get(key) + " seconds");

		// verify test results with expected time
		for (String key : loadTimeResults.keySet())
			assertThat("Load time of " + key + " page", loadTimeResults.get(key),
					lessThanOrEqualTo(expectedMaxLoadTime));
	}

	private int getSiteLoadTime(String url) {
		LocalTime startTime = LocalTime.now();

		if (url.isEmpty())
			yahooPage.open();
		else
			yahooPage.open(url);

		LocalTime endTime = LocalTime.now();

		return Seconds.secondsBetween(startTime, endTime).getSeconds();
	}
}
