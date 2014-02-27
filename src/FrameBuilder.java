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
            Frame localObject;
            if (this.type == "df") {
                localObject = new DecisionFrame();
                ((DecisionFrame)localObject).setName(this.name);
                ((DecisionFrame)localObject).setAffirmativeNode(this.affirmNode);
                ((DecisionFrame)localObject).setNegatoryNode(this.negNode);
                ((DecisionFrame)localObject).setCheckedVariable(this.checkedVar);
                ((DecisionFrame)localObject).setCost((int)this.cost.get());
                ((DecisionFrame)localObject).setCapacity((int)this.capacity.get());
                ((DecisionFrame)localObject).setSpecificity(this.specificity.get());
                ((DecisionFrame)localObject).setSensitivity(this.sensitivity.get());
                arrayOfFrame[j] = localObject;
            } else {
                localObject = new StandardFrame();
                ((StandardFrame)localObject).setName(this.name);
                ((StandardFrame)localObject).setNextFrame(this.nextNode);
                ((StandardFrame)localObject).setCost((int)this.cost.get());
                ((StandardFrame)localObject).setCapacity((int)this.capacity.get());
                arrayOfFrame[j] = localObject;
            }
        }
        return new FrameRange(arrayOfFrame);
    }

    public String getType()
/*     */   {
/*  58 */     return this.type;
/*     */   }

    public void setType(String paramString) {
/*  62 */     this.type = paramString;
/*     */   }

    public String getNextNode() {
/*  66 */     return this.nextNode;
/*     */   }

    public void setNextNode(String paramString) {
/*  70 */     this.nextNode = paramString;
/*     */   }

    public String getCheckedVar() {
/*  74 */     return this.checkedVar;
/*     */   }

    public void setCheckedVar(String paramString) {
/*  78 */     this.checkedVar = paramString;
/*     */   }

    public Range getCost() {
/*  82 */     return this.cost;
/*     */   }

    public void setCost(Range paramRange) {
/*  86 */     this.cost = paramRange;
/*     */   }

    public Range getCapacity() {
/*  90 */     return this.capacity;
/*     */   }

    public void setCapacity(Range paramRange) {
/*  94 */     this.capacity = paramRange;
/*     */   }

    public Range getSensitivity() {
/*  98 */     return this.sensitivity;
/*     */   }

    public void setSensitivity(Range paramRange) {
/* 102 */     this.sensitivity = paramRange;
/*     */   }

    public Range getSpecificity() {
/* 106 */     return this.specificity;
/*     */   }

    public void setSpecificity(Range paramRange) {
/* 110 */     this.specificity = paramRange;
/*     */   }

    public String getAffirmNode() {
/* 114 */     return this.affirmNode;
/*     */   }

    public void setAffirmNode(String paramString) {
/* 118 */     this.affirmNode = paramString;
/*     */   }

    public String getNegNode() {
/* 122 */     return this.negNode;
/*     */   }

    public void setNegNode(String paramString) {
/* 126 */     this.negNode = paramString;
/*     */   }

    public String getName() {
/* 130 */     return this.name;
/*     */   }

    public void setName(String paramString) {
/* 134 */     this.name = paramString;
/*     */   }

    public String toString() {
        return String.format("Name: %s", new Object[] { this.name });
    }
}

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     FrameBuilder
 * JD-Core Version:    0.6.2
 */