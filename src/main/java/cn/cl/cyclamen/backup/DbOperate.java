package cn.cl.cyclamen.backup;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:DbOperate
 * package:cn.cll.cyclamen.backup
 * Description:
 *
 * @date:2020/4/29 17:33
 * @author:cll@163.com
 */

/**
 * --备份数据库
 * mysqldump -h127.0.0.1 -uroot -p123456 cyclamen > E://2020-04-29-19-28-28.sql
 *
 * --还原数据库
 * mysql -h127.0.0.1 -uroot -p123456 cyclamen > E://2020-04-29-19-28-28.sql
 */
public class DbOperate {
    /**
     * 备份数据库db
     * @param root
     * @param pwd
     * @param dbName
     * @param backPath
     * @param backName
     */
    public static void dbBackUp(String root,String pwd,String dbName,String backPath,String backName) throws Exception {
        String pathSql = backPath+backName;
        File fileSql = new File(pathSql);
        //创建备份sql文件
        if (!fileSql.exists()){
            fileSql.createNewFile();
        }
        //mysqldump -hlocalhost -uroot -p123456 db > /home/back.sql
        StringBuffer sb = new StringBuffer();
        sb.append("D:\\MySQL\\mysql-8.0.17-winx64\\bin\\mysqldump");
        sb.append(" -h127.0.0.1");
        sb.append(" -u"+root);
        sb.append(" -p"+pwd);
        sb.append(" "+dbName+" >");
        sb.append(pathSql);
        System.out.println("cmd命令为："+sb.toString());
        Runtime runtime = Runtime.getRuntime();
        System.out.println("开始备份："+dbName);
        Process process = runtime.exec("cmd /c"+sb.toString());
        System.out.println("备份成功!");
    }

    /**
     * 恢复数据库
     * @param root
     * @param pwd
     * @param dbName
     * @param filePath
     *
     */
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
        String backName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date())+".sql";
        DbOperate.dbBackUp("root","123456","cyclamen","D:\\GraduationProject\\Cyclamen\\src\\main\\webapp\\backup\\",backName);
       // DbRestore("root","123456","cyclamen","E://数据备份//2020-04-29-19-28-28.sql");
    }

}
