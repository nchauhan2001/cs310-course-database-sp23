package edu.jsu.mcis.cs310.coursedb.dao;

import java.sql.*;
import com.github.cliftonlabs.json_simple.*;

public class DAOUtility {
    
    public static final int TERMID_SP23 = 1;
    
    public static String getResultSetAsJson(ResultSet rs) {
        
        JsonArray records = new JsonArray();
        
        try {
        
            if (rs != null) {
                ResultSetMetaData metaData = rs.getMetaData();
                int columnCount = metaData.getColumnCount();
                
                while(rs.next()) {
                    JsonObject jsonObj = new JsonObject();
                
                
                    for(int i = 0; i < columnCount; i++) {
                        String col = metaData.getColumnName(i + 1);
                        String value = rs.getString(col);
                        jsonObj.put(col, value);
                
                    }
                
                    records.add(jsonObj);
                
                }
                
            }
            
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        
        return Jsoner.serialize(records);
        
    }
    
}
