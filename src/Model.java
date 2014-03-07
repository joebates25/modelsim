import java.util.ArrayList;
import java.util.PriorityQueue;

/*    */
/*    */

public class Model
   implements Runnable
 {
   PriorityQueue<Event> eventList;
   int time;
   ArrayList<Frame> frames;
   public int totalCost = 0;
   public int totalPatients;

   public PriorityQueue<Event> getEventList()
   {
     return this.eventList;
   }

   public int getTime()
   {
     return this.time;
   }

   public void setTime(int paramInt) {
     this.time = paramInt;

   }

   public Model(ArrayList<Frame> paramArrayList) {
     this.frames = paramArrayList;

   }

     public Model() {
         this.frames = new ArrayList<Frame>();

     }

     public void addFrame(Frame f) {
         this.frames.add(f);
     }

     public void init() {

         this.eventList = new PriorityQueue<Event>();
         for (Frame localFrame : this.frames) {
             localFrame.setParentModel(this);
             localFrame.processed = 0;
       localFrame.totalCost = 0;
             this.totalPatients = ((SourceFrame) frames.get(0)).getNumPatients();
         }
   }

   public Frame getFrameWithName(String paramString)
     throws Exception
   {
     for (Frame localFrame : this.frames) {
       if (localFrame.getName().equalsIgnoreCase(paramString))
         return localFrame;
     }
     throw new Exception(String.format("The node \"%s\" does not exist.", new Object[] { paramString }));
   }

   public void run() {
     ((SourceFrame)this.frames.get(0)).beginArrivals();
     while (this.eventList.size() != 0) {
       Event localEvent = (Event)this.eventList.poll();
       this.time = localEvent.getTime();
       invoke(localEvent);
     }
   }

   public void invoke(Event paramEvent)
   {
     paramEvent.toFrame.recievePatient((Patient)paramEvent.getActivePatients().get(0));
   }

   public void reportResults()
   {
     System.out.println("Total Cost: " + this.totalCost);
     System.out.println("Total Time: " + this.time);
     for (Frame localFrame : this.frames) {
       if ((localFrame instanceof DecisionFrame)) {
         System.out.print(localFrame.name + " Processed: " + localFrame.processed);
         int i = ((DecisionFrame)localFrame).getAffirmativeSent();
         int j = ((DecisionFrame)localFrame).getNegatorySent();
         System.out.print(String.format("  Sent to %s: %d ~ Sent to %s: %d \n", new Object[] { ((DecisionFrame)localFrame).getAffirmativeNode(), Integer.valueOf(i), ((DecisionFrame)localFrame).getNegatoryNode(), Integer.valueOf(j) }));
       }
       else
       {
         System.out.println(localFrame.name + " Processed: " + localFrame.processed);
       }
     }
     System.out.println("\n");
   }
 }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     Model
 * JD-Core Version:    0.6.2
 */