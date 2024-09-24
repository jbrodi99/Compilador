/* The following code was generated by JFlex 1.7.0 */

package com.compilador.model;

import com.compilador.model.Simbolos;
import com.compilador.controller.lexico.TablaSimbolos;

import java_cup.runtime.Symbol;
import java_cup.sym;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Flex.flex</tt>
 */
public class Lexico implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\2\4\1\0\2\4\22\0\1\4\1\66\1\6\3\0\1\67"+
    "\1\0\1\14\1\22\1\13\1\21\1\63\1\55\1\43\1\11\1\2"+
    "\1\10\10\1\1\56\1\62\1\64\1\57\1\65\2\0\1\42\1\52"+
    "\1\40\1\37\1\36\1\53\1\50\1\54\1\34\2\3\1\41\1\51"+
    "\1\46\1\45\1\47\1\3\1\33\1\44\1\35\2\3\1\32\3\3"+
    "\1\15\1\12\1\17\1\16\1\5\1\0\1\3\1\7\2\3\1\27"+
    "\1\30\1\3\1\24\1\25\2\3\1\26\6\3\1\31\3\3\1\23"+
    "\3\3\1\60\1\20\1\61\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uffff\0\uff92\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\2\2\1\3\1\4\1\1\1\5\1\6"+
    "\1\7\1\10\1\11\1\1\1\12\1\13\10\3\1\14"+
    "\3\3\1\15\1\16\1\1\1\17\1\20\1\21\1\22"+
    "\1\23\1\24\1\25\1\1\3\0\1\26\1\0\1\27"+
    "\1\3\1\30\11\3\1\0\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37\1\0\3\3\1\40\6\3\1\41"+
    "\1\0\1\3\1\42\4\3\1\43\3\3\1\0\1\44"+
    "\1\45\5\3\1\46\1\0\5\3\1\0\4\3\1\47"+
    "\1\0\2\3\3\0\2\3\3\0\2\3\31\0\1\50"+
    "\1\51\7\0\1\52\1\53\4\0\1\4";

  private static int [] zzUnpackAction() {
    int [] result = new int[161];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\70\0\160\0\250\0\340\0\u0118\0\u0150\0\u0188"+
    "\0\70\0\70\0\70\0\70\0\u01c0\0\70\0\70\0\u01f8"+
    "\0\u0230\0\u0268\0\u02a0\0\u02d8\0\u0310\0\u0348\0\u0380\0\70"+
    "\0\u03b8\0\u03f0\0\u0428\0\70\0\u0460\0\u0498\0\70\0\70"+
    "\0\70\0\70\0\u04d0\0\u0508\0\u0540\0\u0578\0\u05b0\0\u05e8"+
    "\0\u0150\0\70\0\u0620\0\70\0\u0658\0\340\0\u0690\0\u06c8"+
    "\0\u0700\0\u0738\0\u0770\0\u07a8\0\u07e0\0\u0818\0\u0850\0\u0888"+
    "\0\70\0\70\0\70\0\70\0\70\0\70\0\u05b0\0\u08c0"+
    "\0\u08f8\0\u0930\0\u0968\0\340\0\u09a0\0\u09d8\0\u0a10\0\u0a48"+
    "\0\u0a80\0\u0ab8\0\70\0\u0af0\0\u0b28\0\340\0\u0b60\0\u0b98"+
    "\0\u0bd0\0\u0c08\0\340\0\u0c40\0\u0c78\0\u0cb0\0\u0ce8\0\340"+
    "\0\340\0\u0d20\0\u0d58\0\u0d90\0\u0dc8\0\u0e00\0\340\0\u0e38"+
    "\0\u0e70\0\u0ea8\0\u0ee0\0\u0f18\0\u0f50\0\u0f88\0\u0fc0\0\u0ff8"+
    "\0\u1030\0\u1068\0\340\0\u10a0\0\u10d8\0\u1110\0\u1148\0\u1180"+
    "\0\u11b8\0\u11f0\0\u1228\0\u1260\0\u1298\0\u12d0\0\u1308\0\u1340"+
    "\0\u1378\0\u13b0\0\u13e8\0\u1420\0\u1458\0\u1490\0\u14c8\0\u1500"+
    "\0\u1538\0\u1570\0\u15a8\0\u15e0\0\u1618\0\u1650\0\u1688\0\u16c0"+
    "\0\u16f8\0\u1730\0\u1768\0\u17a0\0\u17d8\0\u1810\0\u1848\0\u1880"+
    "\0\u18b8\0\70\0\70\0\u18f0\0\u1928\0\u1960\0\u1998\0\u19d0"+
    "\0\u1a08\0\u1a40\0\70\0\70\0\u1a78\0\u1ab0\0\u1ae8\0\u1b20"+
    "\0\70";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[161];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\2\1\7\1\5"+
    "\1\3\1\10\1\2\1\11\1\12\1\13\1\2\1\14"+
    "\1\15\1\16\1\17\1\20\1\5\1\21\1\5\1\22"+
    "\2\5\1\23\1\5\1\24\1\5\1\25\1\26\1\27"+
    "\2\5\1\30\3\5\1\31\2\5\1\32\1\33\1\5"+
    "\1\34\1\35\1\36\1\37\1\40\1\41\1\42\1\43"+
    "\1\44\1\45\1\46\71\0\2\3\5\0\1\3\60\0"+
    "\2\3\4\0\1\47\1\3\60\0\3\5\1\0\1\50"+
    "\1\0\2\5\12\0\20\5\1\0\11\5\17\0\1\6"+
    "\63\0\6\51\1\52\61\51\11\0\1\53\76\0\1\54"+
    "\50\0\3\5\1\0\1\50\1\0\2\5\12\0\1\5"+
    "\1\55\16\5\1\0\11\5\14\0\3\5\1\0\1\50"+
    "\1\0\2\5\12\0\5\5\1\56\12\5\1\0\11\5"+
    "\14\0\3\5\1\0\1\50\1\0\2\5\12\0\3\5"+
    "\1\57\14\5\1\0\11\5\14\0\3\5\1\0\1\50"+
    "\1\0\2\5\12\0\10\5\1\60\7\5\1\0\11\5"+
    "\14\0\3\5\1\0\1\50\1\0\2\5\12\0\20\5"+
    "\1\0\2\5\1\61\6\5\14\0\3\5\1\0\1\50"+
    "\1\0\2\5\12\0\20\5\1\0\2\5\1\62\6\5"+
    "\14\0\3\5\1\0\1\50\1\0\2\5\12\0\13\5"+
    "\1\63\4\5\1\0\11\5\14\0\3\5\1\0\1\50"+
    "\1\0\2\5\12\0\20\5\1\0\10\5\1\64\14\0"+
    "\3\5\1\0\1\50\1\0\2\5\12\0\10\5\1\65"+
    "\7\5\1\0\11\5\14\0\3\5\1\0\1\50\1\0"+
    "\2\5\12\0\13\5\1\66\4\5\1\0\11\5\14\0"+
    "\3\5\1\0\1\50\1\0\2\5\12\0\16\5\1\67"+
    "\1\5\1\0\11\5\71\0\1\70\1\71\67\0\1\72"+
    "\67\0\1\73\67\0\1\74\67\0\1\75\77\0\1\76"+
    "\2\0\1\77\5\0\1\77\60\0\3\5\3\0\2\5"+
    "\12\0\20\5\1\0\11\5\25\0\1\100\56\0\3\5"+
    "\1\0\1\50\1\0\2\5\12\0\2\5\1\101\15\5"+
    "\1\0\11\5\14\0\3\5\1\0\1\50\1\0\2\5"+
    "\12\0\6\5\1\102\11\5\1\0\11\5\14\0\3\5"+
    "\1\0\1\50\1\0\2\5\12\0\11\5\1\103\6\5"+
    "\1\0\11\5\14\0\3\5\1\0\1\50\1\0\2\5"+
    "\12\0\12\5\1\104\5\5\1\0\11\5\14\0\3\5"+
    "\1\0\1\50\1\0\2\5\12\0\14\5\1\105\3\5"+
    "\1\0\11\5\14\0\3\5\1\0\1\50\1\0\2\5"+
    "\12\0\15\5\1\106\2\5\1\0\11\5\14\0\3\5"+
    "\1\0\1\50\1\0\2\5\12\0\17\5\1\107\1\0"+
    "\11\5\14\0\3\5\1\0\1\50\1\0\2\5\12\0"+
    "\20\5\1\0\1\5\1\110\7\5\14\0\3\5\1\0"+
    "\1\50\1\0\2\5\12\0\12\5\1\111\5\5\1\0"+
    "\11\5\14\0\3\5\1\0\1\50\1\0\2\5\12\0"+
    "\20\5\1\0\1\5\1\112\7\5\72\0\1\113\23\0"+
    "\1\114\55\0\3\5\1\0\1\50\1\0\2\5\12\0"+
    "\3\5\1\115\14\5\1\0\11\5\14\0\3\5\1\0"+
    "\1\50\1\0\2\5\12\0\4\5\1\116\13\5\1\0"+
    "\11\5\14\0\3\5\1\0\1\50\1\0\2\5\12\0"+
    "\12\5\1\117\5\5\1\0\11\5\14\0\3\5\1\0"+
    "\1\50\1\0\2\5\12\0\14\5\1\120\3\5\1\0"+
    "\3\5\1\121\5\5\14\0\3\5\1\0\1\50\1\0"+
    "\2\5\12\0\16\5\1\122\1\5\1\0\11\5\14\0"+
    "\3\5\1\0\1\50\1\0\2\5\12\0\10\5\1\123"+
    "\7\5\1\0\11\5\14\0\3\5\1\0\1\50\1\0"+
    "\2\5\12\0\20\5\1\0\4\5\1\124\4\5\14\0"+
    "\3\5\1\0\1\50\1\0\2\5\12\0\7\5\1\125"+
    "\10\5\1\0\11\5\14\0\3\5\1\0\1\50\1\0"+
    "\2\5\12\0\17\5\1\126\1\0\11\5\27\0\1\127"+
    "\54\0\3\5\1\0\1\50\1\0\2\5\12\0\4\5"+
    "\1\130\13\5\1\0\11\5\14\0\3\5\1\0\1\50"+
    "\1\0\2\5\12\0\13\5\1\131\4\5\1\0\11\5"+
    "\14\0\3\5\1\0\1\50\1\0\2\5\12\0\13\5"+
    "\1\132\4\5\1\0\11\5\14\0\3\5\1\0\1\50"+
    "\1\0\2\5\12\0\10\5\1\133\7\5\1\0\11\5"+
    "\14\0\3\5\1\0\1\50\1\0\2\5\12\0\17\5"+
    "\1\134\1\0\11\5\14\0\3\5\1\0\1\50\1\0"+
    "\2\5\12\0\10\5\1\135\7\5\1\0\11\5\14\0"+
    "\3\5\1\0\1\50\1\0\2\5\12\0\13\5\1\136"+
    "\4\5\1\0\11\5\14\0\3\5\1\0\1\50\1\0"+
    "\2\5\12\0\12\5\1\137\5\5\1\0\11\5\30\0"+
    "\1\140\53\0\3\5\1\0\1\50\1\0\2\5\12\0"+
    "\15\5\1\141\2\5\1\0\11\5\14\0\3\5\1\0"+
    "\1\50\1\0\2\5\12\0\20\5\1\0\1\5\1\142"+
    "\7\5\14\0\3\5\1\0\1\50\1\0\2\5\12\0"+
    "\10\5\1\143\7\5\1\0\11\5\14\0\3\5\1\0"+
    "\1\50\1\0\2\5\12\0\17\5\1\144\1\0\11\5"+
    "\14\0\3\5\1\0\1\50\1\0\2\5\12\0\13\5"+
    "\1\145\4\5\1\0\11\5\31\0\1\146\52\0\3\5"+
    "\1\0\1\50\1\0\2\5\12\0\16\5\1\147\1\5"+
    "\1\0\11\5\14\0\3\5\1\0\1\50\1\0\2\5"+
    "\12\0\20\5\1\0\4\5\1\150\4\5\14\0\3\5"+
    "\1\0\1\50\1\0\2\5\12\0\13\5\1\151\4\5"+
    "\1\0\11\5\14\0\3\5\1\0\1\50\1\0\2\5"+
    "\12\0\20\5\1\0\5\5\1\152\3\5\14\0\3\5"+
    "\1\0\1\50\1\0\2\5\12\0\20\5\1\0\2\5"+
    "\1\153\6\5\26\0\1\154\55\0\3\5\1\0\1\50"+
    "\1\0\2\5\12\0\17\5\1\155\1\0\11\5\14\0"+
    "\3\5\1\0\1\50\1\0\2\5\12\0\10\5\1\156"+
    "\7\5\1\0\11\5\14\0\3\5\1\0\1\50\1\0"+
    "\2\5\12\0\20\5\1\157\11\5\14\0\3\5\1\0"+
    "\1\50\1\0\2\5\12\0\20\5\1\160\11\5\32\0"+
    "\1\161\51\0\3\5\1\0\1\50\1\0\2\5\12\0"+
    "\10\5\1\162\7\5\1\0\11\5\14\0\3\5\1\0"+
    "\1\50\1\0\2\5\12\0\17\5\1\163\1\0\11\5"+
    "\57\0\1\164\67\0\1\165\43\0\1\166\50\0\3\5"+
    "\1\0\1\50\1\0\2\5\12\0\13\5\1\167\4\5"+
    "\1\0\11\5\14\0\3\5\1\0\1\50\1\0\2\5"+
    "\12\0\20\5\1\0\5\5\1\170\3\5\51\0\1\171"+
    "\67\0\1\172\43\0\1\173\56\0\3\5\1\0\1\50"+
    "\1\0\2\5\12\0\20\5\1\174\11\5\14\0\3\5"+
    "\1\0\1\50\1\0\2\5\12\0\20\5\1\175\11\5"+
    "\53\0\1\176\67\0\1\177\42\0\1\200\120\0\1\201"+
    "\67\0\1\202\60\0\1\203\67\0\1\204\53\0\1\205"+
    "\104\0\1\206\67\0\1\207\65\0\1\210\67\0\1\211"+
    "\50\0\1\212\112\0\1\213\67\0\1\214\74\0\1\215"+
    "\67\0\1\216\40\0\1\217\106\0\1\220\67\0\1\221"+
    "\100\0\1\222\67\0\1\223\32\0\1\224\112\0\1\225"+
    "\67\0\1\226\52\0\1\227\115\0\1\230\67\0\1\231"+
    "\44\0\1\232\113\0\1\233\67\0\1\234\34\0\1\235"+
    "\66\0\1\236\70\0\1\237\65\0\1\240\67\0\1\241"+
    "\56\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[7000];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\6\1\4\11\1\1\2\11\10\1\1\11"+
    "\3\1\1\11\2\1\4\11\4\1\3\0\1\11\1\0"+
    "\1\11\13\1\1\0\6\11\1\1\1\0\12\1\1\11"+
    "\1\0\12\1\1\0\10\1\1\0\5\1\1\0\5\1"+
    "\1\0\2\1\3\0\2\1\3\0\2\1\31\0\2\11"+
    "\7\0\2\11\4\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[161];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true iff the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true iff the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;
  
  /** 
   * The number of occupied positions in zzBuffer beyond zzEndRead.
   * When a lead/high surrogate has been read from the input stream
   * into the final zzBuffer position, this will have a value of 1;
   * otherwise, it will have a value of 0.
   */
  private int zzFinalHighSurrogate = 0;

  /* user code: */
/**
*   Instancia de tabla de simbolos
*
*/
TablaSimbolos symtbl = new TablaSimbolos("ts.txt");



  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexico(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x110000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 182) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length - zzFinalHighSurrogate) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzBuffer.length*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
      zzEndRead += zzFinalHighSurrogate;
      zzFinalHighSurrogate = 0;
    }

    /* fill the buffer with new input */
    int requested = zzBuffer.length - zzEndRead;
    int numRead = zzReader.read(zzBuffer, zzEndRead, requested);

    /* not supposed to occur according to specification of java.io.Reader */
    if (numRead == 0) {
      throw new java.io.IOException("Reader returned 0 characters. See JFlex examples for workaround.");
    }
    if (numRead > 0) {
      zzEndRead += numRead;
      /* If numRead == requested, we might have requested to few chars to
         encode a full Unicode character. We assume that a Reader would
         otherwise never return half characters. */
      if (numRead == requested) {
        if (Character.isHighSurrogate(zzBuffer[zzEndRead - 1])) {
          --zzEndRead;
          zzFinalHighSurrogate = 1;
        }
      }
      /* potentially more input available */
      return false;
    }

    /* numRead < 0 ==> end of stream */
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * Internal scan buffer is resized down to its initial length, if it has grown.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    zzFinalHighSurrogate = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
    if (zzBuffer.length > ZZ_BUFFERSIZE)
      zzBuffer = new char[ZZ_BUFFERSIZE];
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      int zzCh;
      int zzCharCount;
      for (zzCurrentPosL = zzStartRead  ;
           zzCurrentPosL < zzMarkedPosL ;
           zzCurrentPosL += zzCharCount ) {
        zzCh = Character.codePointAt(zzBufferL, zzCurrentPosL, zzMarkedPosL);
        zzCharCount = Character.charCount(zzCh);
        switch (zzCh) {
        case '\u000B':  // fall through
        case '\u000C':  // fall through
        case '\u0085':  // fall through
        case '\u2028':  // fall through
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn += zzCharCount;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL, zzEndReadL);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
            zzDoEOF();
          { return new java_cup.runtime.Symbol(sym.EOF); }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { throw new Error("Caracter no permitido: <" + yytext() + "> en la línea " + yyline);
            } 
            // fall through
          case 44: break;
          case 2: 
            { symtbl.agregarSimbolo("_" + yytext(), "CTE_INT", yytext(), null);
                        return new Symbol(Simbolos.CTE_INT.ordinal(), yytext());
            } 
            // fall through
          case 45: break;
          case 3: 
            { symtbl.agregarSimbolo("_" + yytext(), "ID", yytext(), null);
                        return new Symbol(Simbolos.ID.ordinal(), yytext());
            } 
            // fall through
          case 46: break;
          case 4: 
            { /* No se realiza acción */
            } 
            // fall through
          case 47: break;
          case 5: 
            { return new Symbol(Simbolos.OP_DIV.ordinal(), yytext());
            } 
            // fall through
          case 48: break;
          case 6: 
            { return new Symbol(Simbolos.OP_MUL.ordinal(), yytext());
            } 
            // fall through
          case 49: break;
          case 7: 
            { return new Symbol(Simbolos.PAR_OP.ordinal(), yytext());
            } 
            // fall through
          case 50: break;
          case 8: 
            { return new Symbol(Simbolos.SQR_OP.ordinal(), yytext());
            } 
            // fall through
          case 51: break;
          case 9: 
            { return new Symbol(Simbolos.SQR_CL.ordinal(), yytext());
            } 
            // fall through
          case 52: break;
          case 10: 
            { return new Symbol(Simbolos.OP_SUM.ordinal(), yytext());
            } 
            // fall through
          case 53: break;
          case 11: 
            { return new Symbol(Simbolos.PAR_CL.ordinal(), yytext());
            } 
            // fall through
          case 54: break;
          case 12: 
            { return new Symbol(Simbolos.DOT.ordinal(), yytext());
            } 
            // fall through
          case 55: break;
          case 13: 
            { return new Symbol(Simbolos.OP_LESS.ordinal(), yytext());
            } 
            // fall through
          case 56: break;
          case 14: 
            { return new Symbol(Simbolos.DOUBLEDOT.ordinal(), yytext());
            } 
            // fall through
          case 57: break;
          case 15: 
            { return new Symbol(Simbolos.BRA_OP.ordinal(), yytext());
            } 
            // fall through
          case 58: break;
          case 16: 
            { return new Symbol(Simbolos.BRA_CL.ordinal(), yytext());
            } 
            // fall through
          case 59: break;
          case 17: 
            { return new Symbol(Simbolos.DOTCOM.ordinal(), yytext());
            } 
            // fall through
          case 60: break;
          case 18: 
            { return new Symbol(Simbolos.COMA.ordinal(), yytext());
            } 
            // fall through
          case 61: break;
          case 19: 
            { return new Symbol(Simbolos.MINUS.ordinal(), yytext());
            } 
            // fall through
          case 62: break;
          case 20: 
            { return new Symbol(Simbolos.MAY.ordinal(), yytext());
            } 
            // fall through
          case 63: break;
          case 21: 
            { return new Symbol(Simbolos.NOT.ordinal(), yytext());
            } 
            // fall through
          case 64: break;
          case 22: 
            { return new Symbol(Simbolos.CTE_STR.ordinal(), yytext());
            } 
            // fall through
          case 65: break;
          case 23: 
            { return new Symbol(Simbolos.OR.ordinal(), yytext());
            } 
            // fall through
          case 66: break;
          case 24: 
            { return new Symbol(Simbolos.OP_IF.ordinal(), yytext());
            } 
            // fall through
          case 67: break;
          case 25: 
            { return new Symbol(Simbolos.DECLA.ordinal(), yytext());
            } 
            // fall through
          case 68: break;
          case 26: 
            { return new Symbol(Simbolos.EQ.ordinal(), yytext());
            } 
            // fall through
          case 69: break;
          case 27: 
            { return new Symbol(Simbolos.MINUS_EQ.ordinal(), yytext());
            } 
            // fall through
          case 70: break;
          case 28: 
            { return new Symbol(Simbolos.MAY_EQ.ordinal(), yytext());
            } 
            // fall through
          case 71: break;
          case 29: 
            { return new Symbol(Simbolos.NEQ.ordinal(), yytext());
            } 
            // fall through
          case 72: break;
          case 30: 
            { return new Symbol(Simbolos.AND.ordinal(), yytext());
            } 
            // fall through
          case 73: break;
          case 31: 
            { symtbl.agregarSimbolo("_" + yytext(), "CTE_BIN", yytext(), null);
                        return new Symbol(Simbolos.CTE_BIN.ordinal(), yytext());
            } 
            // fall through
          case 74: break;
          case 32: 
            { return new Symbol(Simbolos.OP_INT.ordinal(), yytext());
            } 
            // fall through
          case 75: break;
          case 33: 
            { return new Symbol(Simbolos.ASIGN.ordinal(), yytext());
            } 
            // fall through
          case 76: break;
          case 34: 
            { return new Symbol(Simbolos.OP_ELSE.ordinal(), yytext());
            } 
            // fall through
          case 77: break;
          case 35: 
            { return new Symbol(Simbolos.OP_CHAR.ordinal(), yytext());
            } 
            // fall through
          case 78: break;
          case 36: 
            { return new Symbol(Simbolos.OP_WHILE.ordinal(), yytext());
            } 
            // fall through
          case 79: break;
          case 37: 
            { return new Symbol(Simbolos.OP_WRITE.ordinal(), yytext());
            } 
            // fall through
          case 80: break;
          case 38: 
            { return new Symbol(Simbolos.OP_FLOAT.ordinal(), yytext());
            } 
            // fall through
          case 81: break;
          case 39: 
            { return new Symbol(Simbolos.OP_BETWEEN.ordinal(), yytext());
            } 
            // fall through
          case 82: break;
          case 40: 
            { symtbl.leerArchivo();
                       return new Symbol(Simbolos.OP_DECSEC.ordinal(), yytext());
            } 
            // fall through
          case 83: break;
          case 41: 
            { return new Symbol(Simbolos.OP_PROSEC.ordinal(), yytext());
            } 
            // fall through
          case 84: break;
          case 42: 
            { return new Symbol(Simbolos.OP_ENDECSEC.ordinal(), yytext());
            } 
            // fall through
          case 85: break;
          case 43: 
            { return new Symbol(Simbolos.OP_ENDPROSEC.ordinal(), yytext());
            } 
            // fall through
          case 86: break;
          default:
            zzScanError(ZZ_NO_MATCH);
        }
      }
    }
  }


}
