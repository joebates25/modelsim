/*    */ public class ImageReaderApplicationFrame extends Frame
/*    */ {
/*  5 */   double sensitivity = 0.0D; double specificity = 0.0D;
/*    */ 
/*    */   public double getSensitivity()
/*    */   {
/*  9 */     return this.sensitivity;
/*    */   }
/*    */ 
/*    */   public void setSensitivity(double paramDouble) {
/* 13 */     this.sensitivity = paramDouble;
/*    */   }
/*    */ 
/*    */   public double getSpecificity() {
/* 17 */     return this.specificity;
/*    */   }
/*    */ 
/*    */   public void setSpecificity(double paramDouble) {
/* 21 */     this.specificity = paramDouble;
/*    */   }
/*    */ 
/*    */   public ImageReaderApplicationFrame(Frame paramFrame, double paramDouble1, double paramDouble2)
/*    */   {
/* 26 */     this.specificity = paramDouble1;
/* 27 */     this.sensitivity = paramDouble2;
/*    */   }
/*    */ }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     ImageReaderApplicationFrame
 * JD-Core Version:    0.6.2
 */