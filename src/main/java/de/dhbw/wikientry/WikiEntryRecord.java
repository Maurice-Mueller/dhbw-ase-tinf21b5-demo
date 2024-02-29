package de.dhbw.wikientry;

import java.time.LocalDateTime;
import java.util.List;

public record WikiEntryRecord(
        String content,

        // meta data
        String author,
        LocalDateTime created,
        LocalDateTime lastUpdated,

        List<WikiEntryRecord> links
) {

    public WikiEntryRecord(String content, String author) {
        this(content, author, LocalDateTime.now(), null, List.of());
    }

    public WikiEntryRecord() {
        this("Test", "Maurice", LocalDateTime.now(), null, List.of());
    }
}
