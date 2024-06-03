package com.green.todo.tag.model.req;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class TagDeleteReq {
    @Parameter(name = "signed_user_id")
    @Schema(example = "5", description = "로그인된 유저의 PK")
    private Long signedUserId;
    @Parameter(name = "tag_id")
    @Schema(example = "3", description = "삭제할 태그의 PK")
    private Long tagId;
    @Parameter(name = "calendar_id")
    @Schema(example = "2", description = "태그가 있는 캘린더의 PK")
    private Long calendarId;

    @ConstructorProperties({"signed_user_id", "tag_id", "calendar_id"})
    public TagDeleteReq(Long signedUserId, Long tagId, Long calendarId) {
        this.signedUserId = signedUserId;
        this.tagId = tagId;
        this.calendarId = calendarId;
    }
}
