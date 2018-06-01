package cn.motian.exception;

import lombok.Getter;

public class TTMSException extends Exception {
    @Getter
    protected TTMSExceptionType exceptionType;

    @Getter
    protected String message;

    @Getter
    protected int tpCode = 0;

    public TTMSException() {
        this("", TTMSExceptionType.UNKNOWN_EXCEPTION);
    }

    public TTMSException(String message, TTMSExceptionType exceptionType) {
        this(message, null, exceptionType);
    }

    public TTMSException(String message, Throwable cause,
                            TTMSExceptionType exceptionType) {
        this(message, cause, exceptionType, 0);
    }

    public TTMSException(String message, Throwable cause,
                            TTMSExceptionType exceptionType, int tpErrorCode) {
        super(composeMessage(exceptionType, message), cause);
        this.message = composeMessage(exceptionType, message);
        this.exceptionType = exceptionType;
        this.tpCode = tpErrorCode;
    }
    public enum TTMSExceptionType {
        UNKNOWN_EXCEPTION {
            public int getErrorCode() {
                return 1000;
            }
        },
        USER_NOT_EXIST{
            public int getErrorCode() {
                return 2000;
            }
        },

        UNKNOWN_UNION_ID {
            public int getErrorCode() {
                return 1004;
            }
        }

        ;
        public int getErrorCode() {
            return 0;
        }
        public String getName() {
            return this.name();
        }
    }

    protected static String composeMessage(TTMSExceptionType exceptionType,
                                           String message) {
        return "Message[" + exceptionType.getName() + "]: " + message;
    }
}
