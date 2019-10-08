package bowling.model;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;

@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@AllArgsConstructor
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
