
import org.opencv.core.*;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import static org.bytedeco.javacpp.opencv_face.createFisherFaceRecognizer;
import static org.opencv.imgcodecs.Imgcodecs.imencode;
import static org.opencv.imgcodecs.Imgcodecs.imread;
import static org.opencv.imgcodecs.Imgcodecs.imwrite;


public class FrameSaver {
///
    CascadeClassifier faceDetector = new CascadeClassifier(FaceDetector.class.getResource("temp/haarcascade_frontalface_alt.xml").getPath().substring(1));
    MatOfRect faceDetections = new MatOfRect();

///


    public static void main(String[] args){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);


    }

    public void formatImageDatabase(){

        File directory = new File("src/image_database/");

        for(File file : directory.listFiles()){

            try {


               // BufferedImage output = new BufferedImage(640,480, image.getType());
                Mat picMat = imread("src/image_database/" + file.getName());


                faceDetector.detectMultiScale(picMat, faceDetections);

                for(Rect rectangle : faceDetections.toArray()){
                    BufferedImage image = ImageIO.read(file);

                    Mat faceMat = new Mat(picMat, rectangle);

                    imwrite("src/image_database/" + file.getName(), faceMat);
                }


              //  ImageIO.write(output, "PNG", file);

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
    public void save(Mat frame, int index){

       // formatImageDatabase();
      //  Rect rectangle = new Rect(0, 0, 640,480);

      //  Mat image = new Mat();

       // Size size = new Size(640, 480);


        //Imgproc.resize(frame, image, size);
      //  if (webSource.grab()) {
            try {

              //  webSource.retrieve(frame);
             //   webSource.release();
                imwrite("src/current_faces/" + index + "-Image.png", frame);

            } catch (Exception ex) {
                ex.printStackTrace();
                System.out.println("Error");
            }
        }

      //  else{
      //      System.out.println("There");
      //  }


   // }
    public FrameSaver(){
    }

}