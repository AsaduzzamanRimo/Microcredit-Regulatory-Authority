package com.doer.mraims.core.util.response;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommonObjectResponseBody<E> extends CommonResponse {
    private E data;
}
