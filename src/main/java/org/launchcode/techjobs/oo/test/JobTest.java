package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId() {
         Job job1 = new Job();
         Job job2 = new Job();
         assertTrue(job2.getId() - job1.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job newJob = new Job("Product tester", new Employer("Acme"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", newJob.getName());
        assertEquals("Acme", newJob.getEmployer().getValue());
        assertEquals("Desert", newJob.getLocation().getValue());
        assertEquals("Quality control", newJob.getPositionType().getValue());
        assertEquals("Persistence", newJob.getCoreCompetency().getValue());
        assertTrue(newJob.getName() instanceof String);
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);

    }

    @Test
    public void testJobsForEquality() {
        Job newJob1 = new Job("Product tester", new Employer ("Acme"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJob2 = new Job("Product tester", new Employer ("Acme"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(newJob1.equals(newJob2));
    }



    @Test
    public void testToStringOutput() {
        Job newJob1 = new Job("Product tester", new Employer ("Acme"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actualOutput = newJob1.toString();
        String expectedOutput = "\n" + "ID: " + newJob1.getId() + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: Acme" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + "\n";



    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job newJob1 = new Job("Product tester", new Employer ("Acme"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String actualOutput = newJob1.toString();
        String expectedOutput = "\n" + "ID: " + newJob1.getId() + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: Acme" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Quality control" + "\n" +
                "Core Competency: Persistence" + "\n";
        assertEquals(expectedOutput, actualOutput);
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job newJob1 = new Job("Product tester", new Employer ("Acme"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        char actualOutput = newJob1.toString().charAt(0);
        assertEquals('\n', actualOutput);
        char desiredOutput = newJob1.toString().charAt(newJob1.toString().length() -1);
        assertEquals('\n', desiredOutput);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job newJob1 = new Job("Product tester", new Employer (""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
        String actualOutput = newJob1.toString();
        String expectedOutput = "\n" + "ID: " + newJob1.getId() + "\n" +
                "Name: Product tester" + "\n" +
                "Employer: Data not available" + "\n" +
                "Location: Desert" + "\n" +
                "Position Type: Data not available" + "\n" +
                "Core Competency: Persistence" + "\n";
        assertEquals(expectedOutput, actualOutput);

    }
}
