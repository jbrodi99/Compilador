package Lexico;

public class Lexicosym {
    public static final int EOF = 0;
    public static final int OP_WHILE = 1;
    public static final int OP_IF = 2;
    public static final int OP_ELSE = 3;
    public static final int OP_WRITE = 4;
    public static final int OP_DECSEC = 5;
    public static final int OP_ENDECSEC = 6;
    public static final int OP_PROSEC = 7;
    public static final int OP_ENDPROSEC = 8;
    public static final int OP_BETWEEN = 9;
    public static final int OP_INT = 10;
    public static final int OP_FLOAT = 11;
    public static final int OP_CHAR = 12;
    public static final int OP_SUM = 13;
    public static final int OP_LESS = 14;
    public static final int OP_MUL = 15;
    public static final int OP_DIV = 16;
    public static final int ASIGN = 17;
    public static final int DECLA = 18;
    public static final int PAR_OP = 19;
    public static final int PAR_CL = 20;
    public static final int SQR_OP = 21;
    public static final int SQR_CL = 22;
    public static final int BRA_OP = 23;
    public static final int BRA_CL = 24;
    public static final int DOTCOM = 25;
    public static final int DOT = 26;
    public static final int COMA = 27;
    public static final int DOUBLEDOT = 28;
    public static final int MINUS = 29;
    public static final int MINUS_EQ = 30;
    public static final int MAY = 31;
    public static final int MAY_EQ = 32;
    public static final int EQ = 33;
    public static final int NEQ = 34;
    public static final int NOT = 35;
    public static final int AND = 36;
    public static final int OR = 37;
    public static final int ID = 38;
    public static final int CTE_INT = 39;
    public static final int CTE_REAL = 40;
    public static final int CTE_STR = 41;
    public static final int CTE_BIN = 42;
    
    
    public static String getTokenName(int tokenType) {
        switch (tokenType) {
            case EOF: return "EOF";
            case OP_WHILE: return "OP_WHILE";
            case OP_IF: return "OP_IF";
            case OP_ELSE: return "OP_ELSE";
            case OP_WRITE: return "OP_WRITE";
            case OP_DECSEC: return "OP_DECSEC";
            case OP_ENDECSEC: return "OP_ENDECSEC";
            case OP_PROSEC: return "OP_PROSEC";
            case OP_ENDPROSEC: return "OP_ENDPROSEC";
            case OP_BETWEEN: return "OP_BETWEEN";
            case OP_INT: return "OP_INT";
            case OP_FLOAT: return "OP_FLOAT";
            case OP_CHAR: return "OP_CHAR";
            case OP_SUM: return "OP_SUM";
            case OP_LESS: return "OP_LESS";
            case OP_MUL: return "OP_MUL";
            case OP_DIV: return "OP_DIV";
            case ASIGN: return "ASIGN";
            case DECLA: return "DECLA";
            case PAR_OP: return "PAR_OP";
            case PAR_CL: return "PAR_CL";
            case SQR_OP: return "SQR_OP";
            case SQR_CL: return "SQR_CL";
            case BRA_OP: return "BRA_OP";
            case BRA_CL: return "BRA_CL";
            case DOTCOM: return "DOTCOM";
            case DOT: return "DOT";
            case COMA: return "COMA";
            case DOUBLEDOT: return "DOUBLEDOT";
            case MINUS: return "MINUS";
            case MINUS_EQ: return "MINUS_EQ";
            case MAY: return "MAY";
            case MAY_EQ: return "MAY_EQ";
            case EQ: return "EQ";
            case NEQ: return "NEQ";
            case NOT: return "NOT";
            case AND: return "AND";
            case OR: return "OR";
            case ID: return "ID";
            case CTE_INT: return "CTE_INT";
            case CTE_REAL: return "CTE_REAL";
            case CTE_STR: return "CTE_STR";
            case CTE_BIN: return "CTE_BIN";
            default: return "UNKNOWN_TOKEN";
        }
    }
}

