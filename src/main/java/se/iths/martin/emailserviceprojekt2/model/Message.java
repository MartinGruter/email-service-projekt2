package se.iths.martin.emailserviceprojekt2.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

@Getter
@Setter
public class Message implements Serializable {
    private String content;
    private String sender;
    private LocalDateTime timestamp;


}
