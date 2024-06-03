package com.green.todo.tag;

import com.green.todo.tag.model.TagEntity;
import com.green.todo.tag.model.req.TagDeleteReq;
import com.green.todo.tag.model.req.TagGetReq;
import com.green.todo.tag.model.req.TagPostReq;
import com.green.todo.tag.model.req.TagUpdateReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TagMapper {
    int insertTag(TagPostReq p);
    TagEntity getTag(TagGetReq p);
    int updateTag(TagUpdateReq p);
    int deleteTag(TagDeleteReq p);
}
