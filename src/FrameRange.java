/*    */ public class FrameRange
/*    */ {
/*    */   Frame[] frames;
/*    */   int current;
/*    */   int size;
/*    */ 
/*    */   public FrameRange(Frame[] paramArrayOfFrame)
/*    */   {
/* 13 */     this.current = 0;
/* 14 */     this.frames = paramArrayOfFrame;
/* 15 */     this.size = paramArrayOfFrame.length;
/*    */   }
/*    */ 
/*    */   public int getSize() {
/* 19 */     return this.size;
/*    */   }
/*    */ 
/*    */   public Frame get() {
/* 23 */     if (this.current >= this.frames.length) {
/* 24 */       this.current = 0;
/* 25 */       return this.frames[this.current];
/*    */     }
/* 27 */     this.current += 1;
/*    */ 
/* 30 */     return this.frames[(this.current - 1)];
/*    */   }
/*    */ }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     FrameRange
 * JD-Core Version:    0.6.2
 */