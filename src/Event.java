/*    */ import java.util.ArrayList;
/*    */ 
/*    */ public class Event
/*    */   implements Comparable
/*    */ {
/*    */   ArrayList<Patient> activePatients;
/*    */   Frame toFrame;
/*    */   Frame fromFrame;
/*    */   int time;
/*    */ 
/*    */   public int getTime()
/*    */   {
/* 10 */     return this.time;
/*    */   }
/*    */ 
/*    */   public Frame getFromFrame() {
/* 14 */     return this.fromFrame;
/*    */   }
/*    */ 
/*    */   public Frame getToFrame() {
/* 18 */     return this.toFrame;
/*    */   }
/*    */ 
/*    */   public ArrayList<Patient> getActivePatients() {
/* 22 */     return this.activePatients;
/*    */   }
/*    */ 
/*    */   public int compareTo(Object paramObject)
/*    */   {
/* 29 */     return this.time - ((Event)paramObject).time;
/*    */   }
/*    */ 
/*    */   public Event(ArrayList<Patient> paramArrayList, Frame paramFrame1, Frame paramFrame2, int paramInt) {
/* 33 */     this.activePatients = paramArrayList;
/* 34 */     this.toFrame = paramFrame1;
/* 35 */     this.fromFrame = paramFrame2;
/* 36 */     this.time = paramInt;
/*    */   }
/*    */ 
/*    */   public Event(Patient paramPatient, Frame paramFrame1, Frame paramFrame2, int paramInt) {
/* 40 */     this.activePatients = arrayWithPatient(paramPatient);
/* 41 */     this.toFrame = paramFrame1;
/* 42 */     this.fromFrame = paramFrame2;
/* 43 */     this.time = paramInt;
/*    */   }
/*    */ 
/*    */   private ArrayList<Patient> arrayWithPatient(Patient paramPatient) {
/* 47 */     ArrayList localArrayList = new ArrayList();
/* 48 */     localArrayList.add(paramPatient);
/* 49 */     return localArrayList;
/*    */   }
/*    */ }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     Event
 * JD-Core Version:    0.6.2
 */