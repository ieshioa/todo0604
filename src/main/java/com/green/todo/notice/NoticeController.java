package com.green.todo.notice;

import com.green.todo.common.CommonUtils;
import com.green.todo.notice.model.req.NoticeReq;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("api/notice")
public class NoticeController {
    private final NoticeService service;
    private final CommonUtils utils;

    @PostMapping("mem")
    @Operation(summary = "실험용 post", description = "캘린더에 새로운 멤버가 추가되었을 때")
    public int test (@RequestBody NoticeReq p){
        service.newMemberNotice(p);
        return 0;
    }

    @PostMapping("board")
    @Operation(summary = "실험용 post", description = "새로운 일정 추가")
    public int testboard (@RequestBody NoticeReq p){
        service.newBoardNotice(p);
        return 0;
    }

    @PostMapping("comment")
    @Operation(summary = "실험용 post", description = "새로운 댓글 추가")
    public int testcomment (@RequestBody NoticeReq p){
        service.newCommentNotice(p,2);
        return 0;
    }
}
