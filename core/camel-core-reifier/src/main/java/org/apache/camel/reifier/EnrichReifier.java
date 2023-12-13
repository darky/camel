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
package org.apache.camel.reifier;

import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.Expression;
import org.apache.camel.Processor;
import org.apache.camel.Route;
import org.apache.camel.model.EnrichDefinition;
import org.apache.camel.model.ProcessorDefinition;
import org.apache.camel.model.language.ConstantExpression;
import org.apache.camel.processor.Enricher;
import org.apache.camel.support.DefaultExchange;

public class EnrichReifier extends ExpressionReifier<EnrichDefinition> {

    public EnrichReifier(Route route, ProcessorDefinition<?> definition) {
        super(route, EnrichDefinition.class.cast(definition));
    }

    @Override
    public Processor createProcessor() throws Exception {
        boolean isShareUnitOfWork = parseBoolean(definition.getShareUnitOfWork(), false);
        boolean isIgnoreInvalidEndpoint = parseBoolean(definition.getIgnoreInvalidEndpoint(), false);
        boolean isAggregateOnException = parseBoolean(definition.getAggregateOnException(), false);

        Enricher enricher;
        if (definition.getExpression() instanceof ConstantExpression) {
            Expression exp = createExpression(definition.getExpression());
            Exchange ex = new DefaultExchange(camelContext);
            String uri = exp.evaluate(ex, String.class);
            enricher = new Enricher(exp, uri);
        } else {
            Expression exp = createExpression(definition.getExpression());
            String uri = definition.getExpression().getExpression();
            enricher = new Enricher(exp, uri);
        }

        enricher.setShareUnitOfWork(isShareUnitOfWork);
        enricher.setIgnoreInvalidEndpoint(isIgnoreInvalidEndpoint);
        enricher.setAggregateOnException(isAggregateOnException);
        Integer num = parseInt(definition.getCacheSize());
        if (num != null) {
            enricher.setCacheSize(num);
        }
        AggregationStrategy strategy = getConfiguredAggregationStrategy(definition);
        if (strategy != null) {
            enricher.setAggregationStrategy(strategy);
        }
        if (definition.getAggregateOnException() != null) {
            enricher.setAggregateOnException(parseBoolean(definition.getAggregateOnException(), false));
        }
        if (definition.getAllowOptimisedComponents() != null) {
            enricher.setAllowOptimisedComponents(parseBoolean(definition.getAllowOptimisedComponents(), true));
        }
        if (definition.getAutoStartComponents() != null) {
            enricher.setAutoStartupComponents(parseBoolean(definition.getAutoStartComponents(), true));
        }

        return enricher;
    }

}
