//http://opencsv.sourceforge.net/apidocs/com/opencsv/bean/CsvToBeanBuilder.html
//https://dzone.com/articles/the-bean-class-for-java-programming#:~:text=Professor%20Ken%20Fogel%20defines%20the,modeling%20data%20in%20a%20program.&text=Rather%20than%20list%20each%20element,together%20into%20a%20single%20class.

import com.opencsv.bean.CsvBindByName;  //acts as a header-->csvBindByName
                                        //anotherWay (CSV file with a header - users-with-header.csv)

import com.opencsv.bean.CsvBindByName;

public class StateCensus {
    @CsvBindByName(column = "State")
    private String stateName;

    @CsvBindByName(column = "Population",required = true)
    private String population;

    @CsvBindByName(column = "AreaInSqKm")
    private String areaInSqKm;

    @CsvBindByName(column = "DensityPerSqKm", required = true)
    private String densityPerSqKm;

    public StateCensus() {

    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public String getPopulation() {
        return population;
    }

    public void setPopulation(String population) {
        this.population = population;
    }

    public String getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public String getDensityPerSqKm() {
        return densityPerSqKm;
    }

    public void setDensityPerSqKm(String densityPerSqKm) {
        this.densityPerSqKm = densityPerSqKm;
    }

    @Override
    public String toString() {
        return  "stateName='" + stateName + '\'' +
                ", population='" + population + '\'' +
                ", areaInSqKm='" + areaInSqKm + '\'' +
                ", densityPerSqKm='" + densityPerSqKm + '\''
                +"\n";
    }
}