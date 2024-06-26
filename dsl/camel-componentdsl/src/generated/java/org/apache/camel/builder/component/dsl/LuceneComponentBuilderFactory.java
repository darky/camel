/* Generated by camel build tools - do NOT edit this file! */
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
package org.apache.camel.builder.component.dsl;

import javax.annotation.processing.Generated;
import org.apache.camel.Component;
import org.apache.camel.builder.component.AbstractComponentBuilder;
import org.apache.camel.builder.component.ComponentBuilder;
import org.apache.camel.component.lucene.LuceneComponent;

/**
 * Perform inserts or queries against Apache Lucene databases.
 * 
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.ComponentDslMojo")
public interface LuceneComponentBuilderFactory {

    /**
     * Lucene (camel-lucene)
     * Perform inserts or queries against Apache Lucene databases.
     * 
     * Category: database,search
     * Since: 2.2
     * Maven coordinates: org.apache.camel:camel-lucene
     * 
     * @return the dsl builder
     */
    static LuceneComponentBuilder lucene() {
        return new LuceneComponentBuilderImpl();
    }

    /**
     * Builder for the Lucene component.
     */
    interface LuceneComponentBuilder extends ComponentBuilder<LuceneComponent> {
    
        /**
         * An Analyzer builds TokenStreams, which analyze text. It thus
         * represents a policy for extracting index terms from text. The value
         * for analyzer can be any class that extends the abstract class
         * org.apache.lucene.analysis.Analyzer. Lucene also offers a rich set of
         * analyzers out of the box.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.lucene.analysis.Analyzer&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param analyzer the value to set
         * @return the dsl builder
         */
        default LuceneComponentBuilder analyzer(org.apache.lucene.analysis.Analyzer analyzer) {
            doSetProperty("analyzer", analyzer);
            return this;
        }
    
        /**
         * A file system directory in which index files are created upon
         * analysis of the document by the specified analyzer.
         * 
         * The option is a: &lt;code&gt;java.io.File&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param indexDir the value to set
         * @return the dsl builder
         */
        default LuceneComponentBuilder indexDir(java.io.File indexDir) {
            doSetProperty("indexDir", indexDir);
            return this;
        }
    
        
        /**
         * Whether the producer should be started lazy (on the first message).
         * By starting lazy you can use this to allow CamelContext and routes to
         * startup in situations where a producer may otherwise fail during
         * starting and cause the route to fail being started. By deferring this
         * startup to be lazy then the startup failure can be handled during
         * routing messages via Camel's routing error handlers. Beware that when
         * the first message is processed then creating and starting the
         * producer may take a little time and prolong the total processing time
         * of the processing.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: false
         * Group: producer
         * 
         * @param lazyStartProducer the value to set
         * @return the dsl builder
         */
        default LuceneComponentBuilder lazyStartProducer(boolean lazyStartProducer) {
            doSetProperty("lazyStartProducer", lazyStartProducer);
            return this;
        }
    
        /**
         * An integer value that limits the result set of the search operation.
         * 
         * The option is a: &lt;code&gt;int&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param maxHits the value to set
         * @return the dsl builder
         */
        default LuceneComponentBuilder maxHits(int maxHits) {
            doSetProperty("maxHits", maxHits);
            return this;
        }
    
        /**
         * An optional directory containing files to be used to be analyzed and
         * added to the index at producer startup.
         * 
         * The option is a: &lt;code&gt;java.io.File&lt;/code&gt; type.
         * 
         * Group: producer
         * 
         * @param srcDir the value to set
         * @return the dsl builder
         */
        default LuceneComponentBuilder srcDir(java.io.File srcDir) {
            doSetProperty("srcDir", srcDir);
            return this;
        }
    
        
        /**
         * Whether autowiring is enabled. This is used for automatic autowiring
         * options (the option must be marked as autowired) by looking up in the
         * registry to find if there is a single instance of matching type,
         * which then gets configured on the component. This can be used for
         * automatic configuring JDBC data sources, JMS connection factories,
         * AWS Clients, etc.
         * 
         * The option is a: &lt;code&gt;boolean&lt;/code&gt; type.
         * 
         * Default: true
         * Group: advanced
         * 
         * @param autowiredEnabled the value to set
         * @return the dsl builder
         */
        default LuceneComponentBuilder autowiredEnabled(boolean autowiredEnabled) {
            doSetProperty("autowiredEnabled", autowiredEnabled);
            return this;
        }
    
        /**
         * To use a shared lucene configuration.
         * 
         * The option is a:
         * &lt;code&gt;org.apache.camel.component.lucene.LuceneConfiguration&lt;/code&gt; type.
         * 
         * Group: advanced
         * 
         * @param config the value to set
         * @return the dsl builder
         */
        default LuceneComponentBuilder config(org.apache.camel.component.lucene.LuceneConfiguration config) {
            doSetProperty("config", config);
            return this;
        }
    }

    class LuceneComponentBuilderImpl
            extends AbstractComponentBuilder<LuceneComponent>
            implements LuceneComponentBuilder {
        @Override
        protected LuceneComponent buildConcreteComponent() {
            return new LuceneComponent();
        }
        private org.apache.camel.component.lucene.LuceneConfiguration getOrCreateConfiguration(LuceneComponent component) {
            if (component.getConfig() == null) {
                component.setConfig(new org.apache.camel.component.lucene.LuceneConfiguration());
            }
            return component.getConfig();
        }
        @Override
        protected boolean setPropertyOnComponent(
                Component component,
                String name,
                Object value) {
            switch (name) {
            case "analyzer": getOrCreateConfiguration((LuceneComponent) component).setAnalyzer((org.apache.lucene.analysis.Analyzer) value); return true;
            case "indexDir": getOrCreateConfiguration((LuceneComponent) component).setIndexDir((java.io.File) value); return true;
            case "lazyStartProducer": ((LuceneComponent) component).setLazyStartProducer((boolean) value); return true;
            case "maxHits": getOrCreateConfiguration((LuceneComponent) component).setMaxHits((int) value); return true;
            case "srcDir": getOrCreateConfiguration((LuceneComponent) component).setSrcDir((java.io.File) value); return true;
            case "autowiredEnabled": ((LuceneComponent) component).setAutowiredEnabled((boolean) value); return true;
            case "config": ((LuceneComponent) component).setConfig((org.apache.camel.component.lucene.LuceneConfiguration) value); return true;
            default: return false;
            }
        }
    }
}