/*
 * Copyright 2019 Andrey S Teplitskiy
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.chmyaf.gradle.plugin.changelog.config;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigTest {

    @Test
    public void testGetTemplates() {
        Config config = new Config();

        // Empty hash map.
        Map<String, ConfigTemplate> templates = new HashMap<>();
        assertEquals(config.getTemplates().size(), 0);
        assertEquals(config.getTemplates(), templates);
    }

    @Test
    public void testSetTemplates() {
        Config config = new Config();
        ConfigTemplate configTemplate = new ConfigTemplate();
        Map<String, ConfigTemplate> templates = new HashMap<>();

        configTemplate.setOutput("output");
        configTemplate.setRepo("repo");
        configTemplate.setTemplate("template");
        templates.put("key", configTemplate);
        config.setTemplates(templates);

        assertEquals(config.getTemplates().size(), 1);
        assertEquals(config.getTemplates(), templates);
        assertTrue(config.getTemplates().containsKey("key"));
        assertTrue(config.getTemplates().containsValue(configTemplate));
    }
}
