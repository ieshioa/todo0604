package com.green.todo.notice;

import com.green.todo.common.CommonUtils;
import com.green.todo.common.model.ResultDto;
import com.green.todo.notice.model.req.NoticePostReq;
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

//    @PostMapping("new_member")
//    @Operation(summary = "새로운 멤버가 추가되었을 때 알림")
//    public ResultDto<Long> newMemberNotice (@RequestBody NoticePostReq p){
//
//    }
}
