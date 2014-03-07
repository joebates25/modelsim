public class FrameRange {
    Frame[] frames;
    int current;
    int size;

    public FrameRange(Frame[] paramArrayOfFrame) {
        this.current = 0;
        this.frames = paramArrayOfFrame;
        this.size = paramArrayOfFrame.length;
    }

    public int getSize() {
/* 19 */     return this.size;
/*    */   }

    public Frame get() {
        if (this.current >= this.frames.length) {
            this.current = 0;
            return this.frames[this.current];
        }
        this.current += 1;

        return this.frames[(this.current - 1)];
    }
}
