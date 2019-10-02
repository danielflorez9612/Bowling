package bowling.model;

import lombok.Data;

import java.util.Objects;
import java.util.Optional;

@Data
public class ScoredFrame {
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

    public boolean isSpare(Integer strikeScore) {
        return Objects.equals(this.frame.getTotalScore(), strikeScore );
    }

    public boolean isStrike(Integer strikeScore) {
        return Optional.ofNullable(frame).map(Frame::getFirstBall).filter(strikeScore::equals).isPresent();
    }
}
