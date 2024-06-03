package com.green.todo.tag.model.res;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagUpdateRes {
    @Parameter(name = "tag_id")
    @Schema(example = "1", description = "수정한 태그의 PK")
    private long tagId;
    @Schema(example = "프로젝트", description = "태그 이름")
    private String title;
    @Schema(example = "1", description = "태그 색상")
    private Integer color;

}
