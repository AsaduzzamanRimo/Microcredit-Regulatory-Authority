package com.doer.mraims.core.util.response;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonListResponseBody<E> extends CommonResponse {
    private List<E> data;
    private int count;
}
