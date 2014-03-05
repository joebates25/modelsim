public class FrameBuilder
{
    String type;
    String nextNode;
    String checkedVar;
    Range cost;
    Range capacity;
    Range sensitivity;
    Range specificity;
    String affirmNode;
    String negNode;
    String name;

    public FrameRange buildFrames()
    {
        int i = 0;
        if (this.type == "df") {
            i = Math.max(i, this.sensitivity.getSize());
            i = Math.max(i, this.specificity.getSize());
        }
        i = Math.max(i, this.cost.getSize());
        i = Math.max(i, this.capacity.getSize());
        Frame[] arrayOfFrame = new Frame[i];
        for (int j = 0; j < i; j++)
        {
            Frame frame;
            if (this.type == "df") {
                frame = new DecisionFrame();
                ((DecisionFrame)frame).setName(this.name);
                ((DecisionFrame)frame).setAffirmativeNode(this.affirmNode);
                ((DecisionFrame)frame).setNegatoryNode(this.negNode);
                ((DecisionFrame)frame).setCheckedVariable(this.checkedVar);
                ((DecisionFrame)frame).setCost((int)this.cost.get());
                ((DecisionFrame)frame).setCapacity((int)this.capacity.get());
                ((DecisionFrame)frame).setSpecificity(this.specificity.get());
                ((DecisionFrame)frame).setSensitivity(this.sensitivity.get());
                arrayOfFrame[j] = frame;
            } else {
                frame = new StandardFrame();
                ((StandardFrame)frame).setName(this.name);
                ((StandardFrame)frame).setNextFrame(this.nextNode);
                ((StandardFrame)frame).setCost((int)this.cost.get());
                ((StandardFrame)frame).setCapacity((int)this.capacity.get());
                arrayOfFrame[j] = frame;
            }
        }
        return new FrameRange(arrayOfFrame);
    }

    public String getType()
   {
     return this.type;
   }

    public void setType(String paramString) {
    this.type = paramString;
  }

    public String getNextNode() {
     return this.nextNode;
   }

    public void setNextNode(String paramString) {
     this.nextNode = paramString;
   }

    public String getCheckedVar() {
    return this.checkedVar;
  }

    public void setCheckedVar(String paramString) {
     this.checkedVar = paramString;
   }

    public Range getCost() {
     return this.cost;
   }

    public void setCost(Range paramRange) {
    this.cost = paramRange;
  }

    public Range getCapacity() {
     return this.capacity;
   }

    public void setCapacity(Range paramRange) {
    this.capacity = paramRange;
  }

    public Range getSensitivity() {
     return this.sensitivity;
   }

    public void setSensitivity(Range paramRange) {
    this.sensitivity = paramRange;
  }

    public Range getSpecificity() {
     return this.specificity;
   }

    public void setSpecificity(Range paramRange) {
     this.specificity = paramRange;
   }

    public String getAffirmNode() {
     return this.affirmNode;
   }

    public void setAffirmNode(String paramString) {
     this.affirmNode = paramString;
   }

    public String getNegNode() {
    return this.negNode;
  }

    public void setNegNode(String paramString) {
     this.negNode = paramString;
   }

    public String getName() {
    return this.name;
  }

    public void setName(String paramString) {
    this.name = paramString;
   }

    public String toString() {
        return String.format("Name: %s", new Object[] { this.name });
    }
}

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     FrameBuilder
 * JD-Core Version:    0.6.2
 */