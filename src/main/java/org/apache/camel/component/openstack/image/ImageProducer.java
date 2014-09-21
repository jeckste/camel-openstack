package org.apache.camel.component.openstack.image;

import org.apache.camel.Exchange;
import org.apache.camel.impl.DefaultProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Openstack producer.
 */
public class ImageProducer extends DefaultProducer {
    private static final Logger LOG = LoggerFactory.getLogger(ImageProducer.class);
    private ImageEndpoint endpoint;

    public ImageProducer(ImageEndpoint endpoint) {
        super(endpoint);
        this.endpoint = endpoint;
    }

    public void process(Exchange exchange) throws Exception {
        System.out.println(exchange.getIn().getBody());    
    }

}
