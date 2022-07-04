package com.ceshi.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/*
*  对Date类型数据进行处理的工具类
*
* */
public class DateUtils {
    /*
    *  对Date对象进行格式化
    *  把当前时间转化为字符串类型和数据库的字符串做比较
    * */
    public  static  String formateDateTime(Date date){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       String dateStr= sdf.format(date);
       return  dateStr;

    }
}
