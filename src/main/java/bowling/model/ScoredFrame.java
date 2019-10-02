package bowling.model;

import lombok.Data;

import java.util.Objects;
import java.util.Optional;

@Data
public class ScoredFrame {
    private static final Integer STRIKE_SCORE = 10;
    private Frame frame;
    private Integer score;

    public ScoredFrame(Frame frame) {
        this.frame = frame;
    }

    public Integer totalScore() {
        return Optional.ofNullable(this.getFrame())
                .map(Frame::getTotalScore)
                .orElse(0)
                ;
    }

    public boolean isSpare() {
        return Objects.equals(this.frame.getTotalScore(), STRIKE_SCORE);
    }

    public boolean isStrike() {
        return Optional.ofNullable(frame).map(Frame::getFirstBall).filter(STRIKE_SCORE::equals).isPresent();
    }
}
