
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
	private boolean printAllTestCases = true;

	public UrlValidatorTest(String testName) {
		super(testName);
	}

	public void testIsValid2() {
		Boolean expectedResult, actualResult, allTestsPassed, actualAllowAllSchemesResult = true;

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

		UrlValidator urlValAllowAllSchemes = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		allTestsPassed = true;
		for (Map.Entry<String, Boolean> s : schemes.entrySet()) {
			for (Map.Entry<String, Boolean> a : authorities.entrySet()) {
				for (Map.Entry<String, Boolean> r : ports.entrySet()) {
					for (Map.Entry<String, Boolean> p : paths.entrySet()) {
						expectedResult = s.getValue() && a.getValue() && r.getValue() && p.getValue();
						actualResult = urlValAllowAllSchemes.isValid(s.getKey() + a.getKey() + r.getKey() + p.getKey());

						if (expectedResult != actualResult) {
							System.out.println("FAIL");
							allTestsPassed = false;
						} else if (printAllTestCases) {
							System.out.println("PASS");
						}

						if ((expectedResult != actualResult) || printAllTestCases) {
							System.out.println(s.getKey() + a.getKey() + r.getKey() + p.getKey());
							System.out.println("urlVal.isValid() says " + actualAllowAllSchemesResult);
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

		int schemeArrayLoop = 0;
		int allowAllSchemeLoop = 0;
		int allow2SlashesFlag = 0;

		ArrayList ValidChars = new ArrayList();
		for (char alphabet = 'A'; alphabet <= 'Z'; alphabet++) {
			ValidChars.add(Character.toString(alphabet));
		}
		for (char alphabet = 'a'; alphabet <= 'z'; alphabet++) {
			ValidChars.add(Character.toString(alphabet));
		}
		for (int numeric = 0; numeric <= 9; numeric++) {
			ValidChars.add(Integer.toString(numeric));
		}

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

		int validityFlag = 0;
		int urlLen = 0;
		int shuffleControllers = 0;
		int loopController = 0;
		String item = "";
		int ValidCharsarrayLen = 0;
		int ValidCharsarrayItem = 0;
		int len = 10;
		Random rand = new Random();
		boolean invalidUrl = false;
		boolean failTest;
		int tldLen = 0;
		for (int i = 0; i < 1000; i++) {
			// validityFlag = i % 4;
			item = "";
			if (i % 10 == 0) {
				len = 100; // one in 10 will be a random number between 1 and 100
			} else {
				len = 10;// 9 in 10 will be a random number between 1 and 100
			}
			urlLen = rand.nextInt(len) + 1; // 2082 is the longest valid url len, dont want alot of those, due to
			if ((i == 30) || (i == 60)) {
				urlLen = 2082;
			}
			if ((i == 99)) {
				urlLen = 2100;
			}
			failTest = ((i % 4) == 0);
			// memory, does the urlvalidator test len limit?
			shuffleControllers = i % 25;
			if (shuffleControllers == 0) { // randomize every 25 loops
				Collections.shuffle(ValidChars);
				Collections.shuffle(InValidChars);
				tldLen = rand.nextInt(7);
			}
			ValidChars.indexOf(ValidChars);
			ValidCharsarrayLen = ValidChars.size();
			ValidCharsarrayItem = 0;

			for (loopController = 0; loopController < urlLen; loopController++) {
				ValidCharsarrayItem++;
				if (ValidCharsarrayItem >= ValidCharsarrayLen) {
					ValidCharsarrayItem = 0;
				}
				if ((failTest) && (ValidCharsarrayItem == (urlLen - 1))) {
					item += (String) InValidChars.get(5);
				} else {
					item += (String) ValidChars.get(ValidCharsarrayItem);
				}
			}
			item += ".";
			for (loopController = 0; loopController < tldLen; loopController++) {
				ValidCharsarrayItem++;
				if (ValidCharsarrayItem >= ValidCharsarrayLen) {
					ValidCharsarrayItem = 0;
				}
				if ((failTest) && (ValidCharsarrayItem == (tldLen - 1))) {
					item += (String) InValidChars.get(5);
				} else {
					item += (String) ValidChars.get(ValidCharsarrayItem);
				}
			}

			paths.put(item, !failTest);
		}
		return paths;
	}

	/**
	 * Create set of tests by taking the testUrlXXX arrays and running through all
	 * possible permutations of their combinations.
	 *
	 * @param testObjects
	 *            Used to create a url.
	 */

}