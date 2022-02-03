package com.jb.serverA.beans;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class RecallDetails {
    //private int _id;
//    @JsonProperty("MISPAR_RECHEV")
//    private int mispar_rechev;
    @JsonProperty("RECALL_ID")
    private int recall_id;
    @JsonProperty("SUG_RECALL")
    private String sug_recall;
    @JsonProperty("SUG_TAKALA")
    private String sug_takala;
    @JsonProperty("TEUR_TAKALA")
    private String teur_takala;
    @JsonProperty("TAARICH_PTICHA")
    private String taarich_pticha;
    private double rank;
}
