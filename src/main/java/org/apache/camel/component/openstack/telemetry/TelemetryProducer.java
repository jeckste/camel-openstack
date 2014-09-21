package org.apache.camel.component.openstack.telemetry;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Openstack producer.
 */
public class TelemetryProducer extends DefaultProducer {
    private static final Logger LOG = LoggerFactory.getLogger(TelemetryProducer.class);
    private TelemetryEndpoint endpoint;

    public TelemetryProducer(TelemetryEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getBody());    
    }

}
