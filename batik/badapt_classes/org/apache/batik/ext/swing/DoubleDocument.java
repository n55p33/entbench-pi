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
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471028785000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gXiN/O4d6PRB6eWmq6jjSNePF1wuBGoUBy53rOzywIFmX5ZpDAPPtT3NXrt1" +
       "SfeWVnAqt4Lt3p+oGZ7eU2D2zhzZ82kEnTbdvPZJ7FdmHsgvF/YuAbJ7wd1m" +
       "FAWmFEdZkSonH5wgf2qv5r9H4dpNFDBRoTx5e4u6llU/6+SU0qxxIuii6YZq" +
       "EG1LQbdi846VZyqHNut+vyrC0WJhPmAdV/Kj4GH2lMz8cJR8VAsnuD+r5Jcp" +
       "OdrTL1LP/bWs+YUIOh+q27Jf9v7kodi/+AOIfW82eAU8T+yJ/cQPR+yj/L//" +
       "ReY+mDXvBrLpR2T7lUPZ3vNSZFtH0N3HL6iyCvv9N91/b+9s5U8+e+n8q56d" +
       "/HV+R3Nwr3onBZ3XYts+WhA90j/rB6pm5rzfuS2P+vnPb0bQldvfm0XQmfw3" +
       "Z/k3thi/FUGvuBUG8D7QHoX87Qi6fBISUMx/j8J9LIIuHMIBA9t2joI8B6gD" +
       "kKz7CX/fNR+8yTVHtmi6+0pcnzoeug82597vtzlHov1jx2J0/p8L+/E03v7v" +
       "wg35U8/2hm95ofbR7eWTbIubTUblPAWd296DHcTkR25LbZ/W2e7j373703de" +
       "2z8/7t4yfGjNR3h76Na3Ox3Hj/L7mM0fvur3X/87z341rwn/H6CfjoZSIgAA");
}
