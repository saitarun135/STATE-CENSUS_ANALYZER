import org.junit.Assert;
import org.junit.Test;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.IOException;

public class StateCensusAnalyserTest {

    public static final String STATECENSUS_CSVFILE = "C:\\Users\\VICKY\\Desktop\\STATE-CENSUS_ANALYZER\\src\\main\\resources\\IndiaStateCensusData.csv";
    public static final String STATECODES_CSVFILE = "C:\\Users\\VICKY\\Desktop\\STATE-CENSUS_ANALYZER\\src\\main\\resources\\IndiaStateCode.csv";
    public static final String WRONG_FILE = "/novalue.txt";
    @Test
    public void GivenTheStateCodesCsvFile_IfHasCorrectNumberOfRecords_ShouldReturnTrue() throws IOException {
        StateCensusAnalyser stateCensusAnalyser = new StateCensusAnalyser();
        try {
            int count = stateCensusAnalyser.openCsvBuilder(STATECODES_CSVFILE, StateCensus.class);
            System.out.println(count);
            Assert.assertEquals(29, count);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void GivenTheStateCodeCsvFile_IfDoesntExist_ShouldThrowCensusAnalyserException() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(WRONG_FILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.CensusExceptionType.NO_SUCH_FILE, e.type);
        }
    }

    @Test
    public void GivenTheStateCodeCsvFile_WhenCorrect_ButFileExtensionIncorrect_ShouldThrowCensusAnalyserException()
            throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECODES_CSVFILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }

    @Test
    public void GivenTheStateCodeCSVFile_WhenCorrect_ButDelimiterIncorrect_ReturnsCensusAnalyserException()
            throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECODES_CSVFILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.CensusExceptionType.DELIMITER_ISSUE, e.type);

        }
    }

    @Test
    public void whenCorrectCodeCSVFile_ButHeaderIncorrect_ShouldReturnFalse() throws IOException {
        try {
            int count = StateCensusAnalyser.openCsvBuilder(STATECODES_CSVFILE, StateCensus.class);
        } catch (CensusAnalyserException e) {
            e.printStackTrace();
            Assert.assertEquals(CensusAnalyserException.CensusExceptionType.INCORRECT_DATA_ISSUE, e.type);
        }
    }

}
