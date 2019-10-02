package bowling.model;

import lombok.Data;

@Data
public class ScoredFrame {
    private Frame frame;
    private Integer score;

    public ScoredFrame(Frame frame) {
        this.frame = frame;
    }
}
