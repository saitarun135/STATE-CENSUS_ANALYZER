//http://opencsv.sourceforge.net/apidocs/com/opencsv/bean/CsvToBeanBuilder.html
//https://dzone.com/articles/the-bean-class-for-java-programming#:~:text=Professor%20Ken%20Fogel%20defines%20the,modeling%20data%20in%20a%20program.&text=Rather%20than%20list%20each%20element,together%20into%20a%20single%20class.

public class CensusAnalyserException extends Exception{
    enum CensusExceptionType{
        NO_SUCH_FILE, INCORRECT_DATA_ISSUE, SOME_OTHER_IO_EXCEPTION, DELIMITER_ISSUE,  NO_SUCH_CLASS
    }
    CensusExceptionType type;
    private String message;

    public CensusAnalyserException() {
    }

    public CensusAnalyserException(CensusExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}
