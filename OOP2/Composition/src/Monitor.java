public class Monitor {

    private String model;
    private String manufacturer;
    private int size;
    //Composition- Resolution class is a part of a monitor,
    // but monitor isn't resolution but it has a resolution
    // basically resolution is a component of a monitor.
    // The monitor has a resolution, which is the native resoluton
    private Resolution nativeResolution;

    public Monitor(String model, String manufacturer, int size, Resolution nativeResolution) {
        this.model = model;
        this.manufacturer = manufacturer;
        this.size =size;
        this.nativeResolution = nativeResolution;
    }

    public void drawPixelAt(int x, int y, String color) {
        System.out.println("Drawing picture at " + x + "," + y + " in color " + color);
    }

    public String getModel() {
        return model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public int getSize() {
        return size;
    }

    public Resolution getNativeResolution() {
        return nativeResolution;
    }
}
