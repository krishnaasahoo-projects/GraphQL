package com.learning.graphql_playground.lec13.dto;

import com.learning.graphql_playground.lec13.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor(staticName = "create")
@NoArgsConstructor
public class DeleteResponseDto {

    private Integer id;
    private Status status;
}
