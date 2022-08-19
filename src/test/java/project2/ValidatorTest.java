package project2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;

import com.spark.custompatterns.utils.AChainDT;
import com.spark.custompatterns.utils.IChain;
import com.spark.custompatterns.utils.IChainDT;
import com.spark.custompatterns.utils.SimpleDateTimeParser;
import com.spark.custompatterns.utils.SimpleDateTimeParserA;
import com.spark.custompatterns.utils.SimpleDateValidator;

public class ValidatorTest {
  @Test
  public void validatorTest(){
      String pattern1 = "yyyy-MM-dd";
      String pattern2 = "yyyy.MM.dd";

      IChain validator1 = new SimpleDateValidator(pattern1);
      IChain validator2 = new SimpleDateValidator(pattern2,validator1);

      String testString = "2020-10-19";
      assertTrue(validator2.validate(testString));
      testString="2020.10.19";
      assertTrue(validator2.validate(testString));
      testString = "2020/10/19";
      assertFalse(validator2.validate(testString));
  }
  @Test
  public void parserTest(){
      String pattern1 = "yyyy-MM-dd";
      String pattern2 = "yyyy.MM.dd";

      IChainDT validator1 = new SimpleDateTimeParser(pattern1);
    //  IChainDT validator2 = new SimpleDateTimeParser(pattern2,validator1);
      IChainDT validator2 = new SimpleDateTimeParser(pattern2);
      validator1.setNextChain(validator2);

      String testString = "2020-10-19";
      LocalDate result = validator1.getDateTime(testString);     
      assertEquals(result.getYear(),2020);
      
      testString = "2020.10.19";
      result = validator1.getDateTime(testString);
      assertEquals(result.getYear(),2020);
      
      testString="10/19/2020";
      result = validator1.getDateTime(testString);
      assertEquals(result.getYear(),1969);
//      assertTrue(validator2.validate(testString));
//      testString = "2020/10/19";
//      assertFalse(validator2.validate(testString));
  }
  @Test
  public void parserATest(){
      String pattern1 = "yyyy-MM-dd";
      String pattern2 = "yyyy.MM.dd";

      AChainDT validator1 = new SimpleDateTimeParserA(pattern1);
    //  IChainDT validator2 = new SimpleDateTimeParser(pattern2,validator1);
      AChainDT validator2 = new SimpleDateTimeParserA(pattern2);
      validator1.setNext(validator2);

      String testString = "2020-10-19";
      LocalDate result = validator1.getDateTime(testString);     
      assertEquals(result.getYear(),2020);
      
      testString = "2020.10.19";
      result = validator1.getDateTime(testString);
      assertEquals(result.getYear(),2020);
      
      testString="10/19/2020";
      result = validator1.getDateTime(testString);
      assertEquals(result.getYear(),1969);
//      assertTrue(validator2.validate(testString));
//      testString = "2020/10/19";
//      assertFalse(validator2.validate(testString));
  }
}
