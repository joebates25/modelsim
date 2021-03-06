import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;
import java.util.Scanner;

public class RetinalSim
 {
   public static void main(String[] args)
   {
     try
     {
       Scanner scanner;
         Model[] models = readInputFile(getInputFile());
           int i = 0;
           for (Model m : models) {
               m.init();
               m.run();

               System.out.printf("Model %d: \n", i);
               i++;
               m.reportResults();
           }
     } catch (Exception localException) { localException.printStackTrace(); }

   }

     private static String getInputFile() {
         Scanner scan = new Scanner(System.in);
         System.out.println("Sample files include input and input2");
         System.out.print("Input file name: ");
         String file = scan.next();
         scan.close();
         return file;

     }

     public static boolean weightedProb(double paramDouble)
   {
       return paramDouble * 100.0D > new Random().nextInt(100);

   }


   public static Model[] readInputFile(String fileName) {
     try {
       Scanner scanner;
       if (fileName.equalsIgnoreCase("input")){
           scanner = new Scanner(RetinalSim.class.getClassLoader().getResourceAsStream("input"));
       } else if (fileName.equalsIgnoreCase("input2")){
           scanner = new Scanner(RetinalSim.class.getClassLoader().getResourceAsStream("input2"));
       } else {
           scanner = new Scanner(new File(fileName));
       }
       ModelBuilder mb = new ModelBuilder();
       while (scanner.hasNext()) {
         String identifier = scanner.next();
         if (identifier.equalsIgnoreCase("source")) {
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
           if (((String)identifier).equalsIgnoreCase("df")) {
             frameBuilder = new FrameBuilder();
             frameBuilder.setType("df");
             frameBuilder.setName(scanner.next());
             String checked_var = scanner.next();
             if ((!checked_var.equalsIgnoreCase("see_opt")) && (!checked_var.equalsIgnoreCase("need-treat")))
               throw new Exception("\"" + checked_var + "\" is an invalid variable. Must use \"see_opt\" or \"need-treat\".");
             frameBuilder.setCheckedVar(checked_var);
             frameBuilder.setSensitivity(getRangeFromDouble(scanner));
             frameBuilder.setSpecificity(getRangeFromDouble(scanner));
             frameBuilder.setCost(getRangeFromDouble(scanner));
             frameBuilder.setCapacity(getRangeFromDouble(scanner));
             frameBuilder.setAffirmNode(scanner.next());
             frameBuilder.setNegNode(scanner.next());
             FrameRange frameRange = frameBuilder.buildFrames();
             mb.add(frameRange);
             System.out.println("NODE PROCESSED: " + frameBuilder.name);
           } else if (((String)identifier).equalsIgnoreCase("sf")) {
             frameBuilder = new FrameBuilder();
             frameBuilder.setType("sf");
             frameBuilder.setName(scanner.next());
             frameBuilder.setCost(getRangeFromDouble(scanner));
             frameBuilder.setCapacity(getRangeFromDouble(scanner));
             frameBuilder.setNextNode(scanner.next());
             FrameRange fr = frameBuilder.buildFrames();
             mb.add(fr);
             System.out.println("NODE PROCESSED: " + frameBuilder.name);
           } else if (identifier.equalsIgnoreCase("sink")) {
             SinkFrame sink = new SinkFrame();
             sink.setName(scanner.next());
             mb.addSink(sink);
             System.out.println("NODE PROCESSED: " + sink.name);
           } else {
             throw new Exception("The term \"" + identifier + "\" is not a valid identifier. Must use source, sink, sf, or df.");
           }
         }
       }
       System.out.println("Creating models...");
       Model[] models = mb.buildModels();
       System.out.println(models.length + " models created. Beginning simulations now.");
       scanner.close();
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

     private static double[] getStepValues(double low, double high, double step) {
         int i = (int) ((high - low) / step);
         double[] arrayOfDouble = new double[i];
     for (int j = 0; j < i; j++) {
         arrayOfDouble[j] = (low + step * j);
     }
     return arrayOfDouble;
   }
 }