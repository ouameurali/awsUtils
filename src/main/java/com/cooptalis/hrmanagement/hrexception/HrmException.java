package com.cooptalis.hrmanagement.hrexception;

import com.cooptalis.hrmanagement.hrenum.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NonNull;
import org.springframework.http.HttpStatus;

@Data
@EqualsAndHashCode(callSuper = true)
public class HrmException extends Exception {

    private static final long serialVersionUID = -4046244778647249855L;

    private final ErrorCodeEnum code;
    private final String technicalMessage;
    private final String publicMessage;
    private final HttpStatus httpStatus;
    private final boolean log;

    public HrmException(@NonNull ErrorCodeEnum code, @NonNull String publicMessage, boolean log) {
        super(code.getTechnicalMessage());
        this.code = code;
        this.publicMessage = publicMessage;
        this.log = log;
        technicalMessage = code.getTechnicalMessage();
        httpStatus = code.getHttpStatus();
    }

    public HrmException(@NonNull ErrorCodeEnum code) {
        this(code, code.getPublicMessage(), true);
    }

    public HrmException(@NonNull ErrorCodeEnum code, boolean log) {
        this(code, code.getPublicMessage(), log);
    }

    public HrmException(@NonNull ErrorCodeEnum code, @NonNull Object... publicMessages) {
        this(code, String.format(code.getPublicMessage(), publicMessages), true);
    }
}
