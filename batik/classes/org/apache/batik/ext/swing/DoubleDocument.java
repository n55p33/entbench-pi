package org.apache.batik.ext.swing;
public class DoubleDocument extends javax.swing.text.PlainDocument {
    public void insertString(int offs, java.lang.String str, javax.swing.text.AttributeSet a)
          throws javax.swing.text.BadLocationException { if (str ==
                                                               null) {
                                                             return;
                                                         }
                                                         java.lang.String curVal =
                                                           getText(
                                                             0,
                                                             getLength(
                                                               ));
                                                         boolean hasDot =
                                                           curVal.
                                                           indexOf(
                                                             '.') !=
                                                           -1;
                                                         char[] buffer =
                                                           str.
                                                           toCharArray(
                                                             );
                                                         char[] digit =
                                                           new char[buffer.
                                                                      length];
                                                         int j =
                                                           0;
                                                         if (offs ==
                                                               0 &&
                                                               buffer !=
                                                               null &&
                                                               buffer.
                                                                 length >
                                                               0 &&
                                                               buffer[0] ==
                                                               '-')
                                                             digit[j++] =
                                                               buffer[0];
                                                         for (int i =
                                                                0;
                                                              i <
                                                                buffer.
                                                                  length;
                                                              i++) {
                                                             if (java.lang.Character.
                                                                   isDigit(
                                                                     buffer[i]))
                                                                 digit[j++] =
                                                                   buffer[i];
                                                             if (!hasDot &&
                                                                   buffer[i] ==
                                                                   '.') {
                                                                 digit[j++] =
                                                                   '.';
                                                                 hasDot =
                                                                   true;
                                                             }
                                                         }
                                                         java.lang.String added =
                                                           new java.lang.String(
                                                           digit,
                                                           0,
                                                           j);
                                                         try {
                                                             java.lang.StringBuffer val =
                                                               new java.lang.StringBuffer(
                                                               curVal);
                                                             val.
                                                               insert(
                                                                 offs,
                                                                 added);
                                                             java.lang.String valStr =
                                                               val.
                                                               toString(
                                                                 );
                                                             if (valStr.
                                                                   equals(
                                                                     ".") ||
                                                                   valStr.
                                                                   equals(
                                                                     "-") ||
                                                                   valStr.
                                                                   equals(
                                                                     "-."))
                                                                 super.
                                                                   insertString(
                                                                     offs,
                                                                     added,
                                                                     a);
                                                             else {
                                                                 java.lang.Double.
                                                                   valueOf(
                                                                     valStr);
                                                                 super.
                                                                   insertString(
                                                                     offs,
                                                                     added,
                                                                     a);
                                                             }
                                                         }
                                                         catch (java.lang.NumberFormatException e) {
                                                             
                                                         }
    }
    public void setValue(double d) { try {
                                         remove(
                                           0,
                                           getLength(
                                             ));
                                         insertString(
                                           0,
                                           java.lang.String.
                                             valueOf(
                                               d),
                                           null);
                                     }
                                     catch (javax.swing.text.BadLocationException e) {
                                         
                                     } }
    public double getValue() { try { java.lang.String t =
                                       getText(
                                         0,
                                         getLength(
                                           ));
                                     if (t !=
                                           null &&
                                           t.
                                           length(
                                             ) >
                                           0) {
                                         return java.lang.Double.
                                           parseDouble(
                                             t);
                                     }
                                     else {
                                         return 0;
                                     } }
                               catch (javax.swing.text.BadLocationException e) {
                                   throw new java.lang.Error(
                                     e.
                                       getMessage(
                                         ));
                               } }
    public DoubleDocument() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GvrKGfEuJfbFspXqgksMvc7K7vY3ayL27UVrUIHrXtr2EWwq6OXY8voFtKWR" +
       "3WQy4rBgVKdWKFG0repSqyxHUbwczGd11Z1jRIkJrcQ1+e64MvVJQqQtdDQ2" +
       "NY8zxuR6OEUIthf2lRbBWJUZ6UjdiJP8HjK3SuaiLHrjmGURXOiMNvgkXfim" +
       "T3c4F2cYkZSJKB0WhaJsJvBELcwTfk5v/IpjePq6GHatYug4M1E0SRqrWUm0" +
       "7G+4PpLMorTHd7G4aRNM29YKvW5RS7Xi1E0EJFpXm3U0LrbaTp2ibL0bFFJ1" +
       "0phOtam3MATfaQfa0Fqk/IRvylaATi2u1RbJOduLkwAljXoPLsCbJloSYFOk" +
       "lpjQXbQ7Sw5LG9JyMa/wjclMHcOcw/MVdl0YdZeSq9WnVYy0iBSxBRHtlNSN" +
       "aPbSCrYxR4kwadNwiTCaDI61itNmWPXd5gAW/eY6cFc9h56MOnrLivR+TMP0" +
       "QudWMzu0pEFHWhCqwKMtazCZ64FM8IRC9uclBzHwIlJ35N4gWWM8tzAnY2+A" +
       "URNtFs/anIQUcHDcl9pWg5mpVj9RPCOttqfOuL6GTdiLnE3Zx9TBypxLBdxs" +
       "p+tGk01xf8qZVkNXNY2aNtTBgm/PnVDkgmC+Yeb1nlEdkE3MN70NZW5Gdkfr" +
       "WpWpgazaRNm1LFptNaXSsjrG0ZnmtMMVrtQ3fn2FRZYpUaFXXnFlScOxQmAn" +
       "3tKPVBV1001KsrYx7guD1qDIEbjM9Byss+RZTq1KxcHIgDd82JRGLZOYTmYy" +
       "gXg4TVT5to3Edk/hQ3egWtqMaNo1bN3He4xfjioVVpmmSFmndJSluBZLlBR8" +
       "yNAKhm3Q5oYskSlRpZOgUYfJaEDJ9nwdueZiXmh6HGv4St9AJaMZF8fTsiGJ" +
       "xVSMO7PCEK4Z1qiyaBgBJvHlRQCcYVLtu4s24ZTK/bDY5VmyV54JXmUZDziA" +
       "47vMZCi5CTmIFywlxs6q2qLH2Ggq6aWgpQ/T6Qo206Q8slcKN2r1TI8uJyhe" +
       "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" +
       "d6DTB6WXG66ijiNdO15wuRBoURy43LGyy/0Hmn1FpjEcPI/tafaxm5d0b2oF" +
       "p3Ir2O79iZrh6T0FZu/jI3suRNBpw81rn+39ysz9+eXC3iVAdi+4i0VRYMhx" +
       "lBWpcvLBCfKn9mr+exQeu4ECLqmMp2xvURNF87NOTmmTNU4E3WG4oRZE21LQ" +
       "zdi8beUZ6qHNuj+oinC0WJgPmMeV/Ah4xntKHv9olHxUCye4P6vmlyk52tMv" +
       "Uc/99az5pQg6F2rbsl/2/uSh2O/4IcS+Jxu8DJ4n9sR+4kcj9lH+P/gScx/O" +
       "mvcC2eZHZPvVQ9ne93JkSyLoruMXVFmF/b4b7r+3d7bKp5+9eO41z/J/k9/R" +
       "HNyrnmegc3ps20cLokf6Z/1A042c9/Pb8qif//xWBF2+9b1ZBJ3Jf3OWf3OL" +
       "8dsR9KqbYQDvA+1RyN+JoEsnIQHF/Pco3Cci6MIhHDCwbecoyHOAOgDJup/y" +
       "913zgRtcc2hLhruvxOTU8dB9sDn3/KDNORLtHz0Wo/P/XNiPp/H2fxeuK595" +
       "ttN/6wvVj28vnxRbStOMyjkGun17D3YQkx++JbV9Wmepqy/e9dnzj+2fH3dt" +
       "GT605iO8PXjz252W40f5fUz6R6/5gzf+7rNfz2vC/wfU0zhsUiIAAA==");
}
