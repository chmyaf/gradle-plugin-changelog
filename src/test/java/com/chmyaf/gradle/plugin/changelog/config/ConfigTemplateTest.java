package com.chmyaf.gradle.plugin.changelog.config;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ConfigTemplateTest {
    @Test
    public void testGetOutput() {
        ConfigTemplate configTemplate = new ConfigTemplate();

        // Empty string.
        assertNotNull(configTemplate.getOutput());
        assertEquals(configTemplate.getOutput(), "");
    }

    @Test
    public void testGetRepo() {
        ConfigTemplate configTemplate = new ConfigTemplate();

        // Empty string.
        assertNotNull(configTemplate.getRepo());
        assertEquals(configTemplate.getRepo(), "");
    }

    @Test
    public void testGetTemplate() {
        ConfigTemplate configTemplate = new ConfigTemplate();

        // Empty string.
        assertNotNull(configTemplate.getTemplate());
        assertEquals(configTemplate.getTemplate(), "");
    }

    @Test
    public void testSetOutput() {
        ConfigTemplate configTemplate = new ConfigTemplate();

        // Unix-style paths.
        configTemplate.setOutput("output/path/nix");
        assertEquals(configTemplate.getOutput(), "output/path/nix");

        // Win-style paths.
        configTemplate.setOutput("C:\\output\\path\\win");
        assertEquals(configTemplate.getOutput(), "C:\\output\\path\\win");
    }

    @Test
    public void testSetRepo() {
        ConfigTemplate configTemplate = new ConfigTemplate();

        configTemplate.setRepo("repo url example");
        assertEquals(configTemplate.getRepo(), "repo url example");
    }

    @Test
    public void testSetTemplate() {
        ConfigTemplate configTemplate = new ConfigTemplate();

        configTemplate.setTemplate("template file example");
        assertEquals(configTemplate.getTemplate(), "template file example");
    }
}
