package com.green.todo.notice.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class NoticeContent {
    private String newUserName;
    private String calendarName;
    private String boardName;
    private final String newMemToOne = String.format("새로운 캘린더 '%s'가 추가되었습니다.", calendarName);
    private final String newMemToOther = String.format("'%s'님이 '%s'에 추가되었습니다.", newUserName, calendarName);
    private final String newBoard = String.format("'%s'에 새로운 일정이 등록되었습니다.", calendarName);
    private final String newComment = String.format("'%s'에 새로운 댓글이 있습니다.", boardName);
}
