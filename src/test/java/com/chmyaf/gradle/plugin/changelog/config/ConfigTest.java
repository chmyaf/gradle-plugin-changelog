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
