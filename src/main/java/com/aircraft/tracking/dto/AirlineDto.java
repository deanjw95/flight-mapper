package com.aircraft.tracking.dto;

/*
* {
    "request": {
        "lang": "en",
        "currency": "USD",
        "time": 1,
        "id": "9rc3s66hlkk",
        "server": "l",
        "host": "airlabs.co",
        "pid": 2157224,
        "key": {
            "id": 26443,
            "api_key": "9a4c5309-9dae-4240-81f7-2a2b4b1e475b",
            "type": "free",
            "expired": "2023-09-22T00:00:00.000Z",
            "registered": "2023-08-23T07:56:52.000Z",
            "limits_by_hour": 2500,
            "limits_by_minute": 250,
            "limits_by_month": 1000,
            "limits_total": 993
        },
        "params": {
            "iata_code": "AA",
            "lang": "en"
        },
        "version": 9,
        "method": "airlines",
        "client": {
            "ip": "121.138.158.223",
            "geo": {
                "country_code": "KR",
                "country": "South Korea",
                "continent": "Asia",
                "city": "Gwacheon",
                "lat": 37.4366,
                "lng": 126.9963,
                "timezone": "Asia/Seoul"
            },
            "connection": {
                "type": "cable/dsl",
                "isp_code": 4766,
                "isp_name": "Korea Telecom"
            },
            "device": {},
            "agent": {},
            "karma": {
                "is_blocked": false,
                "is_crawler": false,
                "is_bot": false,
                "is_friend": false,
                "is_regular": true
            }
        }
    },
    "response": [
        {
            "name": "American Airlines",
            "iata_code": "AA",
            "icao_code": "AAL"
        }
    ],
    "terms": "Unauthorized access is prohibited and punishable by law. \nReselling data 'As Is' without AirLabs.Co permission is strictly prohibited. \nFull terms on https://airlabs.co/. \nContact us info@airlabs.co"
}
* */

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AirlineDto {
    private String name;
    private String iata_code;
    private String icao_code;
}
