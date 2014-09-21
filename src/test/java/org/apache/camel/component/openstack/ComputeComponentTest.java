package org.apache.camel.component.openstack;


import org.apache.camel.Exchange;
import org.apache.camel.Produce;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.junit.Assert;
import org.junit.Test;
import org.openstack4j.api.Builders;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.compute.ServerCreate;

public class ComputeComponentTest extends CamelTestSupport {
	
	private static final String ENDPOINT = "{{ rest url }}:5000";
	private static final String USERNAME = "{{ username }}";
	private static final String PASSWORD = "{{ password }}";
	private static final String TENANT_NAME = "Consulting%20%E2%80%93%20Middleware%20Delivery";
	private static final String VERSION = "2";
	private static final String FLAVOR_ID = "487c8b94-ed78-4b71-8ec1-e5d7a4669707";
	private static final String IMAGE_ID = "732937b9-5278-4d1e-960b-fed4d574449c";

	@Produce
	ProducerTemplate producerTemplate;

	@Test
	public void testOpenstack() throws Exception {
		MockEndpoint mock = getMockEndpoint("mock:result");
		mock.expectedMinimumMessageCount(1);

		ServerCreate sc = Builders.server().name("Test")
				.flavor(FLAVOR_ID)
				.image(IMAGE_ID).build();
		producerTemplate.sendBody("direct:test", sc);

		assertMockEndpointsSatisfied();
		Exchange result = mock.getExchanges().get(0);
		Assert.assertTrue(result.getIn().getBody().getClass().getName().equals("org.openstack4j.openstack.compute.domain.NovaServer"));
		Server server = (Server)result.getIn().getBody();
		Assert.assertNotNull(server.getId());
	}

	@Override
	protected RouteBuilder createRouteBuilder() throws Exception {
		return new RouteBuilder() {
			public void configure() {
				from("direct:test")
						.to("openstack-compute://"+ENDPOINT+"?"
								+ "username="+USERNAME+"&password="+PASSWORD
								+ "&tenantName="+TENANT_NAME+"&version="+VERSION)
						.to("mock:result");
			}
		};
	}
}
