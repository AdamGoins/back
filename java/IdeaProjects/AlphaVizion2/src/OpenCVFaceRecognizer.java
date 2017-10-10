
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacpp.opencv_core.Mat;
import org.bytedeco.javacpp.opencv_core.MatVector;
import org.bytedeco.javacpp.opencv_face;
import org.bytedeco.javacpp.opencv_objdetect;
import org.opencv.core.Core;
import org.opencv.core.MatOfRect;
import org.opencv.core.Size;
import org.opencv.imgproc.Imgproc;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.IntBuffer;

import static org.bytedeco.javacpp.opencv_core.CV_32SC1;
import static org.bytedeco.javacpp.opencv_core.compare;
import static org.bytedeco.javacpp.opencv_face.createFisherFaceRecognizer;
import static org.bytedeco.javacpp.opencv_face.createLBPHFaceRecognizer;
import static org.bytedeco.javacpp.opencv_imgcodecs.CV_LOAD_IMAGE_GRAYSCALE;
import static org.bytedeco.javacpp.opencv_imgcodecs.imdecode;
import static org.bytedeco.javacpp.opencv_imgcodecs.imread;

// import static org.bytedeco.javacpp.opencv_face.createEigenFaceRecognizer;
// import static org.bytedeco.javacpp.opencv_face.createLBPHFaceRecognizer;

/**
 * I couldn't find any tutorial on how to perform face recognition using OpenCV and Java,
 * so I decided to share a viable solution here. The solution is very inefficient in its
 * current form as the training model is built at each run, however it shows what's needed
 * to make it work.
 *
 * The class below takes two arguments: The path to the directory containing the training
 * faces and the path to the image you want to classify. Not that all images has to be of
 * the same size and that the faces already has to be cropped out of their original images
 * (Take a look here http://fivedots.coe.psu.ac.th/~ad/jg/nui07/index.html if you haven't
 * done the face detection yet).
 *
 * For the simplicity of this post, the class also requires that the training images have
 * filename format: <label>-rest_of_filename.png. For example:
 *
 * 1-jon_doe_1.png
 * 1-jon_doe_2.png
 * 2-jane_doe_1.png
 * 2-jane_doe_2.png
 * ...and so on.
 *
 * Source: http://pcbje.com/2012/12/doing-face-recognition-with-javacv/
 *
 * @author Petter Christian Bjelland
 */
public class OpenCVFaceRecognizer {

    String trainingDir = "src/image_database/";
    File root = new File(trainingDir);
    //opencv_face.FaceRecognizer faceRecognizer = createFisherFaceRecognizer();
    //FaceRecognizer faceRecognizer = createEigenFaceRecognizer();
    opencv_face.FaceRecognizer faceRecognizer = createLBPHFaceRecognizer();
    opencv_objdetect.CascadeClassifier faceDetector = new opencv_objdetect.CascadeClassifier(FaceDetector.class.getResource("temp/haarcascade_frontalface_alt.xml").getPath().substring(1));
    MatOfRect faceDetections = new MatOfRect();


    File[] imageFiles;

    public OpenCVFaceRecognizer(){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);
        FilenameFilter imgFilter = new FilenameFilter() {
            public boolean accept(File dir, String name) {
                name = name.toLowerCase();
                return name.endsWith(".jpg") || name.endsWith(".pgm") || name.endsWith(".png");
            }
        };




        imageFiles = root.listFiles(imgFilter);
        MatVector images = new MatVector(imageFiles.length);

        Mat labels = new Mat(imageFiles.length, 1, CV_32SC1);
        IntBuffer labelsBuf = labels.createBuffer();
        int counter = 0;

        for (File image : imageFiles) {
            Mat img = imread(image.getAbsolutePath(), CV_LOAD_IMAGE_GRAYSCALE);
            int label = Integer.parseInt(image.getName().split("\\-")[0]);

            images.put(counter, img);

            labelsBuf.put(counter, label);

            counter++;
        }


        // FaceRecognizer faceRecognizer = createEigenFaceRecognizer();
        // FaceRecognizer faceRecognizer = createLBPHFaceRecognizer()

        faceRecognizer.train(images, labels);

    }

    public String recognize(int index){



        Mat testImage = imread("src/current_faces/" + index + "-Image.png", CV_LOAD_IMAGE_GRAYSCALE);

        int predictedLabel = faceRecognizer.predict(testImage);
        String fileName = imageFiles[predictedLabel].getName();

        String label = fileName.substring(fileName.indexOf("-") + 1, fileName.lastIndexOf("."));
        //String label = fileName.substring(0, fileName.lastIndexOf("."));
        System.out.println("Predicted Label: " + label);

        return label;
    }
}
