package bowling.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Optional;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Frame {
    @EqualsAndHashCode.Include
    private Integer frameNumber;
    private Integer firstBall;
    private Integer secondBall;

    public Frame(Integer frameNumber) {
        this.frameNumber = frameNumber;
    }
    public int getTotalScore() {
        return Optional.ofNullable(this.getFirstBall()).filter(integer -> integer>0).orElse(0) +
                Optional.ofNullable(this.getSecondBall()).filter(integer -> integer>0).orElse(0);
    }
}
