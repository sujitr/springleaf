package com.sujit;

import org.junit.Assert;
import org.junit.Test;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.rule.OutputCapture;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AppTest {
    @Autowired
    private CommandLineRunner clr;
    
    @Rule
    public OutputCapture outputCapture = new OutputCapture();
    
    @Test
    public void checkCommandLineOutput() throws Exception {
        this.clr.run();
        // verify any changes
        String output = this.outputCapture.toString();
        Assert.assertTrue(output, output.contains("Standalone Spring Boot application - Hello World"));
    }
    
}