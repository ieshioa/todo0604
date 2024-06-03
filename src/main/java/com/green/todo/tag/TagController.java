package com.green.todo.tag;

import com.green.todo.common.CommonUtils;
import com.green.todo.common.model.ResultDto;
import com.green.todo.tag.model.req.TagDeleteReq;
import com.green.todo.tag.model.req.TagPostReq;
import com.green.todo.tag.model.req.TagUpdateReq;
import com.green.todo.tag.model.res.TagUpdateRes;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import static com.green.todo.common.model.ResultDto.resultDto;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("api/tag")
@Tag(name = "태그 컨트롤러")
public class TagController {
    private final TagService service;
    private final CommonUtils utils;

    @PostMapping
    @Operation(summary = "태그 post", description = "태그 PK를 리턴함")
    public ResultDto<Long> tagPost(@RequestBody TagPostReq p) {
        utils.init("태그를 생성하였습니다.");
        long result = 0;
        try {
            result = service.tagPost(p);
        } catch (Exception e) {
            utils.noAcceptable(e);
        }
        return resultDto(utils.getCode(), utils.getMsg(), result);
    }

    @PutMapping
    @Operation(summary = "태그 update", description = "태그 PK, 이름, 색상을 리턴함")
    public ResultDto<TagUpdateRes> updateTag (@RequestBody TagUpdateReq p) {
        utils.init("태그 수정을 완료하였습니다.");
        TagUpdateRes result = new TagUpdateRes();
        try {
            service.updateTag(p);
            result.setTagId(p.getTagId());
            result.setTitle(p.getTitle());
            result.setColor(p.getColor());
        } catch (Exception e) {
            utils.noAcceptable(e);
        }
        return resultDto(utils.getCode(), utils.getMsg(),result);
    }

    @DeleteMapping
    @Operation(summary = "태그 delete", description = "삭제가 완료되면 1을 리턴함")
    public ResultDto<Integer> deleteTag(@ParameterObject @ModelAttribute TagDeleteReq p) {
        utils.init("태그 삭제를 완료하였습니다.");
        int result = 0;
        try {
            result = service.deleteTag(p);
        } catch (Exception e) {
            utils.noAcceptable(e);
        }
        return resultDto(utils.getCode(), utils.getMsg(),result);
    }
}
