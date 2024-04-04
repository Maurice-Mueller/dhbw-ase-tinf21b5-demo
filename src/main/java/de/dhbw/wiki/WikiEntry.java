package de.dhbw.wiki;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public record WikiEntry(
        UUID id,

        String content,
        // meta data
        String author,
        LocalDateTime created,
        LocalDateTime lastUpdated,

        List<WikiEntry> links
) {

    public WikiEntry(String content, String author) {
        this(UUID.randomUUID(), content, author, LocalDateTime.now(), null, List.of());
    }

    public WikiEntry() {
        this(UUID.randomUUID(), "Test", "Maurice", LocalDateTime.now(), null, List.of());
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
