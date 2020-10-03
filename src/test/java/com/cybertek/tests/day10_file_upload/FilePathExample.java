package com.cybertek.tests.day10_file_upload;

import org.testng.annotations.Test;

public class FilePathExample {




    @Test
    public void test1(){
      // C:\Users\yemen\IdeaProjects\EU3TestNGSelenium
        System.out.println(System.getProperty("user.dir"));

        String projectPart=System.getProperty("user.dir");
        String filePath="src/test/resources/textfile.txt";
        String fullPath=projectPart+"/"+filePath;
        System.out.println(fullPath);




    }
}
