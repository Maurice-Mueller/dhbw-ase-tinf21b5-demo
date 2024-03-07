package de.dhbw.wikientry;

import java.time.LocalDateTime;
import java.util.List;

public record WikiEntry(
        long id,

        String content,
        // meta data
        String author,
        LocalDateTime created,
        LocalDateTime lastUpdated,

        List<WikiEntry> links
) {

    public WikiEntry(String content, String author) {
        this(WikiEntryRepository.getNextId(), content, author, LocalDateTime.now(), null, List.of());
    }

    public WikiEntry() {
        this(WikiEntryRepository.getNextId(), "Test", "Maurice", LocalDateTime.now(), null, List.of());
    }

    public WikiEntry copyWithLastUpdated(LocalDateTime lastUpdated) {
        return new WikiEntry(
                this.id(),
                this.content(),
                this.author(),
                this.created(),
                lastUpdated,
                this.links());
    }
}
