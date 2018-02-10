package A1Q2S;

/**
 * Tests the IntegralImage class.
 * @author jameselder
 */
public class testIntegralImage {

    public static void main(String[] args) {
        int[][] image1 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] image2 = {{7, 6}, {1}, {9, 11, 3}};
        int top,bottom,left,right;
        double mean;

        IntegralImage integralImage1;
        top = 1;
        bottom = 2;
        left = 0;
        right = 1;

        //test case 1//
       System.out.println("Test case 1:");
       try {
            integralImage1 = new IntegralImage(image1);
        } catch (InvalidImageException iix) {
            System.out.println("Invalid Image Exception");
            return;
        }
        try {
            mean = integralImage1.meanSubImage(top, bottom, left, right); //should be 6.0
            System.out.println("The mean of the subimage from (" + top + "," + left + ") to (" + bottom + "," + right + ") is " + mean);
        } catch (BoundaryViolationException bvx) {
            System.out.println("Index out of range.");
        } catch (NullSubImageException nsix) {
            System.out.println("Null sub-image.");
        }

        //test case 2//
       System.out.println("Test case 2:");
        top = 0;
        bottom = 1;
        left = 0;
        right = 2;

        try {
            mean = integralImage1.meanSubImage(top, bottom, left, right); //should be 3.5
            System.out.println("The mean of the subimage from (" + top + "," + left + ") to (" + bottom + "," + right + ") is " + mean);
        } catch (BoundaryViolationException bvx) {
            System.out.println("Index out of range.");
         } catch (NullSubImageException nsix) {
            System.out.println("Null sub-image.");
        }

        // test case 3//
       System.out.println("Test case 3:");
        top = 1;
        bottom = 2;
        left = 2;
        right = 1;

       try {
            mean = integralImage1.meanSubImage(top, bottom, left, right); //should throw exception
            System.out.println("The mean of the subimage from (" + top + "," + left + ") to (" + bottom + "," + right + ") is " + mean);
        } catch (BoundaryViolationException bvx) {
            System.out.println("Index out of range.");
        } catch (NullSubImageException nsix) {
            System.out.println("Null sub-image.");
        }

        // test case 4//
       System.out.println("Test case 4:");
        top = 5;
        bottom = 7;
        left = 6;
        right = 8;

       try {
            mean = integralImage1.meanSubImage(top, bottom, left, right); // should throw exception
            System.out.println("The mean of the subimage from (" + top + "," + left + ") to (" + bottom + "," + right + ") is " + mean);
         } catch (BoundaryViolationException bvx) {
            System.out.println("Index out of range.");
        } catch (NullSubImageException nsix) {
            System.out.println("Null sub-image.");
        }


        // test case 5//
       System.out.println("Test case 5:");
        top = -5;
        bottom = 7;
        left = -6;
        right = 8;

        try {
            mean = integralImage1.meanSubImage(top, bottom, left, right); //should be 45.0
            System.out.println("The mean of the subimage from (" + top + "," + left + ") to (" + bottom + "," + right + ") is " + mean);
        } catch (BoundaryViolationException bvx) {
            System.out.println("Index out of range.");
         } catch (NullSubImageException nsix) {
            System.out.println("Null sub-image.");
        }


        // test case 6//
       System.out.println("Test case 6:");
        try {
            integralImage1 = new IntegralImage(image2); //should throw exception
        } catch (InvalidImageException iix) {
            System.out.println("Invalid Image Exception");
            return;
        }

    }
}
