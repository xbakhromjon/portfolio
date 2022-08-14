package uz.al_jamoa.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum LinkType {
    YOUTUBE("YOUTUBE", 1),
    GITHUB("GITHUB", 2),
    LINKEDIN("LINKEDIN", 3),
    TELEGRAM("TELEGRAM", 4);

    private final String name;
    private final Integer code;
}
