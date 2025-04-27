package ch18.ex4;


import java.io.*;

public class Test {
    // File
    public static void main(String[] args) {
        //File객체 생성
        // throws exception 필요
//        {
//            // folder
//            File dir = new File("src/ch18/ex4/images"); //  dir
//            System.out.println(dir.exists());   // false
//            if (!dir.exists()) {
//                dir.mkdir();
//            }
//
//            // file
//            File file = new File("src/ch18/ex4/myFile.txt");
//            System.out.println(file.exists());
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//        }
        // file write (char 기반)
        {
            File file = new File("src/ch18/ex4/myFile.txt");

//            try {
//                FileWriter fw = new FileWriter(file);   // close() 필요
//            }catch (IOException e){
//                e.printStackTrace();
//            }
//

            {
                String dir = "src"+File.separator+"ch18";
                String fileName = "image1.png";
                String tgtFileName = "copy_image1.png";
                File src = new File(dir,fileName);  //
                File tgt = new File(dir, tgtFileName);

                try(FileInputStream fileInputStream = new FileInputStream(src);
                    FileOutputStream fileOutputStream = new FileOutputStream(tgt)) {
                    int read;

                    while ((read=fileInputStream.read())!=-1)
                        fileOutputStream.write(read);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
