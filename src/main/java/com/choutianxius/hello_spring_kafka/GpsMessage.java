package com.choutianxius.hello_spring_kafka;

import java.util.Date;

public record GpsMessage(Date timestamp, double latitude, double longitude) {}
