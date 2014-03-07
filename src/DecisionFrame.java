import java.util.Random;

/*     */

public class DecisionFrame extends Frame {
    double sensitivity;
    double specificity;
    String affirmativeNode;
    String negatoryNode;
    int affirmativeSent = 0;
    int negatorySent = 0;
    String checkedVariable;

    public String getCheckedVariable()
/*     */   {
/*  12 */     return this.checkedVariable;
/*     */   }

    public void setCheckedVariable(String paramString) {
/*  16 */     this.checkedVariable = paramString;
/*     */   }

    public String getAffirmativeNode()
/*     */   {
/*  22 */     return this.affirmativeNode;
/*     */   }

    public void setAffirmativeNode(String paramString) {
/*  26 */     this.affirmativeNode = paramString;
/*     */   }

    public String getNegatoryNode() {
/*  30 */     return this.negatoryNode;
/*     */   }

    public void setNegatoryNode(String paramString) {
/*  34 */     this.negatoryNode = paramString;
/*     */   }

    public double getSensitivity() {
/*  38 */     return this.sensitivity;
/*     */   }

    public void setSensitivity(double paramDouble) {
/*  42 */     this.sensitivity = paramDouble;
/*     */   }

    public double getSpecificity() {
/*  46 */     return this.specificity;
/*     */   }

    public void setSpecificity(double paramDouble) {
/*  50 */     this.specificity = paramDouble;
/*     */   }

    public DecisionFrame() {
    }

    public DecisionFrame(DecisionFrame paramDecisionFrame) {
        this.cost = paramDecisionFrame.cost;
        this.capacity = paramDecisionFrame.capacity;
        this.affirmativeNode = paramDecisionFrame.affirmativeNode;
        this.negatoryNode = paramDecisionFrame.negatoryNode;
        this.sensitivity = paramDecisionFrame.sensitivity;
        this.specificity = paramDecisionFrame.specificity;
        this.name = paramDecisionFrame.name;
        this.checkedVariable = paramDecisionFrame.checkedVariable;
    }

    public DecisionFrame(double paramDouble1, double paramDouble2) {
        this.sensitivity = paramDouble1;
        this.specificity = paramDouble2;
    }

    public boolean isDecision() {
        return true;
    }

    public void recievePatient(Patient paramPatient) {
        try {
            double d = new Random().nextInt(100);
            if (this.checkedVariable.equalsIgnoreCase("see_opt")) {
                if (paramPatient.needToSeeOpt) {
                    if (d / 100.0D < getSensitivity()) {
                        this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.affirmativeNode), this, this.parentModel.time + 1));
                        this.affirmativeSent += 1;
                    } else {
                        this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.negatoryNode), this, this.parentModel.time + 1));
                        this.negatorySent += 1;
                    }
                } else if (d / 100.0D < getSpecificity()) {
                    this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.negatoryNode), this, this.parentModel.time + 1));
                    this.negatorySent += 1;
                } else {
                    this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.affirmativeNode), this, this.parentModel.time + 1));
                    this.affirmativeSent += 1;
                }
            } else if (this.checkedVariable.equalsIgnoreCase("need-treat")) {
                if (paramPatient.needTreatment) {
                    if (d / 100.0D < getSensitivity()) {
                        this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.affirmativeNode), this, this.parentModel.time + 1));
                        this.affirmativeSent += 1;
                    } else {
                        this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.affirmativeNode), this, this.parentModel.time + 1));
                        this.affirmativeSent += 1;
                    }
                } else if (d / 100.0D < getSpecificity()) {
                    this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.negatoryNode), this, this.parentModel.time + 1));
                    this.negatorySent += 1;
                } else {
                    this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.affirmativeNode), this, this.parentModel.time + 1));
                    this.affirmativeSent += 1;
                }
            }

            this.parentModel.totalCost += this.cost;
            this.processed += 1;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public String toString() {
        return String.format("Name: %s Cost: %d, Capacity: %d   Sens: %f, Spec: %f   To Nodes: %s, %s", new Object[]{this.name, Integer.valueOf(this.cost), Integer.valueOf(this.capacity), Double.valueOf(this.sensitivity), Double.valueOf(this.specificity), this.affirmativeNode, this.negatoryNode});
    }

    public int getAffirmativeSent()
/*     */   {
/* 129 */     return this.affirmativeSent;
/*     */   }

    public int getNegatorySent() {
/* 133 */     return this.negatorySent;
/*     */   }
}

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     DecisionFrame
 * JD-Core Version:    0.6.2
 */