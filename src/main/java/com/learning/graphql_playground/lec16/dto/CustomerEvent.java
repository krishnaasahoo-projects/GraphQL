package com.learning.graphql_playground.lec16.dto;

import com.learning.graphql_playground.lec16.enums.Action;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "create")
public class CustomerEvent {
    private Integer id;
    private Action action;
}
