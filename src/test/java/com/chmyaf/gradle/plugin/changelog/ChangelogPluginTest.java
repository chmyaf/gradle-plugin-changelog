package com.chmyaf.gradle.plugin.changelog;

import org.gradle.api.Project;
import org.gradle.testfixtures.ProjectBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChangelogPluginTest {

    @Test
    void testApply() {
        String pluginId = "com.chmyaf.gradle.plugin.changelog";
        Project project = ProjectBuilder.builder().build();
        project.getPluginManager().apply(pluginId);

        assertTrue(project.getPluginManager().hasPlugin(pluginId));

        assertNotNull(project.getTasks().getByName("changelogGen"));
    }

}