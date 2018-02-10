package A1Q2S;

/**
 * Represents an integer integral image, which allows the user to query the mean
 * value of an arbitrary rectangular subimage in O(1) time.  Uses O(n) memory,
 * where n is the number of pixels in the image.
 *
 * @author jameselder
 */
public class IntegralImage {

    private final int[][] integralImage;
    private final int imageHeight; // height of image (first index)
    private final int imageWidth; // width of image (second index)

    /**
     * Constructs an integral image from the given input image.  
     *
     * @author jameselder
     * @param image The image represented
     * @throws A1Q2S.InvalidImageException Thrown if input array is not rectangular
     */
    public IntegralImage(int[][] image) throws InvalidImageException {
        int[] imageRow;
        int integralValue;
        imageHeight = image.length;
        if (image.length > 0) {
            imageWidth = image[1].length;
        } else {
            imageWidth = 0;
        }

        integralImage = new int[imageHeight][imageWidth];
        for (int i = 0; i < imageHeight; i++) {
            imageRow = image[i];
            if (imageRow.length != imageWidth) {
                throw new InvalidImageException("Image is not rectangular");
            }
            for (int j = 0; j < imageWidth; j++) {
                integralValue = image[i][j];
                if (i > 0) {
                    integralValue += integralImage[i - 1][j];
                }
                if (j > 0) {
                    integralValue += integralImage[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    integralValue -= integralImage[i - 1][j - 1];
                }
                integralImage[i][j] = integralValue;
            }
        }
    }

    /**
     * Returns the mean value of the rectangular sub-image specified by the
     * top, bottom, left and right parameters. The sub-image should include
     * pixels in rows top and bottom and columns left and right.  For example,
     * top = 1, bottom = 2, left = 1, right = 2 specifies a 2 x 2 sub-image starting
     * at (top, left) coordinate (1, 1).  
     *
     * @author jameselder
     * @param top top row of sub-image
     * @param bottom bottom row of sub-image
     * @param left left column of sub-image
     * @param right right column of sub-image
     * @return 
     * @throws A1Q2S.BoundaryViolationException if image indices are out of range
     * @throws A1Q2S.NullSubImageException if top > bottom or left > right
     */
    public double meanSubImage(int top, int bottom, int left, int right) throws BoundaryViolationException, NullSubImageException {
        double mean;

        if (top < 0 || top > imageHeight - 1
                || bottom < 0 || bottom > imageHeight - 1
                || left < 0 || left > imageWidth - 1
                || right < 0 || right > imageWidth - 1) {
            throw new BoundaryViolationException("Index out of range.");
        } else if (top > bottom || left > right) {
            throw new NullSubImageException("Empty sub-image.");
        } else {
            mean = integralImage[bottom][right];
            if (top > 0) {
                mean -= integralImage[top - 1][right];
            }
            if (left > 0) {
                mean -= integralImage[bottom][left - 1];
            }
            if (top > 0 && left > 0) {
                mean += integralImage[top - 1][left - 1];
            }
            mean /= (bottom - top + 1) * (right - left + 1);
            return mean;
        }
    }
}
