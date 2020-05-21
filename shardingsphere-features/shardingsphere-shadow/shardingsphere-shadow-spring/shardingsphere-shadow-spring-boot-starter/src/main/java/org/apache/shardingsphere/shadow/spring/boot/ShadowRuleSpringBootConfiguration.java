/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.shadow.spring.boot;

import org.apache.shardingsphere.infra.yaml.config.YamlRuleConfiguration;
import org.apache.shardingsphere.shadow.spring.boot.condition.ShadowSpringBootCondition;
import org.apache.shardingsphere.shadow.yaml.config.YamlShadowRuleConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * Shadow rule configuration for spring boot.
 */
@Configuration
public class ShadowRuleSpringBootConfiguration {
    
    /**
     * Shadow YAML rule spring boot configuration.
     *
     * @return YAML rule configuration
     */
    @Bean
    @ConfigurationProperties(prefix = "spring.shardingsphere.rules.shadow")
    @ConditionalOnClass(YamlShadowRuleConfiguration.class)
    @Conditional(ShadowSpringBootCondition.class)
    public YamlRuleConfiguration shadow() {
        return new YamlShadowRuleConfiguration();
    }
}