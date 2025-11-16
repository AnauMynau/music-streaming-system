package com.mss;


import com.mss.facade.music.app.AppFacade;
import com.mss.auth_factory.music.user.User;
import com.mss.auth_factory.music.user.UserTier;
import com.mss.catalog_builder.*;
import com.mss.playback_decorator.music.component.TrackStream;
import com.mss.recommend_strategy.music.repository.InMemoryTrackRepository;
import com.mss.recommend_strategy.music.repository.TrackRepository;
import com.mss.recommend_strategy.music.strategy.ByGenreStrategy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== MUSIC STREAMING SYSTEM DEMO ===\n");

        TrackRepository repo = new InMemoryTrackRepository();
        AppFacade app = new AppFacade(repo);

        User free = app.signup("Inayatulla", UserTier.FREE);
        User prem = app.signup("Sultan", UserTier.PREMIUM);
        System.out.println("Created user: " + free.getName() + " (FREE)");
        System.out.println("Created user: " + prem.getName() + " (PREMIUM)\n");

        Track t = app.search("Believer").get(0);
        System.out.println("Track created with Builder: " + t.getTitle() + " (" + t.getArtist().getName() + ", " + t.getGenre() + ")\n");

        System.out.println("Searching for track \"Believer\" through AppFacade...\n");

        System.out.println("-- Play as FREE --");
        TrackStream freeStream = app.play(free, t);
        System.out.println("Stream info: " + freeStream.info());
        System.out.println("Output: " + freeStream.readChunk() + "\n");

        TrackStream premStream = app.play(prem, t);
        System.out.println("Stream info: " + premStream.info());
        System.out.println("Output: " + premStream.readChunk() + "\n");

        System.out.println("Using strategy: ByGenreStrategy (\"alt-rock\")");
        app.recommend(prem, new ByGenreStrategy("alt-rock", repo))
                .forEach(track -> System.out.println("- " + track.getTitle()));
        System.out.println();

        System.out.println("Publishing ReleaseEvent(\"Whatever It Takes\")");
        app.publishNewRelease(new Track.Builder()
                .id("t3")
                .title("Whatever It Takes")
                .artist(new Artist("a1", "Imagine Dragons", "alt-rock"))
                .genre("alt-rock")
                .seconds(200)
                .build());
        System.out.println("\n=== END OF DEMO ===");
    }
}

