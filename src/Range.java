/*    */ public class Range
/*    */ {
/*    */   double[] values;
/*    */   int current;
/*    */   int size;
/*    */ 
/*    */   public Range(double[] paramArrayOfDouble)
/*    */   {
/* 13 */     this.current = 0;
/* 14 */     this.values = paramArrayOfDouble;
/* 15 */     this.size = paramArrayOfDouble.length;
/*    */   }
/*    */ 
/*    */   public int getSize() {
/* 19 */     return this.size;
/*    */   }
/*    */ 
/*    */   public double get() {
/* 23 */     if (this.current >= this.values.length) {
/* 24 */       this.current = 0;
/* 25 */       return this.values[this.current];
/*    */     }
/* 27 */     this.current += 1;
/* 28 */     return this.values[(this.current - 1)];
/*    */   }
/*    */ 
/*    */   public String toString()
/*    */   {
/* 36 */     return "[" + this.values.toString() + "]";
/*    */   }
/*    */ }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     Range
 * JD-Core Version:    0.6.2
 */