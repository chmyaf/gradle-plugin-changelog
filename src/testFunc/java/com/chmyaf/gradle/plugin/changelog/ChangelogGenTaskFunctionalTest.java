package com.chmyaf.gradle.plugin.changelog;

import org.gradle.testkit.runner.BuildResult;
import org.gradle.testkit.runner.GradleRunner;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import static org.junit.jupiter.api.Assertions.*;

public class ChangelogGenTaskFunctionalTest {
    @TempDir
    public File testProjectDir;

    private void copyExampleProject() throws IOException {
        this.copyExampleProjectFile("build.gradle");
        new File(this.testProjectDir.getAbsolutePath(), "changelogs").mkdirs();
        this.copyExampleProjectFile("changelogs/config.yml");
        this.copyExampleProjectFile("changelogs/history.yml");
        this.copyExampleProjectFile("changelogs/example.md");
        this.copyExampleProjectFile("changelogs/exampleSecond.md");
        this.copyExampleProjectFile("changelogs/template_release.md");
    }

    private void copyExampleProjectFile(String fname) throws IOException {
        Path src;
        Path dst;

        ClassLoader classLoader = getClass().getClassLoader();
        URL resource = classLoader.getResource("changelogGenTask/" + fname);
        if (resource == null) {
            throw new FileNotFoundException("Can't get " + fname);
        }

        src = new File(resource.getFile()).toPath();
        dst = new File(this.testProjectDir, fname).toPath();

        Files.copy(src, dst, StandardCopyOption.REPLACE_EXISTING);
    }

    @Test
    public void testApply() throws IOException {
        this.copyExampleProject();

        BuildResult result = GradleRunner.create()
                .withProjectDir(this.testProjectDir)
                .withPluginClasspath()
                .withArguments("changelogGen")
                .build();

        assertEquals("SUCCESS", result.task(":changelogGen").getOutcome().toString());
    }
}
