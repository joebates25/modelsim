import java.text.NumberFormat;
import java.util.LinkedList;

/*     */
/*     */

public abstract class Frame {
    Model parentModel;
    int cost = 0;
    int capacity = 0;
    int processed = 0;

    String name = "";

    int totalCost = 0;
    public LinkedList<Patient> patients;

    public void setParentModel(Model paramModel)
/*     */   {
/*  11 */     this.parentModel = paramModel;
/*     */   }

    public String getName() {
        if (this.name.equalsIgnoreCase("")) {
            return "[]";
        }
        return this.name;
    }

    public void setName(String paramString) {
/*  26 */     this.name = paramString;
/*     */   }

    public int getTotalCost()
/*     */   {
/*  32 */     return this.totalCost;
/*     */   }

    public void setTotalCost(int paramInt) {
/*  36 */     this.totalCost = paramInt;
/*     */   }

    public Frame() {
        this.patients = new LinkedList();
    }

    public LinkedList<Patient> getPatients()
/*     */   {
/*  47 */     return this.patients;
/*     */   }

    public void setPatients(LinkedList<Patient> paramLinkedList) {
/*  51 */     this.patients = paramLinkedList;
/*     */   }

    public int getCost()
/*     */   {
/*  57 */     return this.cost;
/*     */   }

    public void setCost(int paramInt) {
/*  61 */     this.cost = paramInt;
/*     */   }

    public int getCapacity() {
/*  65 */     return this.capacity;
/*     */   }

    public void setCapacity(int paramInt) {
/*  69 */     this.capacity = paramInt;
/*     */   }

    public int getNumPatients() {
        return this.patients.size();
    }

    public void recievePatient(Patient paramPatient) {
    }

    public boolean canSendPatient() {
        if (this.patients.size() > 0) {
            return true;
        }
        return false;
    }

    public boolean isSource() {
        return false;
    }

    public boolean isSink() {
        return false;
    }

    public boolean isStandard() {
        return false;
    }

    public boolean isDecision() {
        return false;
    }


    public void sendPatient() {
    }

    public void printFrameStatus() {
        System.out.println("Frame: " + getName());
        System.out.println("    Cost: " + NumberFormat.getCurrencyInstance().format(this.cost) + "  Capacity: " + NumberFormat.getNumberInstance().format(this.capacity));

        System.out.println("    Total patients processed: " + this.processed);
        System.out.println("    Simulated Cost: " + this.totalCost);
        System.out.println("");
    }
}

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     Frame
 * JD-Core Version:    0.6.2
 */