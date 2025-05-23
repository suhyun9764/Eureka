package ch18.ex3;

import java.io.*;

public class Test {
    // Buffer 보조 스트림
    public static void main(String[] args) throws Exception{
        // copy() 입출력 stream
        InputStream is = new FileInputStream("src/ch18/test.txt");
        OutputStream os = new FileOutputStream("src/ch18/test2.txt");

        // copy() 입출력 + buffer stream
        InputStream is2 = new FileInputStream("src/ch18/test.txt");
        OutputStream os2 = new FileOutputStream("src/ch18/test2.txt");
        BufferedInputStream bis = new BufferedInputStream(is2);
        BufferedOutputStream bos = new BufferedOutputStream(os2);

        long nonBufferTime = copy(is, os);
        System.out.println(nonBufferTime);

        long bufferTime = copy(bis, bos);
        System.out.println(bufferTime);

        is.close();
        os.close();

        bis.close();
        bos.close();
        is2.close();
        os2.close();

    }

    public static long copy(InputStream is, OutputStream os) throws Exception{
        long start = System.nanoTime();
        //복사
        while(true) {
            int data = is.read();
            if( data == -1 ) break;
            os.write(data);
        }

        long end = System.nanoTime();

        return end - start;
    }
}
