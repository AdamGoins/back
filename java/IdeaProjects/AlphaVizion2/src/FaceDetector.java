
import org.opencv.core.*;
import org.opencv.objdetect.CascadeClassifier;
import org.opencv.videoio.VideoCapture;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;

import static org.opencv.imgcodecs.Imgcodecs.imencode;
import static org.opencv.imgproc.Imgproc.drawMarker;
import static org.opencv.imgproc.Imgproc.putText;


public class FaceDetector extends javax.swing.JFrame {
///

    private DaemonThread myThread = null;
    int count = 0;
    VideoCapture webSource = null;
    Mat frame = new Mat();
    MatOfByte mem = new MatOfByte();
    CascadeClassifier faceDetector = new CascadeClassifier(FaceDetector.class.getResource("temp/haarcascade_frontalface_alt.xml").getPath().substring(1));
    ArrayList<CascadeClassifier> cascadeClassifiers = new ArrayList<>(5);
    MatOfRect faceDetections = new MatOfRect();
    ArrayList<MatOfRect> detectionsArray = new ArrayList<>();
    FrameSaver frameSaver = new FrameSaver();
    OpenCVFaceRecognizer faceRecognizer = new OpenCVFaceRecognizer();


///

    class DaemonThread implements Runnable {

        protected volatile boolean runnable = false;

        @Override
        public void run() {
            synchronized (this) {

                File[] cascades = new File("src/cascades/").listFiles();
                File[] faces = new File("src/current_faces/").listFiles();

                for(File file : faces){

                    file.delete();

                }

                for(int ii = 0; ii < cascades.length; ii++){
                    cascadeClassifiers.add(new CascadeClassifier(FaceDetector.class.getResource("cascades/" + cascades[ii].getName()).getPath().substring(1)));
                    detectionsArray.add(new MatOfRect());
                }

                while (runnable) {
                    if (webSource.grab()) {
                        try {
                            webSource.retrieve(frame);
                            Graphics g = jPanel1.getGraphics();
                            faceDetector.detectMultiScale(frame, faceDetections);


                            int index = 0;

                            for (Rect rectangle : faceDetections.toArray()) {

                                Mat faceMat = new Mat(frame, rectangle);
                                frameSaver.save(faceMat, index);  //WORKING CODE
                                //frameSaver.save(frame, index);
                                String label = faceRecognizer.recognize(index);

                                putText(frame, label, new Point(rectangle.x + (.20 * rectangle.width), rectangle.y), 1, 2 , new Scalar(124, 248, 0), 2);

                           //     Imgproc.rectangle(frame, new Point(rectangle.x, rectangle.y), new Point(rectangle.x + rectangle.width, rectangle.y + rectangle.height),
                           //             new Scalar(0, 255,0));



                                //  Point topLeft = new Point(rectangle.x, rectangle.y);
                              //  Point topRight = new Point(rectangle.width, rectangle.y);
                              //  Point bottomLeft = new Point(rectangle.x, rectangle.height);
                              //  Point bottomRight = new Point(rectangle.width, rectangle.height);

                                for(int i = 0; i < cascadeClassifiers.size(); i++){

                                    cascadeClassifiers.get(i).detectMultiScale(faceMat, detectionsArray.get(i));

                                    for (Rect rect : detectionsArray.get(i).toArray()) {


                                        Point midPoint = new Point(rect.x + rectangle.x + (.5 * rect.width), rect.y + rectangle.y + (.5 * rect.height));
                                        Point topRight = new Point(rect.width, rect.y);
                                        Point bottomLeft = new Point(rect.x, rect.height);
                                        Point bottomRight = new Point(rect.width, rect.height);



                                        drawMarker(frame, midPoint, new Scalar(0, 0, 255));
                                        //drawMarker(frame, topRight, new Scalar(0, 0, 255));
                                       // drawMarker(frame, bottomLeft, new Scalar(0, 0, 255));
                                       // drawMarker(frame, bottomRight, new Scalar(0, 0, 255));



                                     //   rectangle(frame, new Point(rect.x + rectangle.x, rect.y), new Point(rect.x + rect.width, rect.y + rect.height),
                                     //           new Scalar(0, 255, 0));

                                    }

                                    index++;
                                }

                            }

                            imencode(".bmp", frame, mem);
                            Image im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

                            BufferedImage buff = (BufferedImage) im;

                            if (g.drawImage(buff, 0, 0, getWidth(), getHeight()-150 , 0, 0, buff.getWidth(), buff.getHeight(), null)) {
                                if (runnable == false) {
                                    System.out.println("Paused ..... ");
                                    this.wait();
                                }
                            }

                        } catch (Exception ex) {
                            ex.printStackTrace();
                            System.out.println("Error");
                        }
                    }
                }
            }
        }
    }
/////////
    /**
     * Creates new form FaceDetection
     */
    public FaceDetector() {
        initComponents();
        System.out.println(FaceDetector.class.getResource("temp/haarcascade_frontalface_alt.xml").getPath().substring(1));
        frameSaver.formatImageDatabase();

/** THIS CODE HERE IS TO BE USED TO TRY AND SAVE IMAGE FILES BY FACES ONLY
 *

        //Mat frame = new Mat();
        MatOfByte mem = new MatOfByte();
        CascadeClassifier faceDetector = new CascadeClassifier(FaceDetector.class.getResource("temp/haarcascade_frontalface_alt.xml").getPath().substring(1));
        MatOfRect faceDetections = new MatOfRect();
        Mat image;

        File[] images = new File("src/image_database/").listFiles();
        Size size = new Size(640, 480);



        for (File file : images) {

            image = imread("src/image_database/" + file.getName());

            faceDetector.detectMultiScale(image, faceDetections);

            for (Rect rectangle : faceDetections.toArray()) {
                System.out.println("Writing to File " + file.getName());
                Mat faceMat = new Mat(image, rectangle);
                Imgproc.resize(faceMat, image, size);

                imwrite("src/image_database/" + file.getName(), image);
            }

        }* **/
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 376, Short.MAX_VALUE)
        );

        jButton1.setText("Start");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Pause");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addContainerGap())
                        .addGroup(layout.createSequentialGroup()
                                .addGap(255, 255, 255)
                                .addComponent(jButton1)
                                .addGap(86, 86, 86)
                                .addComponent(jButton2)
                                .addContainerGap(258, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1)
                                        .addComponent(jButton2))
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        myThread.runnable = false;            // stop thread
        jButton2.setEnabled(false);   // activate start button
        jButton1.setEnabled(true);     // deactivate stop button

        webSource.release();  // stop caturing fron cam


    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        webSource = new VideoCapture(0); // video capture from default cam
        myThread = new DaemonThread(); //create object of threat class
        Thread t = new Thread(myThread);
        t.setDaemon(true);
        myThread.runnable = true;
        t.start();                 //start thrad
        jButton1.setEnabled(false);  // deactivate start button
        jButton2.setEnabled(true);  //  activate stop button


    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        //String opencvpath = System.getProperty("user.dir") + "/files/";
        //String libPath = System.getProperty("java.library.path");
        //System.out.println(opencvpath);
        //System.out.println(libPath);
        //System.out.println(Core.NATIVE_LIBRARY_NAME);
        //System.load(opencvpath + Core.NATIVE_LIBRARY_NAME + ".dll");
        //System.out.println(Core.NATIVE_LIBRARY_NAME);

        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);


