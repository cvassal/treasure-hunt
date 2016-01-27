package domain.board;

import lombok.Value;

@Value
public class Size {
    private int x;
    private int y;

    public Size(int x, int y) throws Exception {
        if (x < 1 || y < 1) {
            throw new Exception("Board size must not be under 1 x 1");
        }
        this.x = x;
        this.y = y;
    }
}
