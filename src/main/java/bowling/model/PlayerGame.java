package bowling.model;

import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Comparator;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Getter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class PlayerGame {
    @EqualsAndHashCode.Include
    private Player player;
    @Setter(value = AccessLevel.PRIVATE)
    private Set<Frame> frames;


    public PlayerGame(Player player) {
        this.player = player;
        this.frames = new LinkedHashSet<>();
    }

    public PlayerGame addFrame(Frame frame) {
        this.frames.add(frame);
        return this;
    }

    public Optional<Frame> getLastFrame() {
        return this.frames.stream().max(Comparator.comparingInt(Frame::getFrameNumber));
    }

    public int getFrameCounter() {
        return frames.size();
    }
}
