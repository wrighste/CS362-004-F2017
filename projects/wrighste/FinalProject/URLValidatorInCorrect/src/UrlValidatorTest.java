
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

	public void testManualTestHttpAllSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		boolean result = (urlVal.isValid("http://www.amazon.com"));
		if (result && printAllTestCases) {
			System.out.println("Test passed : testManualTestHttpAllSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualTestHttpAllSchemesAllowed");
		}
		assertEquals(result, true);
	}

	public void testManualTestHttpsAllSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		boolean result = (urlVal.isValid("https://postman-echo.com/basic-auth"));
		if (result && printAllTestCases) {
			System.out.println("Test passed : testManualTestHttpsAllSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualTestHttpsAllSchemesAllowed");
		}
		assertEquals(result, true);
	}

	public void testManualFTPAllSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		boolean result = (urlVal.isValid("ftp://username:password@ftp.fakesite.org/"));
		if (result && printAllTestCases) {
			System.out.println("Test passed : testManualFTPAllSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualFTPAllSchemesAllowed");
		}
		assertEquals(result, true);
	}

	public void testManualgopherAllSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		boolean result = (urlVal.isValid("gopher://spinaltap.micro.umn.edu/00/Weather/California/Los%20Angeles"));
		if (result && printAllTestCases) {
			System.out.println("Test passed : testManualgopherAllSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualgopherAllSchemesAllowed");
		}
		assertEquals(result, true);
	}

	public void testManualMailtoAllSchemes() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		boolean result = (urlVal.isValid("mailto:mduerst@ifi.unizh.ch"));
		if (result && printAllTestCases) {
			System.out.println("Test passed : testManualMailtoAllSchemes");

		} else {
			System.out.println("Test failed: testManualMailtoAllSchemes");
		}
	}

	public void testManualFakeSchemeAllSchemes() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);

		boolean result = (urlVal.isValid("BooBooKittyScheme:booBoo@kitty.cat.meow"));
		if (result && printAllTestCases) {
			System.out.println("Test passed : testManualFakeSchemeAllSchemes");

		} else {
			System.out.println("Test failed: testManualFakeSchemeAllSchemes");
		}
		assertEquals(result, true);
	}

	public void testManualTestHttpDefaultSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = (urlVal.isValid("http://www.amazon.com"));
		if (result && printAllTestCases) {
			System.out.println("Test passed : testManualTestHttpDefaultSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualTestHttpDefaultSchemesAllowed");
		}
		assertEquals(result, true);
	}

	public void testURLTooLong() {
		UrlValidator urlVal = new UrlValidator(null, null, UrlValidator.ALLOW_ALL_SCHEMES);
		String bigString = "9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmx wA"
				+ "5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrYsddd"
				+ "4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVd"
				+ "ifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~p"
				+ "FHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteok"
				+ "RBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GN"
				+ "QT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.O"
				+ "bhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq"
				+ "2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I"
				+ "8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmx"
				+ "wA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4"
				+ "gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVi"
				+ "fEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~p"
				+ "FHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteok"
				+ "RBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GN"
				+ "QT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.Oc"
				+ "y-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvl"
				+ "5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gL"
				+ "pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteok"
				+ "1.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQT7X"
				+ "2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdz~pFHuZ0GNQbhKWmxwAjdz~RBa3S6PqT7XS6Pq2CUvlmxwA5DnVifEMt";

		// String bigStringNoTilde =
		// "9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA"
		// +
		// "5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrYsddd"
		// +
		// "4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVd"
		// +
		// "ifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzp"
		// +
		// "FHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteok"
		// +
		// "RBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GN"
		// +
		// "QT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.O"
		// +
		// "bhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq"
		// +
		// "2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I"
		// +
		// "8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmx"
		// +
		// "wA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4"
		// +
		// "gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVi"
		// +
		// "fEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzp"
		// +
		// "FHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteok"
		// +
		// "RBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GN"
		// +
		// "QT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.Oc"
		// +
		// "y-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvl"
		// +
		// "5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gL"
		// +
		// "pFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteok"
		// +
		// "1.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7XS6Pq2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQT7X"
		// +
		// "2CUvlmxwA5DnVifEMteokRBa31.OcbhKWy-I8s9JrY4gLjdzpFHuZ0GNQbhKWmxwAjdzRBa3S6PqT7XS6Pq2CUvlmxwA5DnVifEMt";
		boolean result = (urlVal.isValid("http://www." + bigString + ".com"));
		if (result && printAllTestCases) {
			System.out.println("Test passed : testManualTestHttpDefaultSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualTestHttpDefaultSchemesAllowed");
		}
		assertEquals(result, true);
	}

	public void c() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = (urlVal.isValid("https://postman-echo.net/basic-auth"));
		if (result && printAllTestCases) {
			System.out.println("Test passed : testManualTestHttpsDefaultSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualTestHttpsDefaultSchemesAllowed");
		}
		assertEquals(result, true);
	}

	public void testManualFTPDefaultSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = (urlVal.isValid("ftp://username:password@ftp.fakesite.org/"));
		if (result == false && printAllTestCases) {
			System.out.println("Test passed : testManualFTPDefaultSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualFTPDefaultSchemesAllowed");
		}
		assertEquals(result, false);
	}

	public void testManualgopherDefaultSchemesAllowed() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = (urlVal.isValid("gopher://spinaltap.micro.umn.edu/00/Weather/California/Los%20Angeles"));
		if (result == false && printAllTestCases) {
			System.out.println("Test passed : testManualgopherDefaultSchemesAllowed");

		} else {
			System.out.println("Test failed: testManualgopherDefaultSchemesAllowed");
		}
		assertEquals(result, false);
	}

	public void testManualgopherDefaultSchemesMailto() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = !(urlVal.isValid("gopher://spinaltap.micro.umn.edu/00/Weather/California/Los%20Angeles"));
		if (result && printAllTestCases) {
			System.out.println("Test passed : testManualgopherDefaultSchemesMailto");

		} else {
			System.out.println("Test failed: testManualgopherDefaultSchemesMailto");
		}
		assertEquals(result, true);
	}

	public void testManualFakeSchemeDefaultSchemesMailto() {
		UrlValidator urlVal = new UrlValidator();

		boolean result = !(urlVal.isValid("BooBooKittyScheme:booBoo@kitty.cat.meow"));
		if (result && printAllTestCases) {
			System.out.println("Test passed : testManualFakeSchemeDefaultSchemesMailto");

		} else {
			System.out.println("Test failed: testManualFakeSchemeDefaultSchemesMailto");
		}
		assertEquals(result, true);
	}

	public void testManualTestHttpOnlyHTTPSIsAllowdScheme() {
		String[] schemes = { "https" };
		UrlValidator urlVal = new UrlValidator(schemes);
		boolean result = (urlVal.isValid("ftp://foo.bar.com/"));
		if (result == false && printAllTestCases) {
			System.out.println("Test passed : testManualTestHttpOnlyHTTPSIsAllowdScheme");

		} else {
			System.out.println("Test failed: testManualTestHttpOnlyHTTPSIsAllowdScheme");
		}
		assertEquals(result, false);
	}

	public void testPartitionSchemeValid() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.google.com");
		assertTrue(actual);
	}

	public void testPartitionSchemeInvalidName() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("foo://www.google.com");
		assertFalse(actual);
	}

	public void testPartitionSchemeInvalidChars() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("%$://www.google.com");
		assertFalse(actual);
	}

	public void testPartitionSchemeInvalidSep() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http:/www.google.com");
		assertFalse(actual);
	}

	public void testPartitionSchemeNoScheme() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("www.google.com");
		assertTrue(actual);
	}

	public void testHostTypical() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.amazon.com");
		assertTrue(actual);
	}

	public void testHostShort() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://a.tv");
		assertTrue(actual);
	}

	public void testHostLong() {
		UrlValidator urlVal = new UrlValidator();
		String url = "http://a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.a.com";
		boolean actual = urlVal.isValid(url);
		// Limit 255 chars for hostname
		assertFalse(actual);
	}

	public void testHostIPValid() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://192.168.1.1");
		assertTrue(actual);
	}

	public void testHostIPInvalid1() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://256.255.255.255");
		assertFalse(actual);
	}

	public void testHostIPInvalid2() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://255.255.255");
		assertFalse(actual);
	}

	public void testPortSmall() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com:1");
		assertTrue(actual);
	}

	public void testPortMax() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com:65536");
		assertTrue(actual);
	}

	public void testPortMin() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com:0");
		assertTrue(actual);
	}

	public void testPortOverMax() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com:65536");
		assertFalse(actual);
	}

	public void testPortUnderMin() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com:-1");
		assertFalse(actual);
	}

	public void testSimpleQuery() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.google.com?id=100");
		assertTrue(actual);
	}

	public void testCompoundQuery() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.google.com?id=100?fname=Jane&lname=Doe");
		assertTrue(actual);
	}

	public void testInvalidQuery() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.google.com?id===1");
		assertFalse(actual);
	}

	public void testPortDecimal() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com:2.5");
		assertFalse(actual);
	}

	public void testPortLetter() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com:A");
		assertFalse(actual);
	}

	public void testPortJustColon() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com:");
		assertFalse(actual);
	}

	public void testPathSingle() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com/path");
		assertTrue(actual);
	}

	public void testPathInvalidSep() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com//path");
		assertFalse(actual);
	}

	public void testPathCompund() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com/path/to/file.txt");
		assertTrue(actual);
	}

	public void testPathOutofOrder() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com/path/file.txt/to");
		assertFalse(actual);
	}

	public void testPathNoPath() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.gooogle.com/");
		assertTrue(actual);
	}

	public void testOrderingValid() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("http://www.google.com:80/path/to/file.txt");
		assertTrue(actual);
	}

	public void testOrderingInValid() {
		UrlValidator urlVal = new UrlValidator();
		boolean actual = urlVal.isValid("www.google.com:80/path/to/file.txt/http://");
		assertFalse(actual);
	}

	public void testIsValid2() {
		Boolean expectedResult, actualResult, allTestsPassed = true;

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
		int ValidCharsarrayLen = 0;
		int ValidCharsarrayItem = 0;
		int len = 10;
		Random rand = new Random();
		boolean invalidUrl = false;
		boolean failTest;

		paths.put("www.google.com", true);
		paths.put("test.com", true);
		paths.put("test.tv", true);
		paths.put("255.255.255.255", true);
		paths.put("255.256.255.255", false);

		for (int i = 0; i < 100; i++) {
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
			shuffleControllers = i % 5;
			if (shuffleControllers == 0) { // randomize every 5 loops
				Collections.shuffle(ValidChars);
				Collections.shuffle(InValidChars);
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
			paths.put(item, !failTest);
		}
		return paths;
	}

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