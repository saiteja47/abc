package org.jlrdigital.rv.test.rvseleniumtest.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import org.junit.runner.JUnitCore;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class Main
{    
    private static final Logger LOGGER = LoggerFactory.getLogger("SeleniumTests");

    public static void main(String[] args) throws Exception
    {     
        try
        {
        	System.out.println("Tests running... This may take a while.");
            File file = new File("tests.txt");
            
            try (FileReader fileReader = new FileReader(file))
            {
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                List<String> classes = new LinkedList<>();
                while ((line = bufferedReader.readLine()) != null)
                {
                    if (line.charAt(0) != '#' && !line.equals(""))
                    {
                        System.out.println("Adding class: "+line+" to the queue");
                        classes.add("org.jlrdigital.sta.test.seleniumtest." + line);
                    }
                    else
                    {
                        System.out.println("Not running class: "+line.substring(1));
                    }
                }
                String[] array = new String[classes.size()];
                classes.toArray(array);
                if (classes.size() > 0)
                {
                    JUnitCore.main(array);
                }
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }   
        
        
        /*
        List<String> classes = new LinkedList<>();
        
        String[] array = new String[classes.size()];
        classes.toArray(array);
        if (classes.size() > 0)
        {
            JUnitCore.main(array);
        }*/
        
    }
}
