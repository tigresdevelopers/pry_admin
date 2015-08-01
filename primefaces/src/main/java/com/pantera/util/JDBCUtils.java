/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pantera.util;

import java.sql.ResultSet;



public class JDBCUtils {

	public static Object fn_oColumnData(ResultSet oResultSet, String sColumnTypeName, int iColumnIndex) throws Exception {
		Object oColumnData = null;

		if (sColumnTypeName.equalsIgnoreCase("VARCHAR2") ||
			sColumnTypeName.equalsIgnoreCase("VARCHAR") ||
			sColumnTypeName.equalsIgnoreCase("CHAR") ||
			sColumnTypeName.equalsIgnoreCase("LONGVARCHAR")) {
			oColumnData = oResultSet.getString(iColumnIndex);
		}
		else if (sColumnTypeName.equalsIgnoreCase("NUMBER") ||
				 sColumnTypeName.equalsIgnoreCase("NUMERIC") ||
				 sColumnTypeName.equalsIgnoreCase("DECIMAL") ||
				 sColumnTypeName.equalsIgnoreCase("BIT") ||
				 sColumnTypeName.equalsIgnoreCase("TINYINT") ||
				 sColumnTypeName.equalsIgnoreCase("SMALLINT") ||
				 sColumnTypeName.equalsIgnoreCase("INT") ||
				 sColumnTypeName.equalsIgnoreCase("INTEGER") ||
				 sColumnTypeName.equalsIgnoreCase("BIGINT") ||
				 sColumnTypeName.equalsIgnoreCase("REAL") ||
				 sColumnTypeName.equalsIgnoreCase("FLOAT") ||
				 sColumnTypeName.equalsIgnoreCase("DOUBLE")) {
			oColumnData = oResultSet.getBigDecimal(iColumnIndex);
		}
		else if (sColumnTypeName.equalsIgnoreCase("DATE") ||
				 sColumnTypeName.equalsIgnoreCase("DATETIME") ||
				 sColumnTypeName.equalsIgnoreCase("TIME") ||
				 sColumnTypeName.equalsIgnoreCase("TIMESTAMP")) {
			oColumnData = oResultSet.getTimestamp(iColumnIndex);
		}

		return oColumnData;
	}
}
