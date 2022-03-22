package devoxx.lab.hexagonalarchitecture.courtage.application.quarkus;

import com.github.tomakehurst.wiremock.WireMockServer;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class BourseApiMock {
	private static final String AAPL_QUOTE_RESPONSE = "{" +
		"\"currency\": \"USD\"," +
		"\"exchange\": \"NMS\"," +
		"\"fullExchangeName\": \"NasdaqGS\"," +
		"\"shortName\": \"Apple Inc.\"," +
		"\"longName\": \"Apple Inc.\"," +
		"\"regularMarketPrice\": 166.795," +
		"\"symbol\": \"AAPL\"" +
		"}";
	private static final String EDF_QUOTE_RESPONSE = "{" +
		"\"currency\": \"EUR\"," +
		"\"exchange\": \"PAR\"," +
		"\"fullExchangeName\": \"Paris\"," +
		"\"shortName\": \"EDF\"," +
		"\"longName\": \"Electricité de France S.A.\"," +
		"\"regularMarketPrice\": 8.892," +
		"\"symbol\": \"EDF.PA\"" +
		"}";

	public static void main(String[] args) {
		WireMockServer wireMockServer = new WireMockServer(8090);
		wireMockServer.addStubMapping(
			get(urlEqualTo("/finance/quote/AAPL"))
				.willReturn(aResponse()
					.withStatus(200)
					.withHeader("Content-Type", "application/json")
					.withBody(AAPL_QUOTE_RESPONSE)).build());
		wireMockServer.addStubMapping(
			get(urlEqualTo("/finance/quote/EDF.PA"))
				.willReturn(aResponse()
					.withStatus(200)
					.withHeader("Content-Type", "application/json")
					.withBody(EDF_QUOTE_RESPONSE)).build());
		wireMockServer.start();
	}
}
