package com.green.todo.comment.model.req;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.Getter;
import lombok.Setter;

import java.beans.ConstructorProperties;

@Getter
@Setter
public class CommentDeleteReq {
    @Parameter(name = "comment_id")
    private Long commentId;
    @Parameter(name = "signed_user_id")
    private Long signedUserId;

    @ConstructorProperties({"comment_id","signed_user_id"})
    public CommentDeleteReq(Long commentId, Long signedUserId) {
        this.commentId = commentId;
        this.signedUserId = signedUserId;
    }
}
