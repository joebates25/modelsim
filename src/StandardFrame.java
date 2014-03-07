public class StandardFrame extends Frame {
    String nextFrame;

    public String getNextFrame()
/*    */   {
/*  6 */     return this.nextFrame;
/*    */   }

    public void setNextFrame(String paramString) {
/* 10 */     this.nextFrame = paramString;
/*    */   }

    public StandardFrame() {
    }

    public StandardFrame(StandardFrame paramStandardFrame) {
        this.cost = paramStandardFrame.cost;
        this.capacity = paramStandardFrame.capacity;
        this.nextFrame = paramStandardFrame.nextFrame;
        this.name = paramStandardFrame.name;
    }

    public void recievePatient(Patient paramPatient) {
        try {
            this.parentModel.eventList.add(new Event(paramPatient, this.parentModel.getFrameWithName(this.nextFrame), this, this.parentModel.time + 1));
            this.parentModel.totalCost += this.cost;
            this.processed += 1;
        } catch (Exception localException) {
            localException.printStackTrace();
        }
    }

    public boolean isStandard() {
        return true;
    }

    public String toString() {
        return String.format("Name: %s   Cost: %d, Capacity: %d   To Node: %s", new Object[]{this.name, Integer.valueOf(this.cost), Integer.valueOf(this.capacity), this.nextFrame});
    }
}
