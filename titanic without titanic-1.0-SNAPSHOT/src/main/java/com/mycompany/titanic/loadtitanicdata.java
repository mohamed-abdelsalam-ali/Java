/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.titanic;
import joinery.DataFrame;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import tech.tablesaw.api.DateColumn;
import tech.tablesaw.api.Table;

/**
 *
 * @author Pop
 */
public class loadtitanicdata {

    public loadtitanicdata() {
    }
    public static void main(String[] args ) {
       /**
        * When loading the entire CSV sheet
        * Give the path that the csv is located
        */
       Table hrAnalyticsx  = null;
       try {
       hrAnalyticsx = Table.read().csv("src/main/resources/data/titanic.csv");

           DataFrame<Object> df= DataFrame.readCsv ("src/main/resources/data/titanic.csv").retain("age", 
"sex","name","survived").groupBy(row ->row.get(0));
          DataFrame<Object> dfmean= df.groupBy(row ->row.get(0)).mean();
          DataFrame<Object> dfmax= df.groupBy(row ->row.get(0)).max();
          DataFrame<Object> dfmin= df.groupBy(row ->row.get(0)).min();
          DataFrame<Object> dfstanderdiviation= df.groupBy(row ->row.get(0)).stddev();

           System.out.println("********************************mean Age***************************");
            dfmean.iterrows ().forEachRemaining (System.out::println);
          System.out.println("********************************max Age***************************");
            dfmax.iterrows ().forEachRemaining (System.out::println);
          System.out.println("********************************min Age***************************");
            dfmin.iterrows ().forEachRemaining (System.out::println);
          System.out.println("********************************standerdiviation Age***************************");
            dfstanderdiviation.iterrows ().forEachRemaining (System.out::println);
       System.out.println("********************************Merging Two Data Frames***************************");

            System.out.println(dfmax.add(dfmean));
            
       System.out.println("********************************Adding New Culomn***************************");

            int rowCount=hrAnalyticsx.rowCount ();
            List<LocalDate> dateList=new ArrayList<LocalDate>();
            for(int i=0;i<rowCount;i++) {
            dateList.add (LocalDate.of (2021, 3, i%31==0?1:i%31));
            }
            DateColumn dateColumn=DateColumn.create("Fake Date",dateList);
            hrAnalyticsx.insertColumn (hrAnalyticsx.columnCount (),dateColumn);
       } catch (IOException e) {
           e.printStackTrace ();
       }

      Table structure = hrAnalyticsx.structure();
       System.out.println(structure);
       /**
        * Getting the structure of the table, this is knowing the data types using Table saw
        */
   
       System.out.println("WE ARE HERE, DONE PRINTING titanic.csv ?");


//       System.out.println(hrAnalyticsx.summary());


   }

}
