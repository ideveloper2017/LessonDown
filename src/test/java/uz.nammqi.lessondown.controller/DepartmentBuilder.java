package uz.nammqi.lessondown.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;

public class DepartmentBuilder {
    public static List<String> getIds() {
        return Collections.singletonList("1");
    }

    public static DepartmentDto getDto() {
        DepartmentDto dto = new DepartmentDto();
        dto.setId("1");
        return dto;
    }
}