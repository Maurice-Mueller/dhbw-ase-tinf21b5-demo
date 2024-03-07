package de.dhbw.wikientry;

import java.time.LocalDateTime;
import java.util.List;

public record WikiEntryRecord(
        long id,

        String content,
        // meta data
        String author,
        LocalDateTime created,
        LocalDateTime lastUpdated,

        List<WikiEntryRecord> links
) {

    public WikiEntryRecord(String content, String author) {
        this(WikiEntryRepository.getNextId(), content, author, LocalDateTime.now(), null, List.of());
    }

    public WikiEntryRecord() {
        this(WikiEntryRepository.getNextId(), "Test", "Maurice", LocalDateTime.now(), null, List.of());
    }

    public WikiEntryRecord copyWithLastUpdated(LocalDateTime lastUpdated) {
        return new WikiEntryRecord(
                this.id(),
                this.content(),
                this.author(),
                this.created(),
                LocalDateTime.now(),
                this.links());
    }
}
