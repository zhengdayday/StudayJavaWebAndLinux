# java Io
* 磁盘操作: File
* 字节操作: InputStream 和 OutPutStream
* 字符操作: Reader 和 Writer
* 对象操作: Serializable
* 网络操作: Socket
* 新的输入/输出: NIO

# 磁盘操作
* File 类可以用于表示文件和目录信息，不表示文件的内容
* 递归列出一个目录下所有文件
```java
public static void listAllFiles(File dir) {
    if (dir == null || !dir.exitsts()) {
        return ;
    }
    if (dir.isFile()) {
        System.out.println(dir.getName);
    }
    for (File file : dir.listFiles) {
        listAllFiles(file);
    }
}
```
## 字节操作
* 实现文件复制
```java
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
```
## 字符操作
### 编码与解码
* 编码就是把字符转换为字节，解码就是把字节重新组合成字符
* GBK编码中，中文字符2个字节，英文字符一个字节
* UTF-8编码中，中文字符3个字节，英文字符一个字节
* UTF-16be编码中中文字符和英文字符都是两个字节
* java使用的爽字节编码UTF-16be
### String的编码方式
* String可以看成一个字符序列，可以指定一个编码方式将他编码为字节序列，也可以指定一个编码方式将一个字节序列解码为String
```java
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
    // 在调用无参数 getBytes() 方法时，默认的编码方式不是 UTF-16be。双字节编码的好处是可以使用一个 char 存储中文和英文，而将 String 转为 bytes[] 字节数组就不再需要这个好处，因此也就不再需要双字节编码。getBytes() 的默认编码方式与平台有关，一般为 UTF-8。
```
### Reader 与 Writer
* 不管是磁盘还是网络传输，最小的存储单元都是字节，而不是字符。但是在程序中操作的通常是字符形式的数据，因此需要提供对字符进行操作的方法
* InputStreamReader 实现字节流解码成字符流
* OutputStreamWriter实现字符流解码成为字节流
```java
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
```
## 对象操作
### 序列化
* 序列化就是将一个对象转换为字节序列，方便存储和传输
* 序列化: ObjectOutputStream.writeObject()
* 反序列化: ObjectInputStream.readObject()
* 不会对静态变量进行序列化，因为序列化只是保存对象的状态，静态变量属于类的状态
* Serializable接口它只是一个标准，没有任何方法需要实现，但是如果不去实现它的话而进行序列化，会抛出异常。
* transient关键字可以使一些属性不会被序列化

## 网络操作
* 


