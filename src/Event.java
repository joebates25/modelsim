import java.util.ArrayList;

public class Event
        implements Comparable {
    ArrayList<Patient> activePatients;
    Frame toFrame;
    Frame fromFrame;
    int time;

    public int getTime()
/*    */   {
/* 10 */     return this.time;
/*    */   }

    public Frame getFromFrame() {
/* 14 */     return this.fromFrame;
/*    */   }

    public Frame getToFrame() {
/* 18 */     return this.toFrame;
/*    */   }

    public ArrayList<Patient> getActivePatients() {
/* 22 */     return this.activePatients;
/*    */   }

    public int compareTo(Object paramObject) {
        return this.time - ((Event) paramObject).time;
    }

    public Event(ArrayList<Patient> paramArrayList, Frame paramFrame1, Frame paramFrame2, int paramInt) {
        this.activePatients = paramArrayList;
        this.toFrame = paramFrame1;
        this.fromFrame = paramFrame2;
        this.time = paramInt;
    }

    public Event(Patient paramPatient, Frame paramFrame1, Frame paramFrame2, int paramInt) {
        this.activePatients = arrayWithPatient(paramPatient);
        this.toFrame = paramFrame1;
        this.fromFrame = paramFrame2;
        this.time = paramInt;
    }

    private ArrayList<Patient> arrayWithPatient(Patient paramPatient) {
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(paramPatient);
        return localArrayList;
    }
}

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     Event
 * JD-Core Version:    0.6.2
 */