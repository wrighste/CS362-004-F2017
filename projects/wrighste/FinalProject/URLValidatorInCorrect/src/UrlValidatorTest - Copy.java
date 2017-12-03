
/*
 * Licensed to the Apache Software Foundation (ASF) under one or moref
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import junit.framework.TestCase;

/**
 * Performs Validation Test for url validations.
 *
 * @version $Revision: 1128446 $ $Date: 2011-05-27 13:29:27 -0700 (Fri, 27 May
 *          2011) $
 */
public class UrlValidatorTest extends TestCase {

	private boolean printStatus = false;
	private boolean printIndex = false;// print index that indicates current scheme,host,port,path, query test were
										// using.

	public UrlValidatorTest(String testName) {
		super(testName);
	}

	public void testManualTestHttpAllSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		boolean result = (urlVal.isValid("http://www.amazon.com"));
		if (result) {
			System.out.println("Test passed : testManualTestHttpAllSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualTestHttpAllSchemesAllowed");
		}
	}

	public void testManualTestHttpsAllSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		boolean result = (urlVal.isValid("https://postman-echo/basic-auth"));
		if (result) {
			System.out.println("Test passed : testManualTestHttpsAllSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualTestHttpsAllSchemesAllowed");
		}

	}

	public void testManualFTPAllSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		boolean result = (urlVal.isValid("ftp://username:password@ftp.fakesite.org/"));
		if (result) {
			System.out.println("Test passed : testManualFTPAllSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualFTPAllSchemesAllowed");
		}

	}

	public void testManualgopherAllSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		boolean result = (urlVal.isValid("gopher://spinaltap.micro.umn.edu/00/Weather/California/Los%20Angeles"));
		if (result) {
			System.out.println("Test passed : testManualgopherAllSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualgopherAllSchemesAllowed");
		}

	}

	public void testManualMailtoAllSchemes() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		boolean result = (urlVal.isValid("mailto:mduerst@ifi.unizh.ch"));
		if (result) {
			System.out.println("Test passed : testManualMailtoAllSchemes");

		} else {
			System.out.println("Test failed: testManualMailtoAllSchemes");
		}
	}

	public void testManualFakeSchemeAllSchemes() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		boolean result = (urlVal.isValid("BooBooKittyScheme:booBoo@kitty.cat.meow"));
		if (result) {
			System.out.println("Test passed : testManualFakeSchemeAllSchemes");

		} else {
			System.out.println("Test failed: testManualFakeSchemeAllSchemes");
		}
	}

	public void testManualTestHttpDefaultSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = (urlVal.isValid("http://www.amazon.com"));
		if (result) {
			System.out.println("Test passed : testManualTestHttpDefaultSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualTestHttpDefaultSchemesAllowed");
		}

	}

	public void testManualTestHttpsDefaultSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = (urlVal.isValid("https://postman-echo/basic-auth"));
		if (result) {
			System.out.println("Test passed : testManualTestHttpsDefaultSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualTestHttpsDefaultSchemesAllowed");
		}
	}

	public void testManualFTPDefaultSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = (urlVal.isValid("ftp://username:password@ftp.fakesite.org/"));
		if (result == false) {
			System.out.println("Test passed : testManualFTPDefaultSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualFTPDefaultSchemesAllowed");
		}
	}

	public void testManualgopherDefaultSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = (urlVal.isValid("gopher://spinaltap.micro.umn.edu/00/Weather/California/Los%20Angeles"));
		if (result == false) {
			System.out.println("Test passed : testManualgopherDefaultSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualgopherDefaultSchemesAllowed");
		}
	}

	public void testManualgopherDefaultSchemesMailto() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = (urlVal.isValid("gopher://spinaltap.micro.umn.edu/00/Weather/California/Los%20Angeles"));
		if (result) {
			System.out.println("Test passed : testManualgopherDefaultSchemesMailto");

		} else {
			System.out.println("Test failed: testManualgopherDefaultSchemesMailto");
		}
	}

	public void testManualFakeSchemeDefaultSchemesMailto() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = (urlVal.isValid("BooBooKittyScheme:booBoo@kitty.cat.meow"));
		if (result) {
			System.out.println("Test passed : testManualFakeSchemeDefaultSchemesMailto");

		} else {
			System.out.println("Test failed: testManualFakeSchemeDefaultSchemesMailto");
		}
	}

	public void testManualTestHttpOnlyHTTPSIsAllowdScheme() {
		String[] schemes = { "https" };
		UrlValidator urlVal = new UrlValidator(schemes);
		boolean result = (urlVal.isValid("ftp://foo.bar.com/"));
		if (result == false) {
			System.out.println("Test passed : testManualTestHttpOnlyHTTPSIsAllowdScheme");

		} else {
			System.out.println("Test failed: testManualTestHttpOnlyHTTPSIsAllowdScheme");
		}

	}

	public void testYourFirstPartition() {

	}

	public void testYourSecondPartition() {

	}

	public void RandomtestIsValid() {
		int schemeArrayLoop = 0;
		int allowAllSchemeLoop = 0;
		int allow2SlashesFlag = 0;
		// valid AND existing schemese, found here :
		// https://www.iana.org/assignments/uri-schemes/uri-schemes.xhtml only last one
		// is valid and non-existing

		ArrayList DefaultSchemes = new ArrayList();
		DefaultSchemes.add("http");
		DefaultSchemes.add("https");
		DefaultSchemes.add("ftp");

		String[] validCharArray = { "" };
		String[] InvalidCharArray;

		ArrayList ValidSchemes = new ArrayList();
		ValidSchemes.add("Go");
		ValidSchemes.add("Gopher");
		ValidSchemes.add("Http");
		ValidSchemes.add("Https");
		ValidSchemes.add("hxxp");
		ValidSchemes.add("ms-secondary-screen-controller");
		ValidSchemes.add("ni");
		ValidSchemes.add("soap.beep");
		ValidSchemes.add("telnet");
		ValidSchemes.add("BooBooKitty");

		ArrayList InValidSchemes = new ArrayList();
		InValidSchemes.add("Go<");
		InValidSchemes.add("Go pher");
		InValidSchemes.add("Htt#");
		InValidSchemes.add("H%tps");
		InValidSchemes.add("hx#p");
		InValidSchemes.add("ms<secondary-screen-controller");
		InValidSchemes.add("=");
		InValidSchemes.add("soap[.beep");
		InValidSchemes.add("]elnet");
		InValidSchemes.add("B'oBooKitty");

		ArrayList ValidChars = new ArrayList();
		ValidChars.add("A");
		ValidChars.add("a");
		ValidChars.add("B");
		ValidChars.add("b");
		ValidChars.add("C");
		ValidChars.add("c");
		ValidChars.add("D");
		ValidChars.add("d");
		ValidChars.add("E");
		ValidChars.add("e");
		ValidChars.add("F");
		ValidChars.add("f");
		ValidChars.add("G");
		ValidChars.add("g");
		ValidChars.add("H");
		ValidChars.add("h");
		ValidChars.add("I");
		ValidChars.add("i");
		ValidChars.add("J");
		ValidChars.add("j");
		ValidChars.add("K");
		ValidChars.add("k");
		ValidChars.add("L");
		ValidChars.add("l");
		ValidChars.add("M");
		ValidChars.add("m");
		ValidChars.add("N");
		ValidChars.add("n");
		ValidChars.add("O");
		ValidChars.add("o");
		ValidChars.add("P");
		ValidChars.add("p");
		ValidChars.add("Q");
		ValidChars.add("q");
		ValidChars.add("R");
		ValidChars.add("r");
		ValidChars.add("S");
		ValidChars.add("s");
		ValidChars.add("T");
		ValidChars.add("t");
		ValidChars.add("U");
		ValidChars.add("u");
		ValidChars.add("V");
		ValidChars.add("v");
		ValidChars.add("W");
		ValidChars.add("w");
		ValidChars.add("X");
		ValidChars.add("x");
		ValidChars.add("Y");
		ValidChars.add("y");
		ValidChars.add("Z");
		ValidChars.add("z");
		ValidChars.add("0");
		ValidChars.add("1");
		ValidChars.add("2");
		ValidChars.add("3");
		ValidChars.add("4");
		ValidChars.add("5");
		ValidChars.add("6");
		ValidChars.add("7");
		ValidChars.add("8");
		ValidChars.add("9");
		ValidChars.add("-");
		ValidChars.add(".");
		ValidChars.add("~");

		ArrayList InValidChars = new ArrayList();
		InValidChars.add("!");
		InValidChars.add("*");
		InValidChars.add(" ' ");
		InValidChars.add("(");
		InValidChars.add(")");
		InValidChars.add(";");
		InValidChars.add("/");
		InValidChars.add("?");
		InValidChars.add("#");
		InValidChars.add("[");
		InValidChars.add("]");
		// UrlValidator urlVal = new UrlValidator();
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		int validityFlag = 0; // 0 = valid chars in scheme and rest of url, 1 = invalid scheme, other chars
								// are ok, 2 = scheme is valid, rest of URL is not, 3 = scheme and rest of URL
								// is invalid
		int urlLen = 0;

		String baseString = "";
		String errorMessage = "";
		boolean expectedisValidResult = false;
		boolean result;
		for (int i = 0; i < 100; i++) {
			validityFlag = i % 4;
			urlLen = (i % 10) + 1; // limit to 10 len url for our testing, never less than 1 char
			if (urlLen == 1) {
				Collections.shuffle(ValidChars); // randomize every 10 loops
				Collections.shuffle(InValidChars);
				Collections.shuffle(ValidSchemes);
				Collections.shuffle(InValidSchemes);
			}

			if (validityFlag == 0) { // 0 = valid chars in scheme and rest of url,
				errorMessage = "Valid Scheme and Valid URL text ";
				baseString = ValidSchemes.get(0) + "://" + ValidChars.get(0) + ValidChars.get(1) + ValidChars.get(2)
						+ ValidChars.get(3) + ValidSchemes.get(4) + ValidChars.get(5) + ValidChars.get(6)
						+ ValidChars.get(7) + ValidChars.get(8) + ValidChars.get(9);
				expectedisValidResult = true;
			} else if ((validityFlag == 1)) { // 1 = invalid scheme, other chars
				errorMessage = "InValid Scheme and Valid URL text ";
				baseString = InValidSchemes.get(0) + "://" + ValidChars.get(0) + ValidChars.get(1) + ValidChars.get(2)
						+ ValidChars.get(3) + ValidSchemes.get(4) + ValidChars.get(5) + ValidChars.get(6)
						+ ValidChars.get(7) + ValidChars.get(8) + ValidChars.get(9);
				expectedisValidResult = false;

			} else if ((validityFlag == 2)) { // 2 = scheme is valid, rest of URL is not, first char and fifth is allwys
				errorMessage = "Valid Scheme and InValid URL text ";
				// invalid,
				baseString = ValidSchemes.get(0) + "://" + InValidChars.get(0) + ValidChars.get(1) + ValidChars.get(2)
						+ ValidChars.get(3) + InValidChars.get(4) + ValidChars.get(5) + ValidChars.get(6)
						+ ValidChars.get(7) + ValidChars.get(8) + ValidChars.get(9);
				expectedisValidResult = false;

			} else if ((validityFlag == 3)) { // 3 = scheme and rest is invalid
				errorMessage = "InValid Scheme and InValid URL text ";
				baseString = InValidSchemes.get(0) + "://" + InValidChars.get(0) + ValidChars.get(1) + ValidChars.get(2)
						+ ValidChars.get(3) + InValidChars.get(4) + InValidChars.get(5) + ValidChars.get(6)
						+ ValidChars.get(7) + ValidChars.get(8) + ValidChars.get(9);
				expectedisValidResult = false;

			}
			result = (urlVal.isValid(baseString)); // "https://www.google.com")); //
			// boolean result =
			// (urlVal.isValid("ftp://username:password@ftp.fakesite.org/"));
			// result = (urlVal.isValid("http://www.amazon.com"));
			if (expectedisValidResult != result) {
				System.out.println("Test Failed " + errorMessage + " using " + baseString);

			}
		}
	}

	////////////////////////////////////////
	public void testIsValid1() {
		Map<String, Boolean> schemes = new HashMap<String, Boolean>() {
			{
				put("http://", true);
				put("http:/", false);
				put("http:", false);
				put("http", false);
				put("", true);

			}
		};

		Map<String, Boolean> authorities = generaterHashMap(1);
		// new HashMap<String, Boolean>() {
		// {
		// put("www.google.com", true);
		// put("test.com", true);
		// put("test.tv", true);
		// put("255.255.255.255", true);
		// put("255.256.255.255", false);
		//
		// }
		// };
		// generaterHashMap(1);
		Map<String, Boolean> paths = new HashMap<String, Boolean>() {
			{
				put("/test", true);
				put("/test1", true);
				put("/test/", true);
				put("/test/otherthing/file", true);
				put("//test", false);
				put("/test//", false);

			}
		};

		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		// for(int i = 0; i < 10000; i++)

		for (Map.Entry<String, Boolean> s : schemes.entrySet()) {
			for (Map.Entry<String, Boolean> a : authorities.entrySet()) {
				for (Map.Entry<String, Boolean> p : paths.entrySet()) {
					// System.out.println(p.getKey());

					if (Boolean.TRUE.equals(s.getValue()) && Boolean.TRUE.equals(a.getValue())
							&& Boolean.TRUE.equals(p.getValue())) {
						// assertTrue(urlVal.isValid(s.getKey() + a.getKey() + p.getKey()));
						System.out.println(s.getKey() + a.getKey() + p.getKey());
						System.out.println(
								"urlVal.isValid() says " + urlVal.isValid(s.getKey() + a.getKey() + p.getKey()));
						System.out.println("Predefined rules say true");
						System.out.println("\n");
					}

					else {
						// assertFalse(urlVal.isValid(s.getKey() + a.getKey() + p.getKey()));
						System.out.println(s.getKey() + a.getKey() + p.getKey());
						System.out.println(
								"urlVal.isValid() says " + urlVal.isValid(s.getKey() + a.getKey() + p.getKey()));
						System.out.println("Predefined rules say false");
						System.out.println("\n");
					}

				}
			}
		}

	}

	///////////////////////////////////////////
	public void testIsValid2() {
		Boolean expectedResult, actualResult, allTestsPassed = true, printAllTestCases = false;

		Map<String, Boolean> schemes = new HashMap<String, Boolean>() {
			{
				put("http://", true);
				put("http:/", false);
				put("http:", false);
				put("http", false);
				put("", false);

			}
		};
		Map<String, Boolean> authorities = generaterHashMap(1);
		// Map<String, Boolean> authorities = new HashMap<String, Boolean>() {
		// {
		// put("www.google.com", true);
		// put("test.com", true);
		// put("test.tv", true);
		// put("255.255.255.255", true);
		// put("255.256.255.255", false);
		//
		// }
		// };

		Map<String, Boolean> ports = new HashMap<String, Boolean>() {
			{
				put(":1", true);
				put(":65535", true);
				put(":65536", false);
				put(":0", true);
				put(":-1", false);
				put(":2.5", false);
				put(":a", false);
				put(":362cs", false);
				put(":", false);
				put("", true);
			}
		};

		Map<String, Boolean> paths = new HashMap<String, Boolean>() {
			{
				put("/test", true);
				put("/test1", true);
				put("/test/", true);
				put("/test/otherthing/file", true);
				put("//test", false);
				put("/test//", false);

			}
		};

		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		for (Map.Entry<String, Boolean> s : schemes.entrySet()) {
			for (Map.Entry<String, Boolean> a : authorities.entrySet()) {
				for (Map.Entry<String, Boolean> r : ports.entrySet()) {
					for (Map.Entry<String, Boolean> p : paths.entrySet()) {
						expectedResult = s.getValue() && a.getValue() && r.getValue() && p.getValue();
						actualResult = urlVal.isValid(s.getKey() + a.getKey() + r.getKey() + p.getKey());

						if (expectedResult != actualResult) {
							System.out.println("FAIL");
							allTestsPassed = false;
						} else if (printAllTestCases) {
							System.out.println("PASS");
						}

						if ((expectedResult != actualResult) || printAllTestCases) {
							System.out.println(s.getKey() + a.getKey() + r.getKey() + p.getKey());
							System.out.println("urlVal.isValid() says " + actualResult);
							System.out.println("Predefined rules say " + expectedResult);
							System.out.println("\n");
						}
					}
				}
			}

		}
		assertTrue(allTestsPassed);
	}

	public Map<String, Boolean> generaterHashMap(int urlFlag) {
		Map<String, Boolean> paths = new HashMap<String, Boolean>();
		//////////////
		int schemeArrayLoop = 0;
		int allowAllSchemeLoop = 0;
		int allow2SlashesFlag = 0;
		// valid AND existing schemese, found here :
		// https://www.iana.org/assignments/uri-schemes/uri-schemes.xhtml only last one
		// is valid and non-existing

		ArrayList DefaultSchemes = new ArrayList();
		DefaultSchemes.add("http");
		DefaultSchemes.add("https");
		DefaultSchemes.add("ftp");

		String[] validCharArray = { "" };
		String[] InvalidCharArray;

		ArrayList ValidSchemes = new ArrayList();
		ValidSchemes.add("Go");
		ValidSchemes.add("Gopher");
		ValidSchemes.add("Http");
		ValidSchemes.add("Https");
		ValidSchemes.add("hxxp");
		ValidSchemes.add("ms-secondary-screen-controller");
		ValidSchemes.add("ni");
		ValidSchemes.add("soap.beep");
		ValidSchemes.add("telnet");
		ValidSchemes.add("BooBooKitty");

		ArrayList InValidSchemes = new ArrayList();
		InValidSchemes.add("Go<");
		InValidSchemes.add("Go pher");
		InValidSchemes.add("Htt#");
		InValidSchemes.add("H%tps");
		InValidSchemes.add("hx#p");
		InValidSchemes.add("ms<secondary-screen-controller");
		InValidSchemes.add("=");
		InValidSchemes.add("soap[.beep");
		InValidSchemes.add("]elnet");
		InValidSchemes.add("B'oBooKitty");

		ArrayList ValidChars = new ArrayList();
		ValidChars.add("A");
		ValidChars.add("a");
		ValidChars.add("B");
		ValidChars.add("b");
		ValidChars.add("C");
		ValidChars.add("c");
		ValidChars.add("D");
		ValidChars.add("d");
		ValidChars.add("E");
		ValidChars.add("e");
		ValidChars.add("F");
		ValidChars.add("f");
		ValidChars.add("G");
		ValidChars.add("g");
		ValidChars.add("H");
		ValidChars.add("h");
		ValidChars.add("I");
		ValidChars.add("i");
		ValidChars.add("J");
		ValidChars.add("j");
		ValidChars.add("K");
		ValidChars.add("k");
		ValidChars.add("L");
		ValidChars.add("l");
		ValidChars.add("M");
		ValidChars.add("m");
		ValidChars.add("N");
		ValidChars.add("n");
		ValidChars.add("O");
		ValidChars.add("o");
		ValidChars.add("P");
		ValidChars.add("p");
		ValidChars.add("Q");
		ValidChars.add("q");
		ValidChars.add("R");
		ValidChars.add("r");
		ValidChars.add("S");
		ValidChars.add("s");
		ValidChars.add("T");
		ValidChars.add("t");
		ValidChars.add("U");
		ValidChars.add("u");
		ValidChars.add("V");
		ValidChars.add("v");
		ValidChars.add("W");
		ValidChars.add("w");
		ValidChars.add("X");
		ValidChars.add("x");
		ValidChars.add("Y");
		ValidChars.add("y");
		ValidChars.add("Z");
		ValidChars.add("z");
		ValidChars.add("0");
		ValidChars.add("1");
		ValidChars.add("2");
		ValidChars.add("3");
		ValidChars.add("4");
		ValidChars.add("5");
		ValidChars.add("6");
		ValidChars.add("7");
		ValidChars.add("8");
		ValidChars.add("9");
		ValidChars.add("-");
		ValidChars.add(".");
		ValidChars.add("~");

		ArrayList InValidChars = new ArrayList();
		InValidChars.add("!");
		InValidChars.add("*");
		InValidChars.add(" ' ");
		InValidChars.add("(");
		InValidChars.add(")");
		InValidChars.add(";");
		InValidChars.add("/");
		InValidChars.add("?");
		InValidChars.add("#");
		InValidChars.add("[");
		InValidChars.add("]");

		///////////
		int validityFlag = 0;
		int urlLen = 0;
		int shuffleControllers = 0;
		int loopController = 0;
		String item = "";
		Random rand = new Random();
		for (int i = 0; i < 100; i++) {
			// validityFlag = i % 4;
			urlLen = rand.nextInt(2082) + 1; // 2082, does the urlvalidator test len limit?
			shuffleControllers = i % 100;
			if (shuffleControllers == 1) { // randomize every 100 loops
				Collections.shuffle(ValidChars);
				Collections.shuffle(InValidChars);
			}
			ValidChars.indexOf(ValidChars);
			int ValidCharsarrayLen = ValidChars.lastIndexOf(ValidChars);
			int ValidCharsarrayItem = 0;
			int InValidCharsarrayLen = ValidChars.lastIndexOf(ValidChars);
			int InValidCharsarrayItem = 0;
			item.concat("/");
			for (loopController = 0; loopController < urlLen; loopController++) {
				ValidCharsarrayItem++;
				if (ValidCharsarrayItem > ValidCharsarrayLen) {
					ValidCharsarrayItem = 0;
				}
				item += (String) ValidChars.get(ValidCharsarrayItem);

			}
			paths.put(item, false);
		}
		return paths;
	}

	////////////////////////////////////////
	public void testAnyOtherUnitTest() {

	}
	/**
	 * Create set of tests by taking the testUrlXXX arrays and running through all
	 * possible permutations of their combinations.
	 *
	 * @param testObjects
	 *            Used to create a url.
	 */

}
