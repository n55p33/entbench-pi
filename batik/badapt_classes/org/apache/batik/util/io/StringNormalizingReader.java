package org.apache.batik.util.io;
public class StringNormalizingReader extends org.apache.batik.util.io.NormalizingReader {
    protected java.lang.String string;
    protected int length;
    protected int next;
    protected int line = 1;
    protected int column;
    public StringNormalizingReader(java.lang.String s) { super();
                                                         string = s;
                                                         length = s.length(
                                                                      ); }
    public int read() throws java.io.IOException { int result = length ==
                                                     next
                                                     ? -1
                                                     : string.
                                                     charAt(
                                                       next++);
                                                   if (result <= 13) { switch (result) {
                                                                           case 13:
                                                                               column =
                                                                                 0;
                                                                               line++;
                                                                               int c =
                                                                                 length ==
                                                                                 next
                                                                                 ? -1
                                                                                 : string.
                                                                                 charAt(
                                                                                   next);
                                                                               if (c ==
                                                                                     10) {
                                                                                   next++;
                                                                               }
                                                                               return 10;
                                                                           case 10:
                                                                               column =
                                                                                 0;
                                                                               line++;
                                                                       }
                                                   }
                                                   return result;
    }
    public int getLine() { return line; }
    public int getColumn() { return column;
    }
    public void close() throws java.io.IOException {
        string =
          null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xjOnrjP30/gc8xk/rfqbHXDLynkr4s9d/eTPzzx6fJwXBCu8Yc7F1/SPfjly" +
       "6Ld/zzI5A7gcxYqLfyhw/uS84Kb3Gb+FNJS7LZWdvgCtLd67zyX+6m8t/rEf" +
       "lQyhGtEsn3cJcpLG7xCUjEa6poYS2zHuLP94rdOZQdJmN8rZlnVjnJU24Z1S" +
       "0/dKF6xV0S1sNqEtDXEOWPMh9vIAY1nO2nba3JVGkTJNVwlIiaMuIKnMMy2A" +
       "j8ECjf5az6GTtp+iTYhPdI+nP3Y55Z8Lz3JzoeUe8u/g8tOmL1tML24QU8bK" +
       "CIk7iwKaeAeTEQMSuJQAvB4zC9y7B/aKU20Dv+e+OjcHA6erPxt4ZNdb+15j" +
       "2aCUlgg70vtjKwCglLClohou9Ufw8cHzb/pQaWkHLxTrgma1uihTrtJYyxs0" +
       "LgUCB+veHT154wJXwB0hLmI8Nf3ljzqOTHOI52eeJVnHDjsPP/dwdWizh0q3" +
       "ON8qjKP7vYsHf3j24GEuVZ2zgu+CA+qFX/zrtY4Tv3klR7lYIJnn1rU21Ick" +
       "7dwbrtB9X6p+7mhdQTcUFz2oNKlI+5O4J+qMpBIjGbFtlnWWsqLLVI1uDEG+" +
       "dtgDl3/vnKF/N8KzyvTQVR7+Lef1by9uArqBT9D33S4hEzMUcj48a8xl1ngI" +
       "aeQV0oub8BNVLiHJf4EU681l1nsIOZlXSC9ukj415hLzQB4xU9ZyKzPLsU8x" +
       "cp0F7YWYlUERDaIFXsd1FkCnD02fivY/tcZvFi9QR5URVbtLxmNYtk1VSGdy" +
       "JONedkFhZbZ3qo797vttI1tmcuyhfS13ONjQ3wshuNu9ocotypVDf5y3Y1N8" +
       "7wxOMAtdVnJP+XTv+VfuXyYe87PbGJ5ys25xnEydTngo1zFJ6ooTEJZk9rWa" +
       "7tdseLrNfe12O6HlOS6XyNTmXqx5itVHXWOu6pfXzXCC7unvSolYo1ZkfI/R" +
       "5isQfzqcpJljWz79yJ1CL3/RSDuCGuufcpqnAZ5hU8fhmZvHizWPeb6RZ+yb" +
       "tPk6QSUjmITSKGRZ4eTHZYUmeLCpCp65FbxY82h6Ic/YRdqcBdQAKwQtmLPs" +
       "8PTHYAd25Ka5TzaVkWduBy/WPLr+IHew0J/TjOA52lwiqEiUVYPfFgzTZg9X" +
       "LALxMqZKUcs43/lfGCdFUKPHDRc9gTVl3arzm2DxmVPVpY2ndr7FEDtzW1sB" +
       "2BtLyrL9jGB7L9Z0HJOYthX8xMCLmCsENXndvxHkl1Qm/Uuc+CcE1eckBgPR" +
       "Lzvt63AGd9OChdm3ne5nBJVbdJB0+Yud5CoUfUBCX69paYhr97w1zLJmyudM" +
       "rpltrL/TNtry8RJHHmN/jKRzTpL/NRIWL57a1nfg1vqn+J2QKAuTk3SWWVBk" +
       "8uupTN5a7Dlbeq7irStuVz1btjSd4Wu5wFaAzLd5eBDcWaNOM891YWK0Ze5N" +
       "3j698YXXp4rfhJJ6N/IJkCR2Z59LU1oSCobdoexiGnI8u8npXPG1iU2rYn/+" +
       "NTv5I158N3vTh8VrZx68eqzpdIsfzepBRVC84BQ7MN83oWzH4pg+hColoysF" +
       "IsIskiA7KvUq6t8CDRJmF9OclZleeqNIUGv2ISX7HrZcVsexvkVNKizzQa0/" +
       "y+px/GNjxkx5UtNcDFaP7SA3wrGC7gZ4ajjUq2npM1zJZzQW7fFc4BNn3O+x" +
       "V9rc+A9LMNX2NB0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UX6Pnf7hbZ960+88/Y38wPz/AOV2etqTJwAA");
}
