package com.mss.facade.music.app;

import java.util.List;

import com.mss.factory_auth.music.factory.DefaultUserFactory;
import com.mss.factory_auth.music.user.User;
import com.mss.factory_auth.music.factory.UserFactory;
import com.mss.factory_auth.music.user.UserTier;
import com.mss.builder_catalog.Track;
import com.mss.strategy_recommend.music.repository.TrackRepository;
import com.mss.observer_notify.music.core.EventBus;
import com.mss.observer_notify.music.events.ReleaseEvent;
import com.mss.decorator_playback.music.concretecomponent.BasicStream;
import com.mss.decorator_playback.music.decorator.HdAudioDecorator;
import com.mss.decorator_playback.music.decorator.LyricsDecorator;
import com.mss.decorator_playback.music.component.TrackStream;
import com.mss.strategy_recommend.music.context.RecommendationContext;
import com.mss.strategy_recommend.music.strategy.RecommendationStrategy;

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
