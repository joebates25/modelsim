/*    */ import java.util.PriorityQueue;
/*    */ 
/*    */ public class StandardFrame extends Frame
/*    */ {
/*    */   String nextFrame;
/*    */ 
/*    */   public String getNextFrame()
/*    */   {
/*  6 */     return this.nextFrame;
/*    */   }
/*    */ 
/*    */   public void setNextFrame(String paramString) {
/* 10 */     this.nextFrame = paramString;
/*    */   }
/*    */ 
/*    */   public StandardFrame()
/*    */   {
/*    */   }
/*    */ 
/*    */   public StandardFrame(StandardFrame paramStandardFrame)
/*    */   {
/* 21 */     this.cost = paramStandardFrame.cost;
/* 22 */     this.capacity = paramStandardFrame.capacity;
/* 23 */     this.nextFrame = paramStandardFrame.nextFrame;
/* 24 */     this.name = paramStandardFrame.name;
/*    */   }
/*    */ 
/*    */   public void recievePatient(Patient paramPatient) {
/*    */     try {
/* 29 */       this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.nextFrame), this, this.parentModel.time + 1));
/* 30 */       this.parentModel.totalCost += this.cost;
/* 31 */       this.processed += 1;
/*    */     } catch (Exception localException) {
/* 33 */       localException.printStackTrace();
/*    */     }
/*    */   }
/*    */ 
/* 37 */   public boolean isStandard() { return true; }
/*    */ 
/*    */   public String toString() {
/* 40 */     return String.format("Name: %s   Cost: %d, Capacity: %d   To Node: %s", new Object[] { this.name, Integer.valueOf(this.cost), Integer.valueOf(this.capacity), this.nextFrame });
/*    */   }
/*    */ }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     StandardFrame
 * JD-Core Version:    0.6.2
 */