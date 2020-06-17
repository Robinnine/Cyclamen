package cn.cl.cyclamen.backup;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ClassName:dbBackUp
 * package:cn.cll.cyclamen.backup
 * Description:
 *
 * @date:2020/4/29 18:42
 * @author:cll@163.com
 */

public class DbBackUp {
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
    public static void main(String[] args) throws Exception {
        String backName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date())+"cyclamen.sql";
        DbBackUp.dbBackUp("root","123456","cyclamen","D:\\GraduationProject\\Cyclamen\\src\\main\\webapp\\backup\\",backName);
        // DbRestore("root","123456","cyclamen","E://数据备份//2020-04-29-19-28-28.sql");
    }
}
