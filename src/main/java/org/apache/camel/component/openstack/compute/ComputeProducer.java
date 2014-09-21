package org.apache.camel.component.openstack.compute;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.openstack4j.api.OSClient;
import org.openstack4j.model.compute.Server;
import org.openstack4j.model.compute.ServerCreate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Openstack producer.
 */
public class ComputeProducer extends DefaultProducer {
	private static final Logger LOG = LoggerFactory
			.getLogger(ComputeProducer.class);
	private ComputeEndpoint endpoint;

	public ComputeProducer(ComputeEndpoint endpoint) {
		super(endpoint);
		this.endpoint = endpoint;
	}

	public void process(Exchange exchange) throws Exception {
		OSClient osClient = endpoint.createOsClient();
		Object request = exchange.getIn().getBody();
		if(request instanceof ServerCreate) {
			Server server = osClient.compute().servers().boot((ServerCreate)request);
			exchange.getOut().setBody(server);
			LOG.debug("server: " + server.getId() + " ipv4: " + server.getAccessIPv4() + " status: " + server.getStatus());
		}
	}

}
