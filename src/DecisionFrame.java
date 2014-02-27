/*     */ import java.util.PriorityQueue;
/*     */ import java.util.Random;
/*     */ 
/*     */ public class DecisionFrame extends Frame
/*     */ {
/*     */   double sensitivity;
/*     */   double specificity;
/*     */   String affirmativeNode;
/*     */   String negatoryNode;
/*   9 */   int affirmativeSent = 0; int negatorySent = 0;
/*     */   String checkedVariable;
/*     */ 
/*     */   public String getCheckedVariable()
/*     */   {
/*  12 */     return this.checkedVariable;
/*     */   }
/*     */ 
/*     */   public void setCheckedVariable(String paramString) {
/*  16 */     this.checkedVariable = paramString;
/*     */   }
/*     */ 
/*     */   public String getAffirmativeNode()
/*     */   {
/*  22 */     return this.affirmativeNode;
/*     */   }
/*     */ 
/*     */   public void setAffirmativeNode(String paramString) {
/*  26 */     this.affirmativeNode = paramString;
/*     */   }
/*     */ 
/*     */   public String getNegatoryNode() {
/*  30 */     return this.negatoryNode;
/*     */   }
/*     */ 
/*     */   public void setNegatoryNode(String paramString) {
/*  34 */     this.negatoryNode = paramString;
/*     */   }
/*     */ 
/*     */   public double getSensitivity() {
/*  38 */     return this.sensitivity;
/*     */   }
/*     */ 
/*     */   public void setSensitivity(double paramDouble) {
/*  42 */     this.sensitivity = paramDouble;
/*     */   }
/*     */ 
/*     */   public double getSpecificity() {
/*  46 */     return this.specificity;
/*     */   }
/*     */ 
/*     */   public void setSpecificity(double paramDouble) {
/*  50 */     this.specificity = paramDouble;
/*     */   }
/*     */ 
/*     */   public DecisionFrame() {
/*     */   }
/*     */ 
/*     */   public DecisionFrame(DecisionFrame paramDecisionFrame) {
/*  57 */     this.cost = paramDecisionFrame.cost;
/*  58 */     this.capacity = paramDecisionFrame.capacity;
/*  59 */     this.affirmativeNode = paramDecisionFrame.affirmativeNode;
/*  60 */     this.negatoryNode = paramDecisionFrame.negatoryNode;
/*  61 */     this.sensitivity = paramDecisionFrame.sensitivity;
/*  62 */     this.specificity = paramDecisionFrame.specificity;
/*  63 */     this.name = paramDecisionFrame.name;
/*  64 */     this.checkedVariable = paramDecisionFrame.checkedVariable;
/*     */   }
/*     */ 
/*     */   public DecisionFrame(double paramDouble1, double paramDouble2)
/*     */   {
/*  69 */     this.sensitivity = paramDouble1;
/*  70 */     this.specificity = paramDouble2;
/*     */   }
/*     */   public boolean isDecision() {
/*  73 */     return true;
/*     */   }
/*     */ 
/*     */   public void recievePatient(Patient paramPatient) {
/*     */     try {
/*  78 */       double d = new Random().nextInt(100);
/*  79 */       if (this.checkedVariable.equalsIgnoreCase("see_opt")) {
/*  80 */         if (paramPatient.needToSeeOpt) {
/*  81 */           if (d / 100.0D < getSensitivity()) {
/*  82 */             this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.affirmativeNode), this, this.parentModel.time + 1));
/*  83 */             this.affirmativeSent += 1;
/*     */           } else {
/*  85 */             this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.negatoryNode), this, this.parentModel.time + 1));
/*  86 */             this.negatorySent += 1;
/*     */           }
/*     */         }
/*  89 */         else if (d / 100.0D < getSpecificity()) {
/*  90 */           this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.negatoryNode), this, this.parentModel.time + 1));
/*  91 */           this.negatorySent += 1;
/*     */         } else {
/*  93 */           this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.affirmativeNode), this, this.parentModel.time + 1));
/*  94 */           this.affirmativeSent += 1;
/*     */         }
/*     */       }
/*  97 */       else if (this.checkedVariable.equalsIgnoreCase("need-treat")) {
/*  98 */         if (paramPatient.needTreatment) {
/*  99 */           if (d / 100.0D < getSensitivity()) {
/* 100 */             this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.affirmativeNode), this, this.parentModel.time + 1));
/* 101 */             this.affirmativeSent += 1;
/*     */           } else {
/* 103 */             this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.affirmativeNode), this, this.parentModel.time + 1));
/* 104 */             this.affirmativeSent += 1;
/*     */           }
/*     */         }
/* 107 */         else if (d / 100.0D < getSpecificity()) {
/* 108 */           this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.negatoryNode), this, this.parentModel.time + 1));
/* 109 */           this.negatorySent += 1;
/*     */         } else {
/* 111 */           this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.affirmativeNode), this, this.parentModel.time + 1));
/* 112 */           this.affirmativeSent += 1;
/*     */         }
/*     */       }
/*     */ 
/* 116 */       this.parentModel.totalCost += this.cost;
/* 117 */       this.processed += 1;
/*     */     } catch (Exception localException) {
/* 119 */       localException.printStackTrace();
/*     */     }
/*     */   }
/*     */ 
/*     */   public String toString() {
/* 124 */     return String.format("Name: %s Cost: %d, Capacity: %d   Sens: %f, Spec: %f   To Nodes: %s, %s", new Object[] { this.name, Integer.valueOf(this.cost), Integer.valueOf(this.capacity), Double.valueOf(this.sensitivity), Double.valueOf(this.specificity), this.affirmativeNode, this.negatoryNode });
/*     */   }
/*     */ 
/*     */   public int getAffirmativeSent()
/*     */   {
/* 129 */     return this.affirmativeSent;
/*     */   }
/*     */ 
/*     */   public int getNegatorySent() {
/* 133 */     return this.negatorySent;
/*     */   }
/*     */ }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     DecisionFrame
 * JD-Core Version:    0.6.2
 */