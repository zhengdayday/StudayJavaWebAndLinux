package Java;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;


public class JavaIo {


   // 递归列出所有文件
    public static void listAllFiles(File dir) {
        if (dir == null && !dir.exists()) {
            return ;
        }
        if (dir.isFile()) {
            System.out.println(dir.getName());
            return;
        }
        for (File file : dir.listFiles()) {
            listAllFiles(file);
        }
    }

    // 文件复制
    public static  void copyFile(String src, String dist) {
        try {
            FileInputStream in = new FileInputStream(src);
            FileOutputStream out = new FileOutputStream(dist);
            byte[] buffer = new byte[20 * 1024];
            // read()最多读取buffer.length个字节
            // 返回是实际读取的个数
            // 返回-1 表示读取到eof，文件尾
            while (in.read(buffer, 0, buffer.length) != -1) {
                out.write(buffer);
            }
            in.close();
            out.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // String 编码
    public static void StringMethod() {
        String str1 = "中文";
        try {
            byte[] bytes = str1.getBytes("UTF-8");
            String str2 = new String(bytes, "UTF-8");
            System.out.println(str2);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }

    // 输出文本文件内容
    public static void readFileContent(String filePath) {
        try {
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while ((line = bufferedReader.readLine())  != null) {
               System.out.println(line);
            }
            // 装饰者模式使得 BufferedReader 组合了一个 Reader 对象
            // 在调用 BufferedReader 的 close() 方法时会去调用 Reader 的 close() 方法
            // 因此只要一个 close() 调用即可
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class A implements Serializable {
        private int x;
        private String y;

        A(int x, String y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "x = " + x + " " + "y = " + y;
        }
    }

    // 序列化反序列化
    public static void xuliehua() {
        A a1 = new A(123, "abc");
        String objectFile = "file/a1";
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(objectFile));
            objectOutputStream.writeObject(a1);
            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(objectFile));
            A a2 = (A) objectInputStream.readObject();
            objectInputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void urlUse() {
        try {
            URL url = new URL("http://www.baidu.com");

            /* 字节流 */
            InputStream is = url.openStream();
            /* 字符流 */
            InputStreamReader isr = new InputStreamReader(is, "utf-8");

            /*  提供缓存功能 */
            BufferedReader br = new BufferedReader(isr);

            String line;
            while( (line = br.readLine()) != null) {
                System.out.println(line);
            }
            br.close();


        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        urlUse();
    }
}
