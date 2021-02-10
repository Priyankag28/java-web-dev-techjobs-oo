package Tests;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.Job;
import org.launchcode.techjobs_oo.CoreCompetency;
import org.launchcode.techjobs_oo.Employer;
import org.launchcode.techjobs_oo.Location;
import org.launchcode.techjobs_oo.PositionType;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;


public class jobTest {
    Job test_job1,test_job2,test_job,test1_job,test2_job;

    @Before
    public void createJobObject(){
        test_job1 = new Job();
        test_job2 = new Job();
        test_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test1_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        test2_job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType(" "), new CoreCompetency("Persistence"));
    }
    @Test
    public void testSettingJobId(){
        assertTrue((test_job1.getId() != test_job2.getId()));
        //differenceOfTwoJobIds
        assertEquals(1,test_job2.getId()- test_job1.getId());
    }
    @Test
    public void testJobConstructorSetsAllFields(){
        assertTrue(test_job instanceof Job);
        /*assertEquals("ACME", test_job.getEmployer().toString());*/
        assertEquals("Product tester", test_job.getName());
        assertTrue(test_job.getEmployer() instanceof Employer);
        assertTrue(test_job.getLocation() instanceof Location);
        assertTrue(test_job.getPositionType() instanceof PositionType);
        assertTrue(test_job.getCoreCompetency() instanceof CoreCompetency);
    }
    @Test
    public void testJobsForEquality(){

        assertFalse(test_job.equals(test1_job));
    }
    @Test
    public void startWithBlankLine(){
        //System.out.println(test_job.toString().charAt(0));
        assertTrue(test_job.toString().charAt(0) == '\n');
    }
    @Test
    public void endsWithBlankLine(){
        int length = test_job.toString().length();
        assertTrue(test_job.toString().charAt(length-1) =='\n');
    }
    @ Test
    public void formatOfReturnValue(){
        assertEquals("\n" + " ID: " + test_job.getId() + "\n"+
                "Name: " + test_job.getName() + " \n" +
                "Employer: " + test_job.getEmployer() +" \n" +
                "Location: " + test_job.getLocation() +" \n" +
                "Position Type: " + test_job.getPositionType() + " \n" +
                "Core Competency: " + test_job.getCoreCompetency() + " \n", test_job.toString());
    }
    @Test
    public void emptyFieldCheck(){
         assertEquals("\n" + " ID: " + test2_job.getId() + "\n"+
                "Name: Product tester \n" +
                "Employer: ACME \n" +
                "Location: Desert \n" +
                "Position Type: Data not available \n" +
                "Core Competency: Persistence \n", test2_job.toString() );
         //assertEquals("OOPS! This job does not seem to exist.", test_job1.toString());
    }
    @Test
    public void jobObjectIdCheck() {
        assertEquals("OOPS! This job does not seem to exist.", test_job1.toString());
    }
}
