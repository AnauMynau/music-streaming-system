package com.mss.facade.music.app;

import java.util.List;

import com.mss.auth_factory.music.factory.DefaultUserFactory;
import com.mss.auth_factory.music.user.User;
import com.mss.auth_factory.music.factory.UserFactory;
import com.mss.auth_factory.music.user.UserTier;
import com.mss.catalog_builder.Track;
import com.mss.recommend_strategy.music.repository.TrackRepository;
import com.mss.notify_observer.music.core.EventBus;
import com.mss.notify_observer.music.events.ReleaseEvent;
import com.mss.playback_decorator.music.concretecomponent.BasicStream;
import com.mss.playback_decorator.music.decorator.HdAudioDecorator;
import com.mss.playback_decorator.music.decorator.LyricsDecorator;
import com.mss.playback_decorator.music.component.TrackStream;
import com.mss.recommend_strategy.music.context.RecommendationContext;
import com.mss.recommend_strategy.music.strategy.RecommendationStrategy;

public class AppFacade {
    private final UserFactory userFactory = new DefaultUserFactory();
    private final EventBus bus = new EventBus();
    private final TrackRepository tracks;

    public AppFacade(TrackRepository tracks) {
        this.tracks = tracks;
    }

    public User signup(String name, UserTier tier) {
        User u = userFactory.create(name, tier);
        bus.subscribe(u);
        return u;
    }

    public List<Track> search(String query) {
        return tracks.searchByTitle(query);
    }

    public TrackStream play(User u, Track t) {
        TrackStream s = new BasicStream(t);
        if (u.getTier() == UserTier.PREMIUM) {
            s = new HdAudioDecorator(new LyricsDecorator(s));
        }
        return s;
    }

    public List<Track> recommend(User u, RecommendationStrategy s) {
        return new RecommendationContext(s).recommend(u);
    }

    public void publishNewRelease(Track t) {
        bus.publish(new ReleaseEvent(t));
    }
}
