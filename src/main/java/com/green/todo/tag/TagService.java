package com.green.todo.tag;

import com.green.todo.common.CommonUtils;
import com.green.todo.tag.model.TagEntity;
import com.green.todo.tag.model.req.TagDeleteReq;
import com.green.todo.tag.model.req.TagGetReq;
import com.green.todo.tag.model.req.TagPostReq;
import com.green.todo.tag.model.req.TagUpdateReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TagService {
    private final TagMapper mapper;
    private final CommonUtils utils;
    public long tagPost (TagPostReq p) {
        if(p.getTitle() == null || p.getTitle().isEmpty()) {
            throw new RuntimeException("태그 이름을 입력해주세요.");
        }
        if(!utils.isWithinByteLimit(p.getTitle(), 20)) {
            throw new RuntimeException("태그의 이름이 너무 깁니다.");
        }
        TagGetReq tagGet = new TagGetReq(p.getTitle(), p.getCalendarId());
        TagEntity tag = mapper.getTag(tagGet);
        if(tag != null) {
            throw new RuntimeException("태그의 이름이 중복됩니다.");
        }
        mapper.insertTag(p);
        return p.getTagId();
    }

    public int updateTag(TagUpdateReq p) {
        if((p.getTitle() == null || p.getTitle().isEmpty()) && (p.getColor() == null || p.getColor() < 0)) {
            throw new RuntimeException("수정할 내용을 없습니다.");
        }
        if(!utils.isWithinByteLimit(p.getTitle(), 20)) {
            throw new RuntimeException("태그의 이름이 너무 깁니다.");
        }
        TagGetReq tagGet = new TagGetReq(p.getTitle(), p.getCalendarId());
        TagEntity tag = mapper.getTag(tagGet);
        if(tag != null && p.getTagId() != tag.getTagId()) {
            throw new RuntimeException("태그의 이름이 중복됩니다.");
        }
        int result = mapper.updateTag(p);
        if(result != 1) {
            throw new RuntimeException("수정할 수 없습니다.");
        }
        return result;
    }

    public int deleteTag(TagDeleteReq p) {
        int result = mapper.deleteTag(p);
        if (result != 1) {
            throw new RuntimeException("삭제할 수 없습니다.");
        }
        return result;
    }


}
