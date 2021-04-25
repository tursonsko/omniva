package app.smartive.omniva.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDto{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long locationId;
    @JsonProperty("ZIP")
    private String zip;
    @JsonProperty("NAME")
    private String name;
    @JsonProperty("TYPE")
    private String type;
    @JsonProperty("A0_NAME")
    private String a0_name;
    @JsonProperty("A1_NAME")
    private String a1_name;
    @JsonProperty("A2_NAME")
    private String a2_name;
    @JsonProperty("A3_NAME")
    private String a3_name;
    @JsonProperty("A4_NAME")
    private String a4_name;
    @JsonProperty("A5_NAME")
    private String a5_name;
    @JsonProperty("A6_NAME")
    private String a6_name;
    @JsonProperty("A7_NAME")
    private String a7_name;
    @JsonProperty("A8_NAME")
    private String a8_name;
    @JsonProperty("X_COORDINATE")
    private String x_coordinate;
    @JsonProperty("Y_COORDINATE")
    private String y_coordinate;
    @JsonProperty("SERVICE_HOURS")
    private String service_hours;
    @JsonProperty("TEMP_SERVICE_HOURS")
    private String temp_service_hours;
    @JsonProperty("TEMP_SERVICE_HOURS_UNTIL")
    private String TEMP_SERVICE_HOURS_UNTIL;
    @JsonProperty("TEMP_SERVICE_HOURS_2")
    private String TEMP_SERVICE_HOURS_2;
    @JsonProperty("TEMP_SERVICE_HOURS_2_UNTIL")
    private String TEMP_SERVICE_HOURS_2_UNTIL;
    private String comment_est;
    private String comment_eng;
    private String comment_rus;
    private String comment_lav;
    private String comment_lit;
    @JsonProperty("MODIFIED")
    private String modified;

    public LocationDto() {

    }
}