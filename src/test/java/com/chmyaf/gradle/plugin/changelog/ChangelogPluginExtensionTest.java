package com.chmyaf.gradle.plugin.changelog;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangelogPluginExtensionTest {
    @Test
    public void testChangelogPluginExtensionTest() {
        ChangelogPluginExtension clpe = new ChangelogPluginExtension();

        assertEquals(clpe.config, "config.yml");
        assertEquals(clpe.history, "history.yml");
        assertEquals(clpe.inputDir, "changelogs");
    }
}