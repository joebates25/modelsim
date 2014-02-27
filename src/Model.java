/*    */ import java.io.PrintStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.PriorityQueue;
/*    */ 
/*    */ public class Model
/*    */   implements Runnable
/*    */ {
/*    */   PriorityQueue<Event> eventList;
/*    */   int time;
/*    */   ArrayList<Frame> frames;
/*  9 */   public int totalCost = 0;
/*    */   public int totalPatients;
/*    */ 
/*    */   public PriorityQueue<Event> getEventList()
/*    */   {
/* 13 */     return this.eventList;
/*    */   }
/*    */ 
/*    */   public int getTime()
/*    */   {
/* 18 */     return this.time;
/*    */   }
/*    */ 
/*    */   public void setTime(int paramInt) {
/* 22 */     this.time = paramInt;
/*    */   }
/*    */ 
/*    */   public Model(ArrayList<Frame> paramArrayList) {
/* 26 */     this.eventList = new PriorityQueue();
/* 27 */     this.frames = paramArrayList;
/* 28 */     for (Frame localFrame : paramArrayList)
/* 29 */       localFrame.setParentModel(this);
/* 30 */     this.totalPatients = ((SourceFrame)paramArrayList.get(0)).getNumPatients();
/*    */   }
/*    */ 
/*    */   public void init() {
/* 34 */     for (Frame localFrame : this.frames) {
/* 35 */       localFrame.processed = 0;
/* 36 */       localFrame.totalCost = 0;
/*    */     }
/*    */   }
/*    */ 
/*    */   public Frame getFrameWithName(String paramString)
/*    */     throws Exception
/*    */   {
/* 43 */     for (Frame localFrame : this.frames) {
/* 44 */       if (localFrame.getName().equalsIgnoreCase(paramString))
/* 45 */         return localFrame;
/*    */     }
/* 47 */     throw new Exception(String.format("The node \"%s\" does not exist.", new Object[] { paramString }));
/*    */   }
/*    */ 
/*    */   public void run() {
/* 51 */     ((SourceFrame)this.frames.get(0)).beginArrivals();
/* 52 */     while (this.eventList.size() != 0) {
/* 53 */       Event localEvent = (Event)this.eventList.poll();
/* 54 */       this.time = localEvent.getTime();
/* 55 */       invoke(localEvent);
/*    */     }
/*    */   }
/*    */ 
/*    */   public void invoke(Event paramEvent)
/*    */   {
/* 61 */     paramEvent.toFrame.recievePatient((Patient)paramEvent.getActivePatients().get(0));
/*    */   }
/*    */ 
/*    */   public void reportResults()
/*    */   {
/* 66 */     System.out.println("Total Cost: " + this.totalCost);
/* 67 */     System.out.println("Total Time: " + this.time);
/* 68 */     for (Frame localFrame : this.frames) {
/* 69 */       if ((localFrame instanceof DecisionFrame)) {
/* 70 */         System.out.print(localFrame.name + " Processed: " + localFrame.processed);
/* 71 */         int i = ((DecisionFrame)localFrame).getAffirmativeSent();
/* 72 */         int j = ((DecisionFrame)localFrame).getNegatorySent();
/* 73 */         System.out.print(String.format("  Sent to %s: %d ~ Sent to %s: %d \n", new Object[] { ((DecisionFrame)localFrame).getAffirmativeNode(), Integer.valueOf(i), ((DecisionFrame)localFrame).getNegatoryNode(), Integer.valueOf(j) }));
/*    */       }
/*    */       else
/*    */       {
/* 77 */         System.out.println(localFrame.name + " Processed: " + localFrame.processed);
/*    */       }
/*    */     }
/* 80 */     System.out.println("\n");
/*    */   }
/*    */ }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     Model
 * JD-Core Version:    0.6.2
 */