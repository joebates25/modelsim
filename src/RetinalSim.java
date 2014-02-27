 import java.io.File;
/*     */ import java.io.FileNotFoundException;
/*     */ import java.io.PrintStream;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import java.util.Scanner;

 public class RetinalSim
 {
   public static void main(String[] args)
   {
     try
     {
       Scanner scanner;
       if (args[0].equalsIgnoreCase("-help")) {
         scanner = new Scanner(new File("README"));
         while (((Scanner)scanner).hasNextLine())
           System.out.println(((Scanner)scanner).nextLine());
       }
       else {
         Model[] models = readInputFile(args[0]);
         for (int i = 0; i < models.length; i++)
         {
           models[i].run();

           System.out.printf("Model %d: \n", new Object[] { Integer.valueOf(i) });
           models[i].reportResults();
         }
       }
     } catch (Exception localException) { localException.printStackTrace(); }

   }

   public static boolean weightedProb(double paramDouble)
   {
     double d = new Random().nextInt(100);
     if (paramDouble * 100.0D > d) {
       return true;
     }

     return false;
   }

   public static void printProgress(double paramDouble)
   {
     System.out.print("\r" + paramDouble + "%");
   }

   public static Model[] readInputFile(String fileName) {
     try {
       ModelBuilder mb = new ModelBuilder();
       ArrayList localArrayList = new ArrayList();
       Scanner scanner = new Scanner(new File(fileName));
       while (scanner.hasNext()) {
         String indentifier = scanner.next();
         if (((String)indentifier).equalsIgnoreCase("source")) {
           int i = scanner.nextInt();
           double d1 = scanner.nextDouble();
           double d2 = scanner.nextDouble();
           if ((d1 < 1.0D) && (d2 < 1.0D) && (d1 > 0.0D) && (d2 > 0.0D)) {
             String str = scanner.next();
             SourceFrame localSourceFrame = new SourceFrame(i, d1, d2);
             localSourceFrame.setNextFrame(str);
             mb.addSource(localSourceFrame);
           } else {
             throw new Exception("see_opt and need_treat must both be between 0 and 1");
           }
         }
         else
         {
           FrameBuilder frameBuilder;
           if (((String)indentifier).equalsIgnoreCase("df")) {
             frameBuilder = new FrameBuilder();
             frameBuilder.setType("df");
             frameBuilder.setName(scanner.next());
             String checked_var = scanner.next();
             if ((!((String)checked_var).equalsIgnoreCase("see_opt")) && (!((String)checked_var).equalsIgnoreCase("need-treat")))
               throw new Exception("\"" + (String)checked_var + "\" is an invalid variable. Must use \"see_opt\" or \"need-treat\".");
             frameBuilder.setCheckedVar((String) checked_var);
             frameBuilder.setSensitivity(getRangeFromDouble(scanner));
             frameBuilder.setSpecificity(getRangeFromDouble(scanner));
             frameBuilder.setCost(getRangeFromDouble(scanner));
             frameBuilder.setCapacity(getRangeFromDouble(scanner));
             frameBuilder.setAffirmNode(scanner.next());
             frameBuilder.setNegNode(scanner.next());
             FrameRange frameRange = frameBuilder.buildFrames();
             mb.add(frameRange);
             System.out.println("NODE PROCESSED: " + frameBuilder.name);
           } else if (((String)indentifier).equalsIgnoreCase("sf")) {
             frameBuilder = new FrameBuilder();
             frameBuilder.setType("sf");
             frameBuilder.setName(scanner.next());
             frameBuilder.setCost(getRangeFromDouble(scanner));
             frameBuilder.setCapacity(getRangeFromDouble(scanner));
             frameBuilder.setNextNode(scanner.next());
             FrameRange fr = frameBuilder.buildFrames();
             mb.add(fr);
             System.out.println("NODE PROCESSED: " + frameBuilder.name);
           } else if (((String)indentifier).equalsIgnoreCase("sink")) {
             SinkFrame sink = new SinkFrame();
             sink.setName(scanner.next());
             mb.addSink(sink);
             System.out.println("NODE PROCESSED: " + sink.name);
           } else {
             throw new Exception("The term \"" + (String)indentifier + "\" is not a valid identifier. Must use source, sink, sf, or df.");
           }
         }
       }
       Model[] models = mb.buildModels();
       System.out.println("0 total node(s) processed.");
       return models;
     } catch (FileNotFoundException localFileNotFoundException) {
       System.out.printf("Error: File named \"%s\" was not found. ", fileName);
     } catch (Exception localException) {
       System.out.println(localException.getMessage());
       System.exit(0);
     }
     return null;
   }

   private static Range getRangeFromDouble(Scanner paramScanner) {
     String str = paramScanner.next();
     if (str.charAt(0) == '[') {
       double d1 = Double.parseDouble(str.replace('[', ' ').replace(']', ' ').trim().split(":")[0]);
       double d2 = Double.parseDouble(str.replace('[', ' ').replace(']', ' ').trim().split(":")[1]);
       double d3 = Double.parseDouble(str.replace('[', ' ').replace(']', ' ').trim().split(":")[2]);
       double[] arrayOfDouble = getStepValues(d1, d3, d2);
       return new Range(arrayOfDouble);
     }
     return new Range(new double[] {Double.parseDouble(str)});
   }

   private static double[] getStepValues(double paramDouble1, double paramDouble2, double paramDouble3)
   {
     int i = (int)((paramDouble2 - paramDouble1) / paramDouble3);
     double[] arrayOfDouble = new double[i];
     for (int j = 0; j < i; j++) {
       arrayOfDouble[j] = (paramDouble1 + paramDouble3 * j);
     }
     return arrayOfDouble;
   }
 }

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     RetinalSim
 * JD-Core Version:    0.6.2
 */