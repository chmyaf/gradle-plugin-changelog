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
