/*    */

public class SourceFrame extends Frame {
    int source = 0;
    int sent = 0;
    double opt;
    double treat;
    int arrivalRate;
    String nextFrame;

    public String getNextFrame()
/*    */   {
/*  8 */     return this.nextFrame;
/*    */   }

    public void setNextFrame(String paramString) {
/* 12 */     this.nextFrame = paramString;
/*    */   }

    public SourceFrame(int paramInt, double paramDouble1, double paramDouble2) {
        this.source = paramInt;
        this.opt = paramDouble1;
        this.treat = paramDouble2;
        for (int i = 0; i < paramInt; i++)
            this.patients.add(generatePatient());
    }

    public SourceFrame(SourceFrame paramSourceFrame) {
        this.source = paramSourceFrame.source;
        this.opt = paramSourceFrame.opt;
        this.treat = paramSourceFrame.treat;
        this.nextFrame = paramSourceFrame.nextFrame;
        for (int i = 0; i < this.source; i++)
            this.patients.add(generatePatient());
    }

    public void requestPatient(Frame paramFrame) {
        if (canSendPatient()) {
            paramFrame.recievePatient(generatePatient());
            this.sent += 1;
        }
    }

    public int getOriginalSource()
/*    */   {
/* 46 */     return this.source;
/*    */   }

    public boolean isSource() {
        return true;
    }

    public void startPull() {
    }

    public boolean canSendPatient() {
        return this.sent < this.source;
    }

    public Patient generatePatient() {
        return new Patient(RetinalSim.weightedProb(this.opt), RetinalSim.weightedProb(this.treat));
    }

    public void beginArrivals() {
        for (int i = 1; i < this.patients.size() + 1; i++)
            try {
                this.parentModel.getEventList().add(new Event((Patient) this.patients.get(i - 1), this.parentModel.getFrameWithName(this.nextFrame), this, i));
                this.processed += 1;
            } catch (Exception localException) {
                localException.printStackTrace();
            }
    }

    public int getNumPatients() {
        return this.source - this.sent;
    }

    public String toString() {
        return String.format("Name: %s  # of patients: %d ", new Object[]{this.name, Integer.valueOf(this.patients.size())});
    }
}

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     SourceFrame
 * JD-Core Version:    0.6.2
 */