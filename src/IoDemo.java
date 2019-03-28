
import java.io.*;
import java.util.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

public class IoDemo {
    //创建文件夹
    public static boolean mkDirectory(String path){
        File file = null;
        try{
            file = new File(path);
            if(!file.exists()){
                return file.mkdirs();
            }else{
                return false;
            }
        }catch (Exception e){
            System.out.println("创建文件夹函数异常！");
        }finally {
            file = null;
        }
        return false;
    }

    //创建文件
    public static boolean creatFile(String destFileName){
        File file = new File(destFileName);
        //判断文件或者文件夹是否存在
        if(file.exists()){
            System.out.println("创建失败，文件已存在！");
            return false;
        }
        //判断输入的文件路径是否以\\结束，用来判断是否为文件夹
        if(destFileName.endsWith(File.separator)){
            System.out.println("创建文件失败，目标文件不能是目录 ！");
            return false;
        }
        //判断目标文件所在的目录是否存在
        if(!file.getParentFile().exists()){
            //不存在则创建目录
            System.out.println("正准备创建目标的目录");
            if(!file.getParentFile().mkdirs()){
                System.out.println("目标所在的目录失败！");
                return false;
            }
        }
        //创建目标文件
        try{
            if(file.createNewFile()){
                System.out.println("创建文件成功！");
                return true;
            }else{
                System.out.println("创建文件失败！");
                return false;
            }
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("创建文件失败 " + e.getMessage());
            return false;
        }
    }

    //遍历文件夹所有文件
    public static void TraversFiles(String path){
        File file = new File(path);
        File[] fs = file.listFiles();
        for(File f:fs){
            //判断时候为目录，在递归遍历，注意文件很多时会出现溢出，采用消息队列比较合理
            if(f.isDirectory()){
                TraversFiles(f.toString());
            }
            if(f.isFile()){
                System.out.println(f);
            }
            //System.out.println(f);
        }
    }

    //写入字符串到文件中
    public static void WriteFile(String FilePath,String ContentStr){
        try{
            FileWriter f = new FileWriter(FilePath);
            f.write(ContentStr);
            f.close();
        }catch (Exception e){
            System.out.println("写入异常！");
        }
    }

    //读取文件中的内容
    public static void ReadFile(String FilePath){
        String OneLine;
        int Count = 0;
        try{
            FileReader file = new FileReader(FilePath);
            BufferedReader fileB = new BufferedReader(file);
            while((OneLine = fileB.readLine())!=null){
                Count++;
                System.out.println(OneLine);
            }
            System.out.println("\n 共读了" + Count + "行");
            fileB.close();
        }catch(Exception e){
            System.out.println("读取出错了！" + e);
        }
    }

    //文件压缩
    public static void zipFiles(File[] srcfile,File zipfile){
        byte[] buf = new byte[1024];
        try{
            //ZipOutputStream类，完成文件或文件夹的压缩
            ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipfile));
            for(int i =0;i<srcfile.length;i++){
                FileInputStream in = new FileInputStream(srcfile[i]);
                out.putNextEntry(new ZipEntry(srcfile[i].getName()));
                int len;
                while((len = in.read(buf)) > 0){
                    out.write(buf,0,len);
                }
                out.closeEntry();
                in.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //解压文件
    public static void unZipFiles(File zipfile,String descDir){
        try{
            ZipFile zf = new ZipFile(zipfile);
            for(Enumeration entries = zf.entries();entries.hasMoreElements();){
                ZipEntry entry = (ZipEntry) entries.nextElement();
                String zipEntryName = entry.getName();
                InputStream in = zf.getInputStream(entry);
                OutputStream out = new FileOutputStream(descDir + zipEntryName);
                byte[] buf1 = new byte[1024];
                int len;
                while((len = in.read(buf1)) > 0){
                    out.write(buf1,0,len);
                }
                in.close();
                out.close();
                System.out.println("解压缩完成。");
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }



    public static void main(String[] args){
        //获取当前程序运行路径
        String Path = System.getProperty("user.dir");
        //System.out.println(Path);

        //测试创建文件夹
//        String Dire = Path + "\\文件夹\\54\\ace";
//        if(mkDirectory(Dire)){
//            System.out.println("文件夹创建成功");
//        }else{System.out.println("文件夹创建失败，目录已存在");}

        //测试创建文件
//        String FileName = Path + "\\文件夹\\test.bat";
//        creatFile(FileName);

        //测试遍历目录
//        String TestDir = Path + "\\文件夹\\";
//        TraversFiles(TestDir);

        //测试写入文件
//        String FilePath = Path + "\\文件夹\\test.bat";
//        String Content = "最近你还好吗？\n" + "我说：\"我很好\" \n\t\tNice!";
//        WriteFile(FilePath,Content);

        //测试读取文件
//        String FilePath = Path + "\\文件夹\\test.bat";
//        ReadFile(FilePath);

        //测试压缩文件
//        String File1Path = Path + "\\文件夹\\test.bat";
//        String File2Path = Path + "\\文件夹\\gg\\99.txt";
//        //2个源文件
//        File f1 = new File(File1Path);
//        File f2 = new File(File2Path);
//        File[] srcfile = {f1,f2};
//        //压缩后的文件名
//        File zipfile = new File(Path + "\\TestZip.zip");
//        zipFiles(srcfile,zipfile);

        //测试解压文件,中文路径或者中文文件都会报错
        File unzipfile = new File(Path + "\\TestZip.zip");
        //解压后的目录
        String dir = Path + "\\";
        unZipFiles(unzipfile,dir);
    }

}
