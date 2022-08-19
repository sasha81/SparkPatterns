package project2;

import static org.junit.Assert.assertEquals;

import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.spark.custompatterns.model.Declaration;
import com.spark.custompatterns.model.JobConfig;
import com.spark.custompatterns.utils.ParserService;
public class ParserTest {
	@Test
    public void testJsonParsing() throws IOException {

       

        DataInputStream dataInputStream = new DataInputStream(
                new FileInputStream("src/test/resources/declaration.json"));

        Declaration declaration = ParserService.parseSingleDeclarationStream(dataInputStream, Declaration.class);
        assertEquals(declaration.getDeclaration_id(), "ABCDE12345");
      
       
        assertEquals(declaration.getDeclaration_details().length,1);
     
       assertEquals(declaration.getDeclaration_details()[0].getDetail_1(),10);
      


    }
	@Test
	public void testYmlParser() throws FileNotFoundException {
		List<JobConfig> jobs = ParserService.getLocalFSJobList("src/test/resources/jobs.yml", JobConfig.class);
		 assertEquals(jobs.size(),2);
		 assertEquals(jobs.get(0).getJobName(),"JOB_1");
		 assertEquals(jobs.get(0).getSelect(),"rdbTable_1");
		 assertEquals(jobs.get(1).getJobName(),"JOB_2");
		 assertEquals(jobs.get(1).getSelect(),"rdbTable_2");
	}
}
