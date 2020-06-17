package cn.cl.cyclamen.backup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * ClassName:DbRestore
 * package:cn.cll.cyclamen.backup
 * Description:
 *
 * @date:2020/4/29 18:43
 * @author:cll@163.com
 */
public class DbRestore {
    public static void dbRestore(String root,String pwd,String dbName,String filePath){
        StringBuilder sb = new StringBuilder();
        sb.append("D:\\MySQL\\mysql-8.0.17-winx64\\bin\\mysql");
        sb.append(" -h127.0.0.1");
        sb.append(" -u"+root);
        sb.append(" -p"+pwd);
        sb.append(" "+dbName+" <");
        sb.append(filePath);
        System.out.println("cmd命令为："+sb.toString());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("开始还原数据");
        try {
            Process process = runtime.exec("cmd /c"+sb.toString());
            InputStream is = process.getInputStream();
            BufferedReader bf = new BufferedReader(new InputStreamReader(is,"utf8"));
            String line = null;
            while ((line=bf.readLine())!=null){
                System.out.println(line);
            }
            is.close();
            bf.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("还原成功！");
    }



    public static void main(String[] args) throws Exception {
        //String backName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date())+".sql";
       // DbOperate.dbBackUp("root","123456","cyclamen","D:\\GraduationProject\\Cyclamen\\src\\main\\webapp\\backup\\",backName);
        dbRestore("root","123456","cyclamen","D://GraduationProject//Cyclamen//src//main//webapp//backup//2020-04-29-18-51-11cyclamen.sql");
    }

}
