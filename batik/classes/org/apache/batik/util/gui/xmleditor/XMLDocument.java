package org.apache.batik.util.gui.xmleditor;
public class XMLDocument extends javax.swing.text.PlainDocument {
    protected org.apache.batik.util.gui.xmleditor.XMLScanner lexer;
    protected org.apache.batik.util.gui.xmleditor.XMLContext context;
    protected org.apache.batik.util.gui.xmleditor.XMLToken cacheToken = null;
    public XMLDocument() { this(new org.apache.batik.util.gui.xmleditor.XMLContext(
                                  )); }
    public XMLDocument(org.apache.batik.util.gui.xmleditor.XMLContext context) {
        super(
          );
        this.
          context =
          context;
        lexer =
          new org.apache.batik.util.gui.xmleditor.XMLScanner(
            );
    }
    public org.apache.batik.util.gui.xmleditor.XMLToken getScannerStart(int pos)
          throws javax.swing.text.BadLocationException { int ctx =
                                                           org.apache.batik.util.gui.xmleditor.XMLScanner.
                                                             CHARACTER_DATA_CONTEXT;
                                                         int offset =
                                                           0;
                                                         int tokenOffset =
                                                           0;
                                                         if (cacheToken !=
                                                               null) {
                                                             if (cacheToken.
                                                                   getStartOffset(
                                                                     ) >
                                                                   pos) {
                                                                 cacheToken =
                                                                   null;
                                                             }
                                                             else {
                                                                 ctx =
                                                                   cacheToken.
                                                                     getContext(
                                                                       );
                                                                 offset =
                                                                   cacheToken.
                                                                     getStartOffset(
                                                                       );
                                                                 tokenOffset =
                                                                   offset;
                                                                 javax.swing.text.Element element =
                                                                   getDefaultRootElement(
                                                                     );
                                                                 int line1 =
                                                                   element.
                                                                   getElementIndex(
                                                                     pos);
                                                                 int line2 =
                                                                   element.
                                                                   getElementIndex(
                                                                     offset);
                                                                 if (line1 -
                                                                       line2 <
                                                                       50) {
                                                                     return cacheToken;
                                                                 }
                                                             }
                                                         }
                                                         java.lang.String str =
                                                           getText(
                                                             offset,
                                                             pos -
                                                               offset);
                                                         lexer.
                                                           setString(
                                                             str);
                                                         lexer.
                                                           reset(
                                                             );
                                                         int lastCtx =
                                                           ctx;
                                                         int lastOffset =
                                                           offset;
                                                         while (offset <
                                                                  pos) {
                                                             lastOffset =
                                                               offset;
                                                             lastCtx =
                                                               ctx;
                                                             offset =
                                                               lexer.
                                                                 scan(
                                                                   ctx) +
                                                                 tokenOffset;
                                                             ctx =
                                                               lexer.
                                                                 getScanValue(
                                                                   );
                                                         }
                                                         cacheToken =
                                                           new org.apache.batik.util.gui.xmleditor.XMLToken(
                                                             lastCtx,
                                                             lastOffset,
                                                             offset);
                                                         return cacheToken;
    }
    public void insertString(int offset, java.lang.String str,
                             javax.swing.text.AttributeSet a)
          throws javax.swing.text.BadLocationException {
        super.
          insertString(
            offset,
            str,
            a);
        if (cacheToken !=
              null) {
            if (cacheToken.
                  getStartOffset(
                    ) >=
                  offset) {
                cacheToken =
                  null;
            }
        }
    }
    public void remove(int offs, int len)
          throws javax.swing.text.BadLocationException {
        super.
          remove(
            offs,
            len);
        if (cacheToken !=
              null) {
            if (cacheToken.
                  getStartOffset(
                    ) >=
                  offs) {
                cacheToken =
                  null;
            }
        }
    }
    public int find(java.lang.String str,
                    int fromIndex,
                    boolean caseSensitive)
          throws javax.swing.text.BadLocationException {
        int offset =
          -1;
        int startOffset =
          -1;
        int len =
          0;
        int charIndex =
          0;
        javax.swing.text.Element rootElement =
          getDefaultRootElement(
            );
        int elementIndex =
          rootElement.
          getElementIndex(
            fromIndex);
        if (elementIndex <
              0) {
            return offset;
        }
        charIndex =
          fromIndex -
            rootElement.
            getElement(
              elementIndex).
            getStartOffset(
              );
        for (int i =
               elementIndex;
             i <
               rootElement.
               getElementCount(
                 );
             i++) {
            javax.swing.text.Element element =
              rootElement.
              getElement(
                i);
            startOffset =
              element.
                getStartOffset(
                  );
            if (element.
                  getEndOffset(
                    ) >
                  getLength(
                    )) {
                len =
                  getLength(
                    ) -
                    startOffset;
            }
            else {
                len =
                  element.
                    getEndOffset(
                      ) -
                    startOffset;
            }
            java.lang.String text =
              getText(
                startOffset,
                len);
            if (!caseSensitive) {
                text =
                  text.
                    toLowerCase(
                      );
                str =
                  str.
                    toLowerCase(
                      );
            }
            charIndex =
              text.
                indexOf(
                  str,
                  charIndex);
            if (charIndex !=
                  -1) {
                offset =
                  startOffset +
                    charIndex;
                break;
            }
            charIndex =
              0;
        }
        return offset;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze5AURxnv23u/uAccbw64O0gdkN0QgyF1iIHjdWQPTo5g" +
       "PAzH7Gzv3XCzM8NM791ykTxAhVgViiAQtAJ/KCmQIiGmjMbSIBalSUy0CkJM" +
       "YipEo1WikTKUFbREjd/XPbPz2N27nJW4VdM72/193d+rf9/XvaevkmLLJI1U" +
       "Y2G2w6BWeKXGuiTTovF2VbKsjdDXKz9WKP1ty5V1d4RISQ8Z1y9ZnbJk0VUK" +
       "VeNWD5mhaBaTNJla6yiNI0eXSS1qDkpM0bUe0qBYHUlDVWSFdepxigSbJDNK" +
       "6iTGTCWWYrTDnoCRGVGQJMIliSwLDrdFSZWsGztc8ske8nbPCFIm3bUsRmqj" +
       "26RBKZJiihqJKhZrS5tkvqGrO/pUnYVpmoW3qYtsE6yNLsoyQdPTNddv7O+v" +
       "5SYYL2mazrh61gZq6eogjUdJjdu7UqVJazu5nxRGSaWHmJGWqLNoBBaNwKKO" +
       "ti4VSF9NtVSyXefqMGemEkNGgRiZ7Z/EkEwpaU/TxWWGGcqYrTtnBm1nZbQV" +
       "WmapeGh+5OBjW2qfKSQ1PaRG0bpRHBmEYLBIDxiUJmPUtJbF4zTeQ+o0cHY3" +
       "NRVJVYZtT9dbSp8msRS43zELdqYMavI1XVuBH0E3MyUz3cyol+ABZf8qTqhS" +
       "H+g60dVVaLgK+0HBCgUEMxMSxJ3NUjSgaHFGZgY5Mjq23AUEwFqapKxfzyxV" +
       "pEnQQepFiKiS1hfphtDT+oC0WIcANBmZmndStLUhyQNSH+3FiAzQdYkhoCrn" +
       "hkAWRhqCZHwm8NLUgJc8/rm6bsm++7Q1WogUgMxxKqsofyUwNQaYNtAENSns" +
       "A8FYNS96WJr4/N4QIUDcECAWND/40rU7FzSee1HQTMtBsz62jcqsVz4eG3dh" +
       "envrHYUoRpmhWwo636c532Vd9khb2gCEmZiZEQfDzuC5DT//woOn6HshUtFB" +
       "SmRdTSUhjupkPWkoKjVXU42aEqPxDlJOtXg7H+8gpfAeVTQqetcnEhZlHaRI" +
       "5V0lOv8NJkrAFGiiCnhXtITuvBsS6+fvaYMQUgoPqYJnFhEf/s1ILNKvJ2lE" +
       "kiVN0fRIl6mj/lYEECcGtu2PxCDqByKWnjIhBCO62ReRIA76qT3AjdCXUiLp" +
       "pErjCgR65J7O6ApdTiURbTHWjP/LKmnUdfxQQQG4YXoQBFTYP2t0NU7NXvlg" +
       "avnKa0/1viwCDDeFbSVGcOGwWDjMFxZuhIXDmYXDnoVJQQFfbwIKIGjBYQOw" +
       "9QF7q1q77127dW9TIcSaMVQE1g4BaZMvB7W7+OCAeq98pr56ePblhedDpChK" +
       "6iWZpSQVU8oysw/ASh6w93NVDLKTmyRmeZIEZjdTl2kcMCpfsrBnKdMHqYn9" +
       "jEzwzOCkMNyskfwJJKf85NyRoYc2PXBLiIT8eQGXLAZIQ/YuRPMMarcE8SDX" +
       "vDV7rlw/c3in7iKDL9E4+TGLE3VoCkZE0Dy98rxZ0rO9z+9s4WYvB+RmEuw0" +
       "AMXG4Bo+4GlzQBx1KQOFE7qZlFQccmxcwfpNfcjt4aFax98nQFhU4k6cCM9N" +
       "9tbk3zg60cB2kghtjLOAFjxJfKbbOPrGr/70KW5uJ5/UeAqBbsraPBiGk9Vz" +
       "tKpzw3ajSSnQvX2k6+uHru7ZzGMWKJpzLdiCbTtgF7gQzPyVF7e/+c7l45dC" +
       "mTgvYJDEUzGohdIZJbGfVIygJKw215UHMFAFhMCoablbg/hUEooUUylurH/V" +
       "zFn47F/21Yo4UKHHCaMFo0/g9k9ZTh58ecvfG/k0BTLmYNdmLpkA9vHuzMtM" +
       "U9qBcqQfujjjGy9IRyFFACxbyjDlSEu4DQh32iKu/y28vS0wdjs2cyxv8Pv3" +
       "l6dW6pX3X3q/etP7Z69xaf3FltfXnZLRJsILm7lpmH5SEJzWSFY/0N12bt0X" +
       "a9VzN2DGHphRBuC11psAkWlfZNjUxaW/+en5iVsvFJLQKlKh6lJ8lcQ3GSmH" +
       "6KZWP6Br2vjsncK5Q2XQ1HJVSZbyWR1o4Jm5XbcyaTBu7OHnJn1vyYljl3mU" +
       "GXyKGdk7KGwHVzj3DsL2JmzmZ8dlPtaABwtEhPPfkxkJf8SMYdeXXI7VIwTF" +
       "Xdgs50OLsWkX1mr7Hw2LHcsMMTCNdxZievTlIH7AcWHw1Ku3v3bi0cNDokRq" +
       "zY/9Ab7J/1yvxna9+4+sAOWon6N8C/D3RE4/PrV96Xuc34Vf5G5JZ6d0SGEu" +
       "762nkh+Emkp+FiKlPaRWtg8UmyQ1haDWA0W05Zwy4NDhG/cXxKL6a8ukl+lB" +
       "6PcsGwR+t5SAd6TG9+oA1o9Dv8yEp8kOt6ZgpBYQ/vJ5Eay8nYfNzQ60lhum" +
       "zkBKGg+ga/UI0zJSrNI0Nccat91QsdleGO9G5T2jReXn/ArPhqfZlqw5j8Ix" +
       "d3f2ZOuVj5uRUllsLfy5JiCnPEY5W+GZY680J4+cyohy5uNmpEJGY2/UB6jm" +
       "OGHBR3QCZwqotm0E1dK5gI5/SkjgABAEumkOlJhkRr4zGj9fHt918Fh8/RML" +
       "BUzU+889K+FY/+Sv//1K+MhvX8pRZpcz3bhZpYNU9axZhEv6gKmTH1/dXf72" +
       "uAO//2FL3/Kx1MXY1zhK5Yu/Z4IS8/JjXVCUF3b9eerGpf1bx1DizgyYMzjl" +
       "dzpPv7R6rnwgxM/qAn6yzvh+pjY/6FSYlKVMbaMPepozATDB2T+L7QBYHIzw" +
       "0ZNkPtY8SdJ33EFXdadiFhxNlCRUooP2uf3Wrq3y3pauP4hImpKDQdA1nIw8" +
       "sun1ba9wm5ehkzOaehwMweApsmuFCh/CpwCe/+CDomMHfgP6t9uH8FmZU7hh" +
       "YPiPkPkCCkR21r8z8PiVJ4UCwTQXIKZ7D37tw/C+g2JbiKuc5qzbFC+PuM4R" +
       "6mCzB6WbPdIqnGPVH8/s/NHJnXtCdmUxyEihYt+y+X00wW9yIeeKh2t+vL++" +
       "cBVstg5SltKU7SnaEfcHXKmVinl84N78uOFnS4z2htPyPDAt7949clU1hx/o" +
       "w9aQovWFEdzDy6V4VJfFrWNapga+8JkOYXM/FMF9lNnJCsDA5OlAc+HygY+j" +
       "juL9w/6qcwU8sr0r5LFvqHysAfsUitoNf37VMVItr5ixbAmLezxnYEaW9TJ3" +
       "zFANcaG+ldv++PMwJziJzVFGqhTNgjOwZ4GH7RjEr0cYKRrUlbhr52OflJ1b" +
       "uX3EZ/vY7ZyPNWCHkLin4XbmDZ/6+6NZ6zlsvgunXpMmIavgr1OuTZ75BGxS" +
       "g2Pj4dltK7Z77DbJx5o/9r7tBuCXPWEQCInSmK6rVNJy2euA2P/nR7PoL7A5" +
       "y/B2U4u7q3J7/uRjORMxUum5ycMj6OSsvw7Edbf81LGasknH7n6dFx6ZK+kq" +
       "yEKJlKp6y37Pe4lh0oTClakShwCDf10EvP8IdR9USZl3rsMFwf4aI1PysgPE" +
       "Q+slf4ORhpzkYFr88tK+BZgSpIVzA//20l2GYtalg6gXL16S34EkQIKv7xoO" +
       "LjVm4VKXCmc8xwXpAn8FmvF3w2j+9hStzb6szf8yclJbSvxp1CufObZ23X3X" +
       "Pv2EuDCTVWl4GGephIQm7u4yNdvsvLM5c5Wsab0x7unyOU6WrRMCu5tvmudw" +
       "vwxC3MBImxq4TbJaMpdKbx5fcvaXe0suQn2wmRRIjIzfnH0+TRspKJY3R7MT" +
       "N9S3/JqrrfWbO5YuSPz1LX5fQkSin56fvle+dOLeVw9MPt4YIpUdpBh2HU3z" +
       "g/OKHdoGKg+aPaRasVamQUSYRZFUX1UwDjeFhDmC28U2Z3WmF69bGWnKrnOy" +
       "L6krVH2Imsv1lNj3UFdUuj2+/7LsjVaRMowAg9vjqQUfFSiF3oDo7I12GoZT" +
       "BhY2GBwWDuSGLGw/4K/YXP8vuqir+U4eAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471109864000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
