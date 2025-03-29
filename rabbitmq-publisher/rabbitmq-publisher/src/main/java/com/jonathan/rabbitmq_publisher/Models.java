package com.jonathan.rabbitmq_publisher;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


public class Models {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Students{
        private String name;
        private String grade;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Classroom{
        private String level;
        private String capacity ;
    }

}
