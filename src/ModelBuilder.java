import java.util.ArrayList;
/*    */ import java.util.Iterator;

public class ModelBuilder
{
  ArrayList<FrameRange> frames;
  SourceFrame source;
    ArrayList<SinkFrame> sinks;

    public ModelBuilder()
    {
        this.frames = new ArrayList();
        this.sinks = new ArrayList();
    }

    public void add(FrameRange paramFrameRange) {
        this.frames.add(paramFrameRange);
    }


    public Model[] buildModels() {
        int i = 0;
        for (FrameRange fr: frames){
            i = Math.max(i, fr.getSize());
        }
        Model[] models = new Model[i];
        for (int j = 0; j < models.length; j++) {
            ArrayList modelFrames = new ArrayList();
            modelFrames.add(new SourceFrame(this.source));
            for (FrameRange fr: frames)
            {
                Frame frame = fr.get();
                if (frame.isDecision())
                    modelFrames.add(new DecisionFrame((DecisionFrame)frame));
                else if (frame.isStandard())
                    modelFrames.add(new StandardFrame((StandardFrame)frame));
            }
            for (SinkFrame sink: sinks) {
                modelFrames.add(new SinkFrame(sink));
            }
            models[j] = new Model(modelFrames);
            ((SourceFrame)(models[j].frames.get(0))).setNextFrame(source.nextFrame);
            ((SourceFrame)(models[j].frames.get(0))).setParentModel(models[j]);
        }
        return models;
    }

    public void addSource(SourceFrame paramSourceFrame) {
        this.source = paramSourceFrame;

    }

    public void addSink(SinkFrame paramSinkFrame) {
        this.sinks.add(paramSinkFrame);
    }
}

/* Location:           /Users/josephbates/Desktop/ModelSim 2/ModelSim.jar
 * Qualified Name:     ModelBuilder
 * JD-Core Version:    0.6.2
 */