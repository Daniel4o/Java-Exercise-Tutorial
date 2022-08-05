public class PaintJob {

    public static int getBucketCount(double width, double height, double areaPerBucket, int extraBuckets) {
        if (width <= 0 || height <=0 || areaPerBucket <= 0 || extraBuckets < 0) return -1;
        double area = width * height;
            double areaBucket = areaPerBucket * extraBuckets;
            int bucketsNeeded = 0;
            while(area>areaBucket) {
                areaBucket += areaPerBucket;
                bucketsNeeded++;
    }
            return bucketsNeeded;
    }

    public static int getBucketCount(double width, double height, double areaPerBucket) {
        if (width <= 0|| height <= 0|| areaPerBucket <= 0) return -1;
        double area = width * height;
        int totalBucketsNeeded = 0;
        double areaOfBuckets = 0;
        while(area> areaOfBuckets) {
            areaOfBuckets +=areaPerBucket;
            totalBucketsNeeded++;
        }
        return totalBucketsNeeded;
    }

    public static int getBucketCount(double area, double areaPerBucket) {
        if(area <=0 || areaPerBucket<= 0) return -1;
        double areaNeeded = 0;
        int numberOfBucketsNeeded = 0;
        while(area>areaNeeded) {
            areaNeeded += areaPerBucket;
            numberOfBucketsNeeded++;
        }
        return numberOfBucketsNeeded;
    }
}
