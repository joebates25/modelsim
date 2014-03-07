public class SinkFrame extends Frame {
    public SinkFrame() {
        setCapacity(2147483647);
    }

    public SinkFrame(SinkFrame paramSinkFrame) {
        setCapacity(2147483647);
        this.name = paramSinkFrame.name;
    }

    public void recievePatient(Patient paramPatient) {
        this.processed += 1;
    }

    public boolean isSink() {
        return true;
    }

    public String toString() {
        return String.format("Name: SINK %s", new Object[]{this.name});
    }
}