/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package library;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author AnhLee
 */
public class ConvertDate {
    public Date convertDateSring(String date){
        Date dateUtil = null;
        SimpleDateFormat dateConvert = new SimpleDateFormat("MMM dd, yyyy");
        try {
            dateUtil = dateConvert.parse(date);
        } catch (ParseException e) {
            return null;
        }
        return dateUtil;
    }
    public String getStringTimeStamp(Timestamp date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return dateFormat.format(date);
    }
    public Date getDateTime(String stringDate) {
	DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
	try{
            Date date = df.parse(stringDate);
            return date;
	}catch (ParseException ex){
            return null;
	}
    }
    public Timestamp getTimestamp(java.util.Date date){ 
            return date == null ? null : new java.sql.Timestamp(date.getTime()); 
    }
}
