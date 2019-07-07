package com.chmyaf.gradle.plugin.changelog.history;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class HistoryTest {

    @Test
    void getFirstRelease() {
        History history = new History();

        assertNotNull(history.getFirstRelease());
    }

    @Test
    void getReleases() {
        History history = new History();

        assertNotNull(history.getReleases());
    }

    @Test
    void getUnreleased() {
        History history = new History();

        assertNotNull(history.getUnreleased());
    }

    @Test
    void setFirstRelease() {
        History history = new History();
        HistoryRelease release = new HistoryRelease();

        history.setFirstRelease(release);

        assertEquals(history.getFirstRelease(), release);
    }

    @Test
    void setReleases() {
        History history = new History();
        List<HistoryRelease> releases = new ArrayList<>();
        HistoryRelease release = new HistoryRelease();

        releases.add(release);
        history.setReleases(releases);

        assertEquals(history.getReleases(), releases);
    }

    @Test
    void setUnreleased() {
        History history = new History();
        HistoryRelease release = new HistoryRelease();

        history.setUnreleased(release);

        assertEquals(history.getUnreleased(), release);
    }
}