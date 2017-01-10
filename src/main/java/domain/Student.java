package domain;

import json.*;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class Student extends BasicStudent {
    protected String name;
    protected String surname;
    protected Integer year;
    protected Tuple<String, Integer>[] exams;

    public Student(String name, String surname, Integer year, Tuple<String, Integer>... exams) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.exams = exams ;
    }

    @Override
    public JsonObject toJsonObject() {
        JsonPair jsOne = new JsonPair("name", new JsonString(name));
        JsonPair jsTwo = new JsonPair("surname", new JsonString(surname));
        Json numYearJ = new JsonNumber(year);
        JsonPair jsThree = new JsonPair("year", numYearJ);
        JsonObject[] nj = new JsonObject[exams.length];
        int j = 0;
        for(Tuple<String, Integer> i : exams){
            boolean markP = false;
            if(i.value >=3){
                markP = true;
            }
            nj[j] =new JsonObject(new JsonPair("course", new JsonString(i.key)), new JsonPair("mark", new JsonNumber(i.value)), new JsonPair("passed", new JsonBoolean(markP)));
            j++;
        }
        JsonArray jsA = new JsonArray(nj);
        JsonPair jsFour = new JsonPair("exams", jsA);
       return new JsonObject(jsOne, jsTwo, jsThree, jsFour);
    }
}