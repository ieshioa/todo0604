package com.green.todo.notice.model.req;

import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.RequestBody;
@Getter
@Setter
public class TestReq {
    private long calendarId;
    private long userId;
}
