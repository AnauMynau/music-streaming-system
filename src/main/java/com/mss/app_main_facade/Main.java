package com.mss.app_main_facade;

import com.mss.auth_factory.User;
import com.mss.auth_factory.UserTier;
import com.mss.catalog_builder.Artist;
import com.mss.catalog_builder.InMemoryTrackRepository;
import com.mss.catalog_builder.Track;
import com.mss.catalog_builder.TrackRepository;
import com.mss.recommend_strategy.ByGenreStrategy;


public class Main {
    public static void main(String[] args) {
        TrackRepository repo = new InMemoryTrackRepository();
        AppFacade app = new AppFacade(repo);

        User free = app.signup("Aigerim", UserTier.FREE);
        User prem = app.signup("Yernar", UserTier.PREMIUM);

        Track t = app.search("Believer").get(0);

        System.out.println("-- Play as FREE --");
        System.out.println(app.play(free, t).readChunk());

        System.out.println("-- Play as PREMIUM --");
        System.out.println(app.play(prem, t).readChunk());

        System.out.println("-- Recommend by genre --");
        app.recommend(prem, new ByGenreStrategy("alt-rock", repo))
                .forEach(r -> System.out.println(r.getTitle()));

        System.out.println("-- New release (Observer) --");
        app.publishNewRelease(new Track.Builder()
                .id("t3")
                .title("Whatever It Takes")
                .artist(new Artist("a1", "Imagine Dragons", "alt-rock"))
                .genre("alt-rock")
                .seconds(200)
                .build());
    }
}
