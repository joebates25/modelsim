/*    */ public class SinkFrame extends Frame
/*    */ {
/*    */   public SinkFrame()
/*    */   {
/*  8 */     setCapacity(2147483647);
/*    */   }
/*    */ 
/*    */   public SinkFrame(SinkFrame paramSinkFrame) {
/* 12 */     setCapacity(2147483647);
/* 13 */     this.name = paramSinkFrame.name;
/*    */   }
/*    */ 
/*    */   public void requestPatient(Frame paramFrame)
/*    */   {
/*    */   }
/*    */ 
/*    */   public void recievePatient(Patient paramPatient)
/*    */   {
/* 22 */     this.processed += 1;
/*    */   }
/*    */ 
/*    */   public boolean isSink() {
/* 26 */     return true;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 30 */     return String.format("Name: SINK %s", new Object[] { this.name });
/*    */   }
/*    */ }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     SinkFrame
 * JD-Core Version:    0.6.2
 */