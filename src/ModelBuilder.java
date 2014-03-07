import com.rits.cloning.Cloner;

import java.util.ArrayList;
/*    */

public class ModelBuilder {
    ArrayList<FrameRange> frameRanges;
    SourceFrame source;
    ArrayList<SinkFrame> sinks;
    Cloner objectCloner;
    ArrayList<Model> models = new ArrayList<Model>();

    public ModelBuilder() {
        this.frameRanges = new ArrayList();
        this.sinks = new ArrayList();
        objectCloner = new Cloner();
    }

    public void add(FrameRange paramFrameRange) {
        this.frameRanges.add(paramFrameRange);
    }


    public Model[] buildModels() {
        Model m = new Model();
        buildModel(m, 0);
        assert (models.size() > 0);
        Model[] builtModels = new Model[models.size()];
        for (int i = 0; i < models.size(); i++) {
            builtModels[i] = models.get(i);
        }
        return builtModels;

    }

    private void buildModel(Model model, int index) {
        if (index == frameRanges.size()) {
            model.frames.add(0, objectCloner.deepClone(this.source));
            for (SinkFrame sink : sinks) {
                model.frames.add(objectCloner.deepClone(sink));
            }
            this.models.add(model);
        } else {
            for (Frame f : frameRanges.get(index).frames) {
                Model m = objectCloner.deepClone(model);
                m.addFrame(f);
                buildModel(m, index + 1);
            }
        }

    }

    public void addSource(SourceFrame paramSourceFrame) {
        this.source = paramSourceFrame;

    }

    public void addSink(SinkFrame paramSinkFrame) {
        this.sinks.add(paramSinkFrame);
    }
}