/** THIS CODE HERE IS TO BE USED TO TRY AND SAVE IMAGE FILES BY FACES ONLY
 *

        //Mat frame = new Mat();
        MatOfByte mem = new MatOfByte();
        CascadeClassifier faceDetector = new CascadeClassifier(FaceDetector.class.getResource("temp/haarcascade_frontalface_alt.xml").getPath().substring(1));
        MatOfRect faceDetections = new MatOfRect();
        Mat image;
        File[] images = new File("src/image_database/").listFiles();
        Size size = new Size(640, 480);



        for (File file : images) {

            image = imread("src/image_database/" + file.getName());

            faceDetector.detectMultiScale(image, faceDetections);

            for (Rect rectangle : faceDetections.toArray()) {
                if(rectangle.width < 640){
                    System.out.println("Writing to File " + file.getName());
                    Mat faceMat = new Mat(image, rectangle);
                    Imgproc.resize(faceMat, image, size);

                    imencode(".bmp", image, mem);
                    Image im = null;
                    try {


                        im = ImageIO.read(new ByteArrayInputStream(mem.toArray()));

                        BufferedImage buff = (BufferedImage) im;
                        ImageIO.write(buff, "PNG", new File("src/image_database/" + file.getName()));
                        //imwrite("src/image_database/" + file.getName(), image);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }



            }

        } * **/
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FaceDetector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FaceDetector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FaceDetector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FaceDetector.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FaceDetector().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}