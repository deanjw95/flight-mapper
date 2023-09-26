package com.aircraft.tracking.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class AirportRequest {
    private Request request;
    private List<AirportResponse> response;
    private String terms;

    @Data
    public static class Request {
        private String lang;
        private String currency;
        private int time;
        private String id;
        private String server;
        private String host;
        private int pid;
        private Key key;
        private Params params;
        private int version;
        private String method;
        private Client client;

        @Data
        public static class Key {
            private int id;
            @JsonProperty("api_key")
            private String apiKey;
            private String type;
            private String expired;
            private String registered;
            @JsonProperty("limits_by_hour")
            private int limitsByHour;
            @JsonProperty("limits_by_minute")
            private int limitsByMinute;
            @JsonProperty("limits_by_month")
            private int limitsByMonth;
            @JsonProperty("limits_total")
            private int limitsTotal;

            // Getter and Setter methods go here
        }
        @Data
        public static class Params {
            @JsonProperty("iata_code")
            private String iataCode;
            private String lang;

            // Getter and Setter methods go here
        }

        @Data
        public static class Client {
            private String ip;
            private Geo geo;
            private Connection connection;
            private Device device;
            private Agent agent;
            private Karma karma;

            // Getter and Setter methods go here

            @Data
            public static class Geo {
                @JsonProperty("country_code")
                private String countryCode;
                private String country;
                private String continent;
                private String city;
                private double lat;
                private double lng;
                private String timezone;

                // Getter and Setter methods go here
            }

            @Data
            public static class Connection {
                private String type;
                @JsonProperty("isp_code")
                private int ispCode;
                @JsonProperty("isp_name")
                private String ispName;

                // Getter and Setter methods go here
            }

            @Data
            public static class Device {
                // Define device properties as needed
            }

            @Data
            public static class Agent {
                // Define agent properties as needed
            }

            @Data
            public static class Karma {
                @JsonProperty("is_blocked")
                private boolean isBlocked;
                @JsonProperty("is_crawler")
                private boolean isCrawler;
                @JsonProperty("is_bot")
                private boolean isBot;
                @JsonProperty("is_friend")
                private boolean isFriend;
                @JsonProperty("is_regular")
                private boolean isRegular;

                // Getter and Setter methods go here
            }
        }
    }

    @Data
    public static class AirportResponse {
        private String name;
        @JsonProperty("iata_code")
        private String iataCode;
        @JsonProperty("icao_code")
        private String icaoCode;
        private double lat;
        private double lng;
        @JsonProperty("country_code")
        private String countryCode;
    }
}
