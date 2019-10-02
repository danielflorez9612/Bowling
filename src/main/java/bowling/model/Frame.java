package bowling.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

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
}
