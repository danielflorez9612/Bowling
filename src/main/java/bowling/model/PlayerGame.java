package bowling.model;

import lombok.*;

import java.util.*;

@Data
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

    public void addFrame(Frame frame) {
        this.frames.add(frame);
    }

    public Optional<Frame> getLastFrame() {
        return this.frames.stream().max(Comparator.comparingInt(Frame::getFrameNumber));
    }

    public int getFrameCounter() {
        return frames.size();
    }
}
