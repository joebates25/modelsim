/*    */ import java.util.LinkedList;
/*    */ import java.util.PriorityQueue;
/*    */ 
/*    */ public class SourceFrame extends Frame
/*    */ {
/*  3 */   int source = 0; int sent = 0;
/*    */   double opt;
/*    */   double treat;
/*    */   int arrivalRate;
/*    */   String nextFrame;
/*    */ 
/*    */   public String getNextFrame()
/*    */   {
/*  8 */     return this.nextFrame;
/*    */   }
/*    */ 
/*    */   public void setNextFrame(String paramString) {
/* 12 */     this.nextFrame = paramString;
/*    */   }
/*    */ 
/*    */   public SourceFrame(int paramInt, double paramDouble1, double paramDouble2)
/*    */   {
/* 19 */     this.source = paramInt;
/* 20 */     this.opt = paramDouble1;
/* 21 */     this.treat = paramDouble2;
/* 22 */     for (int i = 0; i < paramInt; i++)
/* 23 */       this.patients.add(generatePatient());
/*    */   }
/*    */ 
/*    */   public SourceFrame(SourceFrame paramSourceFrame)
/*    */   {
/* 28 */     this.source = paramSourceFrame.source;
/* 29 */     this.opt = paramSourceFrame.opt;
/* 30 */     this.treat = paramSourceFrame.treat;
/* 31 */     this.nextFrame = paramSourceFrame.nextFrame;
/* 32 */     for (int i = 0; i < this.source; i++)
/* 33 */       this.patients.add(generatePatient());
/*    */   }
/*    */ 
/*    */   public void requestPatient(Frame paramFrame)
/*    */   {
/* 38 */     if (canSendPatient()) {
/* 39 */       paramFrame.recievePatient(generatePatient());
/* 40 */       this.sent += 1;
/*    */     }
/*    */   }
/*    */ 
/*    */   public int getOriginalSource()
/*    */   {
/* 46 */     return this.source;
/*    */   }
/*    */   public boolean isSource() {
/* 49 */     return true;
/*    */   }
/*    */ 
/*    */   public void startPull() {
/*    */   }
/*    */ 
/*    */   public boolean canSendPatient() {
/* 56 */     return this.sent < this.source;
/*    */   }
/*    */ 
/*    */   public Patient generatePatient() {
/* 60 */     return new Patient(RetinalSim.weightedProb(this.opt), RetinalSim.weightedProb(this.treat));
/*    */   }
/*    */ 
/*    */   public void beginArrivals() {
/* 64 */     for (int i = 1; i < this.patients.size() + 1; i++)
/*    */       try {
/* 66 */         this.parentModel.getEventList().add(new Event((Patient)this.patients.get(i - 1), this.parentModel.getFrameWithName(this.nextFrame), this, i));
/* 67 */         this.processed += 1;
/*    */       } catch (Exception localException) {
/* 69 */         localException.printStackTrace();
/*    */       }
/*    */   }
/*    */ 
/*    */   public int getNumPatients()
/*    */   {
/* 75 */     return this.source - this.sent;
/*    */   }
/*    */ 
/*    */   public String toString() {
/* 79 */     return String.format("Name: %s  # of patients: %d ", new Object[] { this.name, Integer.valueOf(this.patients.size()) });
/*    */   }
/*    */ }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     SourceFrame
 * JD-Core Version:    0.6.2
 */