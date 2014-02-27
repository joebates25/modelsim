/*     */ import java.io.PrintStream;
/*     */ import java.text.NumberFormat;
/*     */ import java.util.LinkedList;
/*     */ 
/*     */ public abstract class Frame
/*     */ {
/*     */   Model parentModel;
/*  14 */   int cost = 0;
/*  15 */   int capacity = 0;
/*  16 */   int processed = 0;
/*     */ 
/*  29 */   String name = "";
/*     */ 
/*  39 */   int totalCost = 0;
/*     */   public LinkedList<Patient> patients;
/*     */ 
/*     */   public void setParentModel(Model paramModel)
/*     */   {
/*  11 */     this.parentModel = paramModel;
/*     */   }
/*     */ 
/*     */   public String getName()
/*     */   {
/*  19 */     if (this.name.equalsIgnoreCase("")) {
/*  20 */       return "[]";
/*     */     }
/*  22 */     return this.name;
/*     */   }
/*     */ 
/*     */   public void setName(String paramString) {
/*  26 */     this.name = paramString;
/*     */   }
/*     */ 
/*     */   public int getTotalCost()
/*     */   {
/*  32 */     return this.totalCost;
/*     */   }
/*     */ 
/*     */   public void setTotalCost(int paramInt) {
/*  36 */     this.totalCost = paramInt;
/*     */   }
/*     */ 
/*     */   public Frame()
/*     */   {
/*  42 */     this.patients = new LinkedList();
/*     */   }
/*     */ 
/*     */   public LinkedList<Patient> getPatients()
/*     */   {
/*  47 */     return this.patients;
/*     */   }
/*     */ 
/*     */   public void setPatients(LinkedList<Patient> paramLinkedList) {
/*  51 */     this.patients = paramLinkedList;
/*     */   }
/*     */ 
/*     */   public int getCost()
/*     */   {
/*  57 */     return this.cost;
/*     */   }
/*     */ 
/*     */   public void setCost(int paramInt) {
/*  61 */     this.cost = paramInt;
/*     */   }
/*     */ 
/*     */   public int getCapacity() {
/*  65 */     return this.capacity;
/*     */   }
/*     */ 
/*     */   public void setCapacity(int paramInt) {
/*  69 */     this.capacity = paramInt;
/*     */   }
/*     */ 
/*     */   public int getNumPatients() {
/*  73 */     return this.patients.size();
/*     */   }
/*     */ 
/*     */   public void recievePatient(Patient paramPatient)
/*     */   {
/*     */   }
/*     */ 
/*     */   public boolean canSendPatient() {
/*  81 */     if (this.patients.size() > 0) {
/*  82 */       return true;
/*     */     }
/*  84 */     return false;
/*     */   }
/*     */   public boolean isSource() {
/*  87 */     return false; } 
/*  88 */   public boolean isSink() { return false; } 
/*  89 */   public boolean isStandard() { return false; } 
/*  90 */   public boolean isDecision() { return false; }
/*     */ 
/*     */ 
/*     */   public void sendPatient()
/*     */   {
/*     */   }
/*     */ 
/*     */   public void printFrameStatus()
/*     */   {
/*  99 */     System.out.println("Frame: " + getName());
/* 100 */     System.out.println("    Cost: " + NumberFormat.getCurrencyInstance().format(this.cost) + "  Capacity: " + NumberFormat.getNumberInstance().format(this.capacity));
/*     */ 
/* 103 */     System.out.println("    Total patients processed: " + this.processed);
/* 104 */     System.out.println("    Simulated Cost: " + this.totalCost);
/* 105 */     System.out.println("");
/*     */   }
/*     */ }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     Frame
 * JD-Core Version:    0.6.2
 */