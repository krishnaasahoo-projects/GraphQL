package com.learning.graphql_playground.lec14.dto;

import com.learning.graphql_playground.lec14.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class DeleteResponseDto {

    private Integer id;
    private Status status;
}
