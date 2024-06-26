/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
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
package org.apache.camel.language;

import java.util.Properties;

import org.apache.camel.CamelContext;
import org.apache.camel.ContextTestSupport;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.spi.Registry;
import org.junit.jupiter.api.Test;

public class BeanLanguageOGNLWithDotInParameterPropertyPlaceholderTest extends ContextTestSupport {

    @Test
    public void testDot() throws Exception {
        getMockEndpoint("mock:result").expectedMessageCount(1);
        getMockEndpoint("mock:result").expectedHeaderReceived("goto", "mock:MyAppV1.2.3/blah");

        template.sendBodyAndHeader("direct:start", "Hello World", "id", "blah");

        assertMockEndpointsSatisfied();
    }

    @Override
    protected Registry createCamelRegistry() throws Exception {
        Registry jndi = super.createCamelRegistry();
        jndi.bind("myBean", new MyDestinationBean());

        Properties myProp = new Properties();
        myProp.put("myApp", "MyAppV1.2.3");
        jndi.bind("myprop", myProp);

        return jndi;
    }

    @Override
    protected CamelContext createCamelContext() throws Exception {
        CamelContext context = super.createCamelContext();
        context.getPropertiesComponent().setLocation("ref:myprop");
        return context;
    }

    @Override
    protected RouteBuilder createRouteBuilder() {
        return new RouteBuilder() {
            @Override
            public void configure() {
                from("direct:start").setHeader("goto").simple("${bean:myBean.whereToMate({{myApp}}, ${header.id})}")
                        .to("mock:result");
            }
        };
    }

    public static class MyDestinationBean {

        public String whereToMate(String version, String id) {
            return "mock:" + version + "/" + id;
        }

    }
}